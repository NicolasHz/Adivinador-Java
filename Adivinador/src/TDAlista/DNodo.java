package TDAlista;
import TDApila.Position;
public class DNodo<E> implements Position<E> {
	private E elemento;
	private DNodo<E> siguiente;
	private DNodo<E> anterior;
	
	public DNodo(){
		elemento=null;
		siguiente=null;
		anterior=null;
	}
	public DNodo(E elem){
		elemento=elem;
	}
	public DNodo(E e,DNodo<E> sig){
		siguiente=sig;
		elemento=e;
	}
	public DNodo(DNodo<E> ant,E e){
		elemento=e;
		anterior=ant;
	}
	public DNodo(DNodo<E> ant,E e,DNodo<E> sig){
		siguiente=sig;
		elemento=e;
		anterior=ant;
	}
	
	public void setElemento(E elem){
		elemento=elem;
	}
	public void setSiguiente(DNodo<E> sig){
		siguiente=sig;
	}
	public void setAnterior(DNodo<E> ant){
		anterior=ant;
	}
	public DNodo<E> getSiguiente(){
		return siguiente;
	}
	public DNodo<E> getAnterior(){
		return anterior;
	}
	public E element(){
		return elemento;
	}
	
	
}
