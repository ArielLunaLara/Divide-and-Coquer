public class TorresDeHanoi {
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Movimientos para " + n + " discos:");
        hanoi(n, 'A', 'C', 'B');
    }

    public static void hanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {
            System.out.println("Mover disco 1 de " + fromRod + " a " + toRod);
            return;
        }
        hanoi(n - 1, fromRod, auxRod, toRod);
        System.out.println("Mover disco " + n + " de " + fromRod + " a " + toRod);
        hanoi(n - 1, auxRod, toRod, fromRod);
    }
}
