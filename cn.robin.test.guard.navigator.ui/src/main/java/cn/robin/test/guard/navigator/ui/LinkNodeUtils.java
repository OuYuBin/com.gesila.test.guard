package cn.robin.test.guard.navigator.ui;

public class LinkNodeUtils {

	public static int listLength(LinkNode linkNode) {
		int length = 0;
		LinkNode currentNode = linkNode;
		while (currentNode != null) {
			length++;
			currentNode = currentNode.getNext();
		}

		return length;
	}
	
	/**
	 * 单链表插入
	 * @param linkNode
	 * @return
	 */
	public static LinkNode insertNode(LinkNode linkNode,LinkNode newInsertNode,int position){
		LinkNode previousNode=linkNode;
		int count=1;
		while(count<position-1){
			previousNode=previousNode.getNext();
			count++;
		}
		LinkNode currentNode=previousNode.getNext();
		newInsertNode.setNext(currentNode);
		previousNode.setNext(newInsertNode);
		return linkNode;
	}
	
	public static LinkNode delNode(LinkNode linkNode,int position){
		LinkNode previousNode=linkNode;
		int count=1;
		while(count<position){
			previousNode=previousNode.getNext();
			count++;
		}
		LinkNode currentLinkNode=previousNode.getNext();
		previousNode.setNext(currentLinkNode.getNext());
		currentLinkNode=null;
		return linkNode;
	}
	
	

	public static void main(String[] args) {
		int[] datas = { 5, 17, 1, 40 };
		LinkNode linkNode = null;
		LinkNode current = null, nextLinkNode = null;
		for (int data : datas) {
			if (current == null) {
				linkNode = new LinkNode(data);
				current=linkNode;
			} else {
				nextLinkNode = new LinkNode(data);
				current.setNext(nextLinkNode);
				current = nextLinkNode;
			}
		}
		insertNode(linkNode,new LinkNode(22),3);
		System.out.println(linkNode);
	}
}
