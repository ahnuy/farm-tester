
package farmtester;

public class Milk extends Product{    
    
    //create milk and its properties
    public Milk(int amount, int unhealthy){
        super(amount* 10400, 3.50, unhealthy);
        quantity += "L";
    }
}
