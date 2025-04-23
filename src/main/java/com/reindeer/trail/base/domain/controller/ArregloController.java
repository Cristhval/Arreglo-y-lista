package com.reindeer.trail.base.domain.controller;
import com.reindeer.trail.base.domain.models.Arreglo;

import java.util.Random;

public class ArregloController {

    private Arreglo[] arreglo1;

    public ArregloController(int capacidad) {
        this.arreglo1 = new Arreglo[capacidad];
    }

    public long llenarArreglo() {
        Random rand = new Random();
        long inicio = System.nanoTime();

        for (int i = 0; i < arreglo1.length; i++) {
            float valor = Math.round((1 + rand.nextFloat() * 10) * 10f) / 10f;
            arreglo1[i] = new Arreglo(valor);
        }

        long fin = System.nanoTime();
        return fin - inicio;
    }

    public Arreglo[] getArreglo1() {
        return arreglo1;
    }

    public Arreglo[] detectarRepetidos() {
        int n = arreglo1.length;
        boolean[] yaRevisado = new boolean[n];
        int contadorRepetidos = 0;

        for (int i = 0; i < n; i++) {
            if (yaRevisado[i]) continue;

            float valorActual = arreglo1[i].getNa();
            boolean esRepetido = false;

            for (int j = i + 1; j < n; j++) {
                if (!yaRevisado[j] && arreglo1[j].getNa() == valorActual) {
                    yaRevisado[j] = true;
                    esRepetido = true;
                }
            }

            if (esRepetido) {
                yaRevisado[i] = true;
                contadorRepetidos++;
            }
        }

        Arreglo[] repetidos = new Arreglo[contadorRepetidos];
        int index = 0;
        yaRevisado = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (yaRevisado[i]) continue;

            float valorActual = arreglo1[i].getNa();
            boolean esRepetido = false;

            for (int j = i + 1; j < n; j++) {
                if (!yaRevisado[j] && arreglo1[j].getNa() == valorActual) {
                    yaRevisado[j] = true;
                    esRepetido = true;
                }
            }

            if (esRepetido) {
                yaRevisado[i] = true;
                repetidos[index++] = new Arreglo(valorActual);
            }
        }
        return repetidos;
    }

    public void mostrarArreglo() {
        System.out.print("Arreglo: [ ");
        for (Arreglo elemento : arreglo1) {
            System.out.print(String.format("%.2f", elemento.getNa()) + " ");
        }
        System.out.println("]");
    }

    public void mostrarRepetidos(Arreglo[] repetidos) {
        System.out.print("Repetidos: [ ");
        for (Arreglo elemento : repetidos) {
            if (elemento != null) {
                System.out.print(String.format("%.2f", elemento.getNa()) + " ");
            }
        }
        System.out.println("]");
    }
}

