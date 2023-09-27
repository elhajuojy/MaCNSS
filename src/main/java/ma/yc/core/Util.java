package ma.yc.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static long generatedLong() {
        long leftLimit = 1L;
        long rightLimit = 100000000L;
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }

    public static boolean verifyEmail(String input){
        String rgx = "^[a-zA-Z0-9]+@[a-z]+\\.[a-z]+$";
        Pattern pattern = Pattern.compile(rgx);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void clearScreen() {
        Print.log("\033[H\033[2J");
        System.out.flush();

    }

    public static String readString(String key , Scanner scanner){
        //todo : fix this bug
        scanner.nextLine();
        Print.log(key+" : ");
        return scanner.nextLine();
    }

    public static String readString(String key , Scanner scanner, String defaultValue){
        //todo : fix this bug
        scanner.nextLine();
        Print.log(key+" : ");
        String input = scanner.nextLine();
        if (input.isEmpty()){
            return defaultValue;
        }
        return input;
    }

    public  static  int readInt(String key , Scanner scanner){
        Print.log(key+" : ");
        return scanner.nextInt();
    }
    public static  int readInt(String key , Scanner scanner, int defaultValue){
        Print.log(key+" : ");
        int input = scanner.nextInt();
        if (input == 0){
            return defaultValue;
        }
        return input;
    }

    //add more helper method
    //todo : work with local storage to store information
    public boolean storeInformation(String key , String value){
        //todo : store the information in the local storage
        return false;
    }
}

