package shop;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Printer {

	
	
	Calculator calculator = new Calculator();
	DecimalFormat df = new DecimalFormat("##0.00");
	//create strings for each part of receipt
	//collate and print receipt
	String itemLine(Item item) {
		String result = "";
		result = result + 
				item.numberOf + 
				item.getName() + " : " + 
				df.format(calculator.taxedPrice(item));
		return result;
	}

	String taxLine(ArrayList<Item> list) {
		String result = "";
		result = result + 
			"Sales Tax: " +
			df.format(calculator.totalTaxPaid(list));
		return result;
		
	}
	
	String totalLine(ArrayList<Item> list) {
		String result = "";
		result = result + 
			"Total: " +
			df.format(calculator.totalAmountPaid(list));
		return result;
		
	}
	
	public void displayResults (ArrayList<Item> list) {
		
		String results = "";
		for (int i = 0; i < list.size(); i++) {
			results = results + "\n" + itemLine(list.get(i));
		}
		results = results + "\n" + taxLine(list);
		results = results + "\n" + totalLine(list);
		System.out.println(results);
		JOptionPane.showMessageDialog(null, results);
	}
	
	
	
	
	
	
	
	
	
	
}
