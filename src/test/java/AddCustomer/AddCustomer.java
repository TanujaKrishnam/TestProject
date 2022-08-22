package AddCustomer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {
	
	
	@FindBy(name = "name")
	WebElement name;
	
	@FindBy(name = "addr")
	WebElement addr;
	
	@FindBy(name = "city")
	WebElement city;
	
	WebDriver driver;
	public AddCustomer(WebDriver driver)
	{
		PageFactory.initElements(driver, AddCustomer.class);
		this.driver = driver;
	}
	
	public void custname(String hy)
	{
		name.sendKeys(hy);
	}
	
	public void custaddr(String yu)
	{
		addr.sendKeys(yu);
	}
	public void custcity(String re)
	{
		city.sendKeys(re);
	}
	

}
