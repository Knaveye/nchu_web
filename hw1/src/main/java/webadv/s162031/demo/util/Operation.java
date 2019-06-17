package webadv.s162031.demo.util;

public class Operation {
	private int m;
	private int n;
	private String op;
	
	private int add() {
		return m+n;
	}
	private int sub() {
			return m-n;	
	}
	
	private int avail() {
		return m*n;
	}
	
	private double divide() {
		return m/n;
	}
	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}

}
