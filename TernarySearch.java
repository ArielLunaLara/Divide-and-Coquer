import java.util.Arrays;
import java.util.Random;

public class TernarySearch {
    public static void main(String[] args) {
        int[] array = new int[50];
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100); 
        }

        Arrays.sort(array);

        System.out.println("Arreglo ordenado: " + Arrays.toString(array));

        int target = array[rand.nextInt(array.length)];
        System.out.println("Elemento a buscar: " + target);

        int result = ternarySearch(array, target, 0, array.length - 1);

        System.out.println("Elemento encontrado en el índice: " + result);
    }

    public static int ternarySearch(int[] array, int target, int low, int high) {
        if (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;

            if (array[mid1] == target) {
                return mid1;
            } else if (array[mid2] == target) {
                return mid2;
            } else if (target < array[mid1]) {
                return ternarySearch(array, target, low, mid1 - 1);
            } else if (target > array[mid2]) {
                return ternarySearch(array, target, mid2 + 1, high);
            } else {
                return ternarySearch(array, target, mid1 + 1, mid2 - 1);
            }
        }
        return -1;
    }
}
