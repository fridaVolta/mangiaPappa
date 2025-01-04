/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mangialapappa;

/**
 *
 * @author frida
 */
public class Papa implements Runnable {
    private final Piatto piatto;

    public Papa(Piatto p) {
        this.piatto = p;
    }

    @Override
    public void run() {
        int value = 0;
        try {
            while (true) {
                piatto.produce(value++);
                Thread.sleep(500); // Simula tempo di produzione
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Produttore interrotto.");
        }
    }
}
