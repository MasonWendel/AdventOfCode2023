import java.util.*;
import java.io.*;
public class Main {
    public static Scanner in; 
    public static void main(String[] args) throws IOException {
        in = new Scanner(new File("input.dat"));
        System.out.println(part1());
    }

    public static String part1(){
        int sum = 0;
        while(in.hasNext()){
            double points = 0.5;
            Scanner line = new Scanner(in.nextLine());
            line.next();
            line.next();
            line.useDelimiter("[|]+");
            ArrayList<String> winnig = new ArrayList<String>(Arrays.asList(line.next().trim().split(" +")));
            ArrayList<String> nums = new ArrayList<String>(Arrays.asList(line.next().trim().split(" +")));
            for (String str : nums) {
                if(winnig.contains(str)){
                    points*=2;
                    System.out.println(str);
                }
            }
            sum+=(int)points;

        }
        return sum+"";
    }
}
