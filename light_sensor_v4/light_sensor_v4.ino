const int sensorPin = A0; //analog input is A0 on board
const int numberOfReadings = 10; //size of readings array

float readingsArray[numberOfReadings]; //array of readings from analogue input
int readIndex = 0; //current reading array index
float sum = 0; //sum of readings 
float average = 0; //average



void setup() {
  Serial.begin(9600); //opens a serial port to read at 9600 bits/s

  //set sum of average to zero when program starts
  for(int currentReading = 0; currentReading < numberOfReadings; currentReading++){
  readingsArray[numberOfReadings] = 0;
  }
}

void loop() {

  //subtract previous reading
  sum -= readingsArray[readIndex];
  //read from sensor
  int sensorValue = analogRead(sensorPin);
  
  //calculate value from sensor to voltage
  float voltage = sensorValue*(5.0/1023.0);
  //assign voltage to the readingsArray indicx
  readingsArray[readIndex] = voltage;

  //add reading to sum
  sum+=readingsArray[readIndex];
  
  //move to the next element in the array
  readIndex+=1;

  //if the end of the array indices has been reached reset it to zero
  if(readIndex >= numberOfReadings){
    readIndex = 0;
  }
//divide the sum by the number of all the indexes in the indices to get an average
average = sum / numberOfReadings;
    //send average to serial
    Serial.println(average);

  }
