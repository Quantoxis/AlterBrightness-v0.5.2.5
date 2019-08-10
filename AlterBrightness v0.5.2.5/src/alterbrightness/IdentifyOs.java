/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alterbrightness;

/**
 *
 * @author Andrew
 */
public class IdentifyOs extends IdentifyOsTest {

    IdentifyOsTest idOsTest;

    public IdentifyOs() {

        this.idOsTest = idOsTest;

        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            idOsTest.setIsWindows(true);
            idOsTest.setIsLinux(false);
            idOsTest.setIsMac(false);
            idOsTest.setIsUnsupportedOs(false);

        } else if (os.contains("linux")) {

            idOsTest.setIsLinux(true);
            idOsTest.setIsWindows(false);
            idOsTest.setIsMac(false);
            idOsTest.setIsUnsupportedOs(false);

        } else if (os.contains("mac")) {

            idOsTest.setIsMac(true);
            idOsTest.setIsLinux(false);
            idOsTest.setIsWindows(false);
            idOsTest.setIsUnsupportedOs(false);
        }

//         else{
//            
//            idOs.setIsUnsupportedOs(true);
//            idOs.setIsLinux(false);
//            idOs.setIsMac(false);
//            idOs.setIsWindows(false);
//        }
    }
}
