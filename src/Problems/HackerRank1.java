package Problems;

import java.util.Scanner;

public class HackerRank1 {
    
    static void first(){
        Scanner scan = new Scanner(System.in);
        int searchNum = scan.nextInt();
        
        int lengthOfArray = scan.nextInt();
        
        
        for(int i=0; i<lengthOfArray; i++){
            if(Integer.parseInt(scan.next()) == searchNum){
                scan.close();
                
                System.out.println(i);
                break;
            }
        }
        
        scan.close();
//        System.out.println("-1");
        
    }

    public static void main(String[] args) {
        first();
    }
}
