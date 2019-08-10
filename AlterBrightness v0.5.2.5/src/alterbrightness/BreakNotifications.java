/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alterbrightness;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Andrew
 */
public class BreakNotifications {

    /**
     * @param args the command line arguments
     */
    int secsPassed = 0;

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {

        public void run() {
            secsPassed++;
            System.out.println("Secs passed: " + secsPassed);
                    JFrame frame = new JFrame();
        JLabel breakPromptLabel = new JLabel("Take a 10 minute break!");

        frame.setSize(300, 200);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        frame.add(breakPromptLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
        frame.setLocation(1800, 800);
        
        
        }
    };

    public void start() {
        timer.scheduleAtFixedRate(task, 600000, 600000);

        BreakNotifications notify = new BreakNotifications();
        notify.start();
        
    }
    



    

}

        
          

  