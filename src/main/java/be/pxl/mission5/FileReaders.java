package be.pxl.mission5;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FileReaders {

    public static Map<String, Integer> readColors(Path path) {
        //Map<String, Integer> colorMap = new HashMap<>(Map.of("R", 0, "G", 0, "B", 0));
        Map<String, Integer> colorMap = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                //colorMap.put(parts[0], colorMap.get(parts[0]) + Integer.parseInt(parts[1]));
                int colorValue = Integer.parseInt(parts[1]);
                colorMap.compute(parts[0], (k, v) -> v == null ? colorValue : v + colorValue);
            }
            //{B=174, R=190, G=19}
        } catch (IOException e) {
            System.err.println("An error occured while reading the file. " + e.getMessage());
        }
        return colorMap;
    }

    public static Set<Point> readPoints(Path path) {
        Set<Point> allPoints = new HashSet<>(120);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.replace("(", "").replace(")", "").split(",");
                allPoints.add(new Point(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
            }
        } catch (IOException e) {
            System.err.println("An error occured while reading the file. " + e.getMessage());
        }
        return allPoints;
    }
}
