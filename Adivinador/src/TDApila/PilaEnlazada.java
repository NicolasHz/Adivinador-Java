package TDApila;

public class PilaEnlazada<E> implements Stack<E> {
	protected Nodo<E> cabeza;
	protected int cant;
	
	public PilaEnlazada(){
		cant=0;
		cabeza=null;
	}
	public E top() throws EmptyStackException{
		if(cant==0) throw new EmptyStackException("pila vacia");
		return cabeza.element();
	}
	public E pop() throws EmptyStackException{
		if(cant==0) throw new EmptyStackException("pila vacia");
		E elem = cabeza.element();
		cabeza = cabeza.getSiguiente();
		return elem;
		
		
	}
	public void push(E e){
		Nodo<E> aux = new Nodo<E>(e,cabeza);
		cabeza=aux;
	}
	public int size(){
		return cant;
	}
	public boolean isEmpty(){
		return cant==0;
	}
	public void invertir2(){
		if (!isEmpty()){
			Nodo<E> n1 = cabeza.getSiguiente();
			cabeza.setSiguiente(null);
			while (n1!=null){
				Nodo<E> n2= n1.getSiguiente();
				n1.setSiguiente(cabeza);
				cabeza=n1;
				n1=n2;
			}
		} 
	}
}
