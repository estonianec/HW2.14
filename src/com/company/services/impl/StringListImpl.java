package com.company.services.impl;

import com.company.services.StringList;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {

    private final int START_SIZE = 4;
    private String[] array = new String[START_SIZE];
    private int position = 0;

    @Override
    public String add(String item) {
        isNeedResize();
        array[position] = item;
        position++;
        return item;
    }

    @Override
    public void isNeedResize() {
        if (array.length == position) {
            array = Arrays.copyOf(array, position * 2);
        }
    }

    @Override
    public String add(int index, String item) {
        checkIncomingIndex(index);
        isNeedResize();
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
    public String set(int index, String item) {
        checkIncomingIndex(index);
        array[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        int index = indexOf(item);
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        remove(index);
        return item;
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index > position) {
            throw new IllegalArgumentException();
        }
        if (position - 1 - index >= 0) System.arraycopy(array, index + 1, array, index, position - 1 - index);
        position--;
        array[position] = null;
        return array[index];
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) >= 0;
    }

    @Override
    public int indexOf(String item) {
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
    public int lastIndexOf(String item) {
        for (int i = position - 1; i >= 0 ; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index > array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
            return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
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
        array = new String[START_SIZE];
        position = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(array, array.length);
    }
}
