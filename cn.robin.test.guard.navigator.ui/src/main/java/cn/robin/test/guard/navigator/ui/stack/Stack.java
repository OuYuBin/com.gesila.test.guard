package cn.robin.test.guard.navigator.ui.stack;

import java.util.Arrays;

/**
 * 
 * @author robin
 *
 */
public class Stack<E> {
	
	private Object[] stacks;
	
	private int size;
	
	public Stack(){
		stacks=new Object[10];
	}
	
	public E peek(){
		if(isEmpty()){
			return null;
		}
		return (E) stacks[size-1];
	}
	
	public E push(E item){
		ensureCapacity(size+1);
		stacks[size++]=item;
		return item;
	}
	
	public E pop(){
		E e=peek();
		stacks[size-1]=null;
		size--;
		return e;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public void ensureCapacity(int size){
		int len=stacks.length;
		if(size>len){
			int newLen=10;
			stacks=Arrays.copyOf(stacks, newLen);
		}
	}
}
