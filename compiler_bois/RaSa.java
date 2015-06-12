import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class RaSa {

	public static void main(String [] args){
		int total  = 0;
		int totalLines = 0;
		int multi;
		int complexity;
		List<String> lines = null;
		for(String filename : args){
			multi = 1;
			complexity = 0;
			try{
				lines = Files.readAllLines(Paths.get(filename), Charset.defaultCharset());
			}
			catch(Exception x){
				//FAILREAD
			}
			if(lines != null){
				for(String line : lines){
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
				System.out.println("File: " + filename + " Lines: " + lines.size() + " Complexity: " + complexity);
				total += complexity;
				totalLines += lines.size();
			}
		}
		System.out.println("Total lines: " + totalLines + " Total complexity: " + total);
	}
	
}
