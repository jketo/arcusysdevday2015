package com.arcusysTest2015

import scala.annotation.tailrec
import scala.io.Source

object ScalaApp {

  case class FileResult(file: String, lines: Int, rasa: Int)

  def main(args: Array[String]) {
    val results = args.map(calculateFile)

    results.foreach { r =>
      println(s"${r.file}: lines: ${r.lines}, RaSa: ${r.rasa}")
    }

    println(s"total: lines ${results.map(_.lines).sum}, Rasa ${results.map(_.rasa).sum}")
  }

  def calculateFile(file: String) = {
    val (lines, rasa) = calculate(Source.fromFile(file), 0, 0, 0)
    FileResult(file, lines, rasa)
  }

  @tailrec
  def calculate(s: Source, lines: Int, level: Int, rasa: Int): (Int, Int) = {
    if (!s.hasNext) (lines, rasa)
    else s.next() match {
      case '\n' => calculate(s, lines + 1, level, rasa)
      case '{' => calculate(s, lines, level + 1, rasa)
      case '}' => calculate(s, lines, level - 1, rasa)
      case ';' => calculate(s, lines, level, rasa + (level + 1))
      case _ => calculate(s, lines, level, rasa)
    }
  }
}