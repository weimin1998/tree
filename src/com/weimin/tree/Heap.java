package com.weimin.tree;

import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
        int[] array = {5, 4, 7, 6, 3, 8, 2, 1, 10, 9};

        heapsort(array);
        System.out.println(Arrays.toString(array));
    }

    // 将数组调整为大顶堆
    public static void adjust(int[] array, int i, int length) {
        int temp = array[i];

        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && array[j] < array[j + 1]) {
                //
                j++;
            }
            if (temp < array[j]) {
                array[i] = array[j];
                i = j;
            } else {
                break;
            }
        }

        array[i] = temp;
    }

    // 堆排序
    private static void heapsort(int[] array) {


        int temp = 0;
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjust(array, i, array.length);
        }

        //System.out.println(Arrays.toString(array));

        for (int j = array.length - 1; j > 0; j--) {
            temp = array[j];
            array[j] = array[0];
            array[0] = temp;

            adjust(array, 0, j);
        }
    }
}
