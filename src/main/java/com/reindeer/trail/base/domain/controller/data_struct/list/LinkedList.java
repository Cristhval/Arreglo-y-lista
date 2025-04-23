package com.reindeer.trail.base.domain.controller.data_struct.list;

public class LinkedList<E> {

    private Nodo<E> cabeza;

    public LinkedList() {
        this.cabeza = null;
    }

    public void insertar(E data) {
        Nodo<E> nuevoNodo = new Nodo<>(data);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<E> actual = cabeza;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(nuevoNodo);
        }
    }

    public long llenarLista(int capacidad) {
        long inicio = System.nanoTime();

        for (int i = 0; i < capacidad; i++) {
            float valor = Math.round((1 + Math.random() * 10) * 10f) / 10f;
            insertar((E) Float.valueOf(valor));
        }

        long fin = System.nanoTime();
        return fin - inicio;
    }

    public Nodo<E>[] detectarRepetidos() {
        Nodo<E> actual = cabeza;
        Nodo<E> siguiente;
        int contadorRepetidos = 0;

        while (actual != null) {
            siguiente = actual.getNext();
            while (siguiente != null) {
                if (actual.getData().equals(siguiente.getData())) {
                    contadorRepetidos++;
                    break;
                }
                siguiente = siguiente.getNext();
            }
            actual = actual.getNext();
        }

        Nodo<E>[] repetidosArray = new Nodo[contadorRepetidos];
        actual = cabeza;
        int index = 0;

        while (actual != null) {
            siguiente = actual.getNext();
            while (siguiente != null) {
                if (actual.getData().equals(siguiente.getData())) {
                    repetidosArray[index++] = actual;
                    break;
                }
                siguiente = siguiente.getNext();
            }
            actual = actual.getNext();
        }

        return repetidosArray;
    }

    public void mostrarLista() {
        Nodo<E> actual = cabeza;
        System.out.print("Lista: [ ");
        while (actual != null) {
            System.out.print(actual.getData() + " ");
            actual = actual.getNext();
        }
        System.out.println("]");
    }

    public void mostrarRepetidos(Nodo<E>[] repetidos) {
        System.out.print("Repetidos: [ ");
        for (Nodo<E> nodo : repetidos) {
            if (nodo != null) {
                System.out.print(nodo.getData() + " ");
            }
        }
        System.out.println("]");
    }

    public Nodo<E> getCabeza() {
        return cabeza;
    }
}
