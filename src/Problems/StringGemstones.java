package Problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class StringGemstones {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numberOfWords = scan.nextInt();

        HashMap<Character, HashSet<String>> map = new HashMap<Character, HashSet<String>>();
        for (int i = 0; i < numberOfWords; i++) {
            String s = scan.next();
            for (int j = 0; j < s.length(); j++) {
                Character c = Character.toLowerCase(s.charAt(j));
                if (map.containsKey(c)) {
                    map.get(c).add(s);
                } else {
                    HashSet<String> temp = new HashSet<String>();
                    temp.add(s);
                    map.put(c, temp);
                }
            }
        }
        int count = 0;
        
        for(Character gem : map.keySet()){
            if(map.get(gem).size() == numberOfWords){
                count++;
            }
        }
        
        System.out.println(count);
        
        scan.close();
    }
}
