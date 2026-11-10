public class Main {
    public static void main(String[] args) {
        int money1 = 2;
        int money2 = 34;

        System.out.println("Cambio de monedas con denominaciones 1, 3 y 4");
        System.out.println("Dinero: " + money1 + " -> minimo de monedas: "
                + CambioMonedas.getChange(money1));
        System.out.println("Dinero: " + money2 + " -> minimo de monedas: "
                + CambioMonedas.getChange(money2));
    }
}
