package fi.arcusys.backseatbuddies;


import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        List<String> arguments = Arrays.asList(args);

        Analyzer analyzer = new Analyzer(arguments);
        System.out.print(analyzer.getResult());
    }
}
