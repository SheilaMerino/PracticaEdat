package es.ubu.inf.edat.pr02;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ColeccionArray2D<E> extends AbstractCollection<E> { // TODO: completar la cabecera

	private E[][] array;
	private int filas = 0, columnas = 0, tam = 0;

	public ColeccionArray2D(E[][] arrayTest) {
		// TODO Auto-generated constructor stub
		array = (E[][]) arrayTest;
		filas = array.length;
		columnas = array[0].length;
		tam = array.length * array[0].length;

	}

	private class Iterator2D implements Iterator<E> {
		// hasNext() { } TODO: completar por el alumno
		int posActualF = 0;
		int posActualC = 0;
		boolean resultado = false;
		int contador = 0;
		int borraF=0;
		int borraC=0;
		int c=0;

		@Override
		public boolean hasNext() {
			if (contador < tam) {
				if (posActualF <= filas) {
					resultado = true;
				} else {
					resultado = false;
				}
				contador++;
				
			} else {
				resultado = false;
			}
			return resultado;
		}

		// E next() { } TODO: completar por el alumno
		@Override
		public E next() {
			E datoActual=null;
			if (hasNext() == true) {
				datoActual=array[posActualF][posActualC];
				borraF=posActualF;
				borraC=posActualC;
					if(posActualC<columnas-1) {
						posActualC++;
					}					
					else {
						posActualC=0;
						posActualF++;						
					}				
			}
			
			return datoActual;
		}

		// void remove() { } TODO: completar por el alumno
		public void remove() {
		 array[borraF][borraC]= null;
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new Iterator2D();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return tam;
	}
	
	// void remove(E) { } TODO: completar por el alumno
	/*@Override
	public boolean remove(Object num) {
		boolean encontrado = false;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (array[i][j] == num) {
					array[i][j] = null;
					encontrado = true;
				}
			}
		}
		return encontrado;
	}*/

}
