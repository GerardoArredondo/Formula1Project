package proyectoColecciones;

import java.util.*;

public class Pista{
    private String identificadorDeLaPista;
    private double distanciaDePista;
    private String ubicacionDePista;
    private boolean diaOnoche;

    static int cantidadDePistas = 0;

    //Constructores
    public Pista(){

    }
    public Pista(String identificadorDeLaPista ,double distanciaDePista, String ubicacionDePista, boolean diaOnoche){
        setidentificadorDeLaPista(identificadorDeLaPista);
        setDiaOnoche(diaOnoche);
        setDistanciaDePista(distanciaDePista);
        setUbicacionDePista(ubicacionDePista);

        cantidadDePistas++;
    } 


    //Setters
    public void setidentificadorDeLaPista(String identificadorDeLaPista){
        this.identificadorDeLaPista = identificadorDeLaPista;
    }
    public void setDistanciaDePista(double distanciaDePista){
        this.distanciaDePista = distanciaDePista;
    }
    public void setUbicacionDePista(String ubicacionDePista){
        this.ubicacionDePista = ubicacionDePista;
    }
    public void setDiaOnoche(boolean diaOnoche){
        this.diaOnoche = diaOnoche;
    }

    //Getters
    public String getidentificadorDeLaPista(){
        return identificadorDeLaPista;
    }
    public double getDistanciaDePista(){
        return distanciaDePista;
    }
    public String getUbicacionDePiesta(){
        return ubicacionDePista;
    }
    public boolean getDiaONoche(){
        return diaOnoche;
    }



    //Metodos
    public String toString(){
        String horario = "";
        if(diaOnoche == true){
            horario = "el día";
        } 
        if(diaOnoche == false){
            horario = "la noche";
        }

        return "\n\tEl identificador de la pista es: " + identificadorDeLaPista + "\n\tLa distancia de la pista es: " + distanciaDePista + "\n\tLa ubicación de la pista es: " +ubicacionDePista + "\n\tEn esta pista se compite en: " + horario;
    }

    
    public static Pista crearPista(){
        String identificadorDeLaPista;
        double distanciaDePista;
        String ubicacionDePista;
        boolean diaOnoche;
        Scanner sc = new Scanner(System.in);

        System.out.print("\n\n\n¿Cuál es el identificador de la pista?(Nombre)\n----> ");
        identificadorDeLaPista = sc.nextLine();
        


        System.out.print("¿Cuál es la distancia que tiene la pista? (En km)\n---->");
        distanciaDePista = sc.nextDouble();
        sc.nextLine();


        System.out.print("¿En dónde está ubicada la pista? \n---->");
        ubicacionDePista = sc.nextLine();


        System.out.print("¿En la pista se compite de día o de noche? (true para día, false para noche) \n---->");
        diaOnoche = sc.nextBoolean();
        sc.nextLine();

        Pista pistaAAgregar = new Pista(identificadorDeLaPista, distanciaDePista, ubicacionDePista, diaOnoche);
        return pistaAAgregar;
        
    }


    
    public static ArrayList<Piloto> carreraEnElCampeonato(ArrayList<Piloto> listaDePilotos, ArrayList<Pista> listaDePista, ArrayList<Carrera> listaDeLasCarreras){
        int numeroRandom = (int) (Math.random()*cantidadDePistas); //el número random es sólo para ver en qué pista se va a competir
        

        System.out.println("\n\n\nBienvenidos a una carrera más aquí en nuestra pista "+  listaDePista.get(numeroRandom).identificadorDeLaPista +" ubicada en " + listaDePista.get(numeroRandom).ubicacionDePista + ", esperamos que estén pasando un increíble día. La carrera está a punto de comenzar.");
        

        
        List<Integer> listaAuxiliarConLasPosiciones = new ArrayList<>();
        for(int i = 0; i < listaDePilotos.size(); i++){
            listaAuxiliarConLasPosiciones.add(i, (i+1));
            
        }
        Collections.shuffle(listaAuxiliarConLasPosiciones); //Ya tengo mi lista con posiciones en un orden aleatorio
        

        for(int i = 0; i < listaDePilotos.size(); i++){
            listaDePilotos.get(i).posicionPiloto = listaAuxiliarConLasPosiciones.get(i); //en el atributo posicion del piloto i le pongo el valor numerico de la posicion barajeada
        }
        
        


        //Tenemos que ordenar los pilotos en la lista dependiendo de su posicion
        //trataremos de ordenarla por bubble sort
        for(int i = 0; i < listaDePilotos.size()-1; i++){
            for(int j = 0; j < listaDePilotos.size() - i -1; j++){
                if(listaDePilotos.get(j).posicionPiloto > listaDePilotos.get(j+1).posicionPiloto){
                    Piloto pilotoAuxiliar = listaDePilotos.get(j);
                    listaDePilotos.set(j, listaDePilotos.get(j+1));
                    listaDePilotos.set(j+1, pilotoAuxiliar);
                }
            }
        }



        for(int i = 0; i < listaDePilotos.size(); i++){
            listaDePilotos.get(i).puntosPiloto += (listaDePilotos.size() - i); //Agrego los puntos correspondientes una vez tengamos ordenados los pilotos por posiciones
        }


        
        System.out.println("\n\nLa carrera ha terminado, he aquí los resultados: ");
        System.out.println("Posiciones de los pilotos:");
        for(int i = 0; i < Piloto.numeroPilotos; i++){
            System.out.println("\n\t" + listaDePilotos.get(i).getNombrePiloto() + ": " + listaDePilotos.get(i).posicionPiloto);
        }
        




        //Aquí agregaremos a la lista de las carreras el ganados de la carrera y en dónde fue la carreara para después ver estos datos
        String ganador;
        String nombreDeLaPista;

        ganador = listaDePilotos.get(0).getNombrePiloto();
        nombreDeLaPista = listaDePista.get(numeroRandom).identificadorDeLaPista;
        Carrera carreraAAgregar = new Carrera(ganador, nombreDeLaPista);
        listaDeLasCarreras.add(carreraAAgregar);

        



        //al retornar la lista debe de estar ordenada con base a las posiciones
        return listaDePilotos; //va a retornar la lista de pilotos con números en las posiciones
    }



    public static ArrayList<Piloto> ordenarListaPorPuntos(ArrayList<Piloto> listaDePilotos){
        for(int i = 0; i < listaDePilotos.size()-1; i++){
            for(int j = 0; j < listaDePilotos.size() - i -1; j++){
                if(listaDePilotos.get(j).puntosPiloto < listaDePilotos.get(j+1).puntosPiloto){
                    Piloto pilotoAuxiliar = listaDePilotos.get(j);
                    listaDePilotos.set(j, listaDePilotos.get(j+1));
                    listaDePilotos.set(j+1, pilotoAuxiliar);
                }
            }
        }

        return listaDePilotos;

    }
    








}