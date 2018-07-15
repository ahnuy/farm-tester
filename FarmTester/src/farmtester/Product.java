
package farmtester;

import java.text.NumberFormat;

public class Product {
    //properties
    double income;
    double price;
    int amount;
    String quantity;
    
    public Product(int amount, double price, int unhealthy){
        NumberFormat df = NumberFormat.getNumberInstance();
        //set properties
        this.amount = amount;
        this.price = price;
        setIncome(unhealthy);
        quantity = df.format(amount);
        
    }
    //set income
    public void setIncome(int unhealthy){
        // price * amount - num unhealthy * price/2 <------ products from sick animals are worth half
        this.income = this.price * this.amount - unhealthy* price/2;
    }
    
}
