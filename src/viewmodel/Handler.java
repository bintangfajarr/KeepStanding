/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Filename     : Handler.java
 * Programmer   : Muhammad Cahyana Bintang Fajar
 * Email        : bintangfajar@upi.edu
 * Desc         : Package viewmodel for handler
 */

/*
 * Saya Muhammad Cahyana Bintang Fajar (2102665) mengerjakan Tugas Masa Depan
 * dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk
 * keberkahanNya maka saya tidak melakukan kecurangan seperti 
 * yang telah dispesifikasikan. Aamiin.
 */
package viewmodel;

import java.awt.Graphics;
import java.util.ArrayList;
import model.GameInterface;
import model.GameObject;

/**
 *
 * @author Muhammad Cahyana Bintang Fajar
 */
public class Handler implements GameInterface {
    /**
     * Attribute declaration.
     */

    private ArrayList<GameObject> object; // Array / List of GameObject.

    /**
     * Constructor.
     */

    // Default constructor.
    public Handler() {
        this.object = new ArrayList<>();

    }

    /**
     * Object access and manipulations.
     */

    // Add object to list.
    public void add(GameObject object) {
        this.object.add(object);
    }

    // Access object from list.
    public GameObject get(int i) {
        return this.object.get(i);
    }

    // Count total object on list.
    public int count() {
        return this.object.size();
    }

    // Remove object from list based on its index.
    public void remove(int i) {
        this.object.remove(i);
    }

    // Remove object from list.
    public void remove(GameObject object) {
        this.object.remove(object);
    }

    /**
     * 
     * Override interface.
     */

    @Override
    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject temp;
            temp = object.get(i);

            temp.render(g);
        }
    }

    @Override
    public void loop() {
        for (int i = 0; i < object.size(); i++) {
            GameObject temp;
            temp = object.get(i);

            temp.loop();
        }
    }
}
