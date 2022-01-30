package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T> {
    private class Node {
        public T item;
        public Node next;
        public Node prev;

        public Node(Node p, T i, Node t) {
            item = i;
            next = t;
            prev = p;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel =new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public LinkedListDeque(T x){
        sentinel =new Node(null, null, null);
        sentinel.next = new Node(sentinel, x, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

// Adds an item of type T to the front of the deque. You can assume that item is never null.
    @Override
    public void addFirst(T item){
        sentinel.next = new Node(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

//Adds an item of type T to the back of the deque. You can assume that item is never null.
    @Override
    public void addLast(T item){
        sentinel.prev = new Node(sentinel.prev, item, sentinel);
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
        Node temp = sentinel.next;
        while(temp.next != sentinel.next) {
            System.out.println(temp.item);
            temp = temp.next;
        }
    }

//Removes and returns the item at the front of the deque. If no such item exists, returns null.
    @Override
    public T removeFirst() {
        if (isEmpty())
            return null;
        T item = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size --;
        return item;
    }

//Removes and returns the item at the back of the deque. If no such item exists, returns null.
    @Override
    public T removeLast() {
        if (isEmpty())
            return null;
        T item = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size --;
        return item;
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
        Deque temp = null;
        if(o instanceof  Deque) {
            temp = TypeCon(o);
        } else {
            return false;
        }
        if(this.size() != temp.size())
            return false;
        if(!ItemEqual(this, temp)) {
            return false;
        }
        return true;
    }

    public Deque TypeCon(Object o) {
        if(o instanceof  LinkedListDeque) {
            return (LinkedListDeque) o;
        } else if(o instanceof ArrayDeque) {
            return (ArrayDeque) o;
        }
        return null;
    }

    public boolean ItemEqual(Deque a, Deque b) {
        for(int i = 0; i < a.size(); i++) {
            if(a.get(i) != b.get(i))
                return false;
        }
        return true;
    }


    public boolean SizeEqual(int a, int b) {
        return (a == b);
    }
    public static void main(String[] args) {
        LinkedListDeque<String> Deque = new LinkedListDeque<String>();
        Deque.addFirst("2");
        System.out.println(Deque.size());
        Deque.addFirst("1");
        Deque.addLast("3");
        System.out.println(Deque.size());
        Deque.printDeque();
    }
}

