package com.airport;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadExl {
	private static final String String = null;

	public static void main(String[] args) throws IOException {
		// open file input stream
		BufferedReader reader = new BufferedReader(new FileReader(
				"C:\\Users\\Training\\Desktop\\airport_list.csv"));

		// read file line by line
		String line = null;
		Scanner scanner = null;
		int index = 0;
		List<Airport> air = new ArrayList<Airport>();

		while ((line = reader.readLine()) != null) {
			Airport air1 = new Airport();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0)
					air1.setIata(data);
				else if (index == 1)
					air1.setAirportname(data);
				else if (index == 3)
					air1.setCity(data);
				
				/*else
					System.out.println(data);*/
				index++;
			}
			index = 0;
			air.add(air1);
		}
		
		//close reader
		reader.close();
		
		System.out.println(air);
		
	}
	
}

