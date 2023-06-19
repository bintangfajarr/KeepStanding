/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Filename     : Game.java
 * Programmer   : Muhammad Cahyana Bintang Fajar
 * Email        : bintangfajar@upi.edu
 * Desc         : Package viewmodel for class Game (main mechanic)
 */

/*
 * Saya Muhammad Cahyana Bintang Fajar (2102665) mengerjakan Tugas Masa Depan
 * dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk
 * keberkahanNya maka saya tidak melakukan kecurangan seperti 
 * yang telah dispesifikasikan. Aamiin.
 */
package viewmodel;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;
import java.util.Random;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import view.Display;
import view.Menu;
import model.GameObject;
import model.Obstacle;
import model.Player;

/**
 *
 * @author Muhammad Cahyana Bintang Fajar
 */
public class Game extends Canvas implements Runnable {
    /**
     * 
     * Attribute declaration.
     */

    /* View-related attributes. */
    public static final int width = 800;
    public static final int height = 600;
    private Display display;

    // Controller controller= new Controller();

    /* Process-related attributes. */
    private boolean running;
    private Handler handler;
    private Thread thread;

    /* Animation-related attributes. */
    private boolean startCounting = false;
    private Clip clip;
    private int standing = 0;
    private int skor = 0;
    private int counter = 0;
    private int stateCounter = 0;
    private int direction = 0;
    private String username;

    // Default constructor.
    public Game() {
        try {
            // Initialize display.
            display = new Display(width, height, "TMD DPBO 2023");
            display.open(this);

            // Initialize game handler.
            handler = new Handler();

            // Initialize controller (keyboard input).
            this.setFocusable(true);
            this.requestFocus();
            this.addKeyListener(new Controller(this, handler));

            // Initialize all object.
            running = true;
            if (running) {
                handler.add(new Player(320, 0));
                int tempY = 0;
                for (int i = 0; i < 7; i++) { // inisiasi obtacle 7
                    handler.add(new Obstacle(RandomNum(0, 500) - Game.WIDTH, tempY + 560)); // add obstacle
                    tempY += RandomNum(120, 240); // random distance between 2 obstacles
                }

                // set obstacle to moving up
                GameObject obs = null;
                for (int i = 0; i < handler.count(); i++) {
                    if (handler.get(i).getType() == "Obstacle") {
                        obs = handler.get(i);
                        int velocity = -1; // set velY to up constant -1
                        obs.setVelY(velocity);
                    }
                }
                // set gravity for player
                handler.get(0).setVelY(+3);
            }
        } catch (Exception e) {
            System.err.println("Failed to instance data.");
        }
    }

    /**
     * 
     * Getter and Setter.
     */

    /* Game running status. */

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    // username
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    // standing
    public void setStanding(int standing) {
        this.standing = standing;
    }

    public int getStanding() {
        return this.standing;
    }

    // score
    public void setSkor(int skor) {
        this.skor = skor;
    }

    public int getSkor() {
        return this.skor;
    }

    // random num generator
    public static int RandomNum(int min, int max) {
        Random random = new Random();
        int result = random.nextInt((max - min) + 1) + min;
        return result;
    }

    /* Game score. */

    /**
     * 
     * Public methods.
     */

    // Clamp, so player won't get offset the display bound.
    public static int clamp(int var, int min, int max) {
        if (var >= max) {
            return var = max;
        } else if (var <= min) {
            return var = min;
        }

        return var;
    }

    // Close display.
    public void close() {
        display.close();
    }

    /**
     * 
     * Game controller.
     */

    // Start threading.
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    // Stop threading.
    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            System.out.println("Thread error : " + e.getMessage());
        }
    }

    // Initialize game when it run for the first time.
    public void render() {
        // Use buffer strategy.
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(4);
            return;
        }

        // Initialize graphics.
        Graphics g = bs.getDrawGraphics();
        // background
        Image bg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/game5.jpg"));
        g.drawImage(bg, 0, 0, null);

        if (running == true) {
            // Render handler.
            handler.render(g);

            // Render score.
            Font oldFont = g.getFont();
            Font newFont = oldFont.deriveFont(oldFont.getSize());
            g.setFont(newFont);

            // draw score standing and username
            g.setColor(Color.white);
            g.drawString("Username : " + username, 20, 70);
            g.setColor(Color.white);
            g.drawString("Standing: " + Integer.toString(standing), 20, 30);
            g.setColor(Color.white);
            g.drawString("Score : " + Integer.toString(skor), 20, 50);

        }

        // Loop the process so it seems like "FPS".
        g.dispose();
        bs.show();
    }

    // Main loop proccess.
    public void loop() {

        LinkedList<GameObject> obstacles = new LinkedList<>(); // list for save obstacle
        GameObject player = null;
        handler.loop();
        if (this.running) {
            counter++;
            if (startCounting) {
                stateCounter++;
            }

            if (stateCounter >= 40) {
                stateCounter = 0;
                startCounting = false;
            }

            if (counter >= 50) {
                direction = (direction == 0) ? 1 : 0;
                counter = 0;
            }

            for (int i = 0; i < handler.count(); i++) {
                if (handler.get(i).getType().equals("Player")) {
                    player = handler.get(i);
                }
                if (handler.get(i).getType().equals("Obstacle")) {
                    obstacles.add(handler.get(i)); // add obstacle to linkedlist
                }
            }

            // loop for set obstacle add new and remove unused obstacle
            GameObject obs = null;
            for (int i = 0; i < handler.count(); i++) {
                if (handler.get(i).getType().equals("Obstacle")) {
                    obs = handler.get(i);
                    if (obs.getY() <= Game.HEIGHT - 40) { // if obs pass the display height, then remove, and add new
                                                          // from the bottom
                        obs.setStanding(false);
                        handler.add(new Obstacle(RandomNum(00, 500) - Game.WIDTH,
                                obstacles.get(handler.count() - 2).getY() + RandomNum(120, 240)));
                        handler.remove(obs);
                        i--;

                    }
                }
            }

            // loop for moving obstacle to top
            for (int i = 0; i < handler.count(); i++) {
                if (handler.get(i).getType().equals("Obstacle")) {
                    obs = handler.get(i);
                    int velocity = -1;
                    obs.setVelY(velocity);
                }
            }

            // loop for collision
            for (int i = 0; i < handler.count(); i++) {
                if (handler.get(i).getType().equals("Obstacle")) {
                    obs = handler.get(i);
                    if (obs.getY() - 62 <= player.getY() && obs.getWidth() >= player.getX() // if player collide with
                                                                                            // obstacle
                            && obs.getY() >= player.getY()) {
                        player.setY(obs.getY() - 62);
                        player.setJumpFlag(0);

                        if (obs.getStanding() == false) { // add standing and score if getStanding false
                            standing++;
                            skor += obs.getScore();
                            obs.setStanding(true);// set to true
                        }
                    }

                    if (obs.getY() >= player.getY() - 60 && obs.getWidth() >= player.getX() // agar tidak bisa nembus
                                                                                            // obstacle lain ketika di
                                                                                            // bawah obstacle
                            && obs.getY() <= player.getY()) {
                        player.setY(obs.getY() + 60);
                    }

                }
                if (player.getY() <= Game.HEIGHT - 30 || player.getY() >= height - 30) { // for game over
                    stopGame();
                }
            }

        }
    }

    /**
     * 
     * Override interface.
     */

    @Override
    public void run() {
        Sound sound = new Sound();
        double fps = 60.0;
        double ns = (1000000000 / fps);
        double delta = 0;

        clip = sound.playSound(this.clip, "bgm.wav");
        // Timer attributes.
        long time = System.nanoTime();
        long now = 0;
        long timer = System.currentTimeMillis();

        int frames = 0;
        while (running) {
            now = System.nanoTime();
            delta += ((now - time) / ns);
            time = now;

            while (delta > 1) {
                loop();
                delta--;
            }

            if (running) {
                render();
                frames++;
            }

            if ((System.currentTimeMillis() - timer) > 1000) {
                timer += 1000;
                frames = 0;
            }

        }

        stop();
    }

    public void saveData() { // process data to database
        try {
            tscoreProcessing process = new tscoreProcessing();
            process.saveData(username, skor, standing);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null,
                "Username: " + this.username + "\nScore: " + this.skor + "\nStanding: " + this.standing, "Game Over!",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public synchronized void stopGame() { // stopgame / game over
        saveData();
        new Sound().stopSound(this.clip);
        running = false;
        this.setVisible(false);
        new Menu().setVisible(true);
        close();
        this.dispose();

    }

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
