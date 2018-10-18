package org.prez.model;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class Placeholder {
    
    public Placeholder(){
        
    }
    
    public Placeholder(JTextField textField, String description) {
        this.addPlaceholder(textField, description);
    }

    public void addPlaceholder(JTextField textField, String description) {
        textField.setText(description);
        textField.setForeground(new Color(153, 153, 153));
        
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                JTextField txt = (JTextField) e.getComponent();
                if (txt.getText().trim().equals("")) {
                    txt.setText(description);
                    txt.setForeground(new Color(153, 153, 153));
                    txt.select(0, 0);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                JTextField txt = (JTextField) e.getComponent();
                if (!txt.getText().equals(description)) {
                    txt.setForeground(Color.black);
                }else{
                    txt.setForeground(new Color(153, 153, 153));
                    txt.select(0, 0);
                }
            }

        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                JTextField txt = (JTextField) e.getComponent();
                if(txt.getText().equals("") || txt.getText().equals(description)){
                    txt.setText(description);
                    txt.setForeground(new Color(153,153,153));
                    txt.select(0, 0);
                }else{
                    txt.setText(txt.getText().replaceAll(description, ""));
                    txt.setForeground(Color.black);
                }
            }
        });
        
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JTextField txt = (JTextField) e.getComponent();
                if (txt.getText().equals(description)) {
                    txt.select(0, 0);
                }
            }
        });
        
        textField.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                JTextField txt = (JTextField) evt.getComponent();
                if (txt.getText().equals(description)) {
                    txt.select(0, 0);
                }
            }
        });
    }
}
