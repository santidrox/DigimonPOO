import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Digievolucion adult1 =
                new Digievolucion("Adult", "Ataque", 30);

        Digievolucion mega1 =
                new Digievolucion("Mega", "Defensa", 40);

        Digievolucion ultimate1 =
                new Digievolucion("Ultimate", "Dano", 25);

        Digievolucion adult2 =
                new Digievolucion("Adult", "Ataque", 35);

        Digievolucion mega2 =
                new Digievolucion("Mega", "Defensa", 30);

        Digievolucion ultimate2 =
                new Digievolucion("Ultimate", "Dano", 25);

        Digievolucion adult3 =
                new Digievolucion("Adult", "Ataque", 40);

        Digievolucion mega3 =
                new Digievolucion("Mega", "Defensa", 35);

        Digimon agumon =
                new Digimon("Agumon", "Fuego", 50, 30, adult1);

        Digimon palmon =
                new Digimon("Palmon", "Planta", 45, 35, mega1);

        Digimon gomamon =
                new Digimon("Gomamon", "Agua", 48, 32, ultimate1);

        Digimon tentomon =
                new Digimon("Tentomon", "Electrico", 47, 34, adult2);

        Digimon[] equipo1 = {
                agumon,
                palmon,
                gomamon,
                tentomon
        };

        Digimon biyomon =
                new Digimon("Biyomon", "Fuego", 46, 34, mega2);

        Digimon togemon =
                new Digimon("Togemon", "Planta", 49, 31, ultimate2);

        Digimon betamon =
                new Digimon("Betamon", "Agua", 47, 33, adult3);

        Digimon elecmon =
                new Digimon("Elecmon", "Electrico", 48, 32, mega3);

        Digimon[] equipo2 = {
                biyomon,
                togemon,
                betamon,
                elecmon
        };

        Entrenador entrenador1 =
                new Entrenador("Entrenador 1", equipo1);

        Entrenador entrenador2 =
                new Entrenador("Entrenador 2", equipo2);

        Batalla batalla =
                new Batalla(entrenador1, entrenador2);

        for (int ronda = 1; ronda <= 4; ronda++) {

            System.out.println();
            System.out.println("============================");
            System.out.println("RONDA " + ronda);
            System.out.println("============================");

            System.out.println();
            System.out.println("Digimon del Entrenador 1:");

            for (int i = 0; i < equipo1.length; i++) {

                if (entrenador1.digimonDisponible(i)) {
                    System.out.println(
                            (i + 1) + " - " + equipo1[i].getNombre()
                    );
                }
            }

            System.out.print("Seleccione un Digimon (1-4): ");
            int seleccion1 = scanner.nextInt();

            seleccion1 = seleccion1 - 1;

            while (seleccion1 < 0
                    || seleccion1 >= 4
                    || !entrenador1.digimonDisponible(seleccion1)) {

                System.out.println("Seleccion no valida.");
                System.out.print("Seleccione nuevamente (1-4): ");

                seleccion1 = scanner.nextInt();
                seleccion1 = seleccion1 - 1;
            }

            Digimon digimon1 =
                    entrenador1.seleccionarDigimon(seleccion1);

            entrenador1.marcarComoUtilizado(seleccion1);

            System.out.println();
            System.out.println("Digimon del Entrenador 2:");

            for (int i = 0; i < equipo2.length; i++) {

                if (entrenador2.digimonDisponible(i)) {
                    System.out.println(
                            (i + 1) + " - " + equipo2[i].getNombre()
                    );
                }
            }

            System.out.print("Seleccione un Digimon (1-4): ");
            int seleccion2 = scanner.nextInt();

            seleccion2 = seleccion2 - 1;

            while (seleccion2 < 0
                    || seleccion2 >= 4
                    || !entrenador2.digimonDisponible(seleccion2)) {

                System.out.println("Seleccion no valida.");
                System.out.print("Seleccione nuevamente (1-4): ");

                seleccion2 = scanner.nextInt();
                seleccion2 = seleccion2 - 1;
            }

            Digimon digimon2 =
                    entrenador2.seleccionarDigimon(seleccion2);

            entrenador2.marcarComoUtilizado(seleccion2);

            System.out.println();

            System.out.println(
                    digimon1.getNombre()
                            + " VS "
                            + digimon2.getNombre()
            );

            int ataque1 =
                    digimon1.calcularAtaqueTotal(digimon2);

            int ataque2 =
                    digimon2.calcularAtaqueTotal(digimon1);

            System.out.println(
                    "Ataque total de "
                            + digimon1.getNombre()
                            + ": "
                            + ataque1
            );

            System.out.println(
                    "Ataque total de "
                            + digimon2.getNombre()
                            + ": "
                            + ataque2
            );

            int resultado =
                    batalla.resolverRonda(digimon1, digimon2);

            if (resultado == 1) {

                System.out.println(
                        "Ganador de la ronda: "
                                + entrenador1.getNombre()
                );

            } else if (resultado == 2) {

                System.out.println(
                        "Ganador de la ronda: "
                                + entrenador2.getNombre()
                );

            } else {

                System.out.println(
                        "La ronda termino en empate."
                );
            }

            batalla.registrarResultado(resultado);
        }

        System.out.println();
        System.out.println("============================");
        System.out.println("RESULTADO FINAL");
        System.out.println("============================");

        System.out.println(
                entrenador1.getNombre()
                        + ": "
                        + entrenador1.getRondasGanadas()
                        + " rondas ganadas."
        );

        System.out.println(
                entrenador2.getNombre()
                        + ": "
                        + entrenador2.getRondasGanadas()
                        + " rondas ganadas."
        );

        int ganador = batalla.determinarGanador();

        if (ganador == 1) {

            System.out.println(
                    "Ganador del enfrentamiento: "
                            + entrenador1.getNombre()
            );

        } else if (ganador == 2) {

            System.out.println(
                    "Ganador del enfrentamiento: "
                            + entrenador2.getNombre()
            );

        } else {

            System.out.println(
                    "El enfrentamiento termino en empate."
            );
        }

        scanner.close();
    }
}