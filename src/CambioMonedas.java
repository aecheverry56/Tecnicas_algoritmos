public class CambioMonedas {
    private static final int[] DENOMINACIONES = {1, 3, 4};

    private CambioMonedas() {
        // Clase de utilidades: no se crean instancias.
    }

    /**
     * Calcula el numero minimo de monedas para formar {@code money}.
     * Usa programacion dinamica para las denominaciones 1, 3 y 4.
     */
    public static int getChange(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("El dinero no puede ser negativo.");
        }

        int[] minCoins = new int[money + 1];
        minCoins[0] = 0;

        for (int amount = 1; amount <= money; amount++) {
            minCoins[amount] = Integer.MAX_VALUE;

            for (int coin : DENOMINACIONES) {
                if (coin <= amount && minCoins[amount - coin] != Integer.MAX_VALUE) {
                    minCoins[amount] = Math.min(minCoins[amount], minCoins[amount - coin] + 1);
                }
            }
        }

        return minCoins[money];
    }
}
