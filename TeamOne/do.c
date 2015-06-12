#include <stdio.h> 
#include <stdlib.h>
#include <string.h>

int timer=1;
int lines=0;
int totalRask=0;
int totalLines=0;

void DoRasa(char *file) {
    int timer=1;
    int lines=0;
    int rask=0;
    int allLines=0;
    char line[1024] = {0};
    FILE *f = fopen(file, "r");
    while ( fgets(line, 1024, f)) {
        allLines++;
        int i = 0;
        while (i < strlen(line)) {
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
    fclose(f);
    totalLines+=allLines;
    totalRask+=rask;  
    printf("%s: lines %d, Rasa %d\n", file, allLines, rask);
}

int main(int argc, char**argv) {
    int i = 1;
    while (i < argc) {
        DoRasa(argv[i]);
        ++i;
    }
    printf("Total: lines %d, Rasa %d\n", totalLines, totalRask);
}

