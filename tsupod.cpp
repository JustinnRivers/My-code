#include <iostream>
#include <fstream>

#include "tsuPod.h"
using namespace std;



int main()

void initTsuPod(char blank,device(NUM_SONGS))
{
 cout << "The TsuPod is ready for use."<<endl;
	for(int i;i<NUM_SONGS;i++)
	{
		device[i].title=blank;
		device[i].name=blank;
		device[i].size=0;
	}
}

void showSongList(device(NUM_SONGS)
{
	for(int i=0;i<NUM_SONGS;i++)
	{
		if(device[i].title || device[i].name)
		{
		cout << "Empty"<<;
		}
		cout << "song number" << i+1 << device[i].title << device[i].name << device[i].size <<endl;
	}
}


