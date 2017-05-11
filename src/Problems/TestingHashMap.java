package Problems;

import java.util.Scanner;

public class TestingHashMap {
    public static void main(String[] args) {
//        HashMap<String,String> testMap = new HashMap<String, String>();
//        
//        testMap.put("1", "test");
//        
//        System.out.println("1" + testMap);
//        change(testMap);
//        
//        System.out.println("TestMap"+testMap);
        
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        
        int[] arrayTest = new int[length];
        
        
        for(int l=0; l<length;l++){
            arrayTest[l] = scan.nextInt();
        }

        int i=0;
        while(i != length/2){
            swap(arrayTest, i, length-1-i);
            i++;
        }
//        
//        System.out.println(Arrays.toString(arrayTest));
        StringBuilder sb = new StringBuilder();
        for(int _each : arrayTest){
//            System.out.print(_each);
            sb.append(_each);
            sb.append(" ");
        }
        
        System.out.println(sb.toString());
    }
    
    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
//    public static void change(HashMap<String, String> mapInFunction){
//        System.out.println(mapInFunction);
//        mapInFunction.put("2", "Tets");
//        System.out.println(mapInFunction);
//        mapInFunction = null;
//        
//        System.out.println(mapInFunction);
//    }
    
}
