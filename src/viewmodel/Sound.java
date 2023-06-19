/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Filename     : Sound.java
 * Programmer   : Muhammad Cahyana Bintang Fajar
 * Email        : bintangfajar@upi.edu
 * Desc         : Package viewmodel for play sound
 */

/*
 * Saya Muhammad Cahyana Bintang Fajar (2102665) mengerjakan Tugas Masa Depan
 * dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk
 * keberkahanNya maka saya tidak melakukan kecurangan seperti 
 * yang telah dispesifikasikan. Aamiin.
 */

package viewmodel;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *

 */
public class Sound {

    public Clip playSound(Clip clip, String filename) {
        try {
            // Fetch BGm
            AudioInputStream audioInput = AudioSystem
                    .getAudioInputStream(new File("src/assets/" + filename).getAbsoluteFile());
            clip = AudioSystem.getClip();

            clip.open(audioInput); // Open Input
            clip.start(); // Start
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        return clip;
    }

    // Stop BGM
    public void stopSound(Clip clip) {
        clip.stop();
    }
}
