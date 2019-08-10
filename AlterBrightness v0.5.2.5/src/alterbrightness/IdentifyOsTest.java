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
public class IdentifyOsTest {

    private boolean isLinux;
    private boolean isWindows;
    private boolean isMac;
    private boolean isUnsupportedOs;

    public boolean getIsLinux(IdentifyOs idOs) {
        return isLinux;
    }

    public void setIsLinux(boolean isNewLinux) {
        isLinux = isNewLinux;
    }

    public boolean getIsWindows(IdentifyOs id) {
        return isWindows;
    }

    public void setIsWindows(boolean isNewWindows) {
        isWindows = isNewWindows;
    }

    public boolean getIsMac() {
        return isMac;
    }

    public void setIsMac(boolean isNewMac) {
        isMac = isNewMac;
    }

    public boolean getIsUnsupportedOs() {
        return isUnsupportedOs;
    }

    public void setIsUnsupportedOs(boolean newUnsupportedOs) {
        isUnsupportedOs = newUnsupportedOs;
    }

}
