public class BSTree<T extends Comparable<T>>{

    private class Node{
	private T data;
	private Node left,right;
	private int height;

	public Node(T value){
	    data=value;
	    height=1;
	}

	public T getData(){return data;}

	public Node getLeft(){return left;}

	public Node getRight(){return right;}

	public void setData(T value){data=value;}

	public void setLeft(Node value){left=value;}

	public void setRight(Node value){right=value;}

	public void add (T value){
	    
	}

	public String toString(){
	    
	}

	public boolean contains(T value){
	    
	}
    }

    private Node root;

    public int getHeight(){
	return root.height();
    }

    public void add(T value){
	root.add(value);
    }

    public boolean contains(T value){
	return root.contains(value);
    }

    public String toString(){
	return root.toString();
    }
}
