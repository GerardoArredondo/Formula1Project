package proyectoColecciones;

import java.util.Scanner;

public class Piloto{
    private String nombrePiloto;
    private String equipoPiloto;
    private String nacionalidadPiloto;
    private int nacimientoPiloto;
    double puntosPiloto;
    static int numeroPilotos = 0;
    int posicionPiloto;

    //Constructores
    public Piloto(){
    }

    public Piloto(String nombre, String equipo, String nacionalidad, int nacimiento){
        setNombrePiloto(nombre);
        setEquipoPiloto(equipo);
        setNacionalidadPiloto(nacionalidad);
        setNacimientoPiloto(nacimiento);
        
        numeroPilotos++;
    }


    //Setters
    public void setNombrePiloto(String nombre){
        this.nombrePiloto = nombre;
    }
    public void setEquipoPiloto(String equipo){
        this.equipoPiloto = equipo;
    }
    public void setNacionalidadPiloto(String nacionalidad){
        this.nacionalidadPiloto = nacionalidad;
    }
    public void setNacimientoPiloto(int nacimiento){
        this.nacimientoPiloto = nacimiento;
    }

    

    //Getters
    public String getNombrePiloto(){
        return nombrePiloto;
    }
    public String getEquipoPiloto(){
        return equipoPiloto;
    }
    public String getNacionalidadPiloto(){
        return nacionalidadPiloto;
    }
    public int getNacimientoPiloto(){
        return nacimientoPiloto;
    }

    

    //Metodos
    public String toString(){
        return "\n\tNombre: " + nombrePiloto + "\n\tEquipo: "+ equipoPiloto + "\n\tNacionalidad: "+ nacionalidadPiloto + "\n\tNacimiento: " + nacimientoPiloto + "\n\tPuntos totales: " + puntosPiloto + "\n\tPosicion en la última carrera: " + posicionPiloto + "\n";
    }


    
    public static Piloto crearPiloto(int i){
        Scanner sc = new Scanner(System.in);
        String nombrePiloto;
        String equipoPiloto;
        String nacionalidadPiloto;
        int nacimientoPiloto;

        System.out.print("\n\nNombre del piloto " + (i+1) + ": ");
        nombrePiloto = sc.nextLine();

        System.out.print("Nombre equipo del piloto " + (i+1) + ": ");
        equipoPiloto = sc.nextLine();
        


        System.out.print("Nacionalidad del piloto " + (i+1) + ": ");
        nacionalidadPiloto = sc.nextLine();

        System.out.print("Año de nacimiento del piloto " + (i+1) + ": ");
        nacimientoPiloto = sc.nextInt();
        sc.nextLine();


        Piloto piloto = new Piloto(nombrePiloto, equipoPiloto, nacionalidadPiloto, nacimientoPiloto);
        return piloto;
    }

    

}