using System;
using System.IO;

namespace HelloWorld
{
  class Hello 
  {
    class RasaResult {      
      public int    LinesCount { get; set; }
      public int    RasaCount  { get; set; }
    }

    static RasaResult RasaConculation(IEnumeration<String> lines)
    {    
      var rasaResult = new RasaResult();

      rasaResult.LinesCount = lines.Count ();
      rasaResult.RasaCount  = lines.Sum (line => {
        line.Count (c => c == ';') * ((line.Count (c => c == '{') - line.Count (c => c == '}')) + 1);
      });

      return rasaResult;
    }

    static void Main(string[] args) 
    {
      foreach (var fileName in args) {
        
        var file = File.OpenText (fileName);
        var content = file.ReadLines ();
        file.Close ();

        var result = RasaConculation (content);

        Console.WriteLine ("File name: " + fileName + " Lines: " + result.LinesCount + " RaSa: " + result.RasaCount);
      }
    }
  }
}

