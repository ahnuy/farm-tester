
package farmtester;

import java.text.NumberFormat;

public class Food {
    
    //Variables
    String animal;
    String type;
    int caloriesperpound;
    int weight;
    int amount;
    int price;

    //Constructor
    public Food( String a, String t, int c, int w, int am, int p ){  
        animal = a;
        type = t;
        caloriesperpound = c;
        
        amount = am * 52;
        weight = w * amount;
        price = p * amount;
    }
    
    //describe
    public void describe(){
        
        NumberFormat df = NumberFormat.getCurrencyInstance();
        
        System.out.println("**************************************************");
        System.out.println("Food: " + type + " for " + animal + "s");
        System.out.println(caloriesperpound + " calories per pound");
        
        System.out.println(weight + " pounds per package, " + amount + " packages left, " + (weight * amount) + " pounds of " + type + " left.");
        System.out.println(df.format(price) + " per package, total cost: " + df.format(price * amount));                  
    }  
}
