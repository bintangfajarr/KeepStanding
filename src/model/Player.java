/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Filename     : Player.java
 * Programmer   : Muhammad Cahyana Bintang Fajar
 * Email        : bintangfajar@upi.edu
 * Desc         : Package model for class Player
 */

/*
 * Saya Muhammad Cahyana Bintang Fajar (2102665) mengerjakan Tugas Masa Depan
 * dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk
 * keberkahanNya maka saya tidak melakukan kecurangan seperti 
 * yang telah dispesifikasikan. Aamiin.
 */
package model;

import viewmodel.Game;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Muhammad Cahyana Bintang Fajar
 */
public class Player extends GameObject {
    /**
     * Constructor.
     */
    private Image img;
    private Image img2;

    // Default constructor.
    public Player() {
        super(0, 0, "Player");
        super.setHeight(30);
        this.img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/player3.png"));
        this.img2 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/player32.png"));
    }

    // Constructor with player position.
    public Player(int x, int y) {
        super(x, y, "Player");
        super.setHeight(30);
        this.img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/player3.png"));
        this.img2 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/player32.png"));
    }

    /**
     * Override interface.
     */

    @Override
    public void render(Graphics object) {
        if (isLeft) // agar asset bergerak kanan kiri
            object.drawImage(img, x, y, null);
        else
            object.drawImage(img2, x, y, null);
    }

    @Override
    public void loop() {
        // Initialize velocity, so object can move.
        this.x += this.velX;
        this.y += this.velY;

        // Initialize player bound, so it won't get offset the display.
        x = Game.clamp(x, 0, (Game.width - 50));
        // y = Game.clamp(y, 0, (Game.height - 70));
    }
}
