#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[])
{
    int total_lines = 0;
    int total_rasa = 0;
    char line[500];
    for (int a = 1; a < argc; ++a) {
        int lines = 0;
        int rasa = 0;
        int mult = 1;
        FILE *java_file = fopen(argv[a], "r");
        while (fgets(line, sizeof line, java_file)) {
            size_t len = strlen(line);
            for (int i = 0; i < len; ++i) {


                char c = line[i];
                if (c == '{') {
                    mult += 1;
                }
                else if (c == '}') {
                    mult -= 1;
                }
                else if (c == ';') {
                    rasa += mult;
                }
            }
            lines += 1;
        }
        printf("%s: lines %d, rasa %d\n", argv[a], lines, rasa);
        total_lines += lines;
        total_rasa += rasa;
    }
    printf("total: lines %d, rasa %d\n", total_lines, total_rasa);
    return 0;
}
