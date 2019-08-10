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
class MonitorPropertiesTest {

    private int brightness;
    private int colourTemperature;
    private float voltage;
    private float averageVoltage;
    private float userBias;
    private boolean sineWaveStatus;
    
    private float redGamma;
    private float greenGamma;
    private float blueGamma;
    private float sineArrayValue;
    private String selectedPort;

    public int getBrightness() {

        return brightness;
    }

    public void setBrightness(int newBrightness) {
        brightness = newBrightness;
    }

    public int getColourTemperature() {
        return colourTemperature;
    }

    public void setColourTemperature(int newColourTemperature) {
        colourTemperature = newColourTemperature;
    }

    public float getVoltage() {
        return voltage;

    }

    public void setVoltage(float newVoltage) {

        voltage = newVoltage;

    }
    
   public float getAverageVoltage(){
       return averageVoltage;
   }
   
   public void setAverageVoltage(float newAverageVoltage)
   {
       averageVoltage = newAverageVoltage;
   }
    
    public float getUserBias(){
        return userBias;
    }
    
    public void setUserBias(float newUserBias){
        userBias = newUserBias;
    }
    
    public boolean getSineWaveStatus()
    {
        return sineWaveStatus;
    }
    
    public void setSineWaveStatus(boolean newSineWaveStatus){
        sineWaveStatus = newSineWaveStatus;
    }
    
    public float getRedGamma()
    {
        return redGamma;
    }
    
    public void setRedGamma(float newRedGamma){
        redGamma = newRedGamma;
    }
    
    public float getGreenGamma(){
        return greenGamma;
    }
    
    public void setGreenGamma(float newGreenGamma){
        greenGamma = newGreenGamma;
    }
    
    public float getBlueGamma(){
        return blueGamma;
    }
    
    public void setBlueGamma(float newBlueGamma){
        blueGamma = newBlueGamma;
    }
    public float getSineArrayValue(){
        return sineArrayValue;
    }
    
    public void setSineArrayValue(float newSineArrayValue){
        sineArrayValue = newSineArrayValue;
    }
    
    public String getSelectedPort()
    {
        return selectedPort;
    }
    
    public void setSelectedPort(String newSelectedPort)
    {
        selectedPort = newSelectedPort;
    }

}
