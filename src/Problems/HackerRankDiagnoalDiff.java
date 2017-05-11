package Problems;

import java.util.Scanner;

public class HackerRankDiagnoalDiff {

    public static void main(String[] args) {

        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT.
         * Your class should be named Solution.
         */
        Scanner in = new Scanner(System.in);

        int counter;
        int sum1 = 0;
        int sumN = 0;
        counter = in.nextInt();
        
        int[][] input = new int[counter][counter];
        for (int j = 0; j < counter; j++) {
            for(int k=0 ; k <counter ; k++){
                input[j][k] = in.nextInt();
            }
        }
        int lengthArr = input.length;
        for(int i=0; i< lengthArr; i++){
            for(int j=0; j < lengthArr; j++){
                if(i==j){
                    sum1 += input[i][j];
                }
                
                
            }
            
        }
        System.out.println(sum1);
    }
}
