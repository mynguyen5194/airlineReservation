package exceptionHandler;

import java.util.Scanner;

public class OutOfBoundsException extends Exception {
	private int errorno;
	private String errormsg;
	
	public OutOfBoundsException() {
		super();
		printmyproblem();
	}
	
	public OutOfBoundsException(String errormsg) {
		super();
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public OutOfBoundsException(int errorno) {
		super();
		this.errorno = errorno;
		printmyproblem();
	}
	
	public OutOfBoundsException(int errorno, String errormsg) {
		super();
		this.errorno = errorno;
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public int getErrorno() {
		return errorno;
	}
	
	public void setErrorno(int errorno) {
		this.errorno = errorno;
	}
	
	public String getErrormsg() {
		return errormsg;
	}
	
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	
	public void printmyproblem() {
		System.out.println("OutOfBoundsException [errorno=" + errorno + ", errormsg=" + errormsg + "]"); 
	}
	
	public void fixProblemReadFromConsole() {
		
		System.out.printf("Problem Resolved: Please re-enter the data\n");
	}
}
