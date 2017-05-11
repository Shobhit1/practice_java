package Problems;

import java.util.Arrays;

public class EmployeeSort{

	public static void main(String[] args) {
		Employee[] es = new Employee[5];
		es[0] = new Employee(5,"Joe");
		es[1] = new Employee(3,"Susan");
		es[2] = new Employee(10,"David");
		es[3] = new Employee(43,"Chris");
		es[4] = new Employee(68,"Jane");
		
		Arrays.sort(es);
		
		for(int i=0;i<es.length;i++){
			System.out.println("Name: " + es[i].getName() + " Number " + es[i].getNumber());
		}
		
		System.out.println();
		
//		Map<String, Integer> emp = new HashMap<>();
//		for(int i=0;i<es.length;i++){
//			emp.put(es[i].getName(), es[i].getNumber());
//		}
//		
//		List<String> keys = new ArrayList<String>(emp.keySet());
//		Collections.sort(keys);
//		
//		for(String key : keys){
//			System.out.println("Name: " + key + " Number " + emp.get(key));
//		}
//		
		
		
	}

}
class Employee implements Comparable<Employee>{

//class Employee{
	
	private String name;
	private Integer number;

	public Employee(Integer number, String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

//	@Override
//	public int compareTo(Employee o) {
//		// TODO Auto-generated method stub
//		return this.name.toUpperCase().compareTo(o.name.toUpperCase());
//	}
//	
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.getNumber().compareTo(o.getNumber());
	}


}
