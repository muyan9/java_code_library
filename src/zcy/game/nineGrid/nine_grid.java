package zcy.game.nineGrid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class nine_grid {
	public static final ArrayList<Integer> nineGridTemplate = new ArrayList<Integer>();
	public int[][] nGrid = new int[9][9];
	
	static
	{
		for(int i=1;i<=9;i++)
			nineGridTemplate.add(i);
	}
	
	public boolean validate(int row ,int col , int digital)
	{
		for(int i=0;i<9;i++)
		{
			if(i==col) continue;
			if(nGrid[row][i]==digital) return false;
		}
		for(int i=0;i<9;i++)
		{
			if(i==row) continue;
			if(nGrid[i][col]==digital) return false;
		}
		int relativeRowPosition = row%3;
		int relativeColPosition = col%3;
		for(int i=row-relativeRowPosition;i<(row-relativeRowPosition+3);i++)
		{
			for(int j=col-relativeColPosition;j<(col-relativeColPosition+3);j++)
			{
				if(i==row && j==col) continue;
				if(nGrid[i][j]==digital) return false;
			}
		}
		return true;
	}
	
	public void generate()
	{
		//Digital data of the first row / col / grid
		ArrayList<Integer> alUnit = (ArrayList<Integer>) nineGridTemplate.clone();
		Random rad = new Random();
		while(true)
		{
			if(alUnit.size()==9) break;
			int iRadDigital = rad.nextInt(9)+1;
			if(alUnit.contains(iRadDigital)) continue;
			alUnit.add(iRadDigital);
			
		}
		
		
		Iterator<Integer> it = alUnit.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}

	private ArrayList<Integer> removeExistNumbers(ArrayList<Integer> list,int row, int col){
		for(Integer i=0;i<9;i++){
			if(nGrid[row][i]!=0 && list.contains(nGrid[row][i]))
				list.remove(list.indexOf(nGrid[row][i]));
		}
		
		for(Integer i=0;i<9;i++){
			if(nGrid[i][col]!=0 && list.contains(nGrid[i][col]))
				list.remove(list.indexOf(nGrid[i][col]));
		}
		
		int relativeRowPosition = row%3;
		int relativeColPosition = col%3;
		for(int i=row-relativeRowPosition;i<(row-relativeRowPosition+3);i++)
		{
			for(int j=col-relativeColPosition;j<(col-relativeColPosition+3);j++)
			{
				if(nGrid[i][j]!=0 && list.contains(nGrid[i][j]))
					list.remove(list.indexOf(nGrid[i][j]));
			}
		}
		
		
		return list;
	}
	public void generateAll()
	{
		
		int iRandDigital = 0;
		Random rad = new Random();
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				while(true)
				{
					ArrayList<Integer> listDTemplate = (ArrayList<Integer>) nineGridTemplate.clone();
					listDTemplate = removeExistNumbers(listDTemplate, i, j);
					if(listDTemplate.size()==0) {
						for(int t=0;t<=j;t++){
							nGrid[i][t] = 0;
						}
						j=0;
						continue;
					}
					iRandDigital = rad.nextInt(listDTemplate.size());
					iRandDigital = listDTemplate.get(iRandDigital);
					if(validate(i, j, iRandDigital))
					{
						nGrid[i][j] = iRandDigital;
						break;
					}
					else
						listDTemplate.remove(listDTemplate.indexOf(iRandDigital));
				}
			}
		}
	}
	
	public void printGrid()
	{
		for(int i=0;i<9;i++)
		{
			if(i%3==0) System.out.println();
			for(int j=0;j<9;j++)
			{
				if(j%3==0) System.out.print(" ");
				System.out.print(nGrid[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("----------------------------------------");
	}
	
	public static void main(String[] args)
	{
		nine_grid n = new nine_grid();
		for(int i=0;i<1000000;i++)
		{
		n.generateAll();
		//n.printGrid();
		System.out.println(i);
		}
	}
}
