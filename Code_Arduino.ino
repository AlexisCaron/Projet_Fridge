#include "DHT.h"
#define DHTPIN 2
#define DHTTYPE DHT22 


DHT dht(DHTPIN, DHTTYPE);

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

        temp1 = (1023.00 / reader ) ;
        temp1 = (temp1 - 1);
        temp1 = (10000 / temp1);
        
                Serial.print("Humidite :");
                Serial.print(h);
                Serial.print(" %\t");
                Serial.print("Temperature du frigo :");
                Serial.print(t);
                Serial.print(" *C");
                Serial.print("\n Temperature exterieure : ");
                Serial.println(temp1);
        
        delay(2500);
}

