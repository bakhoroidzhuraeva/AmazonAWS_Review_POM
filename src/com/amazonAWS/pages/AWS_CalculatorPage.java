package com.amazonAWS.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazonAWS.utilities.Driver;

public class AWS_CalculatorPage {
	WebDriver driver;

	public AWS_CalculatorPage() {
		this.driver = Driver.getDriver(null);
		PageFactory.initElements(driver, this);

	}

	public boolean isAt() {
		return driver.getTitle().equals("Amazon Web Services Simple Monthly Calculator");
	}

	@FindBy(className = "billLabel")
	public WebElement monthlyBill;

	public double getMonthlyBill() {
		String billText = monthlyBill.getText();
		String[] arrText = billText.split("\\$ ");
		String bill = arrText[1].replace(")", "");
		double bills = Double.parseDouble(bill);
		return bills;
	}

	@FindBy(xpath = "(//div[@class='gwt-PushButton small gwt-PushButton-up'])[1]")
	public WebElement addEC2;

	@FindBy(xpath = "//tr[@class=\"EC2InstanceRow itemsTableDataRow table\"]//input[@class=\"gwt-TextBox input\"]")
	public WebElement description;

	@FindBy(xpath = "(//input[@class='gwt-TextBox numericTextBox input'])[1]")
	public WebElement instance;

	public int getInstanceCount() {
		return Integer.parseInt(instance.getAttribute("value"));
	}

	@FindBy(xpath = "//table[@class='SF_EC2_INSTANCE_FIELD_USAGE field usageField']//input")
	public WebElement usageCount;

	public int getUsageCount() {
		return Integer.parseInt(usageCount.getAttribute("value"));
	}

	@FindBy(xpath = "//table[@class='SF_EC2_INSTANCE_FIELD_USAGE field usageField']//select")
	public WebElement usage;

	public String getUsageOption() {
		Select list = new Select(usage);
		return list.getFirstSelectedOption().getText();
	}

	@FindBy(xpath = "//td[@class='cell']//div[@class='gwt-HTML field SF_EC2_INSTANCE_FIELD_TYPE instanceTypeField rowDialogSelectorFieldView']")
	public WebElement ec2type;

	public String getType() {
		return ec2type.getText();
	}

	@FindBy(xpath = "//td[@class='cell']//div[@class='gwt-HTML field SF_COMMON_FIELD_BILLING instanceBillingField rowDialogSelectorFieldView']")
	public WebElement billingOption;

	public String getBillingOption() {
		return billingOption.getText();
	}

	@FindBy(xpath = "//td[@class='cell']//div[@class='gwt-HTML DynamicPrice DynamicPricePricing']")
	public WebElement monthlyCost;

	public double getMonthlyCost() {
		return Double.parseDouble(monthlyCost.getText().replace("$", "").trim());
	}

	@FindBy(xpath = "//table//button[@class='gwt-Button reset small']")
	public WebElement clearForm;

	@FindBy(xpath = "//div[@class='gwt-DialogBox ConfirmDialog Dialog']")
	public WebElement confirmDialog;

	public boolean checkClearAlert() {
		return confirmDialog.isDisplayed();
	}

	@FindBy(xpath = "//button[.='OK']")
	public WebElement OK;

	@FindBy(xpath = "//a[.='Amazon EC2 Service (US-East)']/../../../td[4]/table/tbody/tr/td/input")
	public WebElement monthlyBillCostBeforeDiscounts;

	@FindBy(xpath = "(//div[.='Services'])[1]")
	public WebElement services;

	public boolean isEC2InstancesTableClear() {
		return driver.findElements(By.xpath("//tr[@class='EC2InstanceRow itemsTableDataRow table']")).isEmpty();
	}

}