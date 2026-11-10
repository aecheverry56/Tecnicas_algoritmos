public class CambioMonedasBasico {
    private CambioMonedasBasico() {
        // Clase de utilidades: no se crean instancias.
    }

    /** Calcula el minimo numero de monedas mediante aritmetica basica. */
    public static int getChange(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("El dinero no puede ser negativo.");
        }

        int count = money / 10;

        money %= 10;
        count += money / 5;

        money %= 5;
        count += money;
        return count;
    }
}
