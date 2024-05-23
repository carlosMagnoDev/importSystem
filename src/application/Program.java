package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	public static void main(String[] args) throws ParseException {
		Scanner input = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> productList = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int number = input.nextInt();
		
		for (int i = 0; i < number; i++) {
			input.nextLine();
			System.out.printf("Prodcut #%d data:", i + 1);
			
			System.out.print("\nCommon, used or imported (c/u/i)? ");
			String opc = input.nextLine().toLowerCase();
			
			System.out.print("Name:");
			String name = input.nextLine();
			
			System.out.print("Price:");
			Double price = input.nextDouble();
			
			if (opc.equals("c")) {
				Product product = new Product(name, price);
				productList.add(product);
				
			} else if (opc.equals("i")) {
				System.out.print("Customs free: ");
				Double customsFree = input.nextDouble();
				
				Product product = new ImportedProduct(name, price, customsFree);
				productList.add(product);	
				
			} else if (opc.equals("u")) {
				System.out.print("Manufacture date (DD/MM/YYY): ");
				String date = input.nextLine();
				Date manufactureDate = sdf.parse(date);
				
				Product product = new UsedProduct(name, price, manufactureDate);
				productList.add(product);

			} else {
				System.out.println("Error!");
			}
			
			System.out.println();
		}
		
		System.out.println("PRICE TAGS:");
		for (Product product : productList) {
			System.out.println(product.priceTag());
		}
		
		input.close();
	}
}
