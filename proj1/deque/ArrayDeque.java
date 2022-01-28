package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T> {

    private class Node {
        public T item;
        public ArrayDeque.Node next;
        public ArrayDeque.Node prev;

        public Node(ArrayDeque.Node p, T i, ArrayDeque.Node t) {
            item = i;
            next = t;
            prev = p;
        }
    }

    private ArrayDeque.Node sentinel;
    private int size;

    public ArrayDeque(){
        sentinel =new ArrayDeque.Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public ArrayDeque(T x){
        sentinel =new ArrayDeque.Node(null, null, null);
        sentinel.next = new ArrayDeque.Node(sentinel, x, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    // Adds an item of type T to the front of the deque. You can assume that item is never null.
    @Override
    public void addFirst(T item){
        sentinel.next = new ArrayDeque.Node(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    //Adds an item of type T to the back of the deque. You can assume that item is never null.
    @Override
    public void addLast(T item){
        sentinel.prev = new ArrayDeque.Node(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    //Returns true if deque is empty, false otherwise.
    @Override
    public boolean isEmpty(){
        if (sentinel.equals(sentinel.next) == true && sentinel.equals(sentinel.prev) == true)
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
        ArrayDeque.Node temp = sentinel.next;
        while(temp.next != sentinel.next) {
            System.out.println(temp.item);
            temp = temp.next;
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
