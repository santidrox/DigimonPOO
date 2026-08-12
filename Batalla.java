public class Batalla {

    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private int rondaActual;

    public Batalla(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
        this.rondaActual = 1;
    }

    public int resolverRonda(Digimon digimon1, Digimon digimon2) {

        int ataque1 = digimon1.calcularAtaqueTotal(digimon2);
        int ataque2 = digimon2.calcularAtaqueTotal(digimon1);

        if (ataque1 > ataque2) {
            return 1;
        }

        if (ataque2 > ataque1) {
            return 2;
        }

        return 0;
    }

    public void registrarResultado(int resultado) {

        if (resultado == 1) {
            entrenador1.aumentarRondasGanadas();
        }

        if (resultado == 2) {
            entrenador2.aumentarRondasGanadas();
        }

        rondaActual++;
    }

    public int determinarGanador() {

        if (entrenador1.getRondasGanadas()
                > entrenador2.getRondasGanadas()) {
            return 1;
        }

        if (entrenador2.getRondasGanadas()
                > entrenador1.getRondasGanadas()) {
            return 2;
        }

        return 0;
    }

    public Entrenador getEntrenador1() {
        return entrenador1;
    }

    public Entrenador getEntrenador2() {
        return entrenador2;
    }

    public int getRondaActual() {
        return rondaActual;
    }
}