package pkgHelper;

import java.util.Arrays;

public class Sudoku extends LatinSquare {
	
	private int iSize = getPuzzle().length;
	private int iSqrtSize = (int) Math.sqrt(iSize);
	
	public Sudoku() {
		super();
	}
	
	public Sudoku(int[][] latinSquare) {
		super(latinSquare);
	}
	
	public int[][] getPuzzle(){
		return super.getLatinSquare();
	}
	
	public int[] getRegion(int reg) {
		int col = (reg % iSqrtSize) * iSqrtSize;
		int row = (reg / iSqrtSize) * iSqrtSize;
		int[] myRegion = new int[iSize];
		int idx = 0;
		
		for(int i = row; i<(row+iSqrtSize); i++) {
			for(int k = col; k<(col+iSqrtSize); k++) {
				myRegion[idx++]=getPuzzle()[i][k];
			}
		}
		
		return myRegion;
	}
	
	public int[] getRegion(int iRow, int iCol) {
		int rNum = (iCol/iSqrtSize)+((iRow/iSqrtSize)*iSqrtSize);
		return getRegion(rNum);
	}
	
	public boolean isPartialSudoku() {
		setbIgnoreZero(true);
		boolean s = true;
		
		if(hasDuplicates()==true) {
			s = false;
		}
		if(ContainsZero()==false) {
			s = false;
		}
		
		return s;
	}
	
	public boolean isSudoku() {
		setbIgnoreZero(false);
		super.ClearPuzzleViolation();
		boolean s = true;
		
		if(hasDuplicates()) {
			s = false;
		}
		
		if(!super.isLatinSquare()) {
			s = false;
		}
		
		for(int i = 1; i<super.getLatinSquare().length; i++) {
			if(!hasAllValues(getRow(0), getRegion(i))) {
				s = false;
			}
		}
		
		if(ContainsZero()) {
			s = false;
		}
		
		return s;
	}
	
	public boolean isValueValid(int iCol, int iRow, int iValue ) {
		boolean valid = true;
		if((doesElementExist(getRow(iRow),iValue))==true) {
			AddPuzzleViolation(new PuzzleViolation(ePuzzleViolation.DupRow,iRow));
			valid = false;
			
		}
		if((doesElementExist(getColumn(iCol),iValue))==true) {
			AddPuzzleViolation(new PuzzleViolation(ePuzzleViolation.DupCol,iCol));
			valid = false;
			
		}
		if((doesElementExist(getRegion(iCol,iRow),iValue))==true) {
			AddPuzzleViolation(new PuzzleViolation(ePuzzleViolation.DupRegion, iValue));
			valid = false;
		}
		
		return valid;
	}
	
	public boolean hasDuplicates() {
		boolean dup = false;
		
		if(super.hasDuplicates()==true) {
			dup=true;
		}
		else {
			for(int i=0; i<iSize;i++) {
				if(super.hasDuplicates(getRegion(i))==true) {
					AddPuzzleViolation(new PuzzleViolation(ePuzzleViolation.DupRegion, i));
					dup = true;
				}
			}
		}
		
		return dup;
	}

}
