import argparse


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


def main(args):
    totalRows = 0
    totalRasa = 0
    for filePath in args.argument:
        rowCount, rasa = calculateFileRasa(filePath)
        totalRows += rowCount
        totalRasa += rasa
        print '%s: lines %d, RaSa: %d' % (filePath, rowCount, rasa)
    print 'total: lines %d, RaSa: %d' % (totalRows, totalRasa)


if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument('argument', nargs='*')
    main(parser.parse_args())
