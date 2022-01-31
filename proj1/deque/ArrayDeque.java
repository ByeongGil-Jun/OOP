package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items =(T[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
        size = 0;
    }

    public ArrayDeque(T x){
        items =(T[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
        items[nextFirst] = x;
        nextFirst -= 1;
        size = 1;
    }

    // Adds an item of type T to the front of the deque. You can assume that item is never null.
    @Override
    public void addFirst(T item){
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
    public void resize(int capacity) {
        T[] a =(T[]) new Object[capacity];
        for(int i = 0; i < size; i++) {
            a[i] =items[i];
        }
        items = a;
    }

    //Adds an item of type T to the back of the deque. You can assume that item is never null.
    @Override
    public void addLast(T item){
        if (size == items.length)
            resize(size * 2);
        items[nextLast] = item;
        if (nextLast == items.length-1) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
        size += 1;
    }

    //Returns true if deque is empty, false otherwise.
    @Override
    public boolean isEmpty(){
        if (size == 0)
            return true;
        return false;
    }

    //Returns the number of items in the deque.
    @Override
    public int size(){
        return size;
    }

    //Prints the items in the deque from first to last, separated by a space.
// Once all the items have been printed, print out a new line.
    @Override
    public void printDeque(){
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

    //Removes and returns the item at the front of the deque. If no such item exists, returns null.
    @Override
    public T removeFirst(){
        return null;
    }

    //Removes and returns the item at the back of the deque. If no such item exists, returns null.
    @Override
    public T removeLast() {
        return null;
    }

    //Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
// If no such item exists, returns null. Must not alter the deque!
    @Override
    public T get(int index){
        if (size < index)
            return null;
        if (nextFirst + index <= items.length-1) {
            return items[nextFirst + index];
        } else if (nextLast - index >= 0) {
            return items[nextLast - index];
        }
        return null;
    }
    public T getrecursive(int index){
        return null;
    }

    //The Deque objects we’ll make are iterable (i.e. Iterable<T>) so we must provide this method to return an iterator.
    public Iterator<T> iterator(){
        return null;
    }

    //Returns whether or not the parameter o is equal to the Deque.
// o is considered equal if it is a Deque and if it contains the same contents
// (as goverened by the generic T’s equals method) in the same order.
    @Override
    public boolean equals(Object o){
        if(!(o instanceof java.util.Deque)) {
            return false;
        }
        ArrayDeque te = (ArrayDeque) o;
        for(int i = 0; i < te.size(); i++){

        }

        return true;
    }

    public static void main(String[] args) {

    }
}
