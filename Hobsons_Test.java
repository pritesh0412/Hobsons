
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;


public class HobsonsTest 
{
	public static void main(String[] args) 
    {	
System.out.println("Test 1: Open the Hobsons home page.");
        
				WebDriver driver = new ChromeDriver();
    	  driver.get("http://www.hobsons.com");
		    Thread.sleep(5000);
        
System.out.println("Test 2: Hover Over Menu Headers test");
        
        WebElement element_Sol = driver.findElement(By.linkText("Solutions"));
        Actions action = new Actions(driver);
        action.moveToElement(element_Sol).build().perform();
        Thread.sleep(3000);
        WebElement element_Ser = driver.findElement(By.linkText("Services"));
        action.moveToElement(element_Ser).build().perform();
        Thread.sleep(3000);
        WebElement element_Res = driver.findElement(By.linkText("Resources"));
        action.moveToElement(element_Res).build().perform();
        Thread.sleep(3000);
        WebElement element_About = driver.findElement(By.linkText("About"));
        action.moveToElement(element_About).build().perform();
        Thread.sleep(3000);
        WebElement element_Blog = driver.findElement(By.linkText("Blog"));
        action.moveToElement(element_Blog).build().perform();
        Thread.sleep(3000);
 
System.out.println("Test 3: Page scroll test");
       
       ((JavascriptExecutor)driver).executeScript("window.scrollBy(2000,0)");
       Thread.sleep(2000);
       ((JavascriptExecutor)driver).executeScript("window.scrollBy(-2000,0)"); 
       Thread.sleep(2000);
       
System.out.println("Test 4: Open Careers link. Verify Address for Virginia and Ohio is correct.");

       WebElement elementLocator = driver.findElement(By.linkText("Careers"));
       action.Click(elementLocator).perform();
       Thread.sleep(5000);
       
       WebElement elmarladdr = driver.findElement(By.className(bg-purple));
       String addr = elmarladdr.getText();
       System.out.println("The address for Alrington obtained from UI is "+addr);
        if(addr.contains("3033 Wilson Boulevard, Suite 500 Arlington, VA 22201"))
         {
            System.out.println("The Address for Arlington office is correct");
         }
        else
         {
             System.out.println("The Address for Arlington office is incorrect");
         }
       
       WebElement elmarladdr2 = driver.findElement(By.className(bg-hobsons));
       String addr2 = elmarladdr2.getText();
       System.out.println("The address for Ohio office obtained from UI is "+addr2);
         if(addr2.contains("400 E-Business Way, Suite 400 Cincinnati, OH 45241"))
          {
             System.out.println("The Address for Ohio office is correct");
          }
        else
         {
             System.out.println("The Address for Ohio office is incorrect");
         }
     
System.out.println("Test 5:Open Google maps page on new tab for the selection made.");

       WebElement elementOH = driver.findElement(By.linkText("Cincinnati, OH")).click();
       String sourceContentsOH = (String)((JavascriptExecutor)driver).executeScript("return arguments[0].outerHTML;", elementOH); 
       assertEquals(sourceContentsOH, "<a href=\"https://maps.google.com/?q=400 E-Business Way, Suite 400 Cincinnati, OH 45241" target=\"_blank\">Cincinnati, OH</a>");
       Thread.sleep(5000);
        
       WebElement elementVA = driver.findElement(By.linkText("Arlington, VA")).click();
       String sourceContentsVA = (String)((JavascriptExecutor)driver).executeScript("return arguments[0].outerHTML;", elementVA); 
       assertEquals(sourceContentsVA, "<a href=\"https://maps.google.com/?q=3033 Wilson Boulevard, Suite 500Arlington, VA 22201" target=\"_blank\">Arlington, VA</a>");      
       Thread.sleep(5000);
    }
}
