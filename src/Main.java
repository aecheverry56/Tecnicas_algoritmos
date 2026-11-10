import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ejecutarConteoInversiones();
        ejecutarCambioDinamico();
        ejecutarCambioVoraz();
        PruebaEstresAlgoritmos.ejecutar();
    }

    private static void ejecutarConteoInversiones() {
        int[] numeros = {2, 4, 1, 3, 5};

        System.out.println("=== 1. Conteo de inversiones ===");
        System.out.println("Arreglo original: " + Arrays.toString(numeros));
        System.out.println("Numero de inversiones: "
                + ContadorInversiones.getNumberOfInversions(numeros));
        System.out.println("Arreglo ordenado: " + Arrays.toString(numeros));
        System.out.println();
    }

    private static void ejecutarCambioDinamico() {
        int money = 34;

        System.out.println("=== 2. Cambio con programacion dinamica (1, 3, 4) ===");
        System.out.println("Dinero: " + money + " -> minimo de monedas: "
                + CambioMonedas.getChange(money));
        System.out.println();
    }

    private static void ejecutarCambioVoraz() {
        int money = 28;
        int basico = CambioMonedasBasico.getChange(money);
        int voraz = CambioMonedasVoraz.getChangeGreedy(money);

        System.out.println("=== 3. Cambio voraz (1, 5, 10) ===");
        System.out.println("Dinero: " + money);
        System.out.println("  Enfoque aritmetico: " + basico + " monedas");
        System.out.println("  Enfoque voraz: " + voraz + " monedas");
    }
}
