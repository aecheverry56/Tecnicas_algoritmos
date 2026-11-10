public class CambioMonedasVoraz {
    private CambioMonedasVoraz() {
        // Clase de utilidades: no se crean instancias.
    }

    /** Calcula el minimo numero de monedas usando el enfoque voraz iterativo. */
    public static int getChangeGreedy(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("El dinero no puede ser negativo.");
        }

        int changes = 0;
        int count = 0;
        int[] denominations = {1, 5, 10};
        int max = denominations.length - 1;

        while (changes < money) {
            while (changes <= money && money - changes >= denominations[max]) {
                changes += denominations[max];
                count++;
            }
            max--;
        }

        return count;
    }
}
