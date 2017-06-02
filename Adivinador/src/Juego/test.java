package Juego;

import TDAarbolBinario.ArbolBinario;
import TDAarbolBinario.EmptyTreeException;
import TDAarbolBinario.InvalidOperationException;
import TDAlista.BoundaryViolationException;
import TDAlista.InvalidPositionException;

public class test {
	public static void main(String [] args){
		
		Logica l = new Logica();
		l.agregarPregunta("una guitarra", "un bajo", "tiene 4 cuerdas");
		l.agregarPregunta("una guitarra", "una flauta", "es de aire");
		l.agregarPregunta("una flauta", "una trompeta","es de metal");
		//ESTOY USANDO EL ITERATOR DE JAVA, NO EL QUE PIDEN PORQUE TIRA ERROR Y NO USA NoSuchElementIterator
		l.imprimirTodos();
	}
}

