/**
 * here will be a description
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Subset {
    public static void main(String[] args) {
        String line = StdIn.readLine();
        String[] elements = line.split(" ");
        int kNum = Integer.parseInt(args[0]);        
        //if (kNum > elements.length) throw new NullPointerException("k is bigger than n");
        if(kNum > 0) {
            StdRandom.shuffle(elements,0,kNum-1);
            for (int i = 0; i < kNum; i++) {
                System.out.println(elements[i]);
            }
        }
    }
}