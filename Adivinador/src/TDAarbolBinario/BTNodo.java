package TDAarbolBinario;

import TDApila.Position;

public class BTNodo<E> implements BTPosition<E>{

	private E element;
	private BTPosition<E> left, right, parent;
	
	public BTNodo(BTPosition<E> p,E elem, BTPosition<E> l, BTPosition<E> r){
		parent = p;
		element = elem;
		left = l;
		right = r;
	}
	public void setLeft(BTPosition<E> l){
		left= l;
	}
	public BTPosition<E> getLeft(){
		return left;
	}
	public void setRight(BTPosition<E> r){
		right =  r;
	}
	public BTPosition<E> getRight(){
		return right;
	}
	public void setPadre(BTPosition<E> p){
		parent =  p;
	}
	public BTPosition<E> getPadre(){
		return parent;
	}
	public E element() {
		return element;
	}
	public void setElemento(E e){
		element = e;
	}
	
}
