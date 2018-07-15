
package farmtester;

public class Eggs extends Product{
    //create eggs with its properties
    public Eggs(int amount, int unhealthy){
        super(amount * 300, 0.50, unhealthy); 
        quantity += " eggs";
    }
}
