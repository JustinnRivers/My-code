/****************************************************
Name:
Date:
Problem Number:
C&C++ 2008 Spring
Instructor: Komogortsev, TSU
Objective: Example of the test file for tsuPod code

************************/

#include <iostream>
#include <fstream>

#include "tsuPod.h"

using namespace std;

struct TsuPod
{
string title;
string name;
int size;
};

const int NUM_SONGS=8;
const int MEMORY_SIZE=25;

int main() 

TsuPod device [NUM_SONGS];
char  blank=" ";
     
    // Following code initializes the tsuPod 
    initTsuPod(char  blank);


    
    // Following code lists all songs located in tsuPod memeory 
    showSongList(/*add nessesary parameters here*/);
    cout << endl;
    


    // Following code tests tsuPod input functionality 
    int retCode = addSong("Runaway1", "Bon Jovi1", 1);
    retCode = addSong(/*add nessesary parameters here*/,"Runaway2", "Bon Jovi2", 2);
    retCode = addSong(/*add nessesary parameters here*/, "Runaway3", "Bon Jovi3", 3);
    retCode = addSong(/*add nessesary parameters here*/, "Runaway4", "Bon Jovi4", 1);
    retCode = addSong(/*add nessesary parameters here*/, "Runaway5", "Bon Jovi5", 5);
    retCode = addSong(/*add nessesary parameters here*/, "Runaway6", "Bon Jovi6", 6);
    retCode = addSong(/*add nessesary parameters here*/, "Runaway7", "Bon Jovi7", 1);
    retCode = addSong(/*add nessesary parameters here*/, "Runaway8", "Bon Jovi8", 1);
    retCode = addSong(/*add nessesary parameters here*/, "Runaway8", "Bon Jovi8", 1);
    retCode = addSong(/*add nessesary parameters here*/, "Runaway8", "Bon Jovi8", 1);
    retCode = addSong(/*add nessesary parameters here*/, "Runaway8", "Bon Jovi8", 1);
    cout << retCode << endl;   
    showSongList();
    cout << endl;



    // Following code tests tsuPod song removal functionality         
    retCode = removeSong("Runaway100");
    cout << retCode << endl;    
    showSongList();
    cout << endl;



    // Following code tests tsuPod song shuffling functionality      
    shuffle();
    cout << endl;
    showSongList();
    cout << endl;
    
    system("PAUSE");
    
}
