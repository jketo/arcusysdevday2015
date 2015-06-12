from sys import argv


def inspect(s, level=1):
    try:
        opening = s.index('{')
    except ValueError:
        opening = 0
    try:
        closing = s.index('}')
    except ValueError:
        closing = 0
    count = 0
    if not opening and not closing:
        return s.count(';')
    elif closing >=0 and opening >= 0:
        if opening:
            end = min(opening, closing)
        else:
            end = closing
        head = s[0:end]
        count = head.count(';')
        count = count * level
        going_deeper = opening and opening < closing
        if going_deeper:
            count += inspect(s[end+1:], level + 1)
        else:
            count += inspect(s[end+1:], level - 1)
    return count


def main(argv):
    total_lines = 0
    total_rasa = 0
    for filename in argv[1:]:
        f = open(filename)
        lines = f.readlines()
        linecount = len(lines)
        rasacount = inspect(''.join(lines))
        print '%s: lines %d, RaSa %d' % (filename, linecount, rasacount)
        f.close()
        total_lines += linecount
        total_rasa += rasacount

    print 'total: lines %d, RaSa %d' % (total_lines, total_rasa)


if __name__ == "__main__":
    main(argv)
