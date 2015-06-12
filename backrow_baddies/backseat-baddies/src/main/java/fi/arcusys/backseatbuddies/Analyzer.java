package fi.arcusys.backseatbuddies;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by tturunen on 12.6.2015.
 */
public class Analyzer {


    private static final String LINES = "lines ";
    private static final String RASA = ", RaSa ";

    private final String result;

    public Analyzer(List<String> filePaths) {
        if (filePaths == null || filePaths.isEmpty()) {
            result = "";
            return;
        }
        StringBuilder buffer = new StringBuilder(2048);
        long totalLines = 0;
        long totalRasa = 0;

        for (String argument : filePaths) {
            Path path = Paths.get(argument);
            if (Files.exists(path) && Files.isReadable(path) && Files.isRegularFile(path)) {
                try {
                    Tuple<Long, Long> result = getRasaCount(new String(Files.readAllBytes(path), "UTF-8"));
                     if (result != null && result._1 != null && result._2 != null) {
                        totalLines += result._1;
                        totalRasa += result._2;
                         buffer.append(argument).append(": ").append(LINES).append(result._1).append(RASA).append(result._2).append("\n");
                     }
                } catch (IOException e) {
                    buffer.append("Epic fail ").append(e.getMessage());
                    e.printStackTrace();
                }
            } else {
                buffer.append("Skipping file (not a file or doesn't exist " + path.toString());
            }
        }
        buffer.append("total: lines ").append(totalLines).append(", RaSa ").append(totalRasa).append("\n");


        result = buffer.toString();
    }

    public String getResult() {
        return result;
    }

    private void print(String string) {
        System.out.println(string);
    }

    static Tuple<Long, Long> getRasaCount(String fileContent) {
        if (fileContent == null || fileContent.isEmpty()) {
            return null;
        }

        long rasCount = 0;
        long rasMultiplier = 1;
        long lineCount = 0;
        for (char character : fileContent.toCharArray()) {
            if (character == '{')
                rasMultiplier += 1;
            else if (character == '}')
                rasMultiplier -= 1;
            else if(character == ';')
                rasCount += rasMultiplier;
            else if (character == '\n') {
                lineCount++;
            }
        }
        return new Tuple(new Long(lineCount), new Long(rasCount));
    }

}
