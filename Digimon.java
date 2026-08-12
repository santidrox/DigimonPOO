public class Digimon {

    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private Digievolucion digievolucion;

    public Digimon(String nombre, String tipo, int ataque,
                   int defensa, Digievolucion digievolucion) {

        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.digievolucion = digievolucion;
    }

    public int calcularEfectoTipo(Digimon enemigo) {

        // Ataques efectivos: +20

        if (tipo.equals("Fuego")
                && enemigo.getTipo().equals("Planta")) {
            return 20;
        }

        if (tipo.equals("Planta")
                && enemigo.getTipo().equals("Agua")) {
            return 20;
        }

        if (tipo.equals("Agua")
                && enemigo.getTipo().equals("Fuego")) {
            return 20;
        }

        if (tipo.equals("Electrico")
                && enemigo.getTipo().equals("Agua")) {
            return 20;
        }


        // Ataques debiles: -10

        if (tipo.equals("Planta")
                && enemigo.getTipo().equals("Fuego")) {
            return -10;
        }

        if (tipo.equals("Agua")
                && enemigo.getTipo().equals("Planta")) {
            return -10;
        }

        if (tipo.equals("Fuego")
                && enemigo.getTipo().equals("Agua")) {
            return -10;
        }

        if (tipo.equals("Agua")
                && enemigo.getTipo().equals("Electrico")) {
            return -10;
        }


        // Neutral
        return 0;
    }

    public int calcularAtaqueTotal(Digimon enemigo) {
        return ataque + calcularEfectoTipo(enemigo);
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public Digievolucion getDigievolucion() {
        return digievolucion;
    }
}