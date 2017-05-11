package Problems;

import java.io.File;
import java.util.Scanner;
/**
 * Created by shobhitagarwal on 6/22/15.
 */
public class UVAPracticeStart {

    public static void main(String[] args) {
        Scanner scan;

        try{
        	String filename = args[0];
        	File file = new File(filename);
            scan = new Scanner(file);

            while(scan.hasNext()){
                int a = scan.nextInt();
                int b = scan.nextInt();
                System.out.println(b-a);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
