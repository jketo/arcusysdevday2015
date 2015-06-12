import sys

def count_files():
    filenames = sys.argv[1:]
    complexity = 0
    for filename in filenames:
        f = open(filename)
        complexity += count_rasa(f)
        f.close()
    print complexity

def count_rasa(f):
    multiplier = 1
    complexity = 0
    for line in f:
        for char in line:
            if char == "{":
                multiplier += 1
            elif char == "}":
                multiplier -= 1
            elif char == ";":
                complexity += multiplier
    return complexity

if __name__ == "__main__":
    count_files()