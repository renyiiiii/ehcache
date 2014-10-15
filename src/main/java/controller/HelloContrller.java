package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MysqlDao;
import dao.StuBean;
import encache.EncacheTest;

@Controller
@EnableAutoConfiguration
public class HelloContrller {

	
	 @RequestMapping(value ="/hello/{id}", method = RequestMethod.GET)
	    @ResponseBody
	    public String hello(@PathVariable("id")int id){
		 MysqlDao mysqlDao = new MysqlDao();
		 EncacheTest encacheTest = new EncacheTest();
		 if(encacheTest.findbyid(id)!=null){
			 return encacheTest.findbyid(id).toString();
		 }else{
			 StuBean stu=mysqlDao.findProById(id+"");
			 if(stu!=null){
				 encacheTest.saveStu(stu);
				 return stu.toString();
			 }
			 
			 return "not find";
		 } 
	    }
	/* 第一种方式
	 通过在SimpleController中加上@EnableAutoConfiguration开启自动配置，
	 然后通过SpringApplication.run(SimpleController.class);
	 运行这个控制器；这种方式只运行一个控制器比较方便； */
	   public static void main(String[] args) {
	        SpringApplication.run(HelloContrller.class, args);
	    }
	   

}
