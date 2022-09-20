package edu.touro.cs.mcon364;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList implements List<String> {
    private String[] backingStore = new String[10];
    private int ip = 0; // insertionPoint

    @Override
    public int size() {
        return ip;
    }

    @Override
    public boolean isEmpty() {
        return ip == 0;
    }

    @Override
    public void clear() {
        backingStore = new String[10];
        ip = 0;
    }

    private int find(Object o) {
        if (o != null && !(o instanceof String)) {
            return -1;
        }

        String s = (String) o;
        for (int i = 0; i < ip; i++) {
            if ((o == null && backingStore[i] == null) || backingStore[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object o) {
        return find(o) != -1;
    }

    private void OOBCheck(int i, boolean forAdd) {
        if (i < 0 || (forAdd ? i > ip : i >= ip)) {
            throw new IndexOutOfBoundsException(String.format("Index %d is out of bounds for length %d.", i, ip));
        }
    }

    @Override
    public String get(int index) {
        OOBCheck(index, false);
        return backingStore[index];
    }

    @Override
    public String set(int index, String element) {
        OOBCheck(index, false);

        String old = backingStore[index];
        backingStore[index] = element;
        return old;
    }

    private void growBackingStore() {
        String[] newBs = new String[2 * backingStore.length + 1];
        System.arraycopy(backingStore, 0, newBs, 0, backingStore.length);
        backingStore = newBs;
    }

    @Override
    public void add(int index, String element) {
        OOBCheck(index, true);

        if (ip >= backingStore.length) {
            growBackingStore();
        }

        System.arraycopy(backingStore, index, backingStore, index+1, ip - index);
        backingStore[index] = element;
        ip++;
    }

    @Override
    public boolean add(String s) {
        if (ip >= backingStore.length) {
            growBackingStore();
        }

        backingStore[ip++] = s;
        return true;
    }

    @Override
    public String remove(int index) {
        OOBCheck(index, false);

        String s = backingStore[index];
        int newSize;

        if ((newSize = ip-1) > index) { // if size - 1 < index, it means the last element was removed
            System.arraycopy(backingStore, index + 1, backingStore, index, newSize - index);
        }
        backingStore[newSize] = null;
        ip = newSize;
        return s;
    }

    // todo all below

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public ListIterator<String> listIterator() {
        return null;
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return null;
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return null;
    }
}
