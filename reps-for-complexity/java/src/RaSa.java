import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RaSa {

    public static void main (String[] args) throws IOException {
        System.out.println(args.length);
        for (int i = 0; i < args.length; i++) {


            int[] calcResult = calculate(args[i], args.length, i);
            System.out.println(args[i] + ": lines " + calcResult[0] + ", RaSa " + calcResult[1]);
        }

    }

    private static int[] calculate(String fileName, int files, int argIndex) throws IOException {

        int[] result = new int[2];
        int lines = 0;
        int blocks = 0;
        int rasa = 0;
        int multiplier = 1;
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(fileName));

            String line;
            char statementEndChar = ';';
            char curlyLeft = '{';
            char cutlyRight = '}';
            do {



                line = reader.readLine();

                if (line != null) {
                    lines++;




                    for (int i = 0; i < line.length(); i++) {
                        char c = line.charAt(i);

                        if (c == curlyLeft)
                            multiplier++;
                        if (c == cutlyRight)
                            multiplier--;
                        if (c == statementEndChar) {

                            rasa += multiplier * 1;
                        }


                    }
                }




            } while (line != null);

            String file = reader.toString();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        result[0] = lines;
        result[1] = rasa;
        return result;

    }

}
