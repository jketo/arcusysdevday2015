object ComplexityChecker {

  def calculate(content: String) : (Int, Int) = {
    var complexity = 0
    var depth = 1
    var lines = 0
    for (c <- content) {
      if (c == '{') {
        depth += 1
      }
      if (c == '}') {
        depth -= 1
      }
      if (c == ';') {
        complexity += depth
      }
      if (c == '\n') {
        lines += 1
      }
    }
    (complexity, lines)
  }

  def processFile(path: String) : (Int, Int) = {
    val source = scala.io.Source.fromFile(path)
    val content = try source.mkString finally source.close()
    val (complexity, lines) = calculate(content)
    println("file" + path + ": lines: " + lines + " RaSa: " + complexity)
    (complexity, lines)
  }

  def main(args: Array[String]) {
    var tc = 0
    var tl = 0
    for (arg <- args) {
      val r = processFile(arg)
      tc += r._2
      tl += r._1
    }
    //val totals = args.map((arg) => processFile(arg))
    println("total lines: " + tl + " RaSa: " + tc)
  }

}