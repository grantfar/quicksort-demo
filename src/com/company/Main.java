package com.company;

public class Main {

    public  static void printArray(int[] toPrint){
        for (int i:toPrint)
        {
            System.out.printf("%d  ",i);
        }
        System.out.println();
    }

    public static void quicksort(int[] tosort, int start, int end){
        System.out.printf("\n**************\n%d is the start index, %d is the end index\n",start,end);
        if(end - start <= 1){
            return;
        }

        int pivot = tosort[start+1];

        printArray(tosort);
        System.out.printf("%d [index %d] is the pivot\n", pivot,start+1);
        tosort[start+1]=tosort[start];
        tosort[start] = pivot;
        int swap;
        int leftIndex = start + 1;
        int rightIndex = end - 1;
        while (leftIndex < rightIndex){
            printArray(tosort);
            while (leftIndex < rightIndex && tosort[rightIndex]>=pivot){
                rightIndex--;
            }
            while (leftIndex < rightIndex && tosort[leftIndex]<pivot){
                leftIndex++;
            }
            swap = tosort[leftIndex];
            tosort[leftIndex] = tosort[rightIndex];
            tosort[rightIndex] = swap;
        }
        if(tosort[leftIndex]<pivot) {
            tosort[start] = tosort[leftIndex];
            tosort[leftIndex] = pivot;
        }
        printArray(tosort);
        boolean isSorted = true;
        for (int i = start; i<rightIndex && isSorted; i++){
            isSorted &= tosort[i]<tosort[i+1];
        }
        if(!isSorted){
            quicksort(tosort,start,rightIndex);
        }
        isSorted = true;
        for (int i = rightIndex+1; i<end-1 && isSorted; i++){
            isSorted &= tosort[i]<tosort[i+1];
        }
        if(!isSorted){
            quicksort(tosort,rightIndex+1,end);
        }
    }
    public static void main(String[] args) {
        int[] toSort = {32, 23, 18, 27, 8, 30, 98, 14, 45, 0, 99, 47, 43, 23, 123, 75, 6, 19, 85};
        quicksort(toSort,0,toSort.length);
    }
}
