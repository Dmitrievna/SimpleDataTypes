import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * 
 * Here will be a discription
 * 
 * @author Ivanova Yulia
 * 
 */ 

public class Deque<Item> implements Iterable<Item> {
    private int n;                          // size of the queue
    private Node first;                     // first item
    private Node last;                      // last item
        
    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
        private Node previous;
    }
    
    /**
     * Initialize an emptu deque.
     * 
     */
    
    public Deque() {
        first = null;
        last = null;
        n = 0;    
    }
    
    /**
     * Is this deque empty?
     * @return true if this deque is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null && last == null;
    }
    
    /**
     * Returns the number of items in the deque.
     * @return the number of items in the deque.
     */
    public int size() {
        return n;
    }
    
    /**
     * Adds item at the top of the deque.
     * @param item the item to add.
     */
    public void addFirst(Item item) {
        if (item == null) throw new java.lang.NullPointerException();
        if (!isEmpty()) {
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
            oldfirst.previous = first;
            n++;
        } else { 
            last = new Node();
            first = new Node();
            last.item = item;
            first = last;
            n++;
        }
    }
    
    /**
     * Adds item at the end of the deque.
     * @param item the item to add.
     */
    public void addLast(Item item) {
        if (item == null) throw new java.lang.NullPointerException();
        if (isEmpty()) {
            first = new Node();
            last = new Node();
            first.item = item;
            last = first;
            n++;
        } else {
            Node oldlast = last;        
            last = new Node();
            last.item = item;
            oldlast.next = last;
            last.previous = oldlast;
            n++;
            // System.out.println("//first.item: " + first.item + " //first.next: " + first.next + "//first.previous: " + first.previous);
            // System.out.println("//last.item: " + last.item + " //last.next: " + last.next + "//last.previous: " + last.previous);
        }
    }
    
    /**
     * Removes and returns the item from the top of the deque
     * @return the item from the top
     * @throws java.util.NoSuchElementException if this deque is empty
     */
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow");
            n--;   
            Item item = first.item;
            first = first.next;
            if (size() != 0) {first.previous = null;}
            else {first = last = null;}
        return item;
    }
    
    /**
     * Removes and returns the item from the bottom of the deque
     * @return the item from the bottom
     * @throws java.util.NoSuchElementException if this deque is empty
     */
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow");
            n--;
            Item item = last.item;
            last = last.previous;
            if (size() != 0) {last.next = null;}
            else {first = last = null;}
        return item;
    } 
        
        
        
    
    /**
     * Returns an iterator to this Deque that iterates through the items in LIFO order.
     * @return an iterator to this Deque that iterates through the items in LIFO order.
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
    
    
  /*   public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }*/
     
     
     public static void main(String[] args) {
     
     Deque<Integer> deque = new Deque<Integer>();
     //System.out.println("Begin: " + deque.isEmpty() + " " + deque.toString() + " " + deque.size());
     deque.addLast(1);
     deque.removeFirst();
     deque.addFirst(2);
     deque.addFirst(3);
     deque.addFirst(4);
     deque.addLast(5);
     deque.addLast(6);
     deque.addLast(7);
     deque.removeLast();
     deque.removeLast();
     deque.removeLast();
     deque.removeLast();
     deque.removeLast();
     deque.removeLast();
     deque.addFirst(8);
     deque.addLast(9);
     deque.addFirst(10);
     deque.addFirst(11);
     deque.addFirst(12);
     deque.addLast(13);
     deque.addLast(14);
     deque.addLast(15);
     deque.removeFirst();
     deque.removeFirst();
     deque.removeFirst();
     deque.removeFirst();
     deque.removeLast();
     deque.removeLast();
     deque.addLast(1);
     deque.removeFirst();
     deque.addFirst(2);
     deque.addFirst(3);
     deque.addFirst(4);
     deque.addLast(5);
     deque.addLast(6);
     deque.addLast(7);
     deque.removeLast();
     deque.removeLast();
     deque.removeLast();
     deque.removeLast();
     deque.removeLast();
     deque.removeLast();
     deque.addFirst(8);
     deque.addLast(9);
     deque.addFirst(10);
     deque.addFirst(11);
     deque.addFirst(12);
     deque.addLast(13);
     deque.addLast(14);
     deque.addLast(15);
     deque.removeFirst();
     deque.removeFirst();
     deque.removeFirst();
     deque.removeFirst();
     deque.removeLast();
     deque.removeLast();
     //System.out.println(deque.isEmpty() + " " + deque.toString() + " " + deque.size());
     
     

     
     
     
     }
}