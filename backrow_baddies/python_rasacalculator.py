#!/usr/bin/python3

import sys


def calculate_rasa(java_file):
    rasa_count = 0
    rasa_mult = 1
    for lines_0, line in enumerate(java_file):
        for char in line:
            if char == '{':
                rasa_mult += 1
            elif char == '}':
                rasa_mult -= 1
            elif char == ';':
                rasa_count += rasa_mult
    return lines_0 + 1, rasa_count


if __name__ == "__main__":
    total_lines = 0
    total_rasa = 0
    for java_file in sys.argv[1:]:
        lines, rasa = calculate_rasa(open(java_file, 'r'))
        total_lines += lines
        total_rasa += rasa
        print("{}: lines {}, rasa {}".format(java_file, lines, rasa))
    print("total: lines {}, rasa {}".format(total_lines, total_rasa))
