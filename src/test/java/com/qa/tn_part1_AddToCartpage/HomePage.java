package com.qa.tn_part1_AddToCartpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	public WebDriver driver;
	
	
	@FindBy(name = "search")
	private WebElement searchTextBoxField;
	
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	
	public void enterValidProductDetail() {
		searchTextBoxField.sendKeys("HP");
	}
	
	public SearchProductPage clickOnSearchIcon() {
		searchButton.click();
		return new SearchProductPage(driver);
	}
	
	public SearchProductPage navigateToSearchPage() {
		searchTextBoxField.sendKeys("HP");
		searchButton.click();
		return new SearchProductPage(driver);
	}
	

	
}



