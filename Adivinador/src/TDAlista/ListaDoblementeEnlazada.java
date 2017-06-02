package TDAlista;

import java.util.Iterator;

import java.util.Iterator; 
import TDApila.Position;
public class ListaDoblementeEnlazada<E> implements PositionList<E> {
	protected DNodo<E> head;
	protected DNodo<E> tail;
	protected int cant;
	
	public ListaDoblementeEnlazada(){
		head= new DNodo<E>();
		tail = new DNodo<E>();
		head.setSiguiente(tail);
		tail.setAnterior(head);
		cant = 0;
	}
	
	public int size(){
		return cant;
	}
	
	public boolean isEmpty(){
		return cant==0;
	}
	
	public Position<E> first()throws EmptyListException{
		if(isEmpty()) throw new EmptyListException("lista vacia");
		return head.getSiguiente();
	}
	public Position<E> last() throws EmptyListException{
		if (isEmpty()) throw new EmptyListException("lista vacia");
		return tail.getAnterior();
	}
	public void addFirst(E e){
		DNodo<E> nuevo = new DNodo<E> (head,e,head.getSiguiente());
		DNodo<E> aux = head.getSiguiente();
		aux.setAnterior(nuevo);
		head.setSiguiente(nuevo);
		cant++;
	}
	public void addLast(E e){
		DNodo<E> nuevo = new DNodo<E> (tail.getAnterior(),e,tail);
		DNodo<E> aux = tail.getAnterior();
		aux.setSiguiente(nuevo);
		tail.setAnterior(nuevo);
		cant++;
	}
	
	public Position<E> next(Position<E> p)throws InvalidPositionException,BoundaryViolationException{
		DNodo<E> n = checkPosition(p);
		if(n.getSiguiente()==tail) throw new BoundaryViolationException("No esta en la lista");
		return n.getSiguiente();
	}
	public Position<E> prev(Position<E> p) throws InvalidPositionException,BoundaryViolationException{
		
		DNodo<E> n = checkPosition(p);
		if(n.getAnterior()==head) throw new BoundaryViolationException("No esta en la lista");
		return n.getAnterior();
	}
	
	public DNodo<E> checkPosition(Position<E> p)throws InvalidPositionException{
		try{
			if(p==null) throw new InvalidPositionException("Posicion invalida");
			if (p == head || p == tail) throw new InvalidPositionException("Posicion invalida");
			DNodo<E> n = (DNodo<E>) p;
			return n;
		}catch(ClassCastException e){
			throw new InvalidPositionException("Posicion invalida");
			
		}
		
	}
	
	public void addAfter(Position<E> p,E e) throws InvalidPositionException {
		DNodo<E> n = checkPosition(p);
		DNodo<E> nuevo = new DNodo<E> (n,e,n.getSiguiente());
		n.getSiguiente().setAnterior(nuevo);
		n.setSiguiente(nuevo);
		cant++;
		
	}
	public void addBefore(Position<E> p,E e)throws InvalidPositionException {
		DNodo<E> n = checkPosition(p);
		DNodo<E> nuevo = new DNodo<E> (n.getAnterior(),e,n);
		n.getAnterior().setSiguiente(nuevo);
		n.setAnterior(nuevo);
		cant++;
	}
	
	public E remove(Position<E> p)throws InvalidPositionException{
		DNodo<E> n = checkPosition(p);
		E elem = n.element();
		n.getAnterior().setSiguiente(n.getSiguiente());
		n.getSiguiente().setAnterior(n.getAnterior());
		cant--;
		return elem;
		
		
	}
	public E set(Position<E> p, E e)throws InvalidPositionException{
		DNodo<E> n = checkPosition(p);
		E elem = n.element();
		n.setElemento(e);
		return elem;
	}
	public Iterator<E> iterator(){
		return new ElementIterator<E>(this);
	}

	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> lista = new ListaDoblementeEnlazada<Position<E>>();
		try{
			if(!this.isEmpty()){
				Position<E> pos = first();
				while(pos!=null){
					lista.addLast(pos);
					if(pos==last())
						pos=null;
					else 
						pos = next(pos);
				}
			}
		}catch(EmptyListException e){
			System.out.println(e.getMessage());
		}catch(BoundaryViolationException e){
			System.out.println(e.getMessage());
		}catch(InvalidPositionException e){
			System.out.println(e.getMessage());
		}
		return lista;
	}

	
	
	
}
	

