package be.pxl.mission5;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

import java.util.Random;

public class MessageApp {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        System.out.println("Any TrueColor (RGB), as long as your terminal supports it:");
        for (int i = 0; i <= 300; i++) {
            Attribute bkgColor = Attribute.BACK_COLOR(RANDOM.nextInt(255), RANDOM.nextInt(255), RANDOM.nextInt(255));
            System.out.print(Ansi.colorize("   ", bkgColor));
        }
        System.out.println();
    }
}
