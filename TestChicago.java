import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.IOException;
import java.util.List;

public class TestChicago {

    public static void main(String[] args) throws IOException, InterruptedException {

        // For work in IE you must remove PROTECTED MODE from all zones !!!
         System.setProperty("webdriver.ie.driver", "C:\\selenium-2.51.0\\IEDriverServer.exe");
           WebDriver driver = new InternetExplorerDriver();
           String appUrl = "http://www.remax1stclass.com/homes-for-sale";    
            driver.get(appUrl);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            List <WebElement> ElementCity = driver.findElements(By.className("cityBox"));
            for (int k = 29; k < 33; k++) {
                ElementCity = driver.findElements(By.className("cityBox"));            
                ElementCity.get(k).click();
                String actualTitle = driver.getTitle();
                Thread.sleep(1000);        
                String AllCity = driver.findElement(By.className("allCityListingsTotal")).getText();        
                int AllCity_int = Integer.parseInt(AllCity);    
                    String AllCityNum_str = driver.findElement(By.className("allCityListingsTotal")).getText();
                    AllCityNum_str = AllCityNum_str.replaceAll("[^\\d.]", "");  
                    int AllCityNum_int = Integer.parseInt(AllCityNum_str);
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    
                    int AllCityNumByZip_int3 = 0;
                    List <WebElement> Element = driver.findElements(By.className("zipNameBox"));         
                    for (int j = 0; j < Element.size(); j++) {
                        Element = driver.findElements(By.className("zipNameBox"));                 
                        Thread.sleep(1000);                           
                        String AllCityNum_str2 = Element.get(j).getText();                 
                        Element.get(j).click();
                        String AllCityNum_str1 = driver.findElement(By.className("listingsTotal")).getText();
                        AllCityNum_str1 = AllCityNum_str1.replaceAll("[^\\d.]", "");
                        int AllCityNum_int1 = Integer.parseInt(AllCityNum_str1);
                        List<WebElement> drop = driver.findElements(By.className("zipListingsNum"));           
                        java.util.Iterator<WebElement> i = drop.iterator();
                        int AllCityNumByZip_int = 0;                 
                        while(i.hasNext()) {
                                WebElement row = i.next();   
                            String AllCityNumByZip_str = row.getText().replaceAll("\\p{P}","");
                            AllCityNumByZip_int = Integer.parseInt(AllCityNumByZip_str) + AllCityNumByZip_int;
                                            }     
                        if (AllCityNumByZip_int == AllCityNum_int1)  {
                        System.out.println(actualTitle+" splitted by type zip test: "+AllCityNum_str2+" passed "+AllCityNum_int1+"=="+AllCityNumByZip_int);
                                                                     } else {
                                System.out.println(actualTitle+" splitted by type zip test: "+AllCityNum_str2+" failed "+AllCityNum_int1+"!="+AllCityNumByZip_int);
                                }
                        AllCityNumByZip_int3 += AllCityNum_int1;
                        Thread.sleep(1000);             
                        driver.navigate().back();                 
                        Thread.sleep(1000);
                                                                } // of for (int k = 29; k < 33; k++)
                        if (AllCityNumByZip_int3 == AllCityNum_int)  {
                            System.out.println(actualTitle+" splitted by zips city test: passed "+AllCityNumByZip_int3+"=="+AllCityNum_int);
                                                                     } else {
                            System.out.println(actualTitle+" splitted by zips city test: failed "+AllCityNumByZip_int3+"!="+AllCityNum_int);
                                                                             }
                        Thread.sleep(1000);    
                        driver.navigate().back();        
                        Thread.sleep(1000);
                        if (AllCityNum_int == AllCity_int)  {
                           System.out.println(actualTitle+" all listings splitted by cities test: passed "+AllCityNum_int+"=="+AllCity_int);
                            } else {
                            System.out.println(actualTitle+" all listings splitted by cities test: failed "+AllCityNum_int+"!="+AllCity_int);
                                    }    
                                            }
       
                                                                                       }
                           }
