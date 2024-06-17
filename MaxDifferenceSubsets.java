import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MaxDifferenceSubsets {

    public static void main(String[] args) {
        int n = 50;
        int[] arr = new int[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100) + 1; // Genera números aleatorios entre 1 y 100
        }

        // Dividir en dos sublistas para maximizar la diferencia de sumas
        List<Integer> subset1 = new ArrayList<>();
        List<Integer> subset2 = new ArrayList<>();

        divideArray(arr, subset1, subset2);

        System.out.println("Arreglo original: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Mejor Sublista 1: " + subset1);
        System.out.println("Mejor Sublista 2: " + subset2);

        int sum1 = subset1.stream().mapToInt(Integer::intValue).sum();
        int sum2 = subset2.stream().mapToInt(Integer::intValue).sum();

        System.out.println("Suma Sublista 1: " + sum1);
        System.out.println("Suma Sublista 2: " + sum2);
        System.out.println("Diferencia Máxima: " + Math.abs(sum1 - sum2));
    }

    private static void divideArray(int[] arr, List<Integer> subset1, List<Integer> subset2) {
        Arrays.sort(arr); // Ordenar el arreglo

        for (int i = arr.length - 1; i >= 0; i--) {
            if (subset1.size() < arr.length / 2) {
                subset1.add(arr[i]);
            } else {
                subset2.add(arr[i]);
            }
        }
    }
}
