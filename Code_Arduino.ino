#include "DHT.h"
#define DHTPIN 2
#define DHTTYPE DHT22 


DHT dht(DHTPIN, DHTTYPE);

int peltier = 5;
int power = 0;
int peltier_level = map(power, 0, 99, 0, 255);
float h = 0;
float t = 0;
float r = 10000.00;

void setup(){
    Serial.begin(9600);
    dht.begin();
}

void loop(){
        
        h = dht.readHumidity();
        t = dht.readTemperature();
        double reader = analogRead(0);
        float temp1 = 0;
        char option;
        
        temp1 = (1023.00 / reader ) ;
        temp1 = (temp1 - 1);
        temp1 = (10000 / temp1);

        if(Serial.available() > 0)
  {
     option = Serial.read();
     if(option == 'a')
     power += 5;
     else if(option == 'z')
     power -= 5;

     if (power > 99) power = 99;
     if (power < 0) power = 0;

     peltier_level = map(power, 0, 99, 0, 255);
  }
                Serial.print("Power = ");
                Serial.print(power);
                Serial.print(" PLevel = ");
                Serial.print(peltier_level);
                analogWrite(peltier, peltier_level);
                Serial.print("\n Humidite :");
                Serial.print(h);
                Serial.print(" %\t");
                Serial.print("Temperature du frigo :");
                Serial.print(t);
                Serial.print(" *C");
                Serial.print("\n Temperature exterieure : ");
                Serial.println(temp1);
        
        delay(1000);
}

