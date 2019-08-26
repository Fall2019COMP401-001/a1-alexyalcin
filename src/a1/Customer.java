/**
 * 
 */
package a1;

/**
 * @author Alex
 * Represents a customer... Absolutely unnecessary for project of this size.
 */
public class Customer implements Comparable<Customer>{
    private String firstName;
    private String lastName;
    private Item[] items;
    private int itemsToBuy; 
    
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public void setUpBuyingList(int size) {
        items = new Item[size];
        itemsToBuy = size;
        
    }
    
    public void buyItem(String name, double price, int amount) {
            items[items.length - itemsToBuy] = new Item(name, price, amount);
            itemsToBuy--;

    }
    
    public double getCustomerTotal() {
        double total = 0;
        for (int i = 0; i < items.length; i++) {
            total += items[i].price * items[i].amount;
        }
        return total;
    }
    
    public int getItemTotal(String itemName) { 
        int total = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals(itemName)) {
                total += items[i].amount;
            }
        }
        return total;
    }
    
    public String getAbbreviatedName() {
        return firstName.substring(0,1) + ". " + lastName;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    @Override
    public int compareTo(Customer o) {
        if (getCustomerTotal() > o.getCustomerTotal()) return 1;
        if (getCustomerTotal() < o.getCustomerTotal()) return -1;
        return 0;
    }
    
    private class Item {
        public String name;
        public double price; // i know i know, never use public fields :( (Just pretend it's a struct with a constructor) 
        public int amount;
        
        public Item(String name, double price, int amount) {
            this.name = name;
            this.price = price;
            this.amount = amount;
        }
    }
}
