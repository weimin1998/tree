package com.weimin.tree;

public class Heap {
    public static void main(String[] args) {
        int[] array = {5,4,7,3,4,1,9,8,2,10};

        heapsort(array);
    }

    // 将数组调整为大顶堆
    public  static void adjust(int[] array,int i,int length){
        int temp = array[i];

        for (int j = i*2+1; j <length ; j = j*2+1) {
            if(j+1<length&&array[j]<array[j+1]){
                //
                j++;
            }
            if(temp<array[j]){
                array[i] = array[j];
                i = j;
            }else {
                break;
            }
        }
    }

    // 堆排序
    private static void heapsort(int[] array) {
    }
}
