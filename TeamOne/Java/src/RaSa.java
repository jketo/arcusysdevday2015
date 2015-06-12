import java.io.*;

/**
 * Created by msavolainen on 12/06/15.
 */
public class RaSa {

	public static void main (String[] args) {
		int totalLines = 0;
		int totalRasa = 0;

		for (String fileName : args) {
			int lines = 0;
			int rasa = 0;
			int multiplier = 1;

			// Open the file
			FileInputStream fstream = null;
			try {
				fstream = new FileInputStream(fileName);
				BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

				String line;

				//Read File Line By Line
				while ((line = br.readLine()) != null)   {
					// calculate line
					for(int i = 0; i < line.length(); i++) {
						switch (line.charAt(i)) {
							case '{':
								multiplier += 1;
								break;
							case '}':
								multiplier -= 1;
								break;
							case ';':
								rasa += multiplier;
								break;
						}
					}

					// increment lines
					lines += 1;
				}

				//Close the input stream
				br.close();
			} catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

			System.out.println(fileName + ": lines " + lines + ", RaSa: " + rasa);
			totalLines += lines;
			totalRasa += rasa;
		}

		System.out.println("Total: lines " + totalLines + ", RaSa: " + totalRasa);
	}
}
