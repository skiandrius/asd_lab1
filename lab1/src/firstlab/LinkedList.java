package firstlab;

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
            lastItem = firstItem;
        } else {
            item = new ListItem<E>(e);
        }

        lastItem = lastItem.setNext(item);
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
                    return true;
                }
                if (next == null) {
                    lastItem = prev;
                    prev.setNext(null);
                    item = null;
                    return true;
                }
                prev.setNext(next);
                item = null;
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
            return val;
        }
        if (next == null) {
            lastItem = prev;
            prev.setNext(null);
            E val = item.getValue();
            item = null;
            return val;
        }
        prev.setNext(next);
        E val = item.getValue();
        item = null;
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
        item.setValue(element);

        return item.getValue();
    }

    public boolean contains(final Object o) {
        if (isEmpty()) {
            return false;
        }
        item = firstItem;
        for (int i = 0; i < size - 1; i++) {
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
        for (int i = 0; i < size - 1; i++) {
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
