package webadv.example.rest;

public class Task {

	
	private String context;
	private int id;
	
	public Task( int id,String context) {
		super();
		this.context = context;
		this.id = id;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
	
}
