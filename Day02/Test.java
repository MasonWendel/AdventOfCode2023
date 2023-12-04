import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        Scanner ins = new Scanner(new File("testinput.dat")).useDelimiter("[^\\w]+");
        Scanner in  = new Scanner(ins.nextLine());
        System.out.println(in.useDelimiter("[^\\w]+").next());
        System.out.println(in.next());
    }
}
