using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JavaThingamabob
{
    class Program
    {
        static void Main(string[] args)
        {
            var FileLineArrays = new List<Tuple<string,string[]>>();
            
            foreach (var item in args)
            {
                if (item.Contains('*') || item.Contains('?'))
                {
                    var files = Directory.GetFiles(".", item);
                    foreach (var foundFile in files)
                    {
                        var tempTuple = new Tuple<string, string[]>(foundFile, File.ReadAllLines(foundFile));

                        FileLineArrays.Add(tempTuple);
                    }

                    continue;
                }

                if (!File.Exists(item))
                {
                    continue;
                }

                var file = File.ReadAllLines(item);
                var tuple = new Tuple<string, string[]>(item, file);
                FileLineArrays.Add(tuple);
            }

            int TotalLines = 0;
            int TotalCount = 0;
            foreach (var CheckingObject in FileLineArrays)
            {
                if (!CheckingObject.Item1.EndsWith(".java"))
                {
                    continue;
                }

                int Multiplier = 1;
                int Count = 0;
                
                foreach (var line in CheckingObject.Item2)
                {
                    foreach (var character in line)
                    {
                        switch (character)
                        {
                            case '{':
                                Multiplier++;
                                break;
                            case '}':
                                Multiplier--;
                                break;
                            case ';':
                                Count += Multiplier;
                                break;
                            default:
                                break;
                        }
                    }
                }

                var Filename = CheckingObject.Item1.Replace(".\\", "");

                if (Filename[0] == '.')
                {
                    Filename = Filename.Substring(1);
                }

                Console.WriteLine(Filename + ": lines " + CheckingObject.Item2.Length + ", RaSa " + Count);
                TotalCount += Count;
                TotalLines += CheckingObject.Item2.Length;
            }

            Console.WriteLine("total: lines " + TotalLines + ", RaSa " + TotalCount);
        }
    }
}
