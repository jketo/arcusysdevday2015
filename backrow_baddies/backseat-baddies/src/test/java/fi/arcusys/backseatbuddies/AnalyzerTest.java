package fi.arcusys.backseatbuddies;


import fi.arcusys.backseatbuddies.Analyzer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for simple App.
 */
public class AnalyzerTest {

    public static String TEST_0 = "";
    public static String TEST_1 = "void test()\n{ ; }\n";
    public static String TEST_2 = "void test()\n{\nSystem.out.println(\"Hi\");\n}\n";
    public static String TEST_3 = "void test()\n" +
            "{ int a = 0;        \n" +
            "  int b = 1;\n" +
            "  if (a > b) {\n" +
            "System.out.println(a);\n" +
            "  } else {\n" +
            "System.out.println(a);\n" +
            "  }\n" +
            "  System.out.println(\"Bye\");\n" +
            "}\n";


    @Test
    public void analyzeNull() {
        final String result = new Analyzer(null).getResult();
        assertNotNull(result);
        assertEquals("", result);
    }

//    @Test
//    public void analyzeCheck1() {
//        final String test = "Skipping file (not a file or doesn't exist test_12_counttotal: lines 0, RaSa 0";
//        final String result = new Analyzer(Arrays.asList("test_12_count")).getResult();
//        assertNotNull(result);
//        assertEquals(test, result);
//    }

//    @Test
//    public void testOutput() {
//        List<String> files = new ArrayList<String>();
//        files.add("test_2_count");
//        files.add("test_2_countb");
//        files.add("test_12_count");
//        new Analyzer(files);
//    }

}
