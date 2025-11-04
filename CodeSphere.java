import java.io.*;
import java.util.*;


public class CodeSphere {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to CodeSphere");

        while (true) {
            ArrayList<String> lineOfCode = new ArrayList<String>();


            System.out.println("Enter your java code line by line below.");
            System.out.println("Type END on a new line to stop writing the code.\n");

            int linecount = 1;

            try {
                String line;

                while (true) {
                    System.out.print("Line " + linecount + ">> ");
                    line = reader.readLine();

                    if (line == null || line.equals("END")) {
                        break;
                    }
                    lineOfCode.add(line);
                    linecount++;
                }

                String filename = "Main.java";
                try (FileWriter writer = new FileWriter(filename)) {
                    for (String codeLine : lineOfCode) {
                        writer.write(codeLine + "\n");
                    }
                }

                System.out.println("Code saved successfully to " + filename);

                new File("Main.class").delete();

                if (compile(filename)) {
                    run("Main");
                } else {
                    System.out.println("Compilation failed");
                }

                System.out.println("Do you want to try again? (TRY/EXIT): ");
                String input = reader.readLine();

                if (!input.equals("TRY")) {
                    System.out.println("Exiting CodeSphere....");
                    break;
                }

            } catch (IOException e) {
                System.out.println("An error while writing or saving");
            }
        }
    }
    public static boolean compile(String filename) {
        try {
            System.out.println("Compiling....");
            Process compile = Runtime.getRuntime().exec("javac " + filename);

            BufferedReader compileError = new BufferedReader(new InputStreamReader(compile.getErrorStream()));

            String errorLine;
            boolean hasError = false;

            while ((errorLine = compileError.readLine()) != null) {
                System.out.println(errorLine);
                hasError = true;
            }

            if (hasError) {
                System.out.println("Compilation failed");
                return false;
            }

            System.out.println("Compilation successful!");
            return true;

        } catch (IOException e) {
            System.out.println("Error during compilation or execution");
            return false;
        }
    }

    public static void run(String filename) {
        try {

            System.out.println("Running your program...");
            Process run = Runtime.getRuntime().exec("java Main");

            BufferedReader outputReader = new BufferedReader(new InputStreamReader(run.getInputStream()));
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(run.getErrorStream()));

            String line;
            while ((line = outputReader.readLine()) != null) {
                System.out.println(line);
            }

            while ((line = errorReader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("Program finished successfully");

        } catch (IOException e) {
            System.out.println("Error during execution");
        }
    }
}
