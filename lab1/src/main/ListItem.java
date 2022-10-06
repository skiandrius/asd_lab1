package main;

public class ListItem<E> {
	private E item = null;
	private ListItem<E> next = null;
	private int index = -1;

	public E getValue() {
		return item;
	}
	
	public E setValue(E item) {
		this.item = item;
		return item;
	}
	
	public ListItem<E> getNext() {
		return this.next;
	}
	
	public ListItem<E> setNext(ListItem<E> next) {
		this.next = next;
		return this.next;
	}
	
	public int getIndex() {
		return index;
	}
	
	public int setIndex(int index) {
		this.index = index;
		return this.index;
	}
	
	ListItem(E item) {
		this.item = item;
	}
	
	ListItem(E item, ListItem<E> next) {
		this.item = item;
		this.next = next;
	}
}
