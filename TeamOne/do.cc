#include <iostream> 
#include <fstream>

using namespace std;

int totalLines=0;
int totalRask=0;

void DoRasa(string file) {
    int timer=1;
    int lines=0;
    int rask=0;
    int allLines=0;
    string line;
    ifstream fin;
    fin.open(file.c_str(), ios::in);
    while ( getline(fin, line)) {
        allLines++;
        int i = 0;
        while (i < line.length()) {
            char c = line[i];
            if (c == ';') {
                lines++;
            }
            if (c == '{' ) {
                rask += lines * timer;
                timer++;
                lines = 0;
            }
            if (c == '}') {
                rask += lines * timer;
                if (timer > 1) {
                    timer--;
                }
                lines=0;
            }
            ++i;
        }
    }
    rask += lines * timer;
    fin.close();  
    cout << file << ": lines " << allLines << " , Rasa " << rask << endl;
}

int main(int argc, char**argv) {
    int i = 1;
    while (i < argc) {
        DoRasa(argv[i]);
        ++i;
    }
}

