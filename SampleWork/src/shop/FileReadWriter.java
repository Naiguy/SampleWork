package shop;  
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReadWriter {
	
	String address1 = "input1.txt";
	String address2 = "input2.txt";
	String address3 = "input3.txt";
	String address4 = "input4.txt";
	String address = "input1.txt";
	
	
	
		public ArrayList<Item> readList(BufferedReader reader, String address) {
			ArrayList<Item> list = new ArrayList<Item>();
			try {
				reader = new BufferedReader(new FileReader(address));
				String line = reader.readLine();
				while (line != null) {
					list.add(itemize(line));
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return list;
			
		}
		
		
		public Item itemize (String line) {
			try {
			String[] brokenLine = line.split(" ");
			int number = Integer.parseInt(brokenLine[0]);
			double price = 0.0;
			String itemName = "";
			for (int i = 1; i < brokenLine.length; i++) {
				if (isValidNumber(brokenLine[i])) {
					price = Double.parseDouble(brokenLine[i]);
				}
				
				else if (!isValidNumber(brokenLine[i+1])) {
						itemName = itemName + " " + brokenLine[i];
						}
					}
			
			boolean exception = findException(itemName);
			boolean imported = findImportation(itemName);
			
			Item item = new Item(itemName, price, exception, imported, number);
			
			return item;	
			} catch (Exception e) {
				
				System.out.println("Error while reading file. Likely incorrect formatting.");
				return null;	
			}
		
			
		}
		public Boolean isValidNumber(String string) {
			Boolean result = string.matches("^\\s*(?=.*[1-9])\\d*(?:\\.\\d{1,2})?\\s*$");
			return result;
		}
		
		public boolean findException(String name) {
			boolean result = false;
			boolean needsToAsk = true;
			if (name.contains("chocolate")) {
				result = true; 
				needsToAsk = false;
			}
			if (name.contains("pill")) {
				result = true; 
				needsToAsk = false;
			}
			if (name.contains("book")) {
				result = true; 
				needsToAsk = false;
			}
			if (name.contains("music")) {
				result = false; 
				needsToAsk = false;
			}
			if (name.contains("perfume")) {
				result = false; 
				needsToAsk = false;
			}
			if (needsToAsk) {
				result = askException(name);
			}
			return result;
		}
		
		public boolean askException(String name) {
			Object[] options = { "YES", "NO" };
			String prompt = "Is" + name + " a medicine, food, or a book?";
			int choice = JOptionPane.showOptionDialog(null, prompt , "exception Check",
			JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
			             null, options, options[0]);
			if (choice == 0) return true;
			else return false;
			
		}
		
		public boolean findImportation(String name) {
			if (name.contains("import")) return true;
			else return false;
		}
		
		
		public void askInput() {
				Object[] options = { "INPUT 4", "INPUT 3", "INPUT 2", "INPUT 1" };
				String prompt = "Choose an input file. 1-3 are as given.";
				int choice = JOptionPane.showOptionDialog(null, prompt , "Input Selection",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
				             null, options, options[0]);
				if (choice == 0) {address = address4;}
				if (choice == 1) {address = address3;}
				if (choice == 2) {address = address2;}
				if (choice == 3) {address = address1;}
		
		}
		
		
		
		
		
		
	
}

