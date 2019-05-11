package webadv.s16203122.p02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * @author yjp
 *接收用户在控制台输入账号与密码，
 *并能够将接收到的账号与密码与密码文件中存储的账号与密码进行比对，
 *密码文件中的账号以明文的形式给出，而密码采用SHA-256算法保护。
 */
public class App {
	public static void main(String[] args) {
        //提示输入账户和密码  
        Scanner input = new Scanner(System.in);
        
    	System.out.println("please input you account：");
        String account = input.next();
        System.out.println("please input you password：");
        String password = input.next();		//输入账户和密码
          
       Boolean isRight = VerifyAccount(account,password);
       if(isRight) {
    	   System.out.println("Existing account, successful login!");
       }else {
    	   System.out.println("Error in account or password entry！");
       }
    }
    
    /**
     * 判断账户是否存在，并返回结果
     * @param account
     * @param password
     * @return
     */
    private static Boolean VerifyAccount(String account, String password) {
    	Boolean isexit = false;
    	String fileAccount ;
    	String filePassword;
    	
    	//读取文件获取字符串
    	try {
			BufferedReader bReader = new BufferedReader(new FileReader("account.txt"));
			String line = null;
			while((line = bReader.readLine()) != null) {
				String[] line_a_p = line.split(":");	//切割获得账号和密码
				fileAccount =line_a_p[0];
				filePassword =line_a_p[1];		//密码为加密后的
				
				//如果相等
				if(account.equals(fileAccount)&&filePassword.equals(sha256hex(password))) {
					isexit =true;
					break;
				}
				
			}
			bReader.close();
    	} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
    	
    	return isexit;		
	}
    
    /**
     * 输入字符串，返回经过sha256hex加密后的字符串
     * @param input
     * @return
     */
	public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}

