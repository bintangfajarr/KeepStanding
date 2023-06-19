/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Filename     : tscore.java
 * Programmer   : Muhammad Cahyana Bintang Fajar
 * Email        : bintangfajar@upi.edu
 * Desc         : Package model for savedata
 */

/*
 * Saya Muhammad Cahyana Bintang Fajar (2102665) mengerjakan Tugas Masa Depan
 * dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk
 * keberkahanNya maka saya tidak melakukan kecurangan seperti 
 * yang telah dispesifikasikan. Aamiin.
 */
package model;

/**
 *
 * @author Muhammad Cahyana Bintang Fajar
 */
public class tscore {
    private String username; // username
    private int score;
    private int standing;

    public tscore() {
        //
    }

    // Setter and Getter
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setStanding(int standing) {
        this.standing = standing;
    }

    public int getStanding() {
        return this.standing;
    }

    public void setSkor(int skor) {
        this.score = skor;
    }

    public int getSkor() {
        return this.score;
    }
}
