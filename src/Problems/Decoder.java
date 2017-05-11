package Problems;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Created by shobhitagarwal on 6/22/15.
 */
public class Decoder {

    public static void main(String[] args) {
        Scanner scan;

        try {
//        	String filename = args[0];
            scan = new Scanner(new FileInputStream(args[0]));

            while (scan.hasNext()) {
                String line = scan.next();
                for(int i=0; i<line.length();i++){
                    char x = (char) (line.charAt(i) - (7));
                    System.out.print(x);
                }
                System.out.println();
            }
            System.exit(0);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
