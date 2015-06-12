package fi.arcusys.devday2015.team2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.io.filefilter.WildcardFileFilter;

public class RaSaCalculator {
	Map<String, String> datas = new HashMap<String, String>();
	Map<String, Integer> results = new HashMap<String, Integer>();
	Map<String, Integer> lines = new HashMap<String, Integer>();

	private String[] fileNames;

	public RaSaCalculator(String[] args) {
		this.fileNames = args;

	}

	public void processFiles() {
		readFiles(this.fileNames);
	}

	private void readFiles(String[] args) {
		File dir = new File(".");

		for (String arg : args) {
			FileFilter fileFilter = new WildcardFileFilter(arg);
			File[] files = dir.listFiles(fileFilter);

			for (File file : files) {

				if (file.exists()) {
					String fileName = file.getName();

					BufferedReader reader = null;
					try {
						reader = new BufferedReader(new FileReader(file));

						String line = null;
						int lineCount = 0;
						int depth = 1;
						int complexity = 0;

						while ((line = reader.readLine()) != null) {
							lineCount++;
							for (int i = 0; i < line.length(); i++) {
								char ch = line.charAt(i);
								switch (ch) {
								case '{':
									depth++;
									break;
								case '}':
									depth--;
									break;
								case ';':
									complexity += depth;
									break;
								}
							}
						}
						System.out.println(fileName + ": lines " + lineCount
								+ ", RaSa " + complexity);
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							reader.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RaSaCalculator calculator = new RaSaCalculator(args);
		calculator.processFiles();
	}
}
