package exceptionHandler;

import java.io.*;
import java.util.Scanner;

public class ProblemGenerator {
	private int rowNumber;
	private int columnNumber;
	
	public ProblemGenerator() {}
	public ProblemGenerator(int rowNum, int columnNum) {
		rowNumber = rowNum;
		columnNumber = columnNum;
	}
	public int getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}
	public int getColumnNumber() {
		return columnNumber;
	}
	public void setColumnNumber(int columnNumber) {
		this.columnNumber = columnNumber;
	}
	
	public boolean isOutOfBounds(int rowNum, int columnNum) throws Repair, IOException {
		boolean isOutOfBounds = false;
		
		try {
			if(rowNum > (this.rowNumber-1) || columnNum > (this.columnNumber-1)) {
				isOutOfBounds = true;
			}
		}
		catch(IndexOutOfBoundsException e) {
			throw new Repair();
		}
		finally {
			
		}
		return isOutOfBounds;
	}
}
