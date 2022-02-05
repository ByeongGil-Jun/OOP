package deque;

import afu.org.checkerframework.checker.oigj.qual.O;

import java.util.Iterator;
import java.util.Comparator;

public class MaxArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private Comparator comparator;

    public MaxArrayDeque(Comparator<T> c) {
        items = (T[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
        comparator = c;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length)
            resize(size * 2);
        items[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = items.length-1;
        } else {
            nextFirst -= 1;
        }
        size += 1;
    }

    @Override
    public void addLast(T item) {
        if (size == items.length)
            resize(size * 2);
        items[nextLast] = item;
        if (nextLast == items.length-1) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
        size ++;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    @Override
    public int size() {return size;}

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        for(int i = 0; i < size; i++) {
            a[i] = get(i+1);
        }
        nextFirst = a.length - 1;
        nextLast = size;
        items = a;
    }

    @Override
    public void printDeque() {
        int temp = nextFirst+1;
        while(temp != nextLast) {
            System.out.println(items[temp]);
            if (temp == items.length-1) {
                temp = 0;
            } else {
                temp ++;
            }
        }
    }

    @Override
    public T removeFirst() {
        if (isEmpty() == true)
            return null;
        T RemoveVal;
        if (nextFirst == items.length-1) {
            nextFirst = 0;
            RemoveVal = items[nextFirst];
            items[nextFirst] = null;
        } else {
            nextFirst ++;
            RemoveVal = items[nextFirst];
            items[nextFirst] = null;
        }
        size -= 1;
        if (size < items.length / 4 && items.length > 8) {
            resize(items.length / 4);
        }
        return RemoveVal;
    }

    @Override
    public T removeLast() {
        if (isEmpty() == true)
            return null;
        T RemoveVal;
        if (nextLast == 0) {
            nextLast = items.length-1;
            RemoveVal = items[nextLast];
            items[nextLast] = null;
        } else {
            nextLast --;
            RemoveVal = items[nextLast];
            items[nextLast] = null;
        }
        size -= 1;
        if (size < items.length / 4 && items.length > 8) {
            resize(items.length / 4);
        }
        return RemoveVal;
    }

    @Override
    public T get(int index) {
        if (size < index || index == 0)
            return null;
        if (nextFirst + index < items.length) {
            return items[nextFirst + index];
        } else {
            return items[nextFirst + index - items.length];
        }
    }

    public T max() {
        if (isEmpty() == true)
            return null;
        T max = null;
        for(int i = 1; i < size; i++) {
            if (comparator.compare(get(i), get(i+1)) > 0) {
                max = get(i);
            } else {
                max = get(i+1);
            }
        }
        return max;
    }

    public T max(Comparator<T> c) {
        if (isEmpty() == true)
            return null;
        T max = null;
        for(int i = 1; i < size; i++) {
            if (c.compare(get(i), get(i+1)) > 0) {
                max = get(i);
            } else {
                max = get(i+1);
            }
        }
        return max;
    }

    //not yet
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        Deque temp = null;
        if(o instanceof  LinkedListDeque) {
            temp = (LinkedListDeque) o;
        } else if (o instanceof ArrayDeque){
            temp = (ArrayDeque) o;
        } else {
            return false;
        }
        if(size != temp.size())
            return false;
        if(!ItemEqual(temp)) {
            return false;
        }
        return true;
    }

    private boolean ItemEqual(Deque a) {
        for(int i = 1; i <= a.size(); i++) {
            if(a.get(i) != get(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Comparator<String> c = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        MaxArrayDeque<String> a = new MaxArrayDeque<>(c);
        a.addFirst("aaaa");
        a.addFirst("bab");
    }
}
