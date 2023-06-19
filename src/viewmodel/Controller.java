/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Filename     : Controller.java
 * Programmer   : Muhammad Cahyana Bintang Fajar
 * Email        : bintangfajar@upi.edu
 * Desc         : Package viewmodel for class Controller key input
 */

/*
 * Saya Muhammad Cahyana Bintang Fajar (2102665) mengerjakan Tugas Masa Depan
 * dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk
 * keberkahanNya maka saya tidak melakukan kecurangan seperti 
 * yang telah dispesifikasikan. Aamiin.
 */
package viewmodel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.GameObject;

/**
 *
 * @author Muhammad Cahyana Bintang Fajar
 */
public class Controller extends KeyAdapter implements KeyListener {
    /**
     * Attribute declaration.
     */

    private Game game;
    private Handler handler;

    /**
     * Constructor.
     */

    // Default constructor.
    public Controller() {
        this.game = new Game();
        this.handler = new Handler();
    }

    // Constructor with controller data.
    public Controller(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
    }

    /**
     * Getter and Setter.
     */

    /* Controller's game. */

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    /* Controller's handler. */

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    /**
     * Public methods.
     */

    // Override trait when key is pressed.
    @Override
    public synchronized void keyPressed(KeyEvent e) {
        System.out.println("Pressed");

        // Get key code (what key that pressed?).

        int key = e.getKeyCode();
        if (game.isRunning()) {
            // Searching for player object.
            int i = 0;
            boolean found = false;
            while ((found == false) && (i < handler.count())) {
                if (handler.get(i).getType().equals("Player")) {
                    found = true;
                } else {
                    i++;
                }
            }

            // Set the object and do the handling.
            GameObject temp = handler.get(i);

            if ((key == KeyEvent.VK_W) || (key == KeyEvent.VK_UP)) {

                // Move up.
                if (temp.getJumpFlag() == 0) {
                    temp.setVelY(-5); // move up
                    temp.setJumpFlag(1);
                }

            }
            if ((key == KeyEvent.VK_A) || (key == KeyEvent.VK_LEFT)) {
                // Move left.
                temp.setVelX(-5);
                temp.isLeft = true;

            }
            if ((key == KeyEvent.VK_D) || (key == KeyEvent.VK_RIGHT)) {
                // Move right.
                temp.setVelX(+5);
                temp.isLeft = false;

            }

        }

    }

    // Override trait when key is released from being pressed.
    @Override
    public synchronized void keyReleased(KeyEvent e) {
        System.out.println("Released");

        // Get key code (what key that released?).
        int key = e.getKeyCode();
        if (game.isRunning()) {
            // Searching for player object.
            int i = 0;
            boolean found = false;
            while ((found == false) && (i < handler.count())) {
                if (handler.get(i).getType() == "Player") {
                    found = true;
                } else {
                    i++;
                }
            }

            // Set the object and do the handling.
            GameObject temp = handler.get(i);
            if (key == KeyEvent.VK_SPACE) {
                game.stopGame();
            }
            if ((key == KeyEvent.VK_W) || (key == KeyEvent.VK_UP)) {
                temp.setVelY(+3);// gravity
            }
            if ((key == KeyEvent.VK_A) || (key == KeyEvent.VK_LEFT)) {
                // Stop from being moved left.
                temp.setVelX(0);
            }
            if ((key == KeyEvent.VK_D) || (key == KeyEvent.VK_RIGHT)) {
                // Stop from being moved right.
                temp.setVelX(0);
            }
        }
    }

}
