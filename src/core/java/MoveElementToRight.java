package core.java;

public class MoveElementToRight {

    public static void main(String[] args) {
        int[] result = moveToRight(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);

    }
    private static int[] moveToRight(int[] arr, int k) {

        if (k <= 0 || arr.length < 2) {
            return arr;
        }
        int i = 0;
        int count = 0;
        int prev = arr[i];
        while (count < arr.length) {
            i = (i + k) % arr.length;
            int temp = arr[i];
            arr[i] = prev;
            prev = temp;
            count++;
        }
        return arr;
    }
}
