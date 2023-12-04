import java.util.*;
import java.io.*;

public class Main {
    public static Scanner in; 
    public static void main(String[] args) throws IOException{
        in = new Scanner(new File("input.dat"));
        System.out.println(part2());
    }

    public static String part1(){
        ArrayList<ArrayList<int[]>> nums  = new ArrayList<ArrayList<int[]>>(); // ArrayList for holding the coords of nums
        char[][] schematic = new char[140][140];
        int sum = 0; 
        for(int r  = 0; r<schematic.length; r++){
            char[] line = in.nextLine().toCharArray();
            String num = "";
            for(int c = 0; c<line.length;c++){
                char car = line[c];
                if(Character.isDigit(car)){
                    num+=car;
                } else {
                    if(!num.equals("")){
                        ArrayList<int[]> coords = new ArrayList<int[]>();
                        for(int i = num.length(); i>0;i--){
                            int[] coord = new int[2]; 
                            coord[0] = r;
                            coord[1] = c- i;
                            coords.add(coord);
                        }
                        nums.add(coords);
                        num = "";
                    }
                }
            }
            schematic[r] = line;
        }
        int[][] moves = {{0,1},{0,-1},{1,1},{1,-1},{1,0},{-1,0},{-1,1},{-1,-1}};
        for (ArrayList<int[]> coords : nums) {
            boolean isPart = false;
            String num = "";
            for(int[] coord : coords){
                num+=schematic[coord[0]][coord[1]];
                for (int[] move : moves) {
                    int r = coord[0] + move[0];
                    int c = coord[1] + move[1];
                    if(r>0&&r<schematic.length&&c>0&&c<schematic.length){
                        char car = schematic[r][c];
                        if(car!='.'&&!Character.isDigit(car)){
                            isPart = true;
                        }
                    }
                }
            }
            System.out.println(num+": "+isPart);
            if(isPart){
                sum+=Integer.parseInt(num);
            }
        }
        return sum+"";
    }

    public static String part2(){
        ArrayList<ArrayList<int[]>> nums  = new ArrayList<ArrayList<int[]>>(); // ArrayList for holding the coords of nums
        char[][] schematic = new char[140][140];
        int sum = 0; 
        for(int r  = 0; r<schematic.length; r++){
            char[] line = in.nextLine().toCharArray();
            String num = "";
            for(int c = 0; c<line.length;c++){
                char car = line[c];
                if(Character.isDigit(car)){
                    num+=car;
                } else {
                    if(!num.equals("")){
                        ArrayList<int[]> coords = new ArrayList<int[]>();
                        for(int i = num.length(); i>0;i--){
                            int[] coord = new int[2]; 
                            coord[0] = r;
                            coord[1] = c- i;
                            coords.add(coord);
                        }
                        nums.add(coords);
                        num = "";
                    }
                }
            }
            schematic[r] = line;
        }
        int[][] moves = {{0,1},{0,-1},{1,1},{1,-1},{1,0},{-1,0},{-1,1},{-1,-1}};
        HashMap<String,ArrayList<Integer>> gears  = new HashMap<String,ArrayList<Integer>>();
        for (ArrayList<int[]> coords : nums) {
            String isAdjacentGear = "";
            String num = "";
            for(int[] coord : coords){
                num+=schematic[coord[0]][coord[1]];
                for (int[] move : moves) {
                    int r = coord[0] + move[0];
                    int c = coord[1] + move[1];
                    if(r>0&&r<schematic.length&&c>0&&c<schematic.length){
                        char car = schematic[r][c];
                        if(car!='.'&&!Character.isDigit(car)){
                            if(car=='*'){
                                isAdjacentGear = r+","+c;
                            }
                        }
                    }
                }
            }
            if(!isAdjacentGear.equals("")){
                if(!gears.containsKey(isAdjacentGear)){
                    gears.put(isAdjacentGear, new ArrayList<Integer>());
                }
                gears.get(isAdjacentGear).add(Integer.parseInt(num));
                 
            }
            
        }
        for(String key : gears.keySet()){
            ArrayList<Integer> arr = gears.get(key);
            if(arr.size()>=2){
                int ratio = arr.get(0)*arr.get(1);
                sum+=ratio;
            }
        }
        return sum+"";
    }
}
