
package farmtester;

public class ChickenMeat extends Product{
    //create chicken meat with its properties
    public ChickenMeat(int amount, int unhealthy){
        super(amount * 5, 3.18, unhealthy); 
        quantity += "lbs";
    }
    
}
