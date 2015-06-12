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
     * curl -i -F file=@filu1.txt -F file=@filu2.txt http://localhost:8080/process
     *
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
                str.append(new String(file.getBytes(), "UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        System.out.println(str.toString());

        return str.toString();

    }
}
