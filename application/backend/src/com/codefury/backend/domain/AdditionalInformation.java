package com.codefury.backend.domain;

import java.util.List;

// Helper class for calculating various cost values
public class AdditionalInformation {
	// Calculating GST Amount
	public double totalGST(int orderValue) {

		return (0.1 * orderValue);

	}

	// Calculating Shipping cost
	public double shippingCost(int orderValue, List<Products> products) {
		if (orderValue > 100000) {
			return 0.00;
		}
		double sum = 0;
		for (Products products2 : products) {
			if ((products2.getCategory()).equals("Level 1")) {
				sum += 0.05 * products2.getPrice();
			} else if ((products2.getCategory()).equals("Level 2")) {
				sum += 0.03 * products2.getPrice();
			} else {
				sum += 0.02 * products2.getPrice();
			}
		}
		return sum;
	}
}
