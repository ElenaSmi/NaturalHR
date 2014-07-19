package core;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NaturalHRTest {
       LoginPage lp = new LoginPage (driver);
       MainPage mp = new MainPage (driver);
       EmployeePage ep = new EmployeePage (driver);
       EmployeeQuickAddPage eqAdd = new EmployeeQuickAddPage (driver);
       static WebDriver driver = new FirefoxDriver();
              
       @Before
       public void setUp() throws Exception {lp.login("smielena24@gmail.com", "cupertino2014");}

       @After
       public void tearDown() throws Exception {mp.logoff();}
       
       @AfterClass
       public static void AfterClass(){
    	   driver.quit();
    	   driver = null;
       }

       @Test
       public void test_01_verify_login() {
    	   assertEquals("Login was unsuccessful", true, lp.verifyBodyContains("Quickstart"));}
       
       @Test
       public void test_02_verify_add_Employee() throws InterruptedException{
    	   eqAdd.quickAddEmp("001", "Alex", "Smith", "01/01/1991", "07/07/2007",
    	    		"Software Engineer");
    	   eqAdd.verifyAddEmp("Employee successfully added");
       }
       
       @Test
       public void  test_03_verify_deleteEmployee(){
    	   ep.deletEmp();
    	   ep.verifyEmpDeleted("No employees found");
    	   
       }
       

}
