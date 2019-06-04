package webadv.s16203122.example.aop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;

import webadv.s16203122.example.model.User;

@Aspect
@Configuration
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(LogAspect.class);
   
    //@Pointcut("execution(public * webadv.example.controller.HomeController.check(..))")
    //public void webLog(){}
    
    //@Before("webLog()")
    @Before("execution(public * webadv.s16203122.example.controller.HomeController.check(..)) && args(user,result,..)")
    public void doBefore(User user, BindingResult result) throws Throwable {
    	BufferedWriter bwrite = new BufferedWriter(new FileWriter("log.txt"));
    	bwrite.write("Account:"+user.getAccount()+",login:"+(result.hasErrors()?"failed":"succeeded"));
    	bwrite.newLine();
    	bwrite.close();
    	logger.info(String.format("Account:%s, login %s.", user.getAccount(),result.hasErrors()?"failed":"succeeded"));
       
    }    
}
