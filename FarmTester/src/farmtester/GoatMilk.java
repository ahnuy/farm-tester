
package farmtester;

public class GoatMilk extends Product{
    //create goat milk with its properties
    public GoatMilk(int amount, int unhealthy){
        super(amount * 10400, 4.25, unhealthy);
        quantity += "L";
    }
}
