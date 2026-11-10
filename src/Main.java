import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numeros = {2, 4, 1, 3, 5};

        System.out.println("Arreglo original: " + Arrays.toString(numeros));

        long inversiones = ContadorInversiones.getNumberOfInversions(numeros);

        System.out.println("Numero de inversiones: " + inversiones);
        System.out.println("Arreglo ordenado: " + Arrays.toString(numeros));

        ContadorInversiones.stressTesting(1_000);
        System.out.println("Prueba aleatoria: correcta (1.000 casos).");
    }
}
