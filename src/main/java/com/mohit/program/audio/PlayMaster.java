package com.mohit.program.audio;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Mohit Soni on 15-05-2018.
 */
public class PlayMaster extends JFrame {

    JPanel mainPanel;
    JButton play, stop;

    static String soundPath = "/alarm.wav";

    Clip clip;
    URL url;

    public PlayMaster() {
        setSize(200, 100);
        mainPanel = new JPanel(null);

        play = new JButton("Play");
        play.setBounds(20, 20, 60, 30);
        play.setVisible(true);
        mainPanel.add(play);

        stop = new JButton("Stop");
        stop.setBounds(100, 20, 60, 30);
        stop.setVisible(true);
        mainPanel.add(stop);

        url = this.getClass().getResource(soundPath);

        play.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                try {
                    clip = AudioSystem.getClip();
                    try {
                        AudioInputStream in = AudioSystem.getAudioInputStream(url);
                        clip.open(in);
                        clip.start();
                    } catch (UnsupportedAudioFileException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
        });
        stop.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                clip.stop();
            }
        });
        this.add(mainPanel);
    }

    public static synchronized void play() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    try {
                        URL url = this.getClass().getResource(soundPath);
                        AudioInputStream in = AudioSystem.getAudioInputStream(url);

                        clip.open(in);
                        clip.start();
                    } catch (UnsupportedAudioFileException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
