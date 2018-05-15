package com.mohit.program.progress;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.IOException;

/**
 * Created by Mohit Soni on 15-05-2018.
 */
public class SquareProgressMaster extends JFrame {

    private JPanel mainPanel;
    private JButton tug1, tug2;
    private JLabel jlhead;

    private Dimension dimen;
    private ImageIcon ii_boll;
    private BufferedImage bi_boll;

    private static boolean play = true;

    private int width, height, xV = 0, xH = 0,
            yV = 0, yH = 0;
    private String head, subHead, message;
    private String imgSrc = "/com/mohit/program/progress/image/boll.png";


    public SquareProgressMaster(String head, String subHead, String message) throws HeadlessException {

        dimen = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) dimen.getWidth();
        height = (int) dimen.getHeight();

        try {
            bi_boll = ImageIO.read(getClass().getResource(imgSrc));
            ii_boll = new ImageIcon(bi_boll);
        } catch (ImagingOpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setSize(400, 100);
        setLocation(width / 2 - 200, height / 2 - 50);
        setResizable(false);
        setUndecorated(true);
        setTitle("DY");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFocusable(true);
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int id = e.getKeyCode();
                if (id == 10) {
                    play = false;
                    stop();
                }
            }
        });

        mainPanel = new JPanel(null);
        mainPanel.setBackground(new Color(255, 255, 255));
        this.add(mainPanel);
        setXY(45, 10, 5, 50);
        setText(head, subHead, message);

        jlhead = new JLabel(head);
        jlhead.setBounds(100, 10, 300, 30);
        jlhead.setFont(new Font(head, Font.BOLD, 25));
        mainPanel.add(jlhead);

        jlhead = new JLabel(message);
        jlhead.setBounds(100, 30, 300, 30);
        jlhead.setFont(new Font(subHead, Font.PLAIN, 20));
        mainPanel.add(jlhead);

//		jlhead = new JLabel(messege);
//		jlhead.setBounds(100, 50, 300, 30);
//		jlhead.setFont(new Font(messege,Font.PLAIN, 15));
//		mainPanel.add(jlhead);

        tug1 = new JButton(ii_boll);
        tug1.setBounds(xV, yV, 20, 20);
        tug1.setBorder(BorderFactory.createEmptyBorder());
        tug1.setContentAreaFilled(false);
        tug1.setFocusPainted(false);
        mainPanel.add(tug1);

        tug2 = new JButton(ii_boll);
        tug2.setBounds(xH, yH, 20, 20);
        tug2.setBorder(BorderFactory.createEmptyBorder());
        tug2.setContentAreaFilled(false);
        tug2.setFocusPainted(false);
        mainPanel.add(tug1);

        JLabel verBorder = new JLabel();
        verBorder.setBounds(30, 20, 22, 57);
        verBorder.setBorder(BorderFactory.createLineBorder(new Color(174, 174, 174)));
        verBorder.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 1, Color.GRAY));
        mainPanel.add(verBorder);

        JLabel horBorder = new JLabel();
        horBorder.setBounds(10, 40, 60, 18);
        horBorder.setBorder(BorderFactory.createLineBorder(new Color(174, 174, 174)));
        horBorder.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 2, Color.GRAY));
        mainPanel.add(horBorder);
    }

    @SuppressWarnings("deprecation")
    private void start() {
        this.show();
        new Dowload().execute();
    }

    private void stop() {
        this.dispose();
    }

    private class Dowload extends SwingWorker<Void, Void> {
        @Override
        protected Void doInBackground() throws Exception {
            Move();
            return null;
        }
    }

    private void Move() {
        while (play) {
            for (int i = 10; i >= 0; i--) {
                yV = yV + i;
                xH = xH + i;
                sleep(xV, yV, xH, yH);
            }
            for (int i = 1; i < 7; i++) {
                xV = xV - i;
                yH = yH - i;
                sleep(xV, yV, xH, yH);
            }
            for (int i = 10; i > 0; i--) {
                yV = yV - i;
                xH = xH - i;
                sleep(xV, yV, xH, yH);
            }
            for (int i = 1; i < 7; i++) {
                xV = xV + i;
                yH = yH + i;
                sleep(xV, yV, xH, yH);
            }
            setXY(45, 12, 5, 50);
        }
    }

    private void sleep(int x, int y, int x1, int y1) {
        try {
            tug1.setBounds(x, y, 20, 20);
            tug2.setBounds(x1, y1, 20, 20);
            mainPanel.add(tug1);
            mainPanel.add(tug2);
            mainPanel.invalidate();
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void setXY(int xV, int yV, int xH, int yH) {
        this.xV = xV;
        this.yV = yV;
        this.xH = xH;
        this.yH = yH;
    }

    private void setText(String head, String subHead, String message) {
        this.head = head;
        this.subHead = subHead;
        this.message = message;
    }
}
