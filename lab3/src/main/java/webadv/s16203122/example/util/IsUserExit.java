package webadv.s16203122.example.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import webadv.s16203122.example.model.User;

public class IsUserExit {

	public boolean isUserExit(User user) {
		Boolean  flag=false;
		try {
			BufferedReader bread = new BufferedReader(new FileReader("user.txt"));
			
			String s =null;
			while((s=bread.readLine())!=null) {
				String[] userlist = s.split(",");
				if(userlist[0].equals(user.getAccount())&&userlist[1].equals(user.getPassword())) {
					flag =true;
				}
			}
			bread.close();
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public void addUser(User user) {
		BufferedWriter bwrite;
		try {
			bwrite = new BufferedWriter(new FileWriter("user.txt",true));
			bwrite.write(user.getAccount()+","+user.getPassword());
	    	bwrite.newLine();
	    	bwrite.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
		
	}
}
