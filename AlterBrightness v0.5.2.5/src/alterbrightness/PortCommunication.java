//This class receives information from the arduino that will be used to control the brightness
package alterbrightness;
//add import for the jSerialComm API

import com.fazecast.jSerialComm.SerialPort;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.ListIterator;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrew
 */
public class PortCommunication extends MonitorPropertiesTest implements Runnable {

    //create a global class SerialPort
    SerialPort sp;
    MonitorPropertiesTest mp;
    IdentifyOsTest idOsTest;
    //private BufferedReader input;
    OutputStream output;

    public PortCommunication(MonitorPropertiesTest mp) {
        this.mp = mp;
    }

    //this uses the jSerialComm API
    //create a new instance of  set the correct comm port
    public void run() {

        sp.getCommPorts().toString();

        //the serial port output must be hardcoded here
        sp = com.fazecast.jSerialComm.SerialPort.getCommPort("/dev/ttyACM0");

        //sp = com.fazecast.jSerialComm.SerialPort.getCommPort("COM4");
        SerialPort[] ports = SerialPort.getCommPorts();

        for (SerialPort allPorts : ports) {
            allPorts.getSystemPortName();

        }

        if (sp.openPort()) {
            System.out.println("Port is open");

        } else if (sp.closePort()) {
            System.out.println("port is closed");
        }

        //9600 baud rate, 8 bits, 1 bit, no parity
        sp.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 0, 0);
        Scanner inputFromArduino = new Scanner(sp.getInputStream());
        //String s = inputFromArduino.toString();
        sp.getBaudRate();

        //set baud rate to 9600, number of data bits to 8 bits, 1 stop bits in a word and no parity.
        //no parity is used because error detection is not that important.
        sp.setComPortParameters(9600, 8, 1, 0);
        //timeout

        //mp = new MonitorPropertiesTestClass();
        output = sp.getOutputStream();
        while (inputFromArduino.hasNextLine()) {
            
            inputFromArduino.nextLine();
            
            String sIn = inputFromArduino.nextLine();
            
//catch corrupted values leaving catch statement intentionally empty
            
           try {
            //parse string to float    
            float result = Float.parseFloat(sIn);
            
            //convert voltage to an xrandr --brightness value
            float brightness = result / 5;
            
            mp.setVoltage(brightness);
            
            try {
                //xrandr controls monitors independently
                //the video card output must be hardcoded to this string
                String videoCardOutput = "eDP-1";
                //Terminal command to run Xrandr

                mp.getUserBias();

                float brightnessSetting = 0.5f;
                //add user bias to automatic reading if both total to between 0.0 and 1.0
                if(mp.getUserBias() + brightness >  0.0f && mp.getUserBias() + brightness < 1.0f
                        && brightness > 0.0f && brightness < 1.0f) {

                    brightnessSetting = brightness + mp.getUserBias();
                    
                } else if(brightness > 0.0f && brightness < 1.0f && brightness + mp.getUserBias() < 0.0f
                        || brightness + mp.getUserBias() > 1.0f){
                    
                    brightnessSetting = brightness;
                }

                float gammaRSetting = mp.getRedGamma();
                float gammaGSetting = mp.getGreenGamma();
                float gammaBSetting = mp.getBlueGamma();

                Runtime.getRuntime().exec("xrandr --output " + videoCardOutput + " --brightness " + brightnessSetting + " --gamma " + gammaRSetting + ":" + gammaGSetting + ":" + gammaBSetting);
                System.out.println("Video card output: " + videoCardOutput + " brightness: " + brightness + " Brightness setting: " + brightnessSetting + " User bias: " + mp.getUserBias() + " Red: " + gammaRSetting + " Green: " + gammaGSetting + " Blue: " + gammaBSetting);
           
            } catch (IOException ex) {
                Logger.getLogger(PortCommunication.class.getName()).log(Level.SEVERE, null, ex);
            }
                        } catch (Exception e) {

            }
        }
    }
}

