import java.util.Arrays;

public class Main {
    public static String one(String str) { //Задача 1
        String usedChars="";

        int start = 0, maxStart = 0, curLength = 0, maxLength = 0;

        for(int i = 0; i < str.length(); i++) {
            String currentChar = "" + str.charAt(i);
            if (usedChars.contains(currentChar)) {
                start = i;
                usedChars = "";
            }
            usedChars+=currentChar;
            curLength = i - start + 1;
            if (curLength > maxLength) {
                maxLength = curLength;
                maxStart = start;
            }
        }
        return (str.substring(maxStart, maxStart+maxLength));
    }
    public static int[] two(int array1[], int array2[]) { //Задача 2
        int result[] = new int[array1.length + array2.length];
        int temp1 = 0, temp2 = 0;

        for (int i = 0; i < (array1.length + array2.length); i++) {
            if (temp1 < array1.length && (temp2 >= array2.length || array1[temp1] <= array2[temp2])) {
                result[i] = array1[temp1];
                temp1++;
            } else {
                result[i] = array2[temp2];
                temp2++;
            }
        }
        return result;
    }
    public static int[] three(int array[]) { //Задача 3
        int maxEndingHere = array[0];
        int maxSoFar = array[0];
        int startIndex = 0;
        int endIndex = 0;
        int tempStartIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxEndingHere + array[i]) {
                maxEndingHere = array[i];
                tempStartIndex = i;
            } else {
                maxEndingHere = maxEndingHere + array[i];
            }

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                startIndex = tempStartIndex;
                endIndex = i;
            }
        }

        int[] result = new int[endIndex - startIndex + 1];
        System.arraycopy(array, startIndex, result, 0, endIndex - startIndex + 1);

        return result;
    }
    public static int[][] four(int matrix[][]) { //Задача 4
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][rows - 1 - i] = matrix[i][j];
            }
        }

        return result;
    }
    public static int[] five(int[]array, int target) { //Задача 5
        int result[] = {-9999999,-9999999};
        boolean flag = false;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j) {
                    if (target == (array[i] + array[j])){
                        result[0] = array[i];
                        result[1] = array[j];
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) break;
        }
        if (result[0] == -9999999 & result[1] == -9999999) {
            return null;
        } else {
            return result;
        }
    }
    public static int six(int[][]mas) { //Задача 6
        int sum = 0;
        for (int[] row : mas) {
            for (int element : row) {
                sum+=element;
            }
        }
        return sum;
    }
    public static int[][] seven(int matrix[][]) { //Задача 7
        int rows = matrix.length;
        int cols = matrix[0].length;

        int tempmax = 0;

        int result[][] = new int[matrix.length][1];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > tempmax) tempmax = matrix[i][j];
            }
            result[i][0] = tempmax;
            tempmax = 0;
        }
        return result;
    }
    public static int[][] eight(int matrix[][]) { //Задача 8
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[cols - 1 - j][i] = matrix[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        /*
        //Первое задание
        String str = "ababbacdea";
        System.out.println(one(str));
        */

        /*
        //Второе задание
        int array1[] = {1, 3, 7, 8, 20, 30};
        int array2[] = {2, 3, 9, 10};
        int result[] = two(array1,array2);
        */

        /*
        //Третье задание
        int[] array = {1, -2, 3, 4, -1, 2, 1, -5, 4};
        int[] maxSubarray = three(array);
        System.out.println(Arrays.toString(maxSubarray));
        */

        /*
        //Четвёртое задание
        int matrix[][] = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12}
        };
        int result[][] = four(matrix);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        */

        /*
        //Пятое задание
        int[]array = {1,2,3,4,5,6};
        int target = 7;
        if (five(array,target) != null) {
            int []result = five(array,target);
            System.out.println(result[0] + " " + result[1]);
        }
        */

        /*
        //Шестое задание
        int[][]mas = {
                {1,2,3},
                {4,5,6}
        };
        System.out.println(six(mas));
        */

        /*
        //Седьмое задание
        int matrix[][] = {
                {1,2,3},
                {8,5,6},
                {14,8,9},
                {10,11,12}
        };
        int result[][] = seven(matrix);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        */

        /*
        //Восьмое задание
        int matrix[][] = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12}
        };
        int result[][] = eight(matrix);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        */
    }
}