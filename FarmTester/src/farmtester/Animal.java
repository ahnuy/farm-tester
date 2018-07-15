
package farmtester;

import java.text.NumberFormat;

public class Animal {
    
    //properties that all the farm animals have
    String type;
    int weight;
    double cost;
    boolean healthy;
    
    //format the cost as currency
    NumberFormat df = NumberFormat.getCurrencyInstance();
    
    public Animal(String t, int w, double c, boolean h) {
        type = t;
        weight = w;
        cost = c;
        healthy = h;
    }
    //prints a description of the animal
    public String describe(){
        String description = "";
        description += "I am a " + type + ". I weigh " + weight
                + "kg and cost ";
        if (healthy){
            description += df.format(cost) + ". I am healthy :)\n";
        //if the animal is unhealthy, the cost of them is 
        //reduced to a quarter of the original price
        }else{
            cost = cost/4;
            description += df.format(cost) + ". I am sick :(\n";
        }
        return description;
    }
}