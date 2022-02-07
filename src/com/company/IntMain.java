package com.company;

import com.company.services.IntList;
import com.company.services.impl.IntListImpl;

import java.util.Random;

public class IntMain {

    public static void main(String[] args) {
        IntList intList = new IntListImpl();
        IntList newIntList = new IntListImpl();

        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.removeIndex(1);
        intList.add(1, 2);
        intList.add(5);
        intList.set(5, 6);
        intList.remove(6);

        if (intList.contains(5) || !intList.contains(6)) {
            System.out.println("contains работает");
        }

        if (newIntList.isEmpty()) {
        System.out.println("isEmpty working");
    }

        newIntList.add(1);
        newIntList.add(2);
        newIntList.add(3);
        newIntList.add(4);
        newIntList.add(5);

        System.out.println("index " + intList.indexOf(1));
        System.out.println("index " + intList.lastIndexOf(1));

        if (intList.equals(newIntList)) {
        System.out.println("equals работает");
    }

        System.out.println("Первый intList");
        for (int i = 0; i < intList.size(); i++) {
        System.out.println(intList.get(i));
    }
        System.out.println("Второй intList");
        for (int i = 0; i < newIntList.size(); i++) {
        System.out.println(newIntList.get(i));
    }

        intList.clear();
        if (intList.isEmpty()) {
        System.out.println("clear working");
    }

        Integer[] test = newIntList.toArray();
        System.out.println("test");
        for (Integer s : test) {
        System.out.println(s);
    }

        IntList testSortArray = new IntListImpl();

        testSortArray.add(3);
        testSortArray.add(1);
        testSortArray.add(2);
        testSortArray.add(4);
        testSortArray.add(5);

        System.out.println("Before sort");
        for (int i = 0; i < testSortArray.size(); i++) {
            System.out.println(testSortArray.get(i));
        }

        testSortArray.sort();

        System.out.println("After sort");
        for (int i = 0; i < testSortArray.size(); i++) {
            System.out.println(testSortArray.get(i));
        }

//        IntList testContainsArray = new IntListImpl();
//        generateRandomIntList(testContainsArray, 100);

//        int[] randArr = new int[100_000];
//        randArr = generateRandomArray(randArr);
//        int[] arrForSortA = Arrays.copyOf(randArr, randArr.length);
//        int[] arrForSortB = Arrays.copyOf(randArr, randArr.length);
//        int[] arrForSortC = Arrays.copyOf(randArr, randArr.length);

//        long startA = System.currentTimeMillis();
//        sortBubble(arrForSortA);
//        System.out.println(System.currentTimeMillis() - startA);
//        long startB = System.currentTimeMillis();
//        sortInsertion(arrForSortA); //лучший
//        System.out.println(System.currentTimeMillis() - startB);
//        long startC = System.currentTimeMillis();
//        sortSelection(arrForSortC);
//        System.out.println(System.currentTimeMillis() - startC);



}
//    private static void swapElements(int[] arr, int indexA, int indexB) {
//        int tmp = arr[indexA];
//        arr[indexA] = arr[indexB];
//        arr[indexB] = tmp;
//    }
//    public static void sortBubble(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    swapElements(arr, j, j + 1);
//                }
//            }
//        }
//    }
//    public static void sortSelection(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            int minElementIndex = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[minElementIndex]) {
//                    minElementIndex = j;
//                }
//            }
//            swapElements(arr, i, minElementIndex);
//        }
//    }
    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
    private static int[] generateRandomArray(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000);
        }
        return arr;
    }

    private static IntList generateRandomIntList(IntList arr, int size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr.add(random.nextInt(100));
        }
        return arr;
    }
}
