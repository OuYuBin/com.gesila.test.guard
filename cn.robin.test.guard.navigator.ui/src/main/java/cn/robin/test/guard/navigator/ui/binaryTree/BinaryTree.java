package cn.robin.test.guard.navigator.ui.binaryTree;

/**
 * 
 * @author robin
 *
 */
public class BinaryTree {

	private TreeNode root=null;
	
	public BinaryTree(){
	}
	
	public void insert(int data){
		TreeNode treeNode=new TreeNode(data);
		if(root==null){
			root=treeNode;
		}else{
			TreeNode current=root;
			TreeNode parent;
			while(true){
				parent=current;
				if(data<current.data){
					current=current.left;
					if(current==null){
						parent.left=treeNode;
						return;
					}
				}else{
					current=current.right;
					if(current==null){
						parent.right=treeNode;
						return;
					}
				}
			}
		}
	}
	
	public void buildTree(int[] datas){
		for(int data:datas){
			insert(data);
		}
	}
	
	public static void main(String[] args) {
		BinaryTree binaryTree=new BinaryTree();
		int[] datas={2,8,7,4,9,3,1,6,7,5};
		binaryTree.buildTree(datas);
		System.out.println(binaryTree);
	}
}
