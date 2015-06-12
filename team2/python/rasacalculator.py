#!/usr/bin/env python
import argparse


def calculate_file_rasa(file_path):
    row_count = 0
    multiplier = 1
    rasa = 0

    for line in open(file_path):
        row_count += 1
        for char in line:
            if char == '{':
                multiplier += 1
            if char == ';':
                rasa += multiplier
            if char == '}':
                multiplier -= 1
    return (row_count, rasa)


def main(args):
    total_rows = 0
    total_rasa = 0
    for file_path in args.argument:
        row_count, rasa = calculate_file_rasa(file_path)
        total_rows += row_count
        total_rasa += rasa
        print '%s: lines %d, RaSa: %d' % (file_path, row_count, rasa)
    print 'total: lines %d, RaSa: %d' % (total_rows, total_rasa)


if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument('argument', nargs='*')
    main(parser.parse_args())
