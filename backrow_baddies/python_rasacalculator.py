#!/usr/bin/python3

import sys


def calculate_ras(java_file):
    ras_count = 0
    ras_mult = 1
    for line in java_file:
        for char in line:
            if char == '{':
                ras_mult += 1
            elif char == '}':
                ras_mult -= 1
            elif char == ';':
                ras_count += ras_mult
    return ras_count


if __name__ == "__main__":
    for java_file in sys.argv[1:]:
        print(calculate_ras(open(java_file, 'r')))
