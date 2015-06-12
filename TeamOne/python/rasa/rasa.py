import sys

def count_files():
    filenames = sys.argv[1:]
    complexity = 0
    lines = 0
    for filename in filenames:
        file_complexity, file_lines = count_rasa(filename)
        complexity += file_complexity
        lines += file_lines

    print "total: lines %s, RaSa %s" % (lines, complexity)

def count_rasa(filename):
    multiplier = 1
    complexity = 0
    lines = 0
    with open(filename) as fh:
        for line in fh:
            for char in line:
                if char == "{":
                    multiplier += 1
                elif char == "}":
                    multiplier -= 1
                elif char == ";":
                    complexity += multiplier
            lines += 1
    print "%s: lines %s, RaSa %s" % (filename, lines, complexity)
    return complexity, lines

if __name__ == "__main__":
    count_files()