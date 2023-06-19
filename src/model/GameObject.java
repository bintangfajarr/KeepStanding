/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Filename     : GameObject.java
 * Programmer   : Muhammad Cahyana Bintang Fajar
 * Email        : bintangfajar@upi.edu
 * Desc         : Package model for class GameObject(parent of obstacle and player)
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
public class GameObject implements GameInterface {
    /**
     * Attribute declaration.
     */

    public int x, y; // Position.
    public int jumpFlag; // penanda loncat
    public boolean standing;// menghitung standing
    public boolean isLeft;// apakah sedang ke kiri atau kanan
    public int score; // untuk score
    protected int width, height; // Dimension.
    protected int velX, velY; // Velocity.
    protected String type; // Object type.

    /**
     * Constructor.
     */

    // Default constructor.
    public GameObject() {
        this.x = 0;
        this.y = 0;
        this.type = "";
    }

    // Constructor with object coordinate.
    public GameObject(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    // Constructor with object coordinate and shape.
    public GameObject(int x, int y, int width, int height, String type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    /**
     * Getter and Setter.
     */

    /* Object X position. */

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    /* Object Y position. */

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /* Object width. */

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    /* Object height. */

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /* Object X velocity. */

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    /* Object Y velocity. */

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    /* Object type. */

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // jumpflag
    public void setJumpFlag(int jumpFlag) {
        this.jumpFlag = jumpFlag;
    }

    public int getJumpFlag() {
        return this.jumpFlag;
    }

    // standing
    public void setStanding(boolean standing) {
        this.standing = standing;
    }

    public boolean getStanding() {
        return this.standing;
    }

    // score
    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    /**
     * Override interface (unused, only to avoid error).
     */

    @Override
    public void render(Graphics object) {

    }

    @Override
    public void loop() {

    }
}
