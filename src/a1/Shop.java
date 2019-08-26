/**
 * 
 */
package a1;

/**
 * @author Alex
 *
 */
public class Shop {
    private Offering[] offerings;
    private int offeringCount;
    private int maxOfferings;
    
    public Shop() {
        offeringCount = 0;
        maxOfferings = 9999;
        offerings = new Offering[maxOfferings];
    }
    
    public Shop(int maxOfferings) {
        offeringCount = 0;
        this.maxOfferings = maxOfferings;
        offerings = new Offering[maxOfferings];
    }
    
    public void addOffering(String name, double price) {
        offerings[offeringCount] = new Offering(name, price);
        offeringCount++;
    }
    
    public String[] ListAllOfferings() {
        String[] offString = new String[offeringCount];
        for (int i = 0; i < offeringCount; i++) {
            offString[i] = offerings[i].name;
        }
        return offString;
    }
    
    public double getOfferingPrice(String name) {
        for (int i = 0; i < offeringCount; i++) {
            if (offerings[i].name.equals(name)) {
                return offerings[i].price;
            }
        }
        return -1;
    }
    
    /**
     * 
     * @author Alex
     * Item as considered by store. Assumes infinite stock.
     */
    private class Offering {
        public String name;
        public double price;
        
        public Offering(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }
}
