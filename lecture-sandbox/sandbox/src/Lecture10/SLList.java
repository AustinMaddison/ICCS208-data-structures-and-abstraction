package Lecture10;

import java.util.Iterator;

/**
 * This acts as a wrapper for IntNode
 */
public class SLList implements Iterable<Integer> {
    private class SLListIterator implements Iterator<Integer> {
        IntNode currentNode = sen.next;
        @Override
        public boolean hasNext() {
            if(size <= 0) return false;
            if(currentNode == null) return false;
            return true;
        }

        @Override
        public Integer next() {
            int returnVal = currentNode.head;
            currentNode = currentNode.next;
            return returnVal;
        }
    }

    private static class IntNode {
        // instance variables
        int head;
        IntNode next;

        public IntNode(int head, IntNode rest) {
            this.head = head;
            this.next = rest;
        }

        public int size() {
            if (this.next == null)
                return 1;
            else
                return 1 + this.next.size();
        }

        public int iterativeSize() {
            IntNode current = this;
            int totalSize = 0;

            while (current != null) {
                totalSize++;
                current = current.next;
            }

            return totalSize;
        }
    }

    private IntNode sen;
    private IntNode end;
    private int size;

    public SLList() {
        this.sen = new IntNode( -1,null);
        this.end = null;
        this.size = 0;
    }

    public void addFirst(int x) {
        this.size++;
        this.sen.next = new IntNode(x, this.sen.next);
    }

    public void addLast(int x) {
        this.size++;
        IntNode current = sen;
        for(; current.next != null; current = current.next);

        current.next = new IntNode(x, null);
    }

    public int getFirst() {
        return this.sen.next.head;
    }
    public int getLast() {
        IntNode current = sen;
        for(; current.next != null; current = current.next);
        return current.head;
    }


    public int size() {
        return this.size;
    }

    public void removeFirst() {
        size--;
        this.sen.next = this.sen.next.next;
    }

    public void insert(int newValue, int k) {
        this.size++;
        IntNode current = sen;
        for(int index = 0; index < k; current = current.next) {
            ++index;
        };
        IntNode newNode = new IntNode(newValue, null);
        newNode.next = current.next;
        current.next = newNode;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new SLListIterator();
    }

}
