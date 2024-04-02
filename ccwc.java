import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ccwc {
    public static void main(String[] args) {
        // Check if filename is provided
        if (args.length < 1) {
            System.out.println("Usage: java CCWC [-c | -l | -w] filename");
            return;
        }

        String option = "-c"; // Default option
        String filename = args[args.length - 1]; // Last argument is filename

        // Check if option is provided
        if (args.length > 1) {
            option = args[0];
        }

        try {
            int bytesCount = 0;
            int linesCount = 0;
            int wordsCount = 0;

            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = reader.readLine()) != null) {
                linesCount++;

                // Count words
                String[] words = line.split("\\s+");
                wordsCount += words.length;

                // Count bytes
                bytesCount += line.getBytes().length;
            }
            reader.close();

            // Output based on option
            if (option.equals("-c")) {
                System.out.println(bytesCount + " " + filename);
            } else if (option.equals("-l")) {
                System.out.println(linesCount + " " + filename);
            } else if (option.equals("-w")) {
                System.out.println(wordsCount + " " + filename);
            } else {
                System.out.println(linesCount + " " + wordsCount + " " + bytesCount + " " + filename);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
