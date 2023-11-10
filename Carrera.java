package proyectoColecciones;

public class Carrera {
    private String ganadorDeLaCarrera;
    private String pistaDondeFueLaCarrera;
    static int numeroDeCarreras = 0;


    //Constructores
    public Carrera(String ganadorDeLaCarrera, String pistaDondeFueLaCarrera){
        setganadorDeLaCarrera(ganadorDeLaCarrera);
        setpistaDondeFueLaCarrera(pistaDondeFueLaCarrera);
        numeroDeCarreras++;
    }


    //Setters
    public void setganadorDeLaCarrera(String ganadorDeLaCarrera){
        this.ganadorDeLaCarrera = ganadorDeLaCarrera;
    }

    public void setpistaDondeFueLaCarrera(String pistaDondeFueLaCarrera){
        this.pistaDondeFueLaCarrera = pistaDondeFueLaCarrera;
    }

    //Getters
    public String getganadorDeLaCarrera(){
        return ganadorDeLaCarrera;
    }
    public String getpistaDondeFueLaCarrera(){
        return pistaDondeFueLaCarrera;
    }

    //Metodos


    public String toString(){
        return "\n\tEl ganador de la carrera fue: " + ganadorDeLaCarrera + ".\n\tLa pista en donde se jugó tiene como nombre: " + pistaDondeFueLaCarrera;
    }



}
