/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Filename     : GameInterface.java
 * Programmer   : Muhammad Cahyana Bintang Fajar
 * Email        : bintangfajar@upi.edu
 * Desc         : Package model for render and loop
 */

/*
 * Saya Muhammad Cahyana Bintang Fajar (2102665) mengerjakan Tugas Masa Depan
 * dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk
 * keberkahanNya maka saya tidak melakukan kecurangan seperti 
 * yang telah dispesifikasikan. Aamiin.
 */
package model;

import java.awt.Graphics;

/**
 *
 * @author Muhammad Cahyana Bintang Fajar
 */
public interface GameInterface {
    public void render(Graphics object); // Render object.

    public void loop(); // Loop / refresh object.
}
