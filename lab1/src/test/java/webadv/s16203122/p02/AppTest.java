package webadv.s16203122.p02;
import org.junit.Assert;
import org.junit.Test;

public class AppTest {
    private String ACCOUNT = "16203122";
    private String PASSWORD = "123456";
  
    @Test
    public void testPassword(){
    	String expected ="8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92";
    	Assert.assertEquals(expected, App.sha256hex(PASSWORD));
    }
    
   
}

