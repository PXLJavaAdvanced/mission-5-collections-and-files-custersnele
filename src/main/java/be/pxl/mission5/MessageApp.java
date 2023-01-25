package be.pxl.mission5;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

import java.nio.file.Path;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class MessageApp {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        Map<String, Integer> colorMap = FileReaders.readColors(Path.of("src/main/resources/color.txt"));
        System.out.println(colorMap);
        Attribute bkgColor = Attribute.BACK_COLOR(colorMap.get("R"), colorMap.get("G"), colorMap.get("B"));
        System.out.println(Ansi.colorize("        ", bkgColor));

        System.out.println("Any TrueColor (RGB), as long as your terminal supports it:");
        for (int i = 0; i <= 300; i++) {
            bkgColor = Attribute.BACK_COLOR(RANDOM.nextInt(255), RANDOM.nextInt(255), RANDOM.nextInt(255));
            System.out.print(Ansi.colorize("   ", bkgColor));
        }
        System.out.println();
        System.out.println();

        bkgColor = Attribute.BACK_COLOR(colorMap.get("R"), colorMap.get("G"), colorMap.get("B"));
        Set<Point> allPoints = FileReaders.readPoints(Path.of("src/main/resources/points.txt"));

        int minX = allPoints.stream().mapToInt(Point::getX).min().orElse(0);
        int maxX = allPoints.stream().mapToInt(Point::getX).max().orElse(0);
        int minY = allPoints.stream().mapToInt(Point::getY).min().orElse(0);
        int maxY = allPoints.stream().mapToInt(Point::getY).max().orElse(0);
        for (int y = minY; y <= maxY ; y++) {
            for (int x = minX; x <= maxX; x++) {
                Point aPoint = new Point(x, y);
                if (allPoints.contains(aPoint)) {
                    System.out.print(Ansi.colorize("   ", bkgColor));
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}
