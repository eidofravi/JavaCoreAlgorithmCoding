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
        int k = 0;
        int prev = 0;
        int prevIndex[] = new int[2];
        int stI = 0;
        int stJ = 0;
        int it = 0, ib = 3, jl = 0, jr = 3;
        int m = row - 1;
        int t = 0;
        while (row > 1) {
            System.out.println();
            while (t < m) {
                k = 0;
                prev = arr[stI][stJ];
                prevIndex = new int[]{stI, stJ};
                while (k < 4) {
                    int[] newIndex = getIndex(prevIndex[0], prevIndex[1], it, ib, jl, jr, m);
                    int i = newIndex[0], j = newIndex[1];
                    int temp = arr[i][j];
                    arr[i][j] = prev;
                    prev = temp;
                    prevIndex = newIndex;
                    k++;
                }
                stJ++;
                t++;
            }
            t = 0;
            row = row - 2;
            stI++;
            stJ = stI;
            it++;
            ib--;
            jl++;
            jr--;
            m = row - 1;
        }
        return arr;
    }
    //     0,1
    //   1 2 3 4
    //     5 6 7 8 1,0
    //    9 10 11 12
    //    13 14 15 16

    private static int[] getIndex(int i, int j, int it, int ib, int jl, int jr, int m) {   // m = 3,
        int[] index = new int[2];

        if (i == it) {
            j = j + m;
            if (j > jr) {
                int i_temp = j - jr;
                return new int[]{i + i_temp, jr};
            }
            return new int[]{i, j};

        } else if (j == jr) {
            i = i + m;
            if (i > ib) {
                int j_temp = i - ib;
                j = jr - j_temp;
                i = ib;
                return new int[]{i, j};
            }
            return new int[]{i, j};

        } else if (i == ib) {
            j = j - m;
            if (j < jl) {
                int i_temp = jl - j;
                return new int[]{i - i_temp, jl};
            }
            return new int[]{ib, j};
        } else if (j == jl) {
            i = i - m;
            if (i < it) {
                int j_temp = it - i;
                return new int[]{it, jl + j_temp};
            }
            return new int[]{i, jl};
        }
        return index;
    }
}
