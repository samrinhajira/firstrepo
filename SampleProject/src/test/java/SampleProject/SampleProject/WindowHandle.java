package SampleProject.SampleProject;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandle {
public static void main(String[] args) {
	
	WebDriver driver= new FirefoxDriver();
	driver.get("");
	String parentwindow = driver.getWindowHandle();
	Set<String> allwindows = driver.getWindowHandles();
	for(String chidwindow:allwindows)
	{
		if(!parentwindow.equalsIgnoreCase(chidwindow))
		{
			System.out.println(chidwindow);
		}
	}
}
}
