#include "DHT.h"
#include <math.h>
#define PIN_NTC 0
#define DHTPIN 2
#define DHTTYPE DHT22 


DHT dht(DHTPIN, DHTTYPE);

int peltier = 5;
int power = 0;
int peltier_level = map(power, 0, 99, 0, 255);
float h = 0;
float t = 0;
double Rref = 10000.0; //Résistance de référence à 25°C
double V_IN = 5.0; //Alimentation électrique

//Information de la thermistance
double A_1 = 3.354016E-3;
double B_1 = 2.569850E-4;
double C_1 = 2.620131E-6;
double D_1 = 6.383091E-8;

double SteinhartHart(double R)
{
  //Division de l'équation en 4 parties. La premiere est
  //uniquement A1
  double equationB1 = B_1 * log(R/Rref);
  double equationC1 = C_1 * pow(log(R/Rref), 2);
  double equationD1 = D_1 * pow(log(R/Rref), 3);
  double equation = A_1 + equationB1 + equationC1 + equationD1;
  return pow(equation, -1);
 
}

void setup(){
    Serial.begin(9600);
    dht.begin();

}

void loop(){
        
        h = dht.readHumidity();
        t = dht.readTemperature();
        double reader0 = analogRead(0);
        double reader1 = analogRead(1);
        float temp1 = 0;
        char option;
      
      //Calcul de la tension sur la borne analogique
  double valeurAnalog0 = analogRead(0);
  double valeurAnalog1 = analogRead(1);
  double V0 = valeurAnalog0 / 1024 * V_IN;
  double V1 = valeurAnalog1 / 1024 * V_IN;
 
  //Calcul de la résistance de la thermistance
  double Rth0 = (Rref * V0 ) / (V_IN - V0);
 // Serial.print("Rth extérieure = ");
 // Serial.print(Rth0);

  double Rth1 = (Rref * V1 ) / (V_IN - V1);
 // Serial.print("Rth du module = ");
 // Serial.print(Rth1);
 
  //Calcul de la température en kelvin( Steinhart and Hart)
  double kelvin0 = SteinhartHart(Rth0);
  double celsius0 = kelvin0 - 273.15; //Conversion en celsius   

  double kelvin1 = SteinhartHart(Rth1);
  double celsius1 = kelvin1 - 273.15;

  float K = ((17.27 * t ) / ((237.7 + t)) + (log(h)*0.01));
  float Rosee = (237.7 * K) / (17.7 - K);
        
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
                Serial.print (power);
                Serial.print(" PLevel = ");
                Serial.println(peltier_level);
                analogWrite(peltier, peltier_level);
                Serial.println("Humidite : " + String(h) + "%");
                Serial.println("Temperature du frigo : " + String(t) + " *C");

                Serial.println("Temperature exterieure : " + String(celsius0));
              
                Serial.println("Temperature du module : " + String(celsius1));

                Serial.println("Rosee : " + String(Rosee));
        
        delay(500);
}

