#include "fstream"
#include "string"
using namespace std;
int main (int argc, char *argv[])
{
 char Str[255];int i = 0;
 int depth = 0;
 int summaryRasa = 0;
 int totalLines = 0;

 for (i = 0; i < argc; i++) cout << "argv[" << i << "] содержит " << argv[i] << endl; {
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
	 std::cout << argv[i] << ": lines "<<lines<<", Rasa "<<rasa<<"\n";
	 summaryRasa += rasa;
	 totalLines += lines;
 }
 
 std::cout << "total: lines "<<totalLines<<", Rasa "<<summaryRasa<<"\n";
}