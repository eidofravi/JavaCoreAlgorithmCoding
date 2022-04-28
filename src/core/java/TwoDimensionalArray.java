package core.java;

public class TwoDimensionalArray {

    public static void main(String[] args) {
        int[][] arr = getArray();
        System.out.println(arr);
    }

    public static int[][] getArray() {

        int[][] arr = new int[4][4];
        System.out.println("rows " + arr.length);
        System.out.println("columns " + arr[0].length);

        System.out.println("rows " + arr.length);
        System.out.println("columns " + arr[0].length);
        int rows = arr.length;
        int cols = arr[0].length;
        int k = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = k++;
            }
        }
        System.out.println(arr);
        return arr;
    }
}
