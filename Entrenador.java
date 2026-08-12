public class Entrenador {

    private String nombre;
    private Digimon[] digimons;
    private boolean[] utilizados;
    private int rondasGanadas;

    public Entrenador(String nombre, Digimon[] digimons) {
        this.nombre = nombre;
        this.digimons = digimons;
        this.utilizados = new boolean[4];
        this.rondasGanadas = 0;
    }

    public Digimon seleccionarDigimon(int posicion) {
        return digimons[posicion];
    }

    public boolean digimonDisponible(int posicion) {
        return !utilizados[posicion];
    }

    public void marcarComoUtilizado(int posicion) {
        utilizados[posicion] = true;
    }

    public void aumentarRondasGanadas() {
        rondasGanadas++;
    }

    public String getNombre() {
        return nombre;
    }

    public Digimon[] getDigimons() {
        return digimons;
    }

    public int getRondasGanadas() {
        return rondasGanadas;
    }
}