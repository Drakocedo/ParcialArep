/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.model;

/**
 *
 * @author david.caycedo
 */


import java.util.Iterator;

class Iterador<T> implements Iterator<T> {
	Node<T> actual;

	public Iterador(Node<T> real) {
		actual = real;
	}
	
	public boolean hasNext() {
		return actual != null;
	}

	public T next() {
		T data = (T) actual.getData();
        actual = actual.getNext();
        return data;
	}

}
