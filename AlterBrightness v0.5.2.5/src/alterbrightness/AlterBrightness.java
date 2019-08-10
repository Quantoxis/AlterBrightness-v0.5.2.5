package alterbrightness;

import com.fazecast.jSerialComm.SerialPort;
import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class AlterBrightness {

    public static void main(String[] args) {

        {

            MonitorPropertiesTest mp = new MonitorPropertiesTest();
            
 
            PortCommunication pc = new PortCommunication(mp);
            //create threads
           
            Thread t2 = new Thread(pc);
            //start threads
           
            t2.start();
           
            //draw GUI
            JFrame displayF = new JFrame();
            DisplayPanel displayP = new DisplayPanel(mp);

            displayF.setVisible(true);
            displayF.setResizable(false);
            displayF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            displayF.setSize(550, 500);
            displayF.add(displayP);

            String os = System.getProperty("os.name").toLowerCase();

//        if (os.indexOf("win") >= 0) {
//            System.out.println("Running Windows");
//         
//            screenSet.setIsWindows(true);
//            
//        } else if (os.indexOf("linux") >= 0) {
//            System.out.println("Running linux");
//          screenSet.setIsLinux(true);
//        } else if (os.indexOf("mac") >= 0) {
//            System.out.println("Running mac");
//            isMac = true;
//        } else {
//            System.out.println("OS is unsupported!");
//            isUnsupportedOs = true;
//        }
            if (!SystemTray.isSupported()) {
                System.out.println("Error: system tray is unsupported");
                return;
            }

//TerminalCommands tc = new TerminalCommands();

            DisplayPanel dp = new DisplayPanel(mp);

//tc.runArduino();

//tc.changeBrightness(mp, idOsTest, idOs);
//        dp.setIt(idOsTest, idOs, mp, tc, mp.getBrightness());
//        if (idOsTest.getIsLinux(idOs)) {
//            //tc.changeBrightness(tc, idOsTest, idOs);
//            //tc.getVoltage();
//        } else if (idOsTest.getIsWindows(idOs)) {
//            //change Windows brightness to 30% for now
//            //Runtime.getRuntime().exec("Get-WmiObject -Namespace root/WMI -Class WmiMonitorBrightnessMethods).WmiSetBrightness(1," + Integer.toString(screenSet.getBrightness()+")"));
//            tc.changeBrightness(tc, idOsTest, idOs);
//        } else if (idOsTest.getIsMac()) {
//
//        }
//create popup menu
            final PopupMenu popup = new PopupMenu();

//set a tray icon
            TrayIcon trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().getImage("images/bulb.png"));

//automatically set icon size
            trayIcon.setImageAutoSize(true);

//set tool tip
            trayIcon.setToolTip("Alter screen brightness");

//make tray icon visible
//get system tray
            final SystemTray tray = SystemTray.getSystemTray();

//create menu items
            MenuItem aboutItem = new MenuItem("About");
            MenuItem openItem = new MenuItem("Open");
            MenuItem exitItem = new MenuItem("Exit");

            popup.add(aboutItem);
            popup.add(openItem);
            popup.add(exitItem);

            trayIcon.setPopupMenu(popup);

            try {
                tray.add(trayIcon);
            } catch (AWTException ex) {
                System.out.println("Tray Icon cannot be added to the tray");
            }

            exitItem.addActionListener(ex -> {
                System.exit(0);

            });

            openItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

        }
    }
}
