/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Filename     : tscoreTable.java
 * Programmer   : Muhammad Cahyana Bintang Fajar
 * Email        : bintangfajar@upi.edu
 * Desc         : Package model for class tscoretable (query)
 */

/*
 * Saya Muhammad Cahyana Bintang Fajar (2102665) mengerjakan Tugas Masa Depan
 * dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk
 * keberkahanNya maka saya tidak melakukan kecurangan seperti 
 * yang telah dispesifikasikan. Aamiin.
 */
package model;

import java.sql.SQLException;

/**
 *
 * @author Muhammad Cahyana Bintang Fajar
 */
public class tscoreTable extends DB {
    // constructor
    public tscoreTable() throws Exception, SQLException {
        super();
    }

    public void getData() {
        try {
            // getting all data from table
            String query = "SELECT * FROM tscore ORDER by score DESC";
            createQuery(query);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void getDetailData(String username) {
        try {
            // getting specific data from table
            String query = "SELECT * FROM tscore WHERE username='" + username + "'";
            createQuery(query);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void insertData(tscore exp) {
        try {
            // input data to database
            String query = "INSERT INTO tscore VALUES ('" + exp.getUsername() + "', '" + exp.getSkor() + "', '"
                    + exp.getStanding() + "')";
            createUpdate(query);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void updateData(tscore exp) {
        try {
            // update data
            String query = "UPDATE tscore SET standing=" + exp.getStanding() + ", score=" + exp.getSkor()
                    + " WHERE username='" + exp.getUsername() + "'";
            createUpdate(query);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
