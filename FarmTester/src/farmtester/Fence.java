
package farmtester;

public class Fence extends Housing{
    //create fence
    public Fence(int n, String t){
        super(n,0,12,0);
        //size for cows
        if (t.equals("c"))
            size = n * 30;
        //size for goat
        else if (t.equals("g"))
            size = n * 20;
        //size for horse
        else
            size = n * 50;
        //update cost
        setCost(12,0);
    }
}
