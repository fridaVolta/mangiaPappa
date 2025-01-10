/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mangialapappa;
import java.util.ArrayList;
/**
 *
 * @author frida
 */
public class Piatto {
     private final ArrayList<Integer> listaBocconi;
    private final int maxSize;

    public Piatto(int maxSize) {
        this.listaBocconi = new ArrayList<>();
        this.maxSize = 10;
    }

    public synchronized void produce(int value) throws InterruptedException {
        while ( listaBocconi.size() >= maxSize) {
            System.out.println("Piatto pieno. Il papa' attende.");
            wait();
        }

        listaBocconi.add(value);
        int numMostrato=value+1;
        System.out.println("Boccone preparato sul piatto: " + numMostrato);
        notify(); // Notifica al consumatore
    }

    public synchronized int consume() throws InterruptedException {
        while (listaBocconi.isEmpty()) {
            System.out.println("Piatto vuoto. Il bebe' attende.");
            wait();
        }

        int value = listaBocconi.removeFirst();
        int numMostrato=value+1;
        System.out.println("Mangiato boccone: " + numMostrato);
        notify(); // Notifica al produttore
        return value;
    }
}
