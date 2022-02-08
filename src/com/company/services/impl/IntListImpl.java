package com.company.services.impl;

import com.company.services.IntList;

import java.util.Arrays;
import java.util.Objects;

public class IntListImpl implements IntList {
 private final int START_SIZE = 4;
    private Integer[] array = new Integer[START_SIZE];
    private int position = 0;

    @Override
    public Integer add(int item) {
        checkNeedResize();
        array[position] = item;
        position++;
        return item;
    }

    private void checkNeedResize() {
        if (array.length == position) {
            grow();
        }
        if (position < array.length / 2) {
            resize();
        }
    }

    private void grow() {
        array = Arrays.copyOf(array, (int) (position * 1.5));
    }

    private void resize() {
        array = Arrays.copyOf(array, (int) (array.length * 0.667));
    }

    @Override
    public Integer add(int index, int item) {
        checkIncomingIndex(index);
        checkNeedResize();
        if (position - index >= 0) System.arraycopy(array, index, array, index + 1, position - index);
        array[index] = item;
        position++;
        return item;
    }

    public void checkIncomingIndex(int index) {
        if (index < 0 || index > position) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public Integer set(int index, int item) {
        checkIncomingIndex(index);
        array[index] = item;
        return item;
    }

    @Override
    public Integer remove(int item) {
        int index = indexOf(item);
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        removeIndex(index);
        checkNeedResize();
        return item;
    }

    @Override
    public Integer removeIndex(int index) {
        if (index < 0 || index > position) {
            throw new IllegalArgumentException();
        }
        if (position - 1 - index >= 0) System.arraycopy(array, index + 1, array, index, position - 1 - index);
        position--;
        array[position] = null;
        checkNeedResize();
        return array[index];
    }

    @Override
    public boolean contains(int item) {
        sort();
        int min = 0;
        int max = position;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (mid == max) {
                return false;
            }

            if (item == array[mid]) {
                return true;
            }

            if (item < array[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(int item) {
        {
            for (int i = 0; i < position; i++) {
                if (array[i].equals(item)) {
                    return i;
                }
            }
            return -1;
        }
    }

    @Override
    public int lastIndexOf(int item) {
        for (int i = position - 1; i >= 0 ; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index > array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
            return array[index];
    }

    @Override
    public boolean equals(IntList otherList) {
        if (otherList == null) {
            throw new NullPointerException();
        }
        if (otherList.size() != array.length) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (!Objects.equals(array[i], otherList.get(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int size() {
        return position;
    }

    @Override
    public boolean isEmpty() {
        return position == 0;
    }

    @Override
    public void clear() {
        array = new Integer[START_SIZE];
        position = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(array, array.length);
    }

    @Override
    public void sort() {
    quickSort(array, 0 , position - 1);
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }


}
