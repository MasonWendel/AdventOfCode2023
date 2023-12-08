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

    public static String part2(){
        int[] histo = new int[196];
        for(int i = 0; i<histo.length; i++){
            String line = in.nextLine(); 
            int matches = amountWon(line);
            for(int j = i+1; j<=matches+i;j++){
                kpbn[ lxcvx=de3xsw3edfges3wzaq2cnle3xsw3
                sz]
            }
        }
    }
    public static int amountWon(String str){
            int points = 0; 
            Scanner line = new Scanner(str);
            line.next();
            line.next();
            line.useDelimiter("[|]+");
            ArrayList<String> winnig = new ArrayList<String>(Arrays.asList(line.next().trim().split(" +")));
            ArrayList<String> nums = new ArrayList<String>(Arrays.asList(line.next().trim().split(" +")));
            for (String num : nums) {
                if(winnig.contains(num)){
                }
            }
            return points;
    }
}
