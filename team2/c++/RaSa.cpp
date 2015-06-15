#include <iostream>
#include <fstream>
#include <string>

using namespace std;

void processFile(int& tl, int& tc, const char* path) {
	string line;
	ifstream infile(path);
	int depth = 1;
	int lines = 0; int complexity = 0;
	while (getline(infile, line))
	{
		for (int i = 0; i < line.length(); ++i) {
			if (line[i] == '{') {
				depth++;
			}
			if (line[i] == '}') {
				depth--;
			}
			if (line[i] == ';') {
				complexity += depth;
			}
		}
		lines++;
	}
	cout << "file: " << path << " lines: " << lines << " RaSa: " << complexity << endl;
	tl += lines; tc += complexity;
}

int main(int argc, char** argv) {
	int tl = 0; int tc = 0;
	for (int i = 1; i < argc; ++i) {
		processFile(tl, tc, *(argv + i));
	}
	cout << "total lines: " << tl << " RaSa: " << tc << endl;
}
