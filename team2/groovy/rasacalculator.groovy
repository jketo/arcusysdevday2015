/**
 * Created by avilesov on 12.6.2015.
 */
for (argument in args) {
    File file = new File(argument);
    if (!file.exists()) {
        println "$argument: does not exist"
    } else {
        def (lines, statements) = getRaSA(file);
        println "$argument: lines $lines RaSa: $statements"
    }
}

private def getRaSA(File f){
    def lines = 0
    def level = 1
    def statements = 0
    f.eachLine {
        for (char ch: it.toCharArray()) {
            if (ch == "{") level++
            if (ch == ";") {
                statements = statements + level
            }
            if (ch == "}") level--
        }
        lines++
    }
    return [lines,  statements]
}