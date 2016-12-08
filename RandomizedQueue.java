/**
 * Here will be a description
 */

import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] a;       // array of Items
    private int n;          // number of elements in the queue
    
    
    /**
     * Initiliazes an empty stack.
     */
    public RandomizedQueue() {
        a = (Item[]) new Object[2];
        n = 0;
    }
    
    /**
     * Is this queue empty?
     * @return true if this queue is empty; false otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }
    
    /**
     * Returns number of items in the queue.
     * @return number of items in the queue
     */
    public int size() {
        return n;
    }
    
    // resize undelying array holding the elements
    private void resize(int capacity) {
        // textbook implementation
        @SuppressWarnings("unchecked")
        Item[] temp = (Item[]) new Object[capacity];
       // Item[] temp = new Item[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
    
    /**
     * add an item to the queue.
     * @param is an item to add
     */
    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException();
        if (n == a.length) resize(2*a.length);     // double size of array if necessary
        a[n++] = item;                             // add item
    }
        
    /**
     * Removes and returns the random item from the queue.
     * @return the random item from the queue
     * @throws java.util.NoSuchElementException if there is no elements in the queue
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        StdRandom.shuffle(a, 0, n-1);
        Item item = a[n-1];
        a[n - 1] = null;
        n--;
        // shrink array if necessary 
        if (n > 0 && n == a.length/4) resize(a.length/2);
        return item;
    }
    
    /**
     * Returns but not remove an item from the queue.
     * @return item to show.
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return a[StdRandom.uniform(0,n)];        
    }
    
    
    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     * @return an iterator to this stack that iterates through the items in LIFO order.
     */
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;

        public ReverseArrayIterator() {
            i = n-1;
            StdRandom.shuffle(a, 0, n-1);
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            
            return a[i--];
        }
    }
        
     /**
     * Returns a string representation of this queue.
     * @return the sequence of items in the stack in LIFO order, separated by spaces
     */
 /*   public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }*/
    
    public static void main(String[] args) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
       // System.out.println("Begin: " + queue.toString() + " isEmpty: " + queue.isEmpty() + " elements: " + queue.size());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        //System.out.println("1: " + queue.toString() + " isEmpty: " + queue.isEmpty() + " elements: " + queue.size());
       // System.out.println("Dequeue: " + queue.dequeue() + " elements: " + queue.toString());
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        /*System.out.println("1: " + queue.toString() + " isEmpty: " + queue.isEmpty() + " elements: " + queue.size());
        System.out.println("Dequeue: " + queue.dequeue() + " elements: " + queue.toString());
        System.out.println("Dequeue: " + queue.dequeue() + " elements: " + queue.toString());
        System.out.println("Dequeue: " + queue.dequeue() + " elements: " + queue.toString());
        System.out.println("Dequeue: " + queue.dequeue() + " elements: " + queue.toString());
        System.out.println("Dequeue: " + queue.dequeue() + " elements: " + queue.toString());
        System.out.println("Dequeue: " + queue.dequeue() + " elements: " + queue.toString());
        System.out.println("Dequeue: " + queue.dequeue() + " elements: " + queue.toString());*/
        queue.enqueue(9);
        queue.enqueue(10);
        queue.enqueue(11);
        queue.enqueue(12);
       // System.out.println("1: " + queue.toString() + " isEmpty: " + queue.isEmpty() + " elements: " + queue.size());
       // System.out.println("Dequeue: " + queue.dequeue() + " elements: " + queue.toString());
        queue.enqueue(13);
        queue.enqueue(14);
        queue.enqueue(15);
        queue.enqueue(16);
        //System.out.println("Elements: " + queue.toString());
       /* Iterator itr1 = queue.iterator();
        Iterator itr2 = queue.iterator();
        while (itr1.hasNext() && itr2.hasNext()) {
            Object element1 = itr1.next();
            Object element2 = itr2.next();
            System.out.println(element1 + " " + element2);
      
        }*/
        
        
    }
    

        
        



}