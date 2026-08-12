import java.util.Random;

public class Digievolucion {

    private String nombre;
    private String efecto;
    private int probabilidad;

    public Digievolucion(String nombre, String efecto, int probabilidad) {
        this.nombre = nombre;
        this.efecto = efecto;
        this.probabilidad = probabilidad;
    }

    public boolean intentarActivar() {
        Random random = new Random();
        int numero = random.nextInt(101);

        return numero <= probabilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEfecto() {
        return efecto;
    }

    public int getProbabilidad() {
        return probabilidad;
    }
}