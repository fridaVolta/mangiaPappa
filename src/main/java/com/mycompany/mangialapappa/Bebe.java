/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mangialapappa;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author frida
 */
public class Bebe implements Runnable {
    private final Piatto piatto;

    public Bebe(Piatto p) {
        this.piatto = p;
    }

    @Override
    public void run() {
        try {
            while (true) {
                piatto.consume();
                Thread.sleep(ThreadLocalRandom.current().nextLong(1000)); // Simula tempo di consumo
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Consumatore interrotto.");
        }
    }
}
