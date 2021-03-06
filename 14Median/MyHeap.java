import java.util.*;

@SuppressWarnings("unchecked")

public class MyHeap<T extends Comparable<T>>{
    private int size;
    private T[] data;
    private boolean maxHeap;
    

    public MyHeap(){
	data = (T[]) new Comparable[10];
    }

    public MyHeap(T[] array){
	size=array.length;
	data = (T[]) new Comparable [size+1];
	for (int i = 0;i<size;i++){
	    data[i+1]=array[i];
	}
	heapify();
    }

    public int getSize(){
	return size;
    }

    private void pushDown(int k){
	if (maxHeap){
	    if (k*2>data.length||k*2+1>data.length){}
	    else if (data[k].compareTo(data[k*2])<0){
		T ans = data[k];
		data[k]=data[k*2];
		data[k*2]=ans;
		pushDown(k*2);
	    }else if (data[k].compareTo(data[k*2+1])<0){
		T ans = data[k];
		data[k]=data[k*2+1];
		data[k*2+1]=ans;
		pushDown(k*2+1);
	    }
	}else{
	    if (k*2>data.length||k*2+1>data.length){}
	    else if (data[k].compareTo(data[k*2])>0){
		T ans = data[k];
		data[k]=data[k*2];
		data[k*2]=ans;
		pushDown(k*2);
	    }else if (data[k].compareTo(data[k*2+1])>0){
		T ans = data[k];
		data[k]=data[k*2+1];
		data[k*2+1]=ans;
		pushDown(k*2+1);
	    }
	}
    }

    private void pushUp(int k){
	if (k/2<1){}
	else{
	    T ans = data[k];
	    data[k]=data[k/2];
	    data[k/2]=ans;
	    if (data[k/2].compareTo(data[k/4])>0){
		pushUp(k/2);
	    }
	}
    }

    private void heapify(){
	for (int i=size/2;i>0;i--){
	    pushDown(i);
	}
    }

    public T delete(){
	if (size==0){
	    throw new NoSuchElementException();
	}
	T removed = data[1];
	for (int i=1;i<size;i++){
	    data[i]=data[i+1];
	}
	data[size]=null;
	size--;
	return removed;
    }

    public T peek(){
	if (size==0){
	    throw new NoSuchElementException();
	}
	return data[1];
    }

    public void add(T x){
	if (size+1==data.length){
	    doubleSize();
	}
	data[size+1]=x;
	size++;
	heapify();
    }

    private void doubleSize(){
	T[]vals = (T[]) new Comparable[size*2];
	for (int i = 1;i<=size;i++){
	    vals[i]=data[i];
	}
	data=vals;
    }

    public String toString(){
	String ans ="[";
	for (int i = 1;i<data.length-1;i++){
	    ans+=data[i]+", ";
	}
	ans+=data[data.length-1]+"]";
	return ans;
    }

    //do this last
    public MyHeap(boolean isMax){
	maxHeap=isMax;
	data = (T[]) new Comparable[10];
    }

    public MyHeap(T[] array, boolean isMax){
	maxHeap=isMax;
        size=array.length;
	data = (T[]) new Comparable [size+1];
	for (int i = 0;i<size;i++){
	    data[i+1]=array[i];
	}
	heapify();
    }
}
