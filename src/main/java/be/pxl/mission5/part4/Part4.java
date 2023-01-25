package be.pxl.mission5.part4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Part4 {

    public static void main(String[] args) {
        try {
            StudentService studentService = new StudentService();
            List<String> lines = Files.readAllLines(Path.of("src/main/resources/priority.txt"));
            for (String line: lines) {
                String[] parts = line.split(" ");
                switch (parts[0]) {
                    case "ENTER" ->
                            studentService.add(new Student(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3])));
                    case "SERVE" -> {
                        Student serve = studentService.serve();
                        System.out.println("Serving " + serve.getName());
                    }
                }
            }
            System.out.println("To be processed: " + studentService.getSize());
            while (!studentService.isEmpty()) {
                System.out.println(studentService.serve().getName());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
