package cn.robin.test.guard.navigator.ui.binaryTree;

/**
 * 
 * @author robin
 *
 */
public class BinaryTree {

	private TreeNode root = null;

	public BinaryTree() {
	}

	public void insert(int data) {
		TreeNode treeNode = new TreeNode(data);
		if (root == null) {
			root = treeNode;
		} else {
			TreeNode current = root;
			TreeNode parent;
			while (true) {
				parent = current;
				if (data < current.data) {
					current = current.left;
					if (current == null) {
						parent.left = treeNode;
						return;
					}
				} else {
					current = current.right;
					if (current == null) {
						parent.right = treeNode;
						return;
					}
				}
			}
		}
	}

	public void buildTree(int[] datas) {
		for (int data : datas) {
			insert(data);
		}
	}

	/**
	 * 前序遍历(先根遍历)
	 * 
	 * @param root
	 */
	public void preOrder(TreeNode root) {
		if (root != null) {
			System.out.print(root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void preOrder() {
		preOrder(this.root);
	}
	
	public void postOrder(TreeNode root){
		if(root!=null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+" ");
		}
	}

	public void postOrder(){
		postOrder(this.root);
	}
	
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		int[] datas = { 2, 8, 7, 4, 9, 3, 1, 6, 7, 5 };
		binaryTree.buildTree(datas);
		System.out.println(binaryTree);
		binaryTree.preOrder();
		System.out.println();
		binaryTree.postOrder();
	}
}
