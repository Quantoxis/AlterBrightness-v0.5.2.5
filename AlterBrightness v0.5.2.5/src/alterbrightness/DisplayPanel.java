/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alterbrightness;

import com.fazecast.jSerialComm.SerialPort;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author p4053489
 */
public class DisplayPanel extends JPanel implements ChangeListener{

//    JPanel sliderP;
//    JPanel gammaSliderP;
//    JPanel labelP;
    
    JPanel layoutP;
    JPanel ribbonP;
    
    //declare global menu
    JMenuBar menuBar;
    JMenu portSelect, subMenu;
    JMenu displaySelect;
    JMenuItem portSelectItem;
    JMenuItem displaySelectItem;
    

    JLabel brightnessLvlLabel;

    JLabel redGammaLvlLabel;
    JLabel greenGammaLvlLabel;
    JLabel blueGammaLvlLabel;

    JSlider brightnessSlider;
    JSlider redGammaSlider;
    JSlider greenGammaSlider;
    JSlider blueGammaSlider;


    static final int minGammaLevel = 0;
    static final int maxGammaLevel = 10;
    static final int initialRedGammaLevel = 10;
    static final int initialGreenGammaLevel = 10;
    static final int initialBlueGammaLevel = 7;

    static final int minLevel = -10;
    static final int maxLevel = 10;
    static final int initialLevel = 0;

    MonitorPropertiesTest mp;

    public DisplayPanel(MonitorPropertiesTest mp) {

        this.mp = mp;
        //PortCommunication pc = new PortCommunication();

        ribbonP = new JPanel();
        layoutP = new JPanel();
        layoutP.setLayout(new BoxLayout(layoutP, BoxLayout.PAGE_AXIS));
        
        //layoutP.add(Box.createRigidArea(new Dimension(1,8)));
        
                
        //layoutP.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //create new instances of menu
        menuBar = new JMenuBar();
        portSelect = new JMenu("Port");
        displaySelect = new JMenu("Display");
        portSelectItem = new JMenuItem("COM4");
        
        SerialPort[] ports = SerialPort.getCommPorts();

        for (SerialPort allPorts : ports) {
            //allPorts.getSystemPortName();

   
            portSelectItem = new JMenuItem(allPorts.getSystemPortName());
            String s = allPorts.getSystemPortName();
            String[] menuItems = s.split("");
            
            for(int i=0;i<ports.length;i++){
                JMenuItem portSelectItem = new JMenuItem(menuItems[i]);
                
                //portSelect.add(portSelectItem);
                
            }
           
        }
        portSelectItem.addActionListener((ae) -> {
                if(ae.getSource() == portSelectItem)
    {
        
        mp.setSelectedPort(portSelectItem.getName());
    }
        });
        
        
        displaySelectItem = new JMenuItem("DP-4");
        
        
//        sliderP = new JPanel();
//        gammaSliderP = new JPanel();
//        labelP = new JPanel();

        //mp.setUserBias(mp.getUserBias());
        brightnessLvlLabel = new JLabel("Brightness bias");
        redGammaLvlLabel = new JLabel("Red gamma level");
        greenGammaLvlLabel = new JLabel("Green gamma level");
        blueGammaLvlLabel = new JLabel("Blue gamma level");

        ribbonP.add(menuBar);
        menuBar.add(portSelect);
        menuBar.add(displaySelect);
        portSelect.add(portSelectItem);
        displaySelect.add(displaySelectItem);
        
        
        //a change listener must be added to the slider
        //brightness slider
        brightnessSlider(mp);
        redGammaSlider(mp);
        greenGammaSlider(mp);
        blueGammaSlider(mp);


        time();


    this.add(ribbonP, BorderLayout.NORTH);


       


        
        //this.add(BorderLayout.WEST, gammaSliderP);
        layoutP.add(brightnessLvlLabel);
        layoutP.add(brightnessSlider);
        layoutP.add(redGammaLvlLabel);
        layoutP.add(redGammaSlider);
        layoutP.add(greenGammaLvlLabel);
        layoutP.add(greenGammaSlider);
        layoutP.add(blueGammaLvlLabel);
        layoutP.add(blueGammaSlider);
        

        
        
        
        
        this.add(layoutP, BorderLayout.CENTER);

    }

    public static void restAlert(String restAlertMessage, String titleBar) {
        titleBar = "You must be tired";
        restAlertMessage = "Take a ten minute break";
        JOptionPane.showMessageDialog(null, restAlertMessage);
    }

    public void brightnessSlider(MonitorPropertiesTest ex) {
        brightnessSlider = new JSlider(JSlider.VERTICAL, minLevel, maxLevel, initialLevel);

        //brightnessSlider.addChangeListener(this);
        brightnessSlider.setMajorTickSpacing(2);
        brightnessSlider.setMinorTickSpacing(1);
        brightnessSlider.setPaintTicks(true);
        brightnessSlider.setPaintLabels(true);

        //this.add(decreaseBrightnessBtn);
        //this.add(increaseBrightnessBtn);
        this.add(brightnessSlider);
        brightnessSlider.addChangeListener(this);

    }

    public void redGammaSlider(MonitorPropertiesTest ex) {
        redGammaSlider = new JSlider(JSlider.HORIZONTAL, minGammaLevel, maxGammaLevel, initialRedGammaLevel);

        redGammaSlider.setMajorTickSpacing(1);
        redGammaSlider.setMinorTickSpacing(1);
        redGammaSlider.setPaintTicks(true);
        redGammaSlider.setPaintLabels(true);

     
        redGammaSlider.addChangeListener(this);

    }

    public void greenGammaSlider(MonitorPropertiesTest ex) {
        greenGammaSlider = new JSlider(JSlider.HORIZONTAL, minGammaLevel, maxGammaLevel, initialGreenGammaLevel);

        greenGammaSlider.setMajorTickSpacing(1);
        greenGammaSlider.setMinorTickSpacing(1);
        greenGammaSlider.setPaintTicks(true);
        greenGammaSlider.setPaintLabels(true);

        
        greenGammaSlider.addChangeListener(this);

    }

    public void blueGammaSlider(MonitorPropertiesTest ex) {
        blueGammaSlider = new JSlider(JSlider.HORIZONTAL, minGammaLevel, maxGammaLevel, initialBlueGammaLevel);

        blueGammaSlider.setMajorTickSpacing(1);
        blueGammaSlider.setMinorTickSpacing(1);
        blueGammaSlider.setPaintTicks(true);
        blueGammaSlider.setPaintLabels(true);

        //gammaSliderP.add(blueGammaSlider);
        blueGammaSlider.addChangeListener(this);

    }

    public void stateChanged(ChangeEvent e) {


        JSlider brightnessSource = (JSlider) brightnessSlider;
        JSlider redSource = (JSlider) redGammaSlider;
        JSlider greenSource = (JSlider) greenGammaSlider;
        JSlider blueSource = (JSlider) blueGammaSlider;
        mp.setUserBias((float) brightnessSource.getValue() / 20);
        mp.setRedGamma((float) redSource.getValue() / 10);
        mp.setGreenGamma((float) greenSource.getValue() / 10);
        mp.setBlueGamma((float) blueSource.getValue() / 10);
    }





}

