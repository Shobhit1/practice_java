package Problems;



public class Tree2 {
	public static Node buildTree(Integer[] item , int left, int right){
		if (left>right){
			return null;
		}
		
		if(left == right){
			return new Node(item[left]);
		}
		
//		int middle = (left + (right - left))/2;
		int middle = (left+right)/2;
		
		Node root = new Node(item[middle]);
		
		root.setLeft(buildTree(item, left, middle-1));
		
		root.setRight(buildTree(item,middle+1,right));
		
		return root;
	}



	public static void main(String[] args){

		Integer[] arra = {1,2,3,4,5,6,7,8,9,10};
//		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(arra));

		Node treeTest1 = new Node();
		treeTest1 = buildTree(arra, 0, arra.length-1);

//		new Node().toString(treeTest1);
		
		System.out.println(treeTest1.toString(treeTest1));

	}
}

class Node{
	private int data;
	private Node left;
	private Node right;

	public Node(){
		super();
	}

	public Node(int data) {
		//		this.left = null;
		//		this.right = null;
		this.data = data;
	}

	//	public Node(T data, Node<T> left, Node<T> right){
	//		this.data = data;
	//		this.left = left;
	//		this.right = right;
	//	}


	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}

	public String toString(Node root)
	{
	    StringBuilder builder = new StringBuilder();
	    if (root == null)
	        return "";
	    builder.append(toString(root.left));
//	    builder.append("L");
	    builder.append(toString(root.right));
//	    builder.append("R");
	    return builder.append(root.data).toString();
	}

}
