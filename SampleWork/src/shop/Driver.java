package shop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;


public class Driver {
	
	public static void main(String[] args) throws FileNotFoundException {

		FileReadWriter reader = new FileReadWriter();
		Printer printer = new Printer();
		reader.askInput();
		BufferedReader fileReader = new BufferedReader(new FileReader(reader.address));
		ArrayList<Item> list = reader.readList(fileReader, reader.address);
		printer.displayResults(list);

		
	}

}
