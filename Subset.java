
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
public class Subset {
   public static void main(String[] args) {
       
       int numK = Integer.parseInt(args[0]);
       String[] splited = StdIn.readLine().split("\\s+");
       StdRandom.shuffle(splited);
       for (int i = 0; i < numK; i++) {

       System.out.println(splited[i]);
       
       }    
   
   
   }
}