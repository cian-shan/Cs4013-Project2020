package com.codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Apphome.
 */
public class Apphome {
    private JButton HomeAdmin;
    private JPanel panelMain;
    private JButton HomeUser;
    private JLabel SelectLogin;

    /**
     * Instantiates a new Apphome.
     */
    public Apphome() {
        HomeAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        HomeUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
