public class CambioMonedas {
    private CambioMonedas() {
        // Clase de utilidades: no se crean instancias.
    }

    /** Calcula el minimo de monedas con programacion dinamica para 1, 3 y 4. */
    public static int getChange(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("El dinero no puede ser negativo.");
        }

        int[] coins = {1, 3, 4};
        int[] minCoins = new int[money + 1];

        for (int m = 1; m <= money; m++) {
            minCoins[m] = Integer.MAX_VALUE;

            for (int j = 0; j < coins.length; j++) {
                if (m >= coins[j]) {
                    int numCoins = minCoins[m - coins[j]] + 1;
                    minCoins[m] = Math.min(minCoins[m], numCoins);
                }
            }
        }

        return minCoins[money];
    }
}
