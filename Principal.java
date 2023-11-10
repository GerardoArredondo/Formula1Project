package proyectoColecciones;

import java.util.Scanner;

public class Principal{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int opcion;


        System.out.println("\n\n--------------------------Bienvenido al proyecto número 1--------------------------");

        Campeonato campeonatoPrincipal = Campeonato.crearCampeonato();



        System.out.println("\n\n¿Qué deseas hacer?");


        do{
            System.out.println("\n\n1.- Registrar más pilotos");
            System.out.println("2.- Registar más pistas");
            System.out.println("3.- Ver datos de los pilotos");
            System.out.println("4.- Ver datos de las pistas ");
            System.out.println("5.- Iniciar una carrera");
            System.out.println("6.- Ver las posiciones actuales");
            System.out.println("7.- Ver resultados de las carreras anteriores");
            System.out.println("8.- Ver los equipos que hay en la carrera");
            System.out.println("9.- Terminar campeonato");
            


            System.out.print("Elijo la opción ---> ");
            opcion = sc.nextInt();
            sc.nextLine();



            switch(opcion){
                case 1:
                    System.out.println("\n\n------------Haz elegido registrar más pilotos------------");
                    System.out.print("¿Cuántos pilotos más quieres agregar?\n----> ");
                    int cantidadDePilotosAAgregar = sc.nextInt();
                    sc.nextLine();

                    for(int i = 0; i < cantidadDePilotosAAgregar; i++){
                        Piloto pilotoAAgregar = Piloto.crearPiloto(i);
                        campeonatoPrincipal.listaDePilotos.add(pilotoAAgregar);
                    }

                break;

                case 2:
                    System.out.println("\n\n------------Haz elegido registrar más pistas------------");
                    System.out.println("¿Cuántas pistas más quieres registrar?");
                    int cantidadDePistasAAgregar = sc.nextInt();
                    sc.nextLine();

                    for(int i = 0; i < cantidadDePistasAAgregar; i++){
                        Pista pistaAAgregar = Pista.crearPista();
                        campeonatoPrincipal.listaDePistas.add(pistaAAgregar);
                    }


                break;

                case 3:
                    System.out.println("\n\n------------Elegiste ver los datos de los pilotos------------");
                    for(int i = 0; i < Piloto.numeroPilotos; i++){
                        System.out.println(campeonatoPrincipal.listaDePilotos.get(i));
                    }
                break;

                case 4:
                    System.out.println("\n\n------------Elegiste ver los datos de las pistas------------");
                    for(int i = 0; i < Pista.cantidadDePistas; i++){
                        System.out.println(campeonatoPrincipal.listaDePistas.get(i));
                    }
                break;

                case 5:
                    System.out.println("\n\n------------Haz elegido iniciar una carrera------------");

                    campeonatoPrincipal.listaDePilotos = Pista.carreraEnElCampeonato(campeonatoPrincipal.listaDePilotos, campeonatoPrincipal.listaDePistas, campeonatoPrincipal.listaDeLasCarreras);
                break;

                case 6:
                    System.out.println("\n\n------------Haz elegido ver las posiciones actuales------------");
                    campeonatoPrincipal.listaDePilotos = Pista.ordenarListaPorPuntos(campeonatoPrincipal.listaDePilotos); //ordenamos los pilotos en base a sus pnutos globales

                    for(int i = 0; i < campeonatoPrincipal.listaDePilotos.size(); i++){
                        System.out.println("\n\t--->El piloto " +  campeonatoPrincipal.listaDePilotos.get(i).getNombrePiloto() + " se encuentra en la posición " + (i+1) + " con " + campeonatoPrincipal.listaDePilotos.get(i).puntosPiloto + " puntos");
                    }
                break;

                case 7:
                    System.out.println("\n\n------------Haz elegido ver el resultado de las carreras anteriores------------");
                    System.out.println("\n\nCarreras:");
                    if(campeonatoPrincipal.listaDeLasCarreras.isEmpty()){
                        System.out.println("Todavía no ha habido ninguna carrera");
                    } else{
                        for(int i = 0; i < campeonatoPrincipal.listaDeLasCarreras.size(); i++){
                            System.out.println( (i+1) +".- " + campeonatoPrincipal.listaDeLasCarreras.get(i));
                        }
                    }
                    
                break;

                case 8:
                    System.out.println("\n\n------------Haz elegido verlos equipos que hay en la carrera------------");
                    campeonatoPrincipal.verEquiposDeLosPilotos(campeonatoPrincipal.listaDePilotos);
                break;

                case 9:
                    System.out.println("\n\n------------Haz elegido terminar el campeonato------------");
                    campeonatoPrincipal.listaDePilotos = Pista.ordenarListaPorPuntos(campeonatoPrincipal.listaDePilotos); //ordenamos por puntos globales los pilotos
                    System.out.println("\n\nEl 1er lugar en este campeonato es para " + campeonatoPrincipal.listaDePilotos.get(0).getNombrePiloto() + " con el equipo " + campeonatoPrincipal.listaDePilotos.get(0).getEquipoPiloto());
                    System.out.println("\n\nEl 2do lugar en este campeonato es para " + campeonatoPrincipal.listaDePilotos.get(1).getNombrePiloto() + " con el equipo " + campeonatoPrincipal.listaDePilotos.get(1).getEquipoPiloto());
                    System.out.println("\n\nEl 3er lugar en este campeonato es para " + campeonatoPrincipal.listaDePilotos.get(2).getNombrePiloto() + " con el equipo " + campeonatoPrincipal.listaDePilotos.get(2).getEquipoPiloto());

                    System.out.println("\n\n" + campeonatoPrincipal.listaDePilotos.get(0).getNombrePiloto() + " es el ganador(a) de este campeonato, se lleva " + campeonatoPrincipal.getPremioDelCampeonato() + " por su victoria!!");

                    System.out.println("\n\nMuchas gracias por haber usado el programa, esperamos haya sido de su agrado. :D\n\n\n");
                break;


                

                default:
                    System.out.println("Por favor ingresa una opción válida");
                break;


                
            }



        }while(opcion != 9);
        




    }


}