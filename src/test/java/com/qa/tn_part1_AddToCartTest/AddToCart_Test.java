package com.qa.tn_part1_AddToCartTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tn_part1_AddToCartpage.AddToCartPage;
import com.qa.tn_part1_AddToCartpage.HomePage;
import com.qa.tn_part1_AddToCartpage.ProductInfoPage;
import com.qa.tn_part1_AddToCartpage.SearchProductPage;
import com.tn.qa.testBase.TestBase;


public class AddToCart_Test extends TestBase{
	public WebDriver driver;
	HomePage homepage;
	SearchProductPage searchproductpage;
	ProductInfoPage productinfopage;
	AddToCartPage addtocartpage;
	
	@BeforeMethod
	public void setup() {
		driver = initalizeBrowserAndOpenApplication();
	}

	@Test
	public void checkingOutValidProduct() throws Exception {
		homepage = new HomePage(driver);
		homepage.enterValidProductDetail();
		searchproductpage = homepage.clickOnSearchIcon();
		Assert.assertTrue(searchproductpage.verifyDisplayStatusOfValidProduct());
		searchproductpage.clickOnAddtoCart();
		Thread.sleep(3000);
		productinfopage = new ProductInfoPage(driver);
		productinfopage.clickOnAddToCartButtonInProdInfo();
		addtocartpage = new AddToCartPage(driver);
		Thread.sleep(3000);
		addtocartpage.clickOnAddForCheckout();
		Assert.assertTrue(addtocartpage.varifyMessageofProductAddedDisplayed());
		
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

