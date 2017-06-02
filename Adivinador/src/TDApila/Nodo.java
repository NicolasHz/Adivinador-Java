package TDApila;

public class Nodo<E> implements Position<E> {
	protected E elemento;
	protected Nodo<E> siguiente;
	public Nodo(){
		elemento=null;
		siguiente=null;
	}
	public Nodo(E e){
		elemento=e;
		siguiente=null;
	}
	public Nodo(E e,Nodo<E> sig){
		elemento=e;
		siguiente = sig;
	}
	public E element(){
		return elemento;
	}
	public void setElemento(E e){
		elemento = e;
	}
	public Nodo<E> getSiguiente(){
		return siguiente;
	}
	public void setSiguiente(Nodo<E> sig){
		siguiente=sig;
	}
}
