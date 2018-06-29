package BankingSampleProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://srssprojects.in/cards.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='Table_01']/tbody/tr/td[2]/a/img")).click();
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[contains(@src,'Branches')]")).click();
		/*WebElement ele =driver.findElement(By.xpath("//select[@id='lst_countryS']"));
		Select s= new Select(ele);
		List<WebElement> allOptions = s.getOptions();
		for(WebElement dd_list:allOptions){
			System.out.println(dd_list);*/
		WebElement table = driver.findElement(By.xpath("//table[@id='DG_bankdetails']"));
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		int rowCount = allRows.size();
		for(int i=0;i<=rowCount;i++)
		{
			List<WebElement> allColumns = allRows.get(i).findElements(By.tagName("td"));
			int colCount = allColumns.size();
			
			for(int j=0;j<=colCount;j++)
			{
				WebElement row = table.findElement(By.xpath("//table[@id='DG_bankdetails']/tbody/tr[4]"));
				/*String rTxt = row.getText();
				System.out.println("3rd row of table is: "+rTxt);*/
				
				WebElement cellTxt = row.findElement(By.xpath("//table[@id='DG_bankdetails']/tbody/tr[4]/td[2]"));
				String cellValue = cellTxt.getText();
				System.out.println("celltext is: "+cellValue);
				break;
				/*
				//to read all the data in the table
				String cellText= allColumns.get(j).getText();
				//System.out.println("Cell Value of row Number: "+i+ " and column number: "+j+"is: "+cellText);
				System.out.println("cell value of clumn number "+i+"column number"+j+" is: "+cellText);
				*/
			}
			System.out.println("--------------------------------");
		}
		
		}
		
	}


