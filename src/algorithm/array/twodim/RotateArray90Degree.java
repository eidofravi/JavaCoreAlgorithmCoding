package algorithm.array.twodim;

import core.java.TwoDimensionalArray;



public class RotateArray90Degree {
    public static void main(String[] args) {
        int[][] arr = TwoDimensionalArray.getArray();
        int[][] rotatedArr = rotatedArray(arr);
        System.out.println(rotatedArr);
    }

    private static int[][] rotatedArray(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;

        int el = 4 * row - 4;
        int k = 0;

        int prev = arr[0][0];
        int prevIndex[] = {0,0};

        while (k < el) {
            int[] newIndex = getIndex(prevIndex[0], prevIndex[1], 0, 3, 0, 3, 3);
            int i = newIndex[0], j = newIndex[1];
            int temp = arr[newIndex[i]][j];
            arr[i][j] = prev;
            prev = temp;
            prevIndex = newIndex;
            k++;
        }
        return arr;
    }

                 //   1 2 3 4
               //    5 6 7 8
                //    9 10 11 12
                //    13 14 15 16

    private static int[] getIndex(int i, int j, int it, int ib, int jl, int jr, int m) {
        int[] index = new int[2];

        if (i == it) {
            i = i + m;
            if (i > jr) {
                i = jr;
            }

        } else if (j == jr) {

        }

        return index;
    }
}
