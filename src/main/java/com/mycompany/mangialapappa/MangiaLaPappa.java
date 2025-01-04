/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mangialapappa;

/**
 *
 * @author frida
 */
public class MangiaLaPappa {

    public static void main(String[] args) {
        Piatto piatto= new Piatto(20);
        Thread papa = new Thread(new Papa(piatto));
        Thread bebe = new Thread(new Bebe(piatto));

        papa.start();
        bebe.start();
    }
}
