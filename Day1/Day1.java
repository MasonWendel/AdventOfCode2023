import java.util.*;
import java.io.*;

public class Day1 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("testinput.dat"));

        int biggest = 0; 

        int sum = 0; 

        int prev = 0 ;

        String[][] strs = {{"one","1"},{"two","2"},{"three","3"},{"four","4"},{"five","5"},{"six","6"},{"seven","7"},{"eight","8"},{"nine","9"}};
        

        while(in.hasNext()){
            String line  = in.nextLine();

            for (String[] strings : strs) {
                if(line.contains(strings[0])){
                    line = line.substring(0, line.indexOf(strings[0]))+strings[1]+line.substring(line.indexOf(strings[0])+1);
                }
            }

            
            line = line.replaceAll("[^\\d.]", "");
            char front = line.charAt(0);
            char back = line.charAt(line.length()-1);
            String num = front + "" + back;
            sum += Integer.parseInt(num);
        }
        System.out.println(sum);
    }
}