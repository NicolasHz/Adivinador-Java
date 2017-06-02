package Juego;

import TDAarbolBinario.ArbolBinario;
import TDAarbolBinario.BinaryTree;
import TDAarbolBinario.EmptyTreeException;
import TDAarbolBinario.InvalidOperationException;
import TDAlista.NoSuchElementException;
import TDAlista.BoundaryViolationException;
import TDAlista.InvalidPositionException;

import TDAlista.PositionList;
import TDApila.Position;

public class Logica {
	
	private BinaryTree<String> arbol; 
	private Position<String> actual;
	
	public Logica(){
			arbol = new ArbolBinario<String>();
			try {
				arbol.createRoot("una guitarra");
				actual = arbol.root();
			}catch (InvalidOperationException e) {}
			 catch (EmptyTreeException e) {}
	}
	
	public void agregarPregunta(String instrumento1,String instrumento2,String cualidad){
		try {
			Position<String> pos = this.buscarInstrumento(instrumento1);
			String aux = arbol.replace(pos, cualidad);
			arbol.addLeft(pos, aux);
			arbol.addRight(pos, instrumento2);
		} catch (InvalidPositionException e) {
			System.out.println(e.getMessage());
		}catch (InvalidOperationException e) {
			 System.out.println(e.getMessage());
			}
	}
	
	
	public String imprimirTodos(){
		String s="";
		try {
			Position<String> aux = arbol.root();
			s =Todos(aux);
		} catch (EmptyTreeException e) {
			System.out.println(e.getMessage());
		}
		return s;
		
	}
	
	private String Todos(Position<String> aux){
		String A="";
		try{
			if(arbol.isExternal(aux)){
				A+= imprimirInstrumento(aux);
			}else{
					A += Todos(arbol.left(aux));
					A += Todos(arbol.right(aux));
			}
			
		}catch(InvalidPositionException e){System.out.println(e.getMessage());}
		catch(BoundaryViolationException e){System.out.println(e.getMessage());}
		return A;
	}
	
	private String imprimirInstrumento(Position<String> pos){
		Position<String> aux;
		String todo = "";
		try{
			if(arbol.isRoot(pos)){
				todo += "* "+ pos.element()+".";
			}else
				if(arbol.isRoot(arbol.parent(pos))){
					if(arbol.left((arbol.parent(pos)))==pos){
						todo +="\u2022 "+ pos.element()+" es un instrumento que no "+ arbol.parent(pos).element()+".\n";
					}else{
						todo +="\u2022 "+ pos.element()+" es un instrumento que "+ arbol.parent(pos).element()+".\n";
					}
				}else{
					aux= pos;
					while(!arbol.isRoot(aux)){
						if(arbol.isRoot(arbol.parent(aux))){
							if(arbol.left((arbol.parent(aux)))==aux){
								todo += " y no "+arbol.parent(aux).element()+".\n"; 
							}else{
								todo += "y " + arbol.parent(aux).element()+".\n";
							}
						}else
							if(arbol.left((arbol.parent(aux)))==aux){
								if (arbol.isExternal(aux)){
									todo +="\u2022 "+ aux.element()+" es un instrumento que no "+arbol.parent(aux).element();
								}else{
									todo += " no "+ arbol.parent(aux).element()+" "; 
								}
							}else{
								if (arbol.isExternal(aux)){
									todo +="\u2022 "+ aux.element()+" es un instrumento que "+arbol.parent(aux).element();
								}else{
										todo += arbol.parent(aux).element()+" ";	
								}
							}
						aux = arbol.parent(aux);
					
				}
			}
		
		}catch(InvalidPositionException e){
				System.out.println(e.getMessage());
		}catch(BoundaryViolationException e){
				System.out.println(e.getMessage());
		}
		
		return todo;
	}
		
	private Position<String> buscarInstrumento(String instrumento){
		Position<String> retornar=null;
		try {
			String inst=instrumento;
			Position<String> raiz = arbol.root();
			retornar = buscar2(raiz,inst);
		} catch (EmptyTreeException e) {System.out.print(e.getMessage());}
		return retornar;
	}
	
	private Position<String> buscar(Position<String> pos,String instrumento){
		try{
			if(pos.element().equals(instrumento)){
				return pos;
			}else{
				if(arbol.hasLeft(pos))
					pos =this.buscar(arbol.left(pos), instrumento);
				if(arbol.hasRight(pos))
					pos =this.buscar(arbol.right(pos), instrumento);
			}
		}catch(BoundaryViolationException e){
			System.out.println(e.getMessage());
		}catch(InvalidPositionException e){
			System.out.println(e.getMessage());
		}
		return pos;
	}
	
	private Position<String> buscar2(Position<String> pos,String instrumento){
		Iterable<Position<String>> it =  arbol.positions();
		for(Position<String> aux : it) {
			if(aux.element().equals(instrumento)) {
				return aux;
			}
		}
		return null;
		
	}

	public String Primer(){
		String aux = null;
		try {
			aux= arbol.root().element();
		} catch (EmptyTreeException e) {}
		return aux;
		
	}
	
	public Position<String> getPrimer(){
		Position<String> aux = null;
		try {
			aux= arbol.root();
		} catch (EmptyTreeException e) {}
		return aux;
	}
	
	public void setActual(Position<String> act){
		actual=act;
	}
	
	public String Actual(){
		return actual.element();
	}
	
	public boolean SiguienteSi(){

		boolean haySiguiente = true;
		try {
			if(arbol.isInternal(actual)){
				actual = arbol.right(actual);
			}else{
				haySiguiente=false;
			}
			
		} catch (InvalidPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BoundaryViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return haySiguiente;
	}

	public boolean SiguienteNo(){

		boolean haySiguiente = true;
		try {
			if(arbol.isInternal(actual)){
				actual = arbol.left(actual);
			}else{
				haySiguiente=false;
			}
			
		} catch (InvalidPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BoundaryViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return haySiguiente;
	}
}
