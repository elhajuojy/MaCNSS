package ma.yc.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Util {

    public static long generatedLong() {
        long leftLimit = 1L;
        long rightLimit = 100000000L;
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }

    public static void clearScreen() {

        Print.log("\033[H\033[2J");

        System.out.flush();

    }

    public static String readString(String key , Scanner scanner){
        scanner.nextLine();
        Print.log(key+" : ");
        return scanner.nextLine();
    }
    
}

