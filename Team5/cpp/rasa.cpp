#include <stdio.h>
#include <iostream>
#include "fstream"
#include "string"
using namespace std;
int main (int argc, char *argv[])
{
 int depth = 1;
 int summaryRasa = 0;
 int totalLines = 0;

 for (i = 1; i < argc; i++) {
 	ifstream fin(argv[i], std::ios::in);
 	int rasa = 0;
 	int lines = 0;
	 while (1) {
	 	char ch = fin.get();
	 	if (fin.eof())
	 		break;
	 	switch (ch) {
	 		case ';': rasa += depth; break;
	 		case '{': depth ++; break;
	 		case '}': depth --; break;
	 		case '\n': lines ++; break;
	 	}
	 }
	 std::cout << argv[i] << ": lines "<<lines<<", RaSa "<<rasa<<"\n";
	 summaryRasa += rasa;
	 totalLines += lines;
 }
 
 std::cout << "total: lines "<<totalLines<<", RaSa "<<summaryRasa<<"\n";
}