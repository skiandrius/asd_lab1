package main;

public class LinkedList<E> {
    private ListItem<E> firstItem;
    private ListItem<E> lastItem;
    private ListItem<E> item;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public boolean add(final E e) {
        if (size == 0) {
            firstItem = new ListItem<E>(e);
            firstItem.setIndex(0);
            lastItem = firstItem;
        } else {
            item = new ListItem<E>(e);
            item.setIndex(size);
            lastItem = lastItem.setNext(item);
        }
        size++;
        return true;
    }

    public boolean remove(final Object o) {
        if (isEmpty()) {
            return false;
        }
        item = firstItem;
        ListItem<E> prev = null;
        ListItem<E> next = null;
        for (int i = 0; i < size; i++) {
            next = item.getNext();
            if (item.getValue().equals(o)) {
                if (prev == null) {
                    firstItem = next;
                    item = null;
                    size--;
                    return true;
                }
                if (next == null) {
                    lastItem = prev;
                    prev.setNext(null);
                    item = null;
                    size--;
                    return true;
                }
                prev.setNext(next);
                item = null;
                size--;
                return true;
            }
            prev = item;
            item = item.getNext();
        }
        return false;
    }

    public E remove(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }
        item = firstItem;
        ListItem<E> prev = null;
        ListItem<E> next = item.getNext();
        for (int i = 0; i < index; i++) {
            prev = item;
            item = item.getNext();
        }
        next = item.getNext();
        if (prev == null) {
            firstItem = next;
            E val = item.getValue();
            item = null;
            size--;
            return val;
        }
        if (next == null) {
            lastItem = prev;
            prev.setNext(null);
            E val = item.getValue();
            item = null;
            size--;
            return val;
        }
        prev.setNext(next);
        E val = item.getValue();
        item = null;
        size--;
        return val;
    }

    public E get(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }
        item = firstItem;
        for (int i = 0; i < index; i++) {
            item = item.getNext();
        }
        return item.getValue();
    }

    public E set(final int index, final E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }
        item = firstItem;
        for (int i = 0; i < index; i++) {
            item = item.getNext();
        }
        E val = item.getValue();
        item.setValue(element);

        return val;
    }

    public boolean contains(final Object o) {
        if (isEmpty()) {
            return false;
        }
        item = firstItem;
        for (int i = 0; i < size; i++) {
            if (item.getValue().equals(o)) {
                return true;
            }
            if (!item.equals(lastItem)) {
                item = item.getNext();
            }
        }
        return false;
    }

    public int indexOf(final Object o) {
        if (isEmpty()) {
            return -1;
        }
        item = firstItem;
        for (int i = 0; i < size; i++) {
            if (item.getValue().equals(o)) {
                return item.getIndex();
            }
            if (!item.equals(lastItem)) {
                item = item.getNext();
            }
        }
        return -1;
    }

    public void clear() {
        if (isEmpty()) {
            return;
        }
        item = firstItem;
        ListItem<E> nextItem;
        for (int i = 0; i < size; i++) {
            nextItem = item.getNext();
            item = null;
            item = nextItem;
        }
        firstItem = null;
        lastItem = null;
        item = null;
        size = 0;
    }

    public void sort() {

    }
}
