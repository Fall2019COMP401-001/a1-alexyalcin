package a1;

import java.util.Scanner;

public class A1Jedi {

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
    
    String[] goods = shop.ListAllOfferings();
    for (String good : goods) {
        int customersBought = 0;
        int totalBought = 0;
        for (int c = 0; c < customerCount; c++) {
            int bought = customers[c].getItemTotal(good);
            if (bought != 0) {
                customersBought++;
                totalBought += bought;
            }
        }
        if (customersBought != 0) {
            System.out.println("" + customersBought + " customers bought " + totalBought + " " + good);
        } else {
            System.out.println("No customers bought " + good);
        }
    }
		
	}
}
