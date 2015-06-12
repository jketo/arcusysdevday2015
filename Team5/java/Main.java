import java.io.*;
import java.lang.Exception;
import java.nio.charset.Charset;


public class Main {
    public static void main(String[] args) {
        int depth = 1;
        int summaryRasa = 0;
        int totalLines = 0;

        Charset encoding = Charset.defaultCharset();
        for (String filename : args) {
            File file = new File(filename);
            int rasa = 0;
            int lines = 0;
            try {
                InputStream in = new FileInputStream(file);
                 Reader reader = new InputStreamReader(in, encoding);
                 // buffer for efficiency
                 Reader buffer = new BufferedReader(reader);
                int r;
                while ((r = reader.read()) != -1) {
                    char ch = (char) r;
                    switch (ch) {
                        case ';':
                            rasa += depth;
                            break;
                        case '{':
                            depth++;
                            break;
                        case '}':
                            depth--;
                            break;
                        case '\n':
                            lines++;
                            break;
                    }
                }
            }
            catch (Exception ex) {

            }


            System.out.print(filename + ": lines " + lines + ", RaSa " + rasa + "\n");
            summaryRasa += rasa;
            totalLines += lines;
        }

        System.out.print("total: lines " + totalLines + ", RaSa " + summaryRasa + "\n");
    }
}