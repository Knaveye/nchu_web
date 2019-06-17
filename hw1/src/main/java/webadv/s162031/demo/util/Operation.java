package webadv.s162031.demo.util;

import java.text.DecimalFormat;

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
	
	private String divide() {
		DecimalFormat df = new DecimalFormat("0.00");//格式化小数  
		String num = df.format((float)m/n);//返回的是String类型  
		return num;
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
	public String getResult() {
		int result=0;
		if(this.op.equals("+")) {
			result = this.add();
		}else if(this.op.equals("-")) {
			result = this.sub();
		}else if(this.op.equals("*")) {
			result = this.avail();
		}else {
			return this.divide();
		}
		return new String().valueOf(result);
	}

}
