// This #include statement was automatically added by the Particle IDE.
#include <InternetButton.h>

// This #include statement was automatically added by the Particle IDE.
#include "InternetButton/InternetButton.h"

int countB1=0;
int countB2=0;
int countB3=0;
int countB4=0;

int xValue = 0;
int yValue = 0;
int zValue = 0;

InternetButton b = InternetButton();

bool rainbow=false;

void setup() {
    b.begin();

    Spark.variable("countButton1", &countB1, INT);
    Spark.variable("countButton2", &countB2, INT);
    Spark.variable("countButton3", &countB3, INT);
    Spark.variable("countButton4", &countB4, INT);
    Spark.variable("xValue", &xValue, INT);
    Spark.variable("yValue", &yValue, INT);
    Spark.variable("zValue", &zValue, INT);


    Spark.function("reset",resetButton);
    Spark.function("ledsOff",ledsOff);
    Spark.function("led",led);
    Spark.function("play",play);
    Spark.function("playSong",playCustomSong);
    Spark.function("march",march);
    Spark.function("allLed",allLed);
    b.allLedsOff();

}

void loop() {
    if(b.buttonOn(1)) countB1++;
    if(b.buttonOn(2)) countB2++;
    if(b.buttonOn(3)) countB3++;
    if(b.buttonOn(4)) countB4++;

    xValue = b.readX();
    yValue = b.readY();
    zValue = b.readZ();

     delay(100);
    }

int resetButton(String ignore){
  countB1=0;
  countB2=0;
  countB3=0;
  countB4=0;
}

int play(String command)
{

   b.playSong("C4,8,E4,8,G4,8,C5,8,G5,4");
   return 0;
}

int playCustomSong(String command)
{
   b.playSong(command);
   return 0;
}

int march(String command) {
    b.playSong("A4,4,R,3,A4,4,R,3,A4,4,R,3");
    b.playSong("R,3,F3,8,R,3,C5,8,R,3,A4,4,R,3");
    b.playSong("R,3,F3,8,R,3,C5,8,R,3,A4,4,R,3");
    b.playSong("R,3,A5,4,R,3,A5,4,R,3,A5,4,R,3");
    b.playSong("R,3,F6,8,R,3,C6,8,R,3,A5,4,R,3");
    b.playSong("R,3,F4,8,R,3,C6,8,R,3,A5,4,R,3");
}

int led(String command)
{

    int red = (command.substring(2,5)).toInt();
    int green = (command.substring(5,8)).toInt();
    int blue = (command.substring(8)).toInt();
    int pos = (command.substring(0,2)).toInt();

    b.ledOn(pos, red, green, blue);
    return 0;
}

int allLed(String command)
{

    int red = (command.substring(2,5)).toInt();
    int green = (command.substring(5,8)).toInt();
    int blue = (command.substring(8)).toInt();

    b.ledOn(1, red, green, blue);
    b.ledOn(2, red, green, blue);
    b.ledOn(3, red, green, blue);
    b.ledOn(4, red, green, blue);
    b.ledOn(5, red, green, blue);
    b.ledOn(6, red, green, blue);
    b.ledOn(7, red, green, blue);
    b.ledOn(8, red, green, blue);
    b.ledOn(9, red, green, blue);
    b.ledOn(10, red, green, blue);
    b.ledOn(11, red, green, blue);
    b.ledOn(12, red, green, blue);
    return 0;
}

int ledsOff(String command)
{
    b.allLedsOff();
    return 0;
}