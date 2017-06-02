package TDAarbolBinario;


import java.util.Iterator;
import TDApila.Position;
import TDAlista.BoundaryViolationException;
import TDAlista.InvalidPositionException;
import TDAlista.ListaDoblementeEnlazada;
import TDAlista.PositionList;

public class ArbolBinario<E> implements BinaryTree<E>{
	protected BTPosition<E> raiz;
	protected int cant;
	
	public ArbolBinario(){
		raiz=null;
		cant=0;
	}	
	public int size(){
		return cant;
	}
	public boolean isEmpty(){
		return cant==0;
	}
	public Position<E> createRoot(E elem) throws InvalidOperationException{
		if(raiz!= null) throw new InvalidOperationException("el arbol ya tiene raiz");
		 raiz = new  BTNodo<E> (null,elem,null,null);
		 cant=1;
		 return raiz;
	}
	public boolean hasLeft(Position<E> v)throws InvalidPositionException{
		BTPosition<E> n = checkposition(v);
		return n.getLeft()!= null;
	}
	public boolean hasRight(Position<E> v)throws InvalidPositionException{
		BTPosition<E> n = checkposition(v);
		return n.getRight()!= null;
	}
	public Position<E> left(Position<E> v)throws BoundaryViolationException,InvalidPositionException{
		BTPosition<E> n = checkposition(v);
		if(n.getLeft()==null) throw new BoundaryViolationException("No tiene hijo izquierdo");
		return n.getLeft();
	}
	public Position<E> right(Position<E> v)throws BoundaryViolationException,InvalidPositionException{
		BTPosition<E> n = checkposition(v);
		if(n.getRight()==null) throw new BoundaryViolationException("No tiene hijo derecho");
		return n.getRight();
	}
	public boolean isInternal(Position<E> v)throws InvalidPositionException{
		BTPosition<E> n = checkposition(v);
		return hasLeft(n) || hasRight(n);
	}
	public boolean isExternal(Position<E> v)throws InvalidPositionException{
		BTPosition<E> n = checkposition(v);
		return !hasLeft(n) && !hasRight(n);
	}
	public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException{
		BTPosition<E> n = checkposition(v);
		PositionList<Position<E>> hijos = new ListaDoblementeEnlazada<Position<E>>();
		if(n.getLeft()!=null) hijos.addLast(n.getLeft());
		if(n.getRight()!=null) hijos.addLast(n.getLeft());
		return hijos;
	}
	private BTPosition<E> checkposition(Position<E> v)throws InvalidPositionException{
		BTPosition<E> n;
		try{
			if(v==null) throw new InvalidPositionException("Posicion invalida");
			n = (BTPosition<E>) v;
		}catch(ClassCastException e){
			throw new InvalidPositionException("Posicion invalida.");
		}
		return n;
	}
	public Position<E> root() throws EmptyTreeException {
		if (isEmpty()) throw new EmptyTreeException("Arbol vacio");
		return raiz;
	}
	public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		BTPosition<E> n = checkposition(v);
		if (n == raiz) throw new BoundaryViolationException("Fuera del arbol");
		return n.getPadre();
	}
	public boolean isRoot(Position<E> v) throws InvalidPositionException {
		BTPosition<E> n = checkposition(v);
		return raiz==n;
	}
	public Position<E> addLeft(Position<E> v, E r) throws InvalidOperationException, InvalidPositionException {
		if (isEmpty()) throw new InvalidPositionException("Arbol vacio");
		BTPosition<E> n = checkposition(v);
		
		if (n.getLeft()!=null) throw new InvalidOperationException("Ya tiene un hijo izquierdo");
		BTPosition<E> nuevo = new BTNodo<E>(n,r,null,null);
		n.setLeft(nuevo);
		return nuevo;
	}
	public Position<E> addRight(Position<E> v, E r) throws InvalidOperationException, InvalidPositionException {
		if (isEmpty()) throw new InvalidPositionException("Arbol vacio");
		BTPosition<E> n = checkposition(v);
		
		if (n.getRight()!=null) throw new InvalidOperationException("Ya tiene un hijo derecho");
		BTPosition<E> nuevo = new BTNodo<E>(n,r,null,null);
		n.setRight(nuevo);
		return nuevo;
	}
	public E replace(Position<E> v, E e) throws InvalidPositionException {
		BTPosition<E> n = checkposition(v);
		E aux = n.element();
		n.setElemento(e);
		return aux;
	}
	public E remove(Position<E> v) throws InvalidOperationException, InvalidPositionException {
		BTPosition<E> n = checkposition(v);
		if(isEmpty()) throw new InvalidPositionException("El arbol esta vacio");
		if(n.getLeft()!=null && n.getRight()!=null)throw new InvalidOperationException("No se puede eliminar porque tiene dos hijos");
		
		if(n==raiz){
			if(n.getLeft()!=null){
				raiz = n.getLeft();
				n.getLeft().setPadre(null);
			}else
				if(n.getRight()!=null){
					raiz = n.getRight();
					n.getRight().setPadre(null);
				}else{
					raiz=null;
				}
			
		}else
			if(n.getLeft()!=null){
				if(n.getPadre().getLeft()==n){
					n.getPadre().setLeft(n.getLeft());
					n.getLeft().setPadre(n.getPadre());
				}else if(n.getPadre().getRight()==n){
					n.getPadre().setRight(n.getLeft());
					n.getLeft().setPadre(n.getPadre());
				}	
			}else 
				if (n.getRight()!=null){
					if(n.getPadre().getLeft()==n){
						n.getPadre().setLeft(n.getRight());
						n.getRight().setPadre(n.getPadre());
					}else{
						if(n.getPadre().getRight()==n){
							n.getPadre().setRight(n.getRight());
							n.getRight().setPadre(n.getPadre());
						}
					}
				}
		E aux = n.element();
		n=null;
		return aux;
		
	}
	public Iterator<E> iterator() {
		PositionList<E> L = new ListaDoblementeEnlazada<E>();
		if(cant>0){
			L= generarLista(L,raiz);
		}
		return L.iterator();
	
	}
	private PositionList<E> generarLista(PositionList<E> L, Position<E> pos){
		try{
			L.addLast(pos.element());
			if(this.hasLeft(pos))
				generarLista(L,this.left(pos));
			if(this.hasRight(pos))
				generarLista(L,this.right(pos));
		}catch(InvalidPositionException e){
			System.out.println(e.getMessage());
		}catch(BoundaryViolationException e){
			System.out.println(e.getMessage());
		}
		return L;
		
	}
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> lista = new ListaDoblementeEnlazada<Position<E>>();
		BTPosition<E> pos=raiz;
		this.generarListaPosiciones(lista,pos);
		return lista;	
	}
	private void generarListaPosiciones(PositionList<Position<E>> lista,BTPosition<E> pos){
		lista.addLast(pos);
		if(pos.getLeft()!=null){
			generarListaPosiciones(lista,pos.getLeft());
		}
		if(pos.getRight()!=null){
			generarListaPosiciones(lista,pos.getRight());
		}
	}
	
	public void Attach(Position<E> v, BinaryTree<E> T1, BinaryTree<E> T2) throws InvalidPositionException {
		BTPosition<E> n = checkposition(v);
		if(this.isInternal(n)) throw new InvalidPositionException("No es una hoja");
		if(isEmpty()) throw new InvalidPositionException("El arbol esta vacio");
		try {
			BTPosition<E> leftT = checkposition(T1.root());
			n.setLeft(leftT);
			leftT.setPadre(n);
			BTPosition<E> rightT = checkposition(T2.root());
			n.setRight(rightT);
			rightT.setPadre(n);
		} catch (EmptyTreeException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	

}
