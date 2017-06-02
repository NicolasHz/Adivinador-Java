package TDAarbolBinario;

import TDApila.Position;

public interface BTPosition<E> extends Position<E>{
	
	public void setLeft(BTPosition<E> l);
	public BTPosition<E> getLeft();
	public void setRight(BTPosition<E> r);
	public BTPosition<E> getRight();
	public void setPadre(BTPosition<E> p);
	public BTPosition<E> getPadre();
	public void setElemento(E e);
}
