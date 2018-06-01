package cn.robin.test.guard.navigator.ui;

/**
 * 链表对象
 * 
 * @author robin
 *
 */
public class LinkNode {

	private int data;

	private LinkNode next;

	public LinkNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public LinkNode getNext() {
		return next;
	}

	public void setNext(LinkNode next) {
		this.next = next;
	}

}
