package pkgHelper;

public class Puzzle {
	
	private static int[][] puzzle;
	
	public Puzzle(int[][] puzzle) {
		this.puzzle = puzzle;
	}
	
	public int[] GetRegion(int iRow, int iCol) throws Exception {
		int iSize = puzzle.length;
		int iSizesqrt = (int) Math.sqrt(iSize);
		
		int i = (iCol / iSizesqrt) + ((iRow / iSizesqrt) * iSizesqrt);
		
		return GetRegion(i);
	}
	
	public int[] GetRegion(int r) throws Exception {
		
		int[] myRegion = new int[puzzle.length];
		int idx = 0;
		int iSize = puzzle.length;
		int iSizeSqrt = (int) Math.sqrt(iSize);
		
		if ((r+1) > iSize) {
			throw new Exception("Bad Region Call");
		}
			
		for (int iRow = (r/iSizeSqrt) * iSizeSqrt; iRow < ((r / iSizeSqrt)*iSizeSqrt); iRow++) {
			for (int iCol = (r % iSizeSqrt)*iSizeSqrt; iCol < ((r % iSizeSqrt)*iSizeSqrt); iCol++) {
				myRegion[idx++] = puzzle[iRow][iCol];
			}
		}
		
		return myRegion;
	}
		
}

