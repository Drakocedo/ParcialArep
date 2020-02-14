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
public class Node<E> {
	private E data;
    private Node<E> next = null;
    private Node<E> prior = null;

    public Node() {
    }

    public Node(E dato) {
        this.data = dato;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrior() {
        return prior;
    }

    public void setPrior(Node<E> prior) {
        this.prior = prior;
    }
}
