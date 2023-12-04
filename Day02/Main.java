import java.util.*;
import java.io.*;

public class Main {

    public static Scanner in;
    public static void main(String[] args) throws IOException {
        in = new Scanner(new File("input.dat"));
        System.out.println(part2());
    }

    public static String part2(){
        int sum = 0; 
        HashMap<String,Integer> mustBeThere  = new HashMap<String,Integer>();
        mustBeThere.put("blue",0);
        mustBeThere.put("green",0);
        mustBeThere.put("red",0);
        while(in.hasNext()){
            // Creating scanner for each line 
            Scanner line =  new Scanner(in.nextLine()).useDelimiter("[^\\w]+");
            line.next();   
            line.next();
            while(line.hasNext()){
                int cubes = line.nextInt(); 
                String color = line.next();
                mustBeThere.put(color,Math.max(cubes,mustBeThere.get(color)));
            }

            int power = mustBeThere.get("red")*mustBeThere.get("green")*mustBeThere.get("blue");

            mustBeThere.put("blue",0);
            mustBeThere.put("green",0);
            mustBeThere.put("red",0);

            sum += power;
        }

        return sum+"";
    }

    public static String part1(){
        
        int sum = 0; 
        HashMap<String,Integer> bench  = new HashMap<String,Integer>();
        bench.put("blue", 14);
        bench.put("green",13);
        bench.put("red", 12);
        while(in.hasNext()){
            boolean isPossible = true; 
            // Creating scanner for each line 
            Scanner line =  new Scanner(in.nextLine()).useDelimiter("[^\\w]+");
            line.next();
            int gameNum  = line.nextInt();
            
            while(line.hasNext()){
                int cubes = line.nextInt(); 
                String color = line.next();
                if(cubes>bench.get(color)){
                    isPossible = false; 
                }
            }

            if(isPossible){
                sum+=gameNum; 
            }

        }

        return sum+"";
        
    }
}