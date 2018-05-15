package com.mohit.program.topic.collection.grid;


import com.mohit.program.util.Global;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mohit Soni on 15-05-2018.
 */
public class GridMaster extends JFrame {
    GridLayout experimentLayout = new GridLayout(0, 2);

    public GridMaster() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(getContentPane());
        pack();
        setVisible(true);
        setResizable(false);
    }

    public void addComponentsToPane(final Container pane) {
        final JPanel compsToExperiment = new JPanel();
        compsToExperiment.setLayout(experimentLayout);
        //Set up components preferred size
        JButton b = new JButton("Just fake button");
        Dimension buttonSize = b.getPreferredSize();
        compsToExperiment.setPreferredSize(new Dimension((int) (buttonSize.getWidth() * 3),
                (int) (buttonSize.getHeight() * 5)));

        experimentLayout.setHgap(10);
        experimentLayout.setVgap(10);

        ActionListener listener = new MyListener();
        for (int i = 0; i < 5; i++) {
            Image newimg = new Global().createImageIcon("/m1.png").getImage()
                    .getScaledInstance(170, 50, Image.SCALE_FAST);
            ImageIcon icon = new ImageIcon(newimg);

            JButton but = new JButton(icon);
            but.setBorder(BorderFactory.createEmptyBorder());
            but.setContentAreaFilled(false);
            but.setFocusPainted(false);
            but.addActionListener(listener);
            compsToExperiment.add(but);
        }
        pane.add(compsToExperiment, BorderLayout.NORTH);
    }

    private class MyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button pressed: " + e.paramString());
        }
    }

}
