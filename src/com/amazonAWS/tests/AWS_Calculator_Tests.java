package com.amazonAWS.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.amazonAWS.pages.AWS_CalculatorPage;
import com.amazonAWS.utilities.TestBaseClass;

public class AWS_Calculator_Tests extends TestBaseClass {
	AWS_CalculatorPage awsPage = new AWS_CalculatorPage();

	@Test(priority = 0, description = "Monthly bill should be $0.00 by default")
	public void defaultMonthlyBillTest() {
		assertTrue(awsPage.isAt());
		System.out.println(awsPage.monthlyBill.getText());
		assertEquals(awsPage.monthlyBill.getText(), "Estimate of your Monthly Bill ($ 0.00)");
		assertEquals(awsPage.getMonthlyBill(), 0.0);

	}

	@Test(priority = 1)
	public void addedEC_2DefaultValuesTest() {
		awsPage.addEC2.click();

		assertTrue(awsPage.description.getAttribute("value").isEmpty());

		assertEquals(1, awsPage.getInstanceCount());
		System.out.println(awsPage.getInstanceCount());

		assertEquals(100, awsPage.getUsageCount());
		System.out.println(awsPage.getUsageCount());

		assertEquals(awsPage.getUsageOption(), "% Utilized/Month");
		System.out.println(awsPage.getUsageOption());

		assertEquals(awsPage.getType(), "Linux on t1.micro");
		System.out.println(awsPage.getType());

		assertEquals(awsPage.getBillingOption(), "On-Demand (No Contract)");
		System.out.println(awsPage.getBillingOption());

		assertEquals(awsPage.getMonthlyCost(), 14.64);
		System.out.println(awsPage.getMonthlyCost());

		double servicesTabMonthlyCost = awsPage.getMonthlyCost();
		awsPage.monthlyBill.click();
		double billTabMonthlyCost = Double.parseDouble((awsPage.monthlyBillCostBeforeDiscounts.getAttribute("value")));
		assertEquals(servicesTabMonthlyCost, billTabMonthlyCost);
		awsPage.services.click();

	}

	@Test(priority = 2)
	public void clearFormTest() {
		awsPage.clearForm.click();

		assertTrue(awsPage.checkClearAlert());
		assertTrue(awsPage.confirmDialog.getText().contains("Please Confirm"));
		assertTrue(awsPage.confirmDialog.getText()
				.contains("Are you sure you want to clear all entries in this service form?"));
		awsPage.OK.click();
		System.out.println(awsPage.isEC2InstancesTableClear());
		assertEquals(awsPage.isEC2InstancesTableClear(), true);

	}

}
