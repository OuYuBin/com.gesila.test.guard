package cn.robin.test.guard.navigator.ui.reverse;

public class EightQueen {

	public static final int QUEEN_NUMBER=4;
	
	private int[][] grids=new int[QUEEN_NUMBER][QUEEN_NUMBER];
	/**
	 * 构建4×4的二维组
	 * 
	 *    0 1 2 3
	 * ----------  
	 * 0| 0 0 0 0
	 * 1| 0 0 0 0
	 * 2| 0 0 0 0
	 */
	public void init(){
		for(int i=0;i<QUEEN_NUMBER;i++){
			for(int j=0;j<QUEEN_NUMBER;j++){
				this.grids[i][j]=0;
				}
		}
	}
	
	public int[][] getGrids() {
		return grids;
	}

	/**
	 * 已“行”为扫描目标
	 */
	public void queenMaker(int row,int[][] grids){
		//--守护结束递归结束标志位
		if(row==QUEEN_NUMBER){
			for(int i=0;i<QUEEN_NUMBER;i++)
	          {    
	              for(int j=0;j<QUEEN_NUMBER;j++)
	              {
	                  System.out.print(grids[i][j]+" ");
	              }
	              System.out.println("\n");
	          }
			System.out.println("******************************");
		}
		//--已"列"为循环
		for(int col=0;row<QUEEN_NUMBER&&col<QUEEN_NUMBER;col++){
			//--判断8个方向的数据是否符合要求
			if(isCorrect(row,col,grids)){
				System.out.println(row+"."+col);
			grids[row][col]=1;
			queenMaker(row+1,grids);
			grids[row][col]=0;
			}
			
		}
		
	}

	private boolean isCorrect(int row, int col, int[][] grids) {
		int r,c;
		//--判断行
		for(r=row,c=0;c<QUEEN_NUMBER;c++){
			if(grids[r][c]==1){
				return false;
			}
		}
		//--判断列
		for(r=0,c=col;r<QUEEN_NUMBER;r++){
			if(grids[r][c]==1){
				return false;
			}
		}
		//--判断左上
		for(r=row-1,c=col-1;r>=0&&c>=0;r--,c--){
			if(grids[r][c]==1){
				return false;
			}
		}
		//--判断右上
		for(r=row-1,c=col+1;r>=0&&c<QUEEN_NUMBER;r--,c++){
			if(grids[r][c]==1){
				return false;
			}
		}
		//--判断左下
		for(r=row+1,c=col-1;r<QUEEN_NUMBER&&c>=0;r++,c--){
			if(grids[r][c]==1){
				return false;
			}
		}
		
		//--判断右下
		for(r=row+1,c=col+1;r<QUEEN_NUMBER&&c<QUEEN_NUMBER;r++,c++){
			if(grids[r][c]==1){
				return false;
			}
		}
			
		return true;
	}
	
	public static void main(String[] args) {
		EightQueen eightQueen=new EightQueen();
		eightQueen.init();
		eightQueen.queenMaker(0, eightQueen.getGrids());
	}
}
