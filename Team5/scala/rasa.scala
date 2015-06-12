package com.arcusysTest2015

import scala.annotation.tailrec
import scala.io.Source

object Main extends App {
  args.foreach(calculateFile)

  def calculateFile(file: String) {
    val (lines, rasa) = calculate(Source.fromFile(file)(scala.io.Codec.ISO8859), 0,0,0)

    println(s"$file: lines: $lines, RaSa: $rasa")
  }

  @tailrec
  def calculate(source: Source, lines: Int, level: Int, rasa: Int) : (Int, Int) = {
    if (!source.hasNext) (lines, rasa)
    else source.next() match {
      case '\n' => calculate(source, lines + 1, level, rasa)
      case '{' => calculate(source, lines, level + 1, rasa)
      case '}' => calculate(source, lines, level - 1, rasa)
      case ';' => calculate(source, lines, level, rasa + (level + 1))
      case _ => calculate(source, lines, level, rasa)
    }
  }
}