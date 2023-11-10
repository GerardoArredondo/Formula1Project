package proyectoColecciones;

import java.util.ArrayList;
import java.util.Scanner;

public class Campeonato{
    ArrayList<Piloto> listaDePilotos = new  ArrayList<>();
    ArrayList<Pista> listaDePistas = new ArrayList<>();
    ArrayList<Carrera> listaDeLasCarreras = new ArrayList<>();
    private String premioDelCampeonato;
    private int cantidadDePilotos;
    private int cantidadDePistas;
    Scanner sc = new Scanner(System.in);


    //Constructores
    public Campeonato(ArrayList<Piloto> listaDePilotos, ArrayList<Pista> listaDePistas, String premioDelCampeonato){
        setListaDePilotos(listaDePilotos);
        setListaDePistas(listaDePistas);
        setPremioDelCampeonato(premioDelCampeonato);
    }


    //Setters
    public void setListaDePilotos(ArrayList<Piloto> listaDePilotos){
        this.listaDePilotos = listaDePilotos;
    }
    public void setListaDePistas(ArrayList<Pista> listaDePista){
        this.listaDePistas = listaDePista;
    }
    public void setPremioDelCampeonato(String premioDelCampeonato){
        this.premioDelCampeonato = premioDelCampeonato;
    }
    public void setCantidadDePilotos(int cantidadDePilotos){
        this.cantidadDePilotos = cantidadDePilotos;
    }
    public void setCantidadDePistas(int cantidadDePistas){
        this.cantidadDePistas = cantidadDePistas;
    }

    //Getters
    public ArrayList<Piloto> getListaDePiloto(){
        return listaDePilotos;
    }
    public ArrayList<Pista> getListaDePistas(){
        return listaDePistas;
    }
    public String getPremioDelCampeonato(){
        return premioDelCampeonato;
    }
    public int getCantidadDePilotos() {
        return cantidadDePilotos;
    }
    public int getCantidadDePistas() {
        return cantidadDePistas;
    }







    //Metodos


    public static Campeonato crearCampeonato(){
        ArrayList<Piloto> listaDePilotos = new  ArrayList<>();
        ArrayList<Pista> listaDePistas = new ArrayList<>();
        String premioDelCampeonato;
        int cantidadDePilotos;
        int cantidadDePistas;
        Scanner sc = new Scanner(System.in);


        System.out.print("¿Qué quieres que sea el premio del campeonato?\n----> ");
        premioDelCampeonato = sc.nextLine();

        System.out.print("¿Cuántos pilotos quieres tener en el campeonato?\n---->");
        cantidadDePilotos = sc.nextInt();
        sc.nextLine();

        System.out.print("¿Cuántas pistas quieres tener en el campeonato?\n---->");
        cantidadDePistas = sc.nextInt();
        sc.nextLine();




        for(int i = 0; i < cantidadDePilotos; i++){
            Piloto pilotoAAgregar = Piloto.crearPiloto(i);
            listaDePilotos.add(pilotoAAgregar);
        }

        for(int i = 0; i < cantidadDePistas; i++){
            Pista pistaAAgregar = Pista.crearPista();
            listaDePistas.add(pistaAAgregar);
        }
        



        Campeonato campeonatoPrincipal = new Campeonato(listaDePilotos, listaDePistas, premioDelCampeonato);
        return campeonatoPrincipal;
    }



    public void verEquiposDeLosPilotos(ArrayList<Piloto> listaDePilotos){
        for(int i = 0; i < listaDePilotos.size(); i++){
            System.out.println("\n\tEquipo ----> " + listaDePilotos.get(i).getEquipoPiloto() +", Piloto ----> " + listaDePilotos.get(i).getNombrePiloto());
        }
    }


    
}