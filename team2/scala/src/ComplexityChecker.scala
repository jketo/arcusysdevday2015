object ComplexityChecker {


  def calculate(content: String) : (Int, Int) = {
    var complexity = 0
    var depth = 1
    var statements = 0;
    for (c <- content) {
      if (c == '{') {
        depth += 1
      }
      if (c == '}') {
        depth -= 1
      }
      if (c == ';') {
        statements += 1
        complexity += depth
      }
    }
    (complexity, statements)
  }

  def processFile(path: String) = {
    val source = scala.io.Source.fromFile(path)
    val lines = try source.mkString finally source.close()
    val (complexity, statements) = calculate(lines)
    println("file" + path + ": lines: " + statements + " RaSa: " + complexity)
  }

  def main(args: Array[String]) {
    args.foreach(processFile)
  }

}