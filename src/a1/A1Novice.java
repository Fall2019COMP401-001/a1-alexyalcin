package a1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		int complete_customers = 0;
		int customer_num;
		Customer[] customers;
		customer_num = scan.nextInt();
		customers = new Customer[customer_num];
		while(complete_customers != customer_num) {
		    String fn = scan.next();
		    String ln = scan.next();
		    customers[complete_customers] = new Customer(fn, ln);
		    int toBuy = scan.nextInt();
		    customers[complete_customers].setUpBuyingList(toBuy);
		    for (int i = 0; i < toBuy; i++) {
		        int itemCount = scan.nextInt();
		        String itemName = scan.next();
		        double itemPrice = scan.nextDouble();
		        customers[complete_customers].buyItem(itemName, itemPrice, itemCount);
		    }
		    complete_customers++;
		}
		
    DecimalFormat money = new DecimalFormat("0.00");

		for (int i = 0; i < customer_num; i++) {
		    System.out.println(customers[i].getAbbreviatedName() + ": " + money.format(customers[i].getCustomerTotal()));
		    
		}

	}
}
