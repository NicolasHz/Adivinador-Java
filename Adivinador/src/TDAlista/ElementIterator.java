package TDAlista;
import java.util.Iterator;

import TDApila.Position;
public class ElementIterator<E> implements Iterator<E> {
	protected PositionList<E> list;
	protected Position<E> cursor;
	
	public ElementIterator(PositionList<E> L) {
		try{
			list=L;
			if (list.isEmpty()) cursor=null;
			else cursor = list.first();
		}catch(EmptyListException e){
			System.out.println("Lista vacia");
		}
	}
	
	public E next(){
		if(cursor==null) System.out.println("no hay mas elementos");//nosuchelementiterator ERROOOOOOOORRR
		E elem = cursor.element();
		try{
			if(cursor==list.last()) cursor= null;
			else cursor= list.next(cursor);
			
		}catch(EmptyListException e){
			System.out.println("Lista vacia");
		}catch(BoundaryViolationException e){
			System.out.println("Posicion invalida");
		}catch(InvalidPositionException e){
			System.out.println("Posicion invalida");
		}
		return elem;
	}
	public boolean hasNext() {
		return cursor!= null;
	}

}
