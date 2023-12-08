import java.util.*;

import javax.crypto.AEADBadTagException;

import java.io.*;
public class Main {
    public static Scanner in;
    public static void main(String[] args) throws IOException {
        in = new Scanner(new File("input.dat"));
        part2();
    }

    public static void part1(){
        String LR = in.nextLine();
        in.nextLine();

        TreeMap<String, String[]> map = new TreeMap<String, String[]>();
        while(in.hasNextLine()){
            String[] t = in.nextLine().split("\\W+");
            
            map.put(t[0],new String[]{t[1],t[2]});
        }

        String current = "AAA";
        
        int steps = 0; 
        while(!current.equals("ZZZ")){
            int dirStep = steps%LR.length();

            String dir  = LR.substring(dirStep, dirStep+1);

            String[] values = map.get(current);

            current  = dir.equals("L") ? values[0] : values[1];

            steps++;
        }
        System.out.println(steps);
    }

    public static void part2(){
        String LR = in.nextLine();
        in.nextLine();

        TreeMap<String, String[]> map = new TreeMap<String, String[]>();
        while(in.hasNextLine()){
            String[] t = in.nextLine().split("\\W+");
            
            map.put(t[0],new String[]{t[1],t[2]});
        }

        
        int steps = 0; 
        boolean done = false;
        ArrayList<String> curr = new ArrayList<String>();
        ArrayList<String> results = new ArrayList<String>();

        for(String k : map.keySet()){
            if(k.endsWith("A")){
                curr.add(k);
            }
        }


        while(!done){
            int dirStep = steps%LR.length();

            String dir  = LR.substring(dirStep, dirStep+1);

            for(String str : curr){
                if(dir.equals("L")){
                    results.add(map.get(str)[0]);
                    
                } else {
                    results.add(map.get(str)[1]);
                }
                
            }

            done = true;
            for(String str : results){
                done = done&&str.endsWith("Z");
            }

            curr = results;
            results = new ArrayList<String>();
            steps++;
        }
        System.out.println(steps);
    }
}
