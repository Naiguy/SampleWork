package shop;

import java.util.ArrayList;

public class Calculator {
	
	public double taxedPrice(Item item) {
		//price + tax
		double result = item.getPrice();
		result = result + taxAmount(item);
		result = result * item.numberOf;
		return result;
	}
	
	
	public double taxAmount(Item item) {
		double basicResult = 0;
		double importResult = 0;
		double result;
		if (!item.getIsExempt()) {
			basicResult = getBasicTax(item);
		}
		if (item.getIsImported()) {
			importResult = getImportTax(item);
		}
		result = basicResult + importResult;

		return result;
	}
	
	public double getBasicTax(Item item) {
		double result = item.getPrice() * 0.10;
		result = Math.ceil(result * 20.0) / 20.0;
		return result;
	}
	
	public double getImportTax(Item item) {
		double result = item.getPrice() * 0.05;
		result = Math.ceil(result * 20.0) / 20.0;
		return result;
	}
	
	public double totalTaxPaid(ArrayList<Item> list) {
		double total = 0;
		for (int i = 0; i < list.size(); i++) {
			total = total + taxAmount(list.get(i));
		}
		total = Math.round(total * 100.00) / 100.00;
		return total;
		
	}
	public double totalAmountPaid(ArrayList<Item> list) {
		double total = 0;
		for (int i = 0; i < list.size(); i++) {
			total = total + taxedPrice(list.get(i));
		}
		total = Math.round(total * 100.00) / 100.00;

		return total;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
