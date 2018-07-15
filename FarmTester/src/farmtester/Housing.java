
package farmtester;

public class Housing {
    
    //properties
    int num;
    int perAnimal;
    int size;
    double cost;
    
    public Housing( int n, int an,double c, double m){
        //set properties
        num = n;
        perAnimal = an;
        size = num * perAnimal;
        setCost(c,m);      
    }
    //set cost
    public void setCost( double c, double m){
        //size *cost/feet + maintenance cost per month
        if (size > 0)
            cost = c * size + m * 12;
        else
            cost = 0;
    }
}
    
    
    
    

