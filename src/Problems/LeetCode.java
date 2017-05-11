package Problems;

public class LeetCode {

    public int canWinNim(int n) {

        int sum = 10;
        while (sum >= 10) {
            sum += n;
            n = n / 10;
        }

        return sum;
    }

    public static void main(String[] args) {

        // LeetCode lc = new LeetCode();
        //
        // int sumTest = lc.canWinNim(136);
        // // while(sumTest >= 10){
        // // sumTest = lc.canWinNim(sumTest);
        // // }
        //
        // System.out.println(sumTest);

//        String line = "0ZtOuzEA3k8XjSaf6MgR-w  [\"VNcAmYH4P7csDQafLoJhYQ\",\"rpOyqD_893cqmDAtJLbdog\",\"4U9kSBLuBDU391x6bxU-YA\",\"fHtTaujcyKvXglE33Z5yIw\"]";
        String line = "Xqd0DzHaiyRqVH3WRG7hzg   5   vcNAWiLM4dR7D2nwwJ7nCA  Xqd0DzHaiyRqVH3WRG7hzg  Lily";
        String[] temp = line.split("\\s+");

//        String friendList = temp[1];
//        StringTokenizer st = new StringTokenizer(temp, ",\"");

//        while (st.hasMoreTokens()) {
//            String temp3 = st.nextToken();
//            if (!temp3.equals("[") && !temp3.equals("]")) {
//                System.out.println(temp3);
//            }
//        }
        
        for(String s : temp){
            System.out.println(s);
        }
        
        
        // System.out.println(Arrays.toString(x.split("\\s+")));
    }
}
