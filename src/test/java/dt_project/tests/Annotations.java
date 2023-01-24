package dt_project.tests;

import org.testng.annotations.*;

public class Annotations {
/*
    Hierarchy: suite > test > group > class > method
    @Test   : Creates test case
    @Before and @After  : 10 before and after annotations. The are
    @Ignore : Skip test case
    @Test(enable=false) : Disable the test case.By default, enable=true
    @Test(priority=number):priority/order test case executation.
    NOTE:Tests that has no priority parameter has a priority of 0.Test(priority=0)
    TestNG test cases runs in alphabetical order by default
    TestNG methodlari alfabetik olarak calistirir
    Ama priority() methoduyla numara vererek siralamayi ayarlayabiliriz.
 */
@BeforeSuite
public void beforeSuite(){
    System.out.println("Before Suite");
}
    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @Test(priority = 2)
    public void test1(){
        System.out.println("test1");
    }
    @Ignore // atlamasini istedigimiz method'un basina koyuyoruz.
    @Test
    public void test2(){
        System.out.println("test2");
    }
    @Test(enabled = false) //false olursa calistir demektir.
    public void test3(){
        System.out.println("test3");
    }
    @Test(priority = 3)
    public void test4(){
        System.out.println("test4");
    }
    @Test(priority = 1)
    public void test5(){
        System.out.println("test5");
    }

    @Test(groups = "minor_regression_group")
    public void test6(){
        System.out.println("test6");
    }
}
