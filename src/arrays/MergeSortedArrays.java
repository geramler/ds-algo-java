package arrays;

import java.util.Arrays;

public class MergeSortedArrays {

    public static int[] merge(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) {
            return arr2 != null ? arr2 : new int[0];
        }

        if (arr2 == null || arr2.length == 0) {
            return arr1;
        }

        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            result[k++] = (arr1[i] < arr2[j]) ? arr1[i++] : arr2[j++];
        }

        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8, 9};
        System.out.println("Merged: " + Arrays.toString(merge(arr1, arr2)));
    }
}