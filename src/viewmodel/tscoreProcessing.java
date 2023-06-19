/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Filename     : tscoreProcessing.java
 * Programmer   : Muhammad Cahyana Bintang Fajar
 * Email        : bintangfajar@upi.edu
 * Desc         : Package viewmodel for class tscoreProcessing, process all data to db
 */

/*
 * Saya Muhammad Cahyana Bintang Fajar (2102665) mengerjakan Tugas Masa Depan
 * dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk
 * keberkahanNya maka saya tidak melakukan kecurangan seperti 
 * yang telah dispesifikasikan. Aamiin.
 */
package viewmodel;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.tscore;
import model.tscoreTable;

/**
 *
 * @author Muhammad Cahyana Bintang Fajar
 */
public class tscoreProcessing {
    private String error; // for storing error message
    private tscoreTable table; // a class for accessing query
    private ArrayList<tscore> data; // for storing result from query

    // Constructor
    public tscoreProcessing() {
        try {
            // Initializing Table Object and List
            table = new tscoreTable();
            data = new ArrayList<tscore>();
        } catch (Exception e) {
            error = e.toString();
        }
    }

    // Read Data From Database And Return It As DefaultTableModel
    public DefaultTableModel readData() {
        DefaultTableModel dataTbl = null;
        try {
            // Getting All Data From screrience Table
            Object[] column = { "Username", "Score", "Standing" };
            dataTbl = new DefaultTableModel(null, column);
            table.getData();
            while (table.getResult().next()) {
                // Taking All Query Result
                tscore scr = new tscore();
                scr.setUsername(table.getResult().getString(1));
                scr.setSkor(table.getResult().getInt(2));
                scr.setStanding(table.getResult().getInt(3));

                Object[] row = new Object[3];
                row[0] = scr.getUsername();
                row[1] = scr.getSkor();
                row[2] = scr.getStanding();

                // Add Data to List
                dataTbl.addRow(row);
                data.add(scr);
            }
            // Close Result
            table.closeResult();

            // Close Database Connection
            table.closeConnection();
        } catch (Exception e) {
            error = e.toString();
        }

        return dataTbl;
    }

    // Check Username is Exist in Database
    public boolean isDataExist(String username) {
        boolean result = false;
        try {
            table.getData();
            while (table.getResult().next()) {
                if (table.getResult().getString(1).equals(username)) {
                    result = true;
                    break;
                }
            }
        } catch (Exception e) {
            error = e.toString();
        }

        return result;
    }

    // Get Data
    public void getData(String username) {
        try {
            table.getDetailData(username);
            tscore scr = new tscore();
            table.getResult().next();
            scr.setUsername(table.getResult().getString(1));
            scr.setSkor(table.getResult().getInt(2));
            scr.setStanding(table.getResult().getInt(3));

            data.add(scr);

            table.closeResult();
            table.closeConnection();
        } catch (Exception e) {
            error = e.toString();
        }
    }

    // Save Data
    public void saveData(String username, int score, int standing) {
        try {
            tscore scr = new tscore();
            scr.setUsername(username);
            scr.setSkor(score);
            scr.setStanding(standing);

            // Checking Is Username Already Exist in Database or Not
            if (isDataExist(username)) {
                table.updateData(scr);
            } else {
                table.insertData(scr);
            }
            table.closeConnection();
        } catch (Exception e) {
            error = e.toString();
        }
    }

    // Get Data
    public String getUsername(int i) {
        return data.get(i).getUsername();
    }

    public int getSkor(int i) {
        return data.get(i).getSkor();
    }

    public int getStanding(int i) {
        return data.get(i).getStanding();
    }

    public int getSize() {
        return data.size();
    }

    public String getError() {
        return this.error;
    }
}
