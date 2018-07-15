
package farmtester;

public class Beef extends Product{
    // Create beef with its properties
    public Beef(int amount, int unhealthy){
        super(amount * 750, 3.70, unhealthy);            
        quantity += "lbs";
    }
}
