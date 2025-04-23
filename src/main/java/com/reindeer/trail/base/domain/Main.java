package com.reindeer.trail.base.domain;

import com.reindeer.trail.base.domain.controller.ArregloController;
import com.reindeer.trail.base.domain.controller.data_struct.list.LinkedList;
import com.reindeer.trail.base.domain.models.Arreglo;
import com.reindeer.trail.base.domain.controller.data_struct.list.Nodo;

public class Main {

    public static void main(String[] args) {
        int capacidad = 100;
        int repeticiones = 3;

        System.out.println("== PRUEBAS CON ARREGLO ==");
        for (int i = 1; i <= repeticiones; i++) {
            ArregloController arregloController = new ArregloController(capacidad);
            long tiempo = arregloController.llenarArreglo();
            Arreglo[] repetidos = arregloController.detectarRepetidos();

            System.out.println("Repeticion " + i + ":");
            System.out.println("Tiempo de llenado: " + tiempo + " ns");
            System.out.println("Elementos repetidos: " + repetidos.length);


            arregloController.mostrarArreglo();


            arregloController.mostrarRepetidos(repetidos);

            System.out.println("----------------------------");
        }

        System.out.println("\n== PRUEBAS CON LISTA ENLAZADA ==");
        for (int i = 1; i <= repeticiones; i++) {
            LinkedList<Float> listaController = new LinkedList<>();
            long tiempo = listaController.llenarLista(capacidad);
            Nodo<Float>[] repetidos = listaController.detectarRepetidos();

            System.out.println("Repeticion " + i + ":");
            System.out.println("Tiempo de llenado: " + tiempo + " ns");
            System.out.println("Elementos repetidos: " + repetidos.length);


            System.out.print("Lista: [ ");
            Nodo<Float> actual = listaController.getCabeza();
            while (actual != null) {
                System.out.print(String.format("%.2f", actual.getData()) + " ");
                actual = actual.getNext();
            }
            System.out.println("]");


            System.out.print("Repetidos: [ ");
            for (Nodo<Float> nodo : repetidos) {
                if (nodo != null) {
                    System.out.print(String.format("%.2f", nodo.getData()) + " ");
                }
            }
            System.out.println("]");

            System.out.println("----------------------------");
        }
    }
}
