package com.reindeer.trail.base.domain.controller.data_struct.list;

public class Nodo <E>{

    private E data;
    private Nodo<E> next;

    public Nodo(E data, Nodo<E> next){
        this.data = data;
        this.next = next;
    }

    public Nodo(E data){
        this.data = data;
        this.next = null;

    }


    public Nodo(){
        this.data = null;
        this.next = null;
    }


    public E getData() {
        return data;
    }

    public Nodo<E> getNext() {
        return next;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setNext(Nodo<E> next) {
        this.next = next;
    }

}
