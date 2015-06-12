#!/usr/bin/env python
import argparse, logging


def calculateFileRasa(filePath):
    rowCount = 0
    multiplier = 1
    rasa = 0

    for line in open(filePath):
        rowCount += 1
        for char in line:
            if '{' in char:
                multiplier += 1
            if ';' in char:
                rasa += multiplier
            if '}' in char:
                multiplier -= 1
    return (rowCount, rasa)


def calculateRasa(filePaths):
    totalRows = 0
    totalRasa = 0
    for filePath in filePaths:
        rowCount, rasa = calculateFileRasa(filePath)
        totalRows += rowCount
        totalRasa += rasa
        print '%s: lines %d, RaSa: %d' % (filePath, rowCount, rasa)
    print 'total: lines %d, RaSa: %d' % (totalRows, totalRasa)


def main(args, loglevel):
    logging.basicConfig(format="%(levelname)s: %(message)s", level=loglevel)
    logging.debug("Your Arguments: %s" % args.argument)
    calculateRasa(args.argument)


if __name__ == '__main__':
    parser = argparse.ArgumentParser(description="Does a thing to some stuff.")
    parser.add_argument('argument', nargs='*')
    parser.add_argument("-v",
                        "--verbose",
                        help="increase output verbosity",
                        action="store_true")
    args = parser.parse_args()

    # Setup logging
    if args.verbose:
        loglevel = logging.DEBUG
    else:
        loglevel = logging.INFO

    main(args, loglevel)
