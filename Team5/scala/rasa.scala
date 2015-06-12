package com.arcusysTest2015

import scala.io.Source

object Main extends App {
  args.foreach(calculateFile)

  def calculateFile(file: String) {
    val (lines, level, rasa) = calculate(Source.fromFile(file)(scala.io.Codec.ISO8859))

    println(s"$file: lines: $lines, RaSa: $rasa")
  }

  def calculate(source: Source) {
    var lines = 1
    var level = 1
    var rasa = 0

    source.foreach {
      case '\n' => lines += 1
      case '{' => level += 1
      case '}' => level -= 1
      case ';' => rasa += level
      case _ =>
    }

    (lines, level, rasa)
  }
}