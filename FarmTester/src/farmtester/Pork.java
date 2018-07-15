
package farmtester;

public class Pork extends Product{
    //create pork with its properties
    public Pork(int amount, int unhealthy){
        super(amount * 280, 3.50, unhealthy);
        quantity += "lbs";
    }
    
}
