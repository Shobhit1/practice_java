package Problems;

public class spaceTrim {
	public String trimmer(String s){
		String[] tokens = s.split(" ");
		s = "";
		for (String items:tokens){
			if (items != " "){
				s = s.trim();
				s = s + " " + items;
			}
		}
		
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new spaceTrim().trimmer("      Hello    World         "));

	}

}
