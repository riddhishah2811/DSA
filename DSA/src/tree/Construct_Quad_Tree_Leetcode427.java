package tree;
//Definition for a QuadTree node.
class Node {
 public boolean val;
 public boolean isLeaf;
 public Node topLeft;
 public Node topRight;
 public Node bottomLeft;
 public Node bottomRight;

 
 public Node() {
     this.val = false;
     this.isLeaf = false;
     this.topLeft = null;
     this.topRight = null;
     this.bottomLeft = null;
     this.bottomRight = null;
 }
 
 public Node(boolean val, boolean isLeaf) {
     this.val = val;
     this.isLeaf = isLeaf;
     this.topLeft = null;
     this.topRight = null;
     this.bottomLeft = null;
     this.bottomRight = null;
 }
 
 public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
     this.val = val;
     this.isLeaf = isLeaf;
     this.topLeft = topLeft;
     this.topRight = topRight;
     this.bottomLeft = bottomLeft;
     this.bottomRight = bottomRight;
 }
};
public class Construct_Quad_Tree_Leetcode427 {
	public static boolean sameValue(int[][] grid,int x1,int y1,int len)
    {
        for(int i=x1;i<x1 + len;i++)
        {
            for(int j=y1;j<y1 + len;j++)
            {
                if(grid[i][j]!=grid[x1][y1])
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static Node util(int[][] grid,int x1,int y1,int len)
    {
    	// if(sameValue(grid,x1,y1,len))
        // {
        //     return new Node(grid[x1][y1] == 1, true, null, null, null, null);
        // }

        // Optimized
        if(len==1)
        {
            return new Node(grid[x1][y1] == 1, true, null, null, null, null);
        }
        else{
            Node n=new Node(false,false);

            n.topLeft= util(grid,x1,y1,len/2);
            n.topRight = util(grid,x1,y1+(len/2),len/2);
            n.bottomLeft = util(grid,x1 + (len/2),y1 ,len/2);
            n.bottomRight = util(grid,x1 + (len/2),y1 + (len/2), len/2);
            
            //Optimized
            if(n.topLeft.isLeaf==true && n.topRight.isLeaf==true && n.bottomLeft.isLeaf==true && n.bottomRight.isLeaf==true &&
            n.topLeft.val==n.topRight.val && n.topRight.val==n.bottomLeft.val && n.bottomLeft.val==n.bottomRight.val){
                return new Node(n.topLeft.val, true, null, null, null, null);
            }
             return new Node(n.topLeft.val,false,n.topLeft,n.topRight,n.bottomLeft,n.bottomRight);

        }
    }
    public static Node construct(int[][] grid) {
       return util(grid,0,0,grid.length); 
    }
	public static void main(String[] args) {
		int[][] grid = {
				{0,1},
				{1,0}
		};
		Node res=construct(grid);
		System.out.println(res);
	}
}


