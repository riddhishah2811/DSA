package dp;
/*
 * Some civilians are partying in a grid of dimensions n * m. Some terrorists also sneaked into the party and occupied some cells. 
 * Each cell in the grid will either be empty or can accommodate at most one person which can be either 
 * {civilian, terrorist, or soldier}.
 * 
 * Assuming that the ,  terrorists can move in any direction (left, up, right,down) if the corresponding cell is empty 
 * or contains a civilian find if there exists an arrangement of soldiers such that none of the civilians got harmed or 
 * report if that is impossible.
 * 
 * Note :
 * 1. Initially, no soldiers are on the grid
 * 2. Soldiers can only be deputed into empty cells. 
 * 3. Neither of Soldiers or Civilians can't move.
 * 4. Many braveheart soldiers are there hence you need not minimize the soldiers.
 * 5. grid[i][j] = 'E'  represents an empty cell, grid[i][j] = 'T' represents a terrorist,  grid[i][j] = 'C' 
 *    represents a civiliana, and grid[i][j] = 'S'  represents a soldier. 
 * */
public class SaveCivilians {
	public static int dx[]= {1,-1,0,0};
	public static int dy[]= {0,0,1,-1};
	public static boolean safe(int x,int y,int n,int m)
	{
		if(x<0 || y <0 || x>=n || y>=m)
			return false;
		return true;
	}
	public static boolean saveCivilians(int n,int m,char grid[][])
	{
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++)
			{
				if(grid[i][j]=='C')
				{
					for(int k=0;k<4;k++)
					{
						int dr=i + dx[k];
						int dc=j + dy[k];
						
						if(safe(dr,dc,n,m)==true && grid[dr][dc]=='T')
						{
							return false;	
						}
					}
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int n=5,m=5;
//		Ex : 1
//		char grid[][]={
//				{'E','E','E','C','E'},
//				{'E','E','C','C','E'},
//				{'E','C','E','E','E'},
//				{'E','E','T','T','E'},
//				{'E','E','E','E','E'}
//		};
		
//		Ex: 2
		char grid[][]={
				{'E','E','E','C','E'},
				{'E','E','C','C','E'},
				{'E','C','E','T','E'},
				{'E','E','T','T','E'},
				{'E','E','E','E','E'}
		};
		
		boolean b=saveCivilians(n,m,grid);
		if(b==true)
		{
			System.out.println("Possible");
		}
		else
		{
			System.out.println("Not Possible");
		}
		
	}

}
