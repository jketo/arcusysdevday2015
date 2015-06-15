#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>

void processFile(int& lines, int& complexity, const char* path) {
	std::string line;
	std::ifstream infile(path);
	int depth = 1;
	while (std::getline(infile, line))
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
	std::cout << "file: " << path << " lines: " << lines << " RaSa: " << complexity << std::endl;
}

int main(int argc, char** argv) {
	int tl = 0; int tc = 0;
	for (int i = 1; i < argc; ++i) {
		int lines = 0; int complexity = 0;
		processFile(lines, complexity, *(argv + i));
		tl += lines;
		tc += complexity;
	}
	std::cout << "total lines: " << tl << " RaSa: " << tc << std::endl;
}
