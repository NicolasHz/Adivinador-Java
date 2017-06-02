package TDApila;

public class PilaInvertible<E> extends PilaEnlazada<E> implements Stack<E> {
	
	public void invertir(){
		try{
			Stack<E> pila1 = new PilaEnlazada<E>();
			Stack<E> pila2 = new PilaEnlazada<E>();
			this.pasar(this, pila1);
			this.pasar(pila1, pila2);
			this.pasar(pila2, this);
		}catch(EmptyStackException e){
			System.out.println(e.getMessage());
		}
	}	
	
	private void pasar(Stack<E> pila1,Stack<E> pila2) throws EmptyStackException{
		if(pila1.isEmpty())throw new EmptyStackException("pila vacia");
		while(!pila1.isEmpty()){
			pila2.push(pila1.pop());
		}
	}
}
