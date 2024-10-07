package controller;
import Model.GameOfCrap;
import view.CrapsFrame;

import javax.swing.*;
import java.awt.*;

public class CrapsMain {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                final CrapsFrame main = new CrapsFrame();
               // final CrapsView main = new CrapsView();
                final Dimension frameSize = new Dimension(400,200);
                GameOfCrap.getMyInstance().addPropertyChangeListener(main);
                final JFrame frame = new JFrame("Game of Crap");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.setContentPane(main);
                frame.pack();
                frame.setSize(frameSize);



            }
        });


    }
}
