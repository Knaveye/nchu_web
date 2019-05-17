package webadv.s16203122.p02;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 执行程序创建密码文件
 * @author yjp
 *
 */
public class CreatePassword {
	public static 	String pathname = "account.txt";

	public static void main(String[] args) {
		//创建map
		Map<String,String> pasMap =new HashMap<String,String>();
		
		//如果文件不存在，则创建文件
		File file = new File(pathname);
		try {
			//如果文件不存在，则创建文件
			if(!file.exists()) {
				file.createNewFile();
				System.out.println("文件不存在，已新建一个文件");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		//添加数据
		pasMap.put("16203122", "123456");
		pasMap.put("15070316365", "666666");
		
		//添加数据
		try {	
			String sha256Pass;
			BufferedWriter  bwriter = new BufferedWriter(new FileWriter(pathname));
			for (Map.Entry<String, String> entry : pasMap.entrySet()) { 
				  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
				 sha256Pass = DigestUtils.sha256Hex(entry.getValue());	//密码加密
				 System.out.println("sha256Pass = "+sha256Pass);
				  bwriter.write(entry.getKey()+":"+sha256Pass);	//账户加密码
				  bwriter.newLine();		//换行
			}
		
			bwriter.close();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
}
