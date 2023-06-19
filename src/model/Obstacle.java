/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Filename     : Obstacle.java
 * Programmer   : Muhammad Cahyana Bintang Fajar
 * Email        : bintangfajar@upi.edu
 * Desc         : Package model for class Obstacle extend gameObject
 */

/*
 * Saya Muhammad Cahyana Bintang Fajar (2102665) mengerjakan Tugas Masa Depan
 * dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk
 * keberkahanNya maka saya tidak melakukan kecurangan seperti 
 * yang telah dispesifikasikan. Aamiin.
 */
package model;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 *
 * @author Muhammad Cahyana Bintang Fajar
 */
public class Obstacle extends GameObject {

    private int panjang;

    // Constructor with player position.
    public Obstacle(int x, int y) {
        super(0, y, "Obstacle");
        this.panjang = x;
        this.score = x;
        this.score /= 60; // set score
        this.score = (11 - this.score) * 10; // agar score sesuai panjangnya
        super.setWidth(panjang);

    }

    /**
     * Override interface.
     */

    @Override
    public void render(Graphics object) {
        Image obs = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/block3.png")); // assets
        BufferedImage resizedImage = new BufferedImage(panjang, 60, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(obs, 0, 0, panjang, 60, null);
        g2d.dispose();
        // set icon
        object.drawImage(resizedImage, x, y, null);
        // draw score
        Font font = new Font("Poppins", Font.BOLD, 20);
        object.setFont(font);
        object.setColor(Color.white);
        object.drawString(Integer.toString(getScore()), panjang, y + 25);

    }

    @Override
    public void loop() {
        // Initialize velocity, so object can move.
        this.x += this.velX;
        this.y += this.velY;
    }

    private BufferStrategy getBufferStrategy() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
