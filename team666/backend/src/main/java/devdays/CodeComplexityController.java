package devdays;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;

@RestController
public class CodeComplexityController {

    @RequestMapping("/")
    public String process() {
        return "API welcome";
    }

    /**
     * @param files
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String process(
            @RequestParam(value = "file", required = true) MultipartFile[] files) throws IOException {
        System.out.println("going into processing");
        System.out.printf("amount of files: " + files.length);

        StringBuilder str = new StringBuilder();

        Arrays.asList(files).forEach(file -> {
            try {
                str.append(analyzeComplexity(new String(file.getBytes(), "UTF-8")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        System.out.println(str.toString());

        return str.toString();

    }

    String analyzeComplexity(String source) {
        int index = 0;
        int level = 1;
        int count = 0;
        int rasaScore = 0;
        String result;
        while (index < source.length()) {
            if (source.charAt(index) == '{') {
                level++;
            } else if (source.charAt(index) == '}') {
                level--;
            } else if (source.charAt(index) == ';') {
                count++;
                if (level > 3)
                    rasaScore = rasaScore + 3;
                else rasaScore = rasaScore + level;
            }

            index++;
        }

        result = "java: lines " + count + ", RaSa " + rasaScore;

        return result;
    }
}
