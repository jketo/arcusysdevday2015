using System;
using System.Collections.Generic;
using System.Collections;
using System.IO;

public class RaSa {

    public static void main(string [] args){
		int total  = 0;
		int totalLines = 0;
		int multi;
		int complexity;
		IList<string> lines = null;
		for(string filename : args){
			multi = 1;
			complexity = 0;
			try{
				lines = Files.readAllLines(Paths.get(filename), 					Charset.defaultCharset());
			}
			catch(Exception x){
				//FAILREAD
			}
			if(lines != null){
				for(string line : lines){
					char[] chars = line.toCharArray();
					for(char c : chars){
						if(c == '{'){
							multi++;
						}
						else if(c == '}'){
							multi--;
						}
						else if(c == ';'){
							complexity += multi;
						}
					}
				}
				Console.WriteLine("File: " + filename + " Lines: " + lines.size() 							+ " Complexity: " + complexity);
				total += complexity;
				totalLines += lines.size();
			}
		}
		Console.WriteLine("Total lines: " + totalLines + " Total complexity: " + total);
	}
	
}
