package a1;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int storeCount = scan.nextInt();
		Shop shop = new Shop(storeCount);
		
		for (int i = 0; i < storeCount; i++) {
		    String name = scan.next();
		    double price = scan.nextDouble();
		    shop.addOffering(name, price);
		}
		
		int customerCount = scan.nextInt();
		Customer[] customers = new Customer[customerCount];
		for (int i = 0; i < customerCount; i++) {
		    String fn = scan.next();
		    String ln = scan.next();
		    customers[i] = new Customer(fn, ln);
		    int toBuy = scan.nextInt();
		    customers[i].setUpBuyingList(toBuy);
		    for (int c = 0; c < toBuy; c++) {
		        int amount = scan.nextInt();
		        String name = scan.next();
		        double price = shop.getOfferingPrice(name);
		        customers[i].buyItem(name, price, amount);
		    }
		}
		
		Arrays.sort(customers);
		DecimalFormat money = new DecimalFormat("#.00");
		System.out.println ("Biggest: " + customers[customerCount - 1].getFullName() + " (" + money.format(customers[customerCount - 1].getCustomerTotal()) + ")");
		System.out.println ("Smallest: " + customers[0].getFullName() + " (" + money.format(customers[0].getCustomerTotal()) + ")");
		
		double total = 0;
		for (int i = 0; i < customerCount; i++) {
		    total += customers[i].getCustomerTotal();
		}
		System.out.println("Average: " + money.format(total / customerCount));
	}
}
