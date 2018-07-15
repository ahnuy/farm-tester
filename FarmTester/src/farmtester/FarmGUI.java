
package farmtester;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;

public class FarmGUI extends javax.swing.JFrame {

    /**
     * Creates new form FarmGUI
     */
    NumberFormat df = NumberFormat.getCurrencyInstance(); //currency format
    NumberFormat cf = NumberFormat.getNumberInstance(); // number format
    ArrayList<Animal> animals = new ArrayList();    //array of Animals
    int numCows=1;  //number of cows
    int numPigs=1;  //number of pigs
    int numChickens=1;  //number of chicken
    int numHorses=1;    //number of horses
    int numGoats=1; //number of horses
    int cowUnhealthy = 0;   //number of sick cows
    int pigUnhealthy = 0;   //number of sick pigs
    int chickenUnhealthy = 0;   //number of sick chicken
    int horseUnhealthy = 0; //number of sick horse
    int goatUnhealthy = 0;  //number of sick goat
    double cost=0;  //total costs
    double profit=0;    //total profits
    double saved = 0;   //total saved
    
    
    //COW,GOAT,HORSE,PIG,CHICKEN <--- order of arrays
    int[] numAnimals;   //number of animals in array
    int[] animalsUnhealthy; // number of sick animals in array
    int[] numFood = new int[5]; //number of food
    double[] animalCost = new double[5];    //animal costs
    double[] foodCost = new double[5];  //food costs
    double[] totalAnimalCost = new double[5];   //food + animal costs
    //FENCE,CHICKEN PEN,PIGHOUSE <--- order of arrays
    int[] animalSpace = new int[3]; //space
    double[] maintCost = new double[3]; //maintenance costs
    //MILK,BEEF,PORK,EGGS,POULTRY MEAT,GOAT MILK <--- order of arrays
    double[] numProd = new double[6];   //number of products
    double[] prodCost = {3.50,3.70,3.50,0.50,3.18,4.25};    //costs
    double[]prof = new double[6];   //profits from products
    
    Food[] food;    //Array of food
    Housing[] housing;  //Array of housing
    Product[] product;  //Array of products
    
    //JLabel Locations
    JLabel[]animalsLoc;
    JLabel[]animalsCostLoc;
    JLabel[]foodCostLoc;
    JLabel[]totalAnimalCostLoc;
    JLabel[]animalSpaceLoc;
    JLabel[]maintCostLoc;
    JLabel[]numFoodLoc;
    JLabel[]numProdLoc;
    JLabel[]profLoc;
    
    //Random
    Random r = new Random();
    //GUI
    public FarmGUI() {
        initComponents();
    }
    //////////////
    //GET VALUES//
    //////////////
    //Get Values for farm
    public void getVals(){
        getNumAnimals();    //num animals
        getArrays();    //fill food, housing, product arrays
        getAnimalCosts();   //get animal costs
        getNumFood();   //get number of food
        getFoodCosts(); //get food costs
        getTotalAnimalCosts();  // get animal costs
        getAnimalSpace();   //get space used
        getMaintCosts();    //get maintenece costs
        getNumProd();   //get total amount of products
        getProfits();   //get profits
        getOverall();   //get final cost, profits, and earned
    }
    //Fill Arrays
    public void getArrays(){
        //Food
        food = new Food[]{new Hay(numCows),new Grain(numGoats),new Grass(numHorses),new Corn(numPigs),new PoultryFeed(numChickens)};
        //Product
        product = new Product[]{new Milk(numCows,cowUnhealthy),new Beef(numCows,cowUnhealthy),new Pork(numPigs,pigUnhealthy),new Eggs(numChickens,chickenUnhealthy),new ChickenMeat(numChickens,chickenUnhealthy),new GoatMilk(numGoats,goatUnhealthy)};
        //housing
        housing = new Housing[]{new Fence(numCows,"c"),new Fence(numGoats,"g"),new Fence(numHorses,"h"),new PigHouse(numPigs),new ChickenPen(numCows)};
        
    }
    //get profit
    public void getProfits(){
        profLoc = new JLabel[]{jLabel45,jLabel51,jLabel57,jLabel63,jLabel69,jLabel75};  //locations
        for (int i = 0; i < 6; i++){
            prof[i] = numProd[i]*prodCost[i];   //multiply amount of products by its price
        }
    }
    //get number of animals
    public void getNumAnimals(){
            
        numAnimals = new int[]{numCows,numGoats,numHorses,numPigs,numChickens}; //get number of animals
        animalsUnhealthy = new int[]{cowUnhealthy,goatUnhealthy,horseUnhealthy,pigUnhealthy,chickenUnhealthy}; //get unhealthy animals
        animalsLoc = new JLabel[]{jLabel127,jLabel77,jLabel23,jLabel129,jLabel117,jLabel24,jLabel131,jLabel107,jLabel22,jLabel136,jLabel85,jLabel37,jLabel134,jLabel93,jLabel30}; //locations
    }
    //get number of food
    public void getNumFood(){
        for (int i = 0; i < 5; i++){
            numFood[i] = food[i].amount;    //get amount of food
        }

        numFoodLoc = new JLabel[]{jLabel128,jLabel130,jLabel132,jLabel135,jLabel133};//locations
    }
    //food costs
    public void getFoodCosts(){
        //numfood * price
        foodCost[0] = numCows * food[0].price;  //cow costs
        foodCost[1] = numGoats * food[1].price; //goat costs
        foodCost[2] = numHorses * food[2].price;    //horse costs
        foodCost[3] = numPigs * food[3].price;  //pig costs
        foodCost[4] = numChickens * food[4].price;  //chicken costs
        
        foodCostLoc = new JLabel[]{jLabel83,jLabel123,jLabel113,jLabel91,jLabel103};    //locations
    }
    //get number of products
    public void getNumProd(){
        for(int i = 0; i < 6; i++){
            numProd[i] = product[i].amount; //product amount
        }
        numProdLoc = new JLabel[]{jLabel41,jLabel47,jLabel53,jLabel59,jLabel65,jLabel71};   //locations
    }    
    //get animal costs
    public void getAnimalCosts(){
        Animal[] animals = {new Cow(true),new Goat(true),new Horse(true),new Pig(true),new Chicken(true)};
        //animal costs * number of animals
        animalCost[0] = animals[0].cost * numCows;  //animal costs
        animalCost[1] = animals[1].cost * numGoats; //goat costs
        animalCost[2] = animals[2].cost * numHorses;    //horse costs
        animalCost[3] = animals[3].cost * numPigs;  //pig costs
        animalCost[4] = animals[4].cost * numChickens;  //chicken costs
        animalsCostLoc = new JLabel[]{jLabel79, jLabel119,jLabel109,jLabel87,jLabel99}; //locations
    }
    //get total animal costs
    public void getTotalAnimalCosts(){
        for (int i=0; i < 5; i++){
            //food costs + animal costs
            totalAnimalCost[i] = foodCost[i] + animalCost[i];   //total animal costs
        }
        totalAnimalCostLoc = new JLabel[]{jLabel95,jLabel125,jLabel115,jLabel97,jLabel105}; //locations
    }
    //get animal space
    public void getAnimalSpace(){
        animalSpace[0] = housing[0].size + housing[1].size + housing[2].size;   //fence
        animalSpace[1] = housing[3].size;   //chicken pen
        animalSpace[2] = housing[4].size;   //pig house
        animalSpaceLoc = new JLabel[]{jLabel18, jLabel27,jLabel34}; //locations
    }
    //get maintnance costs
    public void getMaintCosts(){
        maintCost[0] = housing[0].cost + housing[1].cost + housing[2].cost; //fence
        maintCost[1] = housing[3].cost; //chicken pen
        maintCost[2] = housing[4].cost; //pig house
        maintCostLoc = new JLabel[]{jLabel25, jLabel32,jLabel39};   //locations
    }
    //get total money spent, gained, saved
    public void getOverall(){
        double temp;
        //set total money spent, gained, saved to 0
        cost = 0;
        saved = 0;
        profit = 0;
        
        for (int i = 0; i < 5; i++){
            cost += totalAnimalCost[i]; //add animal costs
        }
        for (int i=0; i < 3; i++){
            cost += maintCost[i];   //add maintnance costs
        }
        //healthy horse
        for (int i = 0; i < numHorses - horseUnhealthy; i++){
            temp = cost * 0.025;    //save 2.5% per house
            saved += temp;  //add to saved
            cost -= temp;   //subtract from cost
        }
        //unhealthy
        for (int i = 0; i < horseUnhealthy; i++){
            temp = cost * 0.0125;    //save 1.25% per house
            saved += temp;  //add to saved
            cost -= temp;   //subtract from cost
        }
        for(int i =0; i < 6; i++){
            profit += prof[i];  //add profits
        }
    }
    //////////////
    //SET VALUES//
    //////////////
    public void setVals(){
        setNumAnimals();    //set number of animals
        setAnimalCosts();   //set animal costs
        setNumFood();   //set number of food
        setFoodCosts(); //set food costs
        setTotalAnimalCosts();  //set total animal costs
        setAnimalSpace();   //set space requirements
        setMaintCosts();    //set maintnance costs
        setNumProd();   //set number of products
        setProfs(); //set profits
        setOverall();   //set final costs, profits, saved
    }
    public void setNumFood(){
        int i = 0;
        for (int n: numFood){
            numFoodLoc[i].setText("x" + Integer.toString(n));   //set text
            i++;
        }
    }
    public void setProfs(){
        int i=0;
        for(double n: prof){
            profLoc[i].setText(df.format(n));   //set text
            i++;
        }
    }
    public void setNumAnimals(){
        for (int i = 0; i < 15; i+=3){
            animalsLoc[i].setText("x " + Integer.toString(numAnimals[i/3]));    //set text
            animalsLoc[i+1].setText(Integer.toString(numAnimals[i/3]) + "\n (" + Integer.toString(animalsUnhealthy[i/3]) + " unhealthy)");  //set text
            animalsLoc[i+2].setText(Integer.toString(numAnimals[i/3]) + "\n (" + Integer.toString(animalsUnhealthy[i/3]) + " unhealthy)");  //set text
        }
    }
    public void setAnimalCosts(){
        int i = 0;
        //Costs
        for (double n: animalCost){
            animalsCostLoc[i].setText(df.format(n));    //set text
            i++;
        }
    }
    public void setFoodCosts(){
        int i = 0;
        //Costs
        for (double n: foodCost){
            foodCostLoc[i].setText(df.format(n));   //set text
            i++;
        }
    }
    public void setTotalAnimalCosts(){
        int i = 0;
        //Costs
        for (double n: totalAnimalCost){
            totalAnimalCostLoc[i].setText(df.format(n));    //set text
            i++;
        }
    }
    public void setAnimalSpace(){
        int i = 0;
        //Costs
        for (int n: animalSpace){
            animalSpaceLoc[i].setText(cf.format(n) + "ft");  //set text
            i++;
        }
    }
    public void setMaintCosts(){
        int i = 0;
        for (double n: maintCost){
            maintCostLoc[i].setText(df.format(n));  //set text
            i++;
        }
    }
    public void setNumProd(){
        String [] prods = {product[0].quantity,product[1].quantity,product[2].quantity,product[3].quantity,product[4].quantity,product[5].quantity};    //get product strings with prefix
        int i = 0;
        for (String n: prods){
            numProdLoc[i].setText(n);   //set text
            i++;
        }
    }
    public void setOverall(){
        jLabel138.setText(df.format(cost) + "  ("+ df.format(saved) + " saved from horses)");   //set costs and savings
        jLabel140.setText(df.format(profit));   //set revenue
        jLabel142.setText(df.format(profit - cost));    //set net profit
    }
    ///////////////
    //CREATE FARM//
    ///////////////
    public void addAnimals(){
        int c;  //unhealthy chance
        cowUnhealthy = 0;   //sick cows
        pigUnhealthy = 0;   //sick pigs
        chickenUnhealthy = 0;   //sick chicken
        horseUnhealthy = 0; //sick horses
        goatUnhealthy = 0;  //sick goats
        //add cows
        for (int i=0; i < numCows; i++){
            c = r.nextInt(10);  //10% chance of unhealthy
            if (c==0){
                animals.add(new Cow(false));
                cowUnhealthy++;
            }
            else
                animals.add(new Cow(true));
        }
        //add goats
        for (int i=0; i < numGoats; i++){
            c = r.nextInt(10);  //10% chance of unhealthy
            if (c==0){
                animals.add(new Goat(false));
                goatUnhealthy++;
            }
            else
                animals.add(new Goat(true));
        }
        //add horses
        for (int i=0; i < numHorses; i++){
            c = r.nextInt(10);  //10% chance of unhealthy
            if (c==0){
                animals.add(new Horse(false));
                horseUnhealthy++;
            }
            else
                animals.add(new Horse(true));
        }
        //add pigs
        for (int i=0; i < numPigs; i++){
            c = r.nextInt(10);  //10% chance of unhealthy
            if (c==0){
                animals.add(new Pig(false));
                pigUnhealthy++;
            }
            else
                animals.add(new Pig(true));
        }
        //add chicken
        for (int i=0; i < numChickens; i++){
            c = r.nextInt(10);  //10% chance of unhealthy
            if (c==0){
                animals.add(new Chicken(false));
                chickenUnhealthy++;
            }
            else
                animals.add(new Chicken(true));
        }
    }
    //print description of animals in the box
    public void printMessage(){
        String message = "";
        for (int i = 0; i < animals.size(); i++){
            message += animals.get(i).describe();   //get message
        }
        jTextArea2.setText(message);    //set text
    }
  
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jLabel130 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel143 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel144 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel145 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel146 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel147 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel152 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton15 = new javax.swing.JButton();
        jLabel153 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Farm Generator");
        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setLayout(null);

        jButton14.setText("Change Farm");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton14);
        jButton14.setBounds(879, 10, 110, 23);

        jLabel130.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel130.setText("x ##");
        jPanel2.add(jLabel130);
        jLabel130.setBounds(320, 540, 100, 30);

        jLabel141.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel141.setText("Net Income/Loss:");
        jPanel2.add(jLabel141);
        jLabel141.setBounds(570, 880, 120, 17);

        jLabel142.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel142.setText("##");
        jPanel2.add(jLabel142);
        jLabel142.setBounds(690, 880, 330, 14);

        jLabel140.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel140.setText("##");
        jPanel2.add(jLabel140);
        jLabel140.setBounds(670, 850, 330, 14);

        jLabel139.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel139.setText("Total Revenue:");
        jPanel2.add(jLabel139);
        jLabel139.setBounds(570, 850, 100, 17);

        jLabel138.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel138.setText("##");
        jPanel2.add(jLabel138);
        jLabel138.setBounds(650, 820, 330, 14);

        jLabel137.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel137.setText("Total Costs:");
        jPanel2.add(jLabel137);
        jLabel137.setBounds(570, 820, 90, 17);

        jLabel136.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel136.setText("x ##");
        jPanel2.add(jLabel136);
        jLabel136.setBounds(850, 190, 60, 30);

        jLabel135.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel135.setText("x ##");
        jPanel2.add(jLabel135);
        jLabel135.setBounds(650, 290, 130, 30);

        jLabel134.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel134.setText("x ##");
        jPanel2.add(jLabel134);
        jLabel134.setBounds(850, 570, 70, 30);

        jLabel133.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel133.setText("x ##");
        jPanel2.add(jLabel133);
        jLabel133.setBounds(640, 720, 140, 30);

        jLabel132.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel132.setText("x ##");
        jPanel2.add(jLabel132);
        jLabel132.setBounds(210, 850, 180, 30);

        jLabel131.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel131.setText("x ##");
        jPanel2.add(jLabel131);
        jLabel131.setBounds(360, 720, 70, 30);

        jLabel127.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel127.setText("x ##");
        jPanel2.add(jLabel127);
        jLabel127.setBounds(310, 130, 60, 40);

        jLabel128.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel128.setText("x ##");
        jPanel2.add(jLabel128);
        jLabel128.setBounds(300, 230, 120, 30);

        jLabel129.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel129.setText("x ##");
        jPanel2.add(jLabel129);
        jLabel129.setBounds(320, 450, 60, 30);

        jLabel126.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmtester/farmPic.png"))); // NOI18N
        jLabel126.setAlignmentY(0.0F);
        jPanel2.add(jLabel126);
        jLabel126.setBounds(80, 0, 920, 930);

        jTabbedPane4.addTab("Farm", jPanel2);

        jTabbedPane1.setBackground(new java.awt.Color(51, 51, 0));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Cow");

        jLabel3.setText("Pig");

        jLabel4.setText("Chicken");

        jLabel5.setText("Horse");

        jLabel6.setText("Goat");

        jLabel76.setText("Amount");

        jLabel77.setText("##");

        jLabel78.setText("Cost to Buy");

        jLabel79.setText("##");

        jLabel80.setText("Food");

        jLabel81.setText("Hay");

        jLabel82.setText("Food Costs");

        jLabel83.setText("##");

        jLabel84.setText("Amount");

        jLabel85.setText("##");

        jLabel86.setText("Cost to Buy");

        jLabel87.setText("##");

        jLabel88.setText("Food");

        jLabel89.setText("Corn");

        jLabel90.setText("Food Costs");

        jLabel91.setText("##");

        jLabel92.setText("Amount");

        jLabel93.setText("##");

        jLabel94.setText("Total Costs");

        jLabel95.setText("##");

        jLabel96.setText("Total Costs");

        jLabel97.setText("##");

        jLabel98.setText("Cost to Buy");

        jLabel99.setText("##");

        jLabel100.setText("Food");

        jLabel101.setText("Poultry Feed");

        jLabel102.setText("Food Costs");

        jLabel103.setText("##");

        jLabel104.setText("Total Costs");

        jLabel105.setText("##");

        jLabel106.setText("Amount");

        jLabel107.setText("##");

        jLabel108.setText("Cost to Buy");

        jLabel109.setText("##");

        jLabel110.setText("Food");

        jLabel111.setText("Grass");

        jLabel112.setText("Food Costs");

        jLabel113.setText("##");

        jLabel114.setText("Total Costs");

        jLabel115.setText("##");

        jLabel116.setText("Amount");

        jLabel117.setText("##");

        jLabel118.setText("Cost to Buy");

        jLabel119.setText("##");

        jLabel120.setText("Food");

        jLabel121.setText("Grain");

        jLabel122.setText("Food Cost");

        jLabel123.setText("##");

        jLabel124.setText("Total Costs");

        jLabel125.setText("##");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel76)
                            .addComponent(jLabel77)
                            .addComponent(jLabel84)
                            .addComponent(jLabel85)
                            .addComponent(jLabel92)
                            .addComponent(jLabel93)
                            .addComponent(jLabel106)
                            .addComponent(jLabel107)
                            .addComponent(jLabel116)
                            .addComponent(jLabel117))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel78)
                            .addComponent(jLabel79)
                            .addComponent(jLabel86)
                            .addComponent(jLabel87)
                            .addComponent(jLabel98)
                            .addComponent(jLabel99)
                            .addComponent(jLabel108)
                            .addComponent(jLabel109)
                            .addComponent(jLabel118)
                            .addComponent(jLabel119))
                        .addGap(100, 100, 100)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel80)
                            .addComponent(jLabel81)
                            .addComponent(jLabel88)
                            .addComponent(jLabel89)
                            .addComponent(jLabel100)
                            .addComponent(jLabel101)
                            .addComponent(jLabel110)
                            .addComponent(jLabel111)
                            .addComponent(jLabel120)
                            .addComponent(jLabel121))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel82)
                            .addComponent(jLabel83)
                            .addComponent(jLabel90)
                            .addComponent(jLabel91)
                            .addComponent(jLabel102)
                            .addComponent(jLabel103)
                            .addComponent(jLabel112)
                            .addComponent(jLabel113)
                            .addComponent(jLabel122)
                            .addComponent(jLabel123))
                        .addGap(100, 100, 100)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel125)
                            .addComponent(jLabel124)
                            .addComponent(jLabel115)
                            .addComponent(jLabel114)
                            .addComponent(jLabel105)
                            .addComponent(jLabel104)
                            .addComponent(jLabel97)
                            .addComponent(jLabel96)
                            .addComponent(jLabel95)
                            .addComponent(jLabel94))))
                .addContainerGap(356, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(jLabel78)
                    .addComponent(jLabel80)
                    .addComponent(jLabel82)
                    .addComponent(jLabel94))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(jLabel79)
                    .addComponent(jLabel81)
                    .addComponent(jLabel83)
                    .addComponent(jLabel95))
                .addGap(80, 80, 80)
                .addComponent(jLabel3)
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84)
                    .addComponent(jLabel86)
                    .addComponent(jLabel88)
                    .addComponent(jLabel90)
                    .addComponent(jLabel96))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85)
                    .addComponent(jLabel87)
                    .addComponent(jLabel89)
                    .addComponent(jLabel91)
                    .addComponent(jLabel97))
                .addGap(80, 80, 80)
                .addComponent(jLabel4)
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel92)
                    .addComponent(jLabel98)
                    .addComponent(jLabel100)
                    .addComponent(jLabel102)
                    .addComponent(jLabel104))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(jLabel99)
                    .addComponent(jLabel101)
                    .addComponent(jLabel103)
                    .addComponent(jLabel105))
                .addGap(40, 40, 40)
                .addComponent(jLabel5)
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel106)
                    .addComponent(jLabel108)
                    .addComponent(jLabel110)
                    .addComponent(jLabel112)
                    .addComponent(jLabel114))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel107)
                    .addComponent(jLabel109)
                    .addComponent(jLabel111)
                    .addComponent(jLabel113)
                    .addComponent(jLabel115))
                .addGap(80, 80, 80)
                .addComponent(jLabel6)
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel116)
                    .addComponent(jLabel118)
                    .addComponent(jLabel120)
                    .addComponent(jLabel122)
                    .addComponent(jLabel124))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel117)
                    .addComponent(jLabel119)
                    .addComponent(jLabel121)
                    .addComponent(jLabel123)
                    .addComponent(jLabel125))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Animal", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Fence");

        jLabel7.setText("Chicken Pen");

        jLabel8.setText("Pig House");

        jLabel15.setText("Space");

        jLabel16.setText("Animals");

        jLabel17.setText("Maintenance Costs");

        jLabel18.setText("##");

        jLabel19.setText("Horse");

        jLabel20.setText("Cow");

        jLabel21.setText("Goat");

        jLabel22.setText("##");

        jLabel23.setText("##");

        jLabel24.setText("##");

        jLabel25.setText("##");

        jLabel26.setText("Space");

        jLabel27.setText("##");

        jLabel28.setText("Animals");

        jLabel29.setText("Chicken");

        jLabel30.setText("##");

        jLabel31.setText("Maintenance Costs");

        jLabel32.setText("##");

        jLabel33.setText("Space");

        jLabel34.setText("##");

        jLabel35.setText("Animals");

        jLabel36.setText("Pig");

        jLabel37.setText("##");

        jLabel38.setText("Maintenance Costs");

        jLabel39.setText("##");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34))
                        .addGap(150, 150, 150)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel37)))
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36))
                        .addGap(144, 144, 144)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jLabel31)
                            .addComponent(jLabel25)
                            .addComponent(jLabel17)
                            .addComponent(jLabel32)
                            .addComponent(jLabel39))))
                .addContainerGap(401, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel22)
                    .addComponent(jLabel25))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel23))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel24))
                .addGap(58, 58, 58)
                .addComponent(jLabel7)
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel28)
                    .addComponent(jLabel31))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel32))
                .addGap(120, 120, 120)
                .addComponent(jLabel8)
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel35)
                    .addComponent(jLabel38))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37)
                    .addComponent(jLabel39))
                .addContainerGap(320, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Housing", jPanel5);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Cow Milk");

        jLabel10.setText("Beef");

        jLabel11.setText("Pork");

        jLabel12.setText("Eggs");

        jLabel13.setText("Chicken Meat");

        jLabel14.setText("Goat Milk");

        jLabel40.setText("Amount");

        jLabel41.setText("##");

        jLabel42.setText("Price");

        jLabel43.setText("$3.50");

        jLabel44.setText("Profits");

        jLabel45.setText("Amount * Price = $##.##");

        jLabel46.setText("Amount");

        jLabel47.setText("##");

        jLabel48.setText("Price");

        jLabel49.setText("$3.70");

        jLabel50.setText("Profits");

        jLabel51.setText("Amount * Price = $##.##");

        jLabel52.setText("Amount");

        jLabel53.setText("##");

        jLabel54.setText("Price");

        jLabel55.setText("$3.50");

        jLabel56.setText("Profits");

        jLabel57.setText("Amount * Price = $##.##");

        jLabel58.setText("Amount");

        jLabel59.setText("##");

        jLabel60.setText("Price");

        jLabel61.setText("$0.50");

        jLabel62.setText("Profits");

        jLabel63.setText("Amount * Price = $##.##");

        jLabel64.setText("Amount");

        jLabel65.setText("##");

        jLabel66.setText("Price");

        jLabel67.setText("$3.18");

        jLabel68.setText("Profits");

        jLabel69.setText("Amount * Price = $##.##");

        jLabel70.setText("Amount");

        jLabel71.setText("##");

        jLabel72.setText("Price");

        jLabel73.setText("$4.25");

        jLabel74.setText("Profits");

        jLabel75.setText("Amount * Price = $##.##");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47)
                            .addComponent(jLabel52)
                            .addComponent(jLabel53)
                            .addComponent(jLabel58)
                            .addComponent(jLabel59)
                            .addComponent(jLabel64)
                            .addComponent(jLabel65)
                            .addComponent(jLabel70)
                            .addComponent(jLabel71))
                        .addGap(150, 150, 150)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(jLabel43)
                            .addComponent(jLabel48)
                            .addComponent(jLabel49)
                            .addComponent(jLabel54)
                            .addComponent(jLabel55)
                            .addComponent(jLabel60)
                            .addComponent(jLabel61)
                            .addComponent(jLabel66)
                            .addComponent(jLabel67)
                            .addComponent(jLabel72)
                            .addComponent(jLabel73))
                        .addGap(200, 200, 200)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel75)
                            .addComponent(jLabel74)
                            .addComponent(jLabel69)
                            .addComponent(jLabel68)
                            .addComponent(jLabel63)
                            .addComponent(jLabel62)
                            .addComponent(jLabel57)
                            .addComponent(jLabel56)
                            .addComponent(jLabel51)
                            .addComponent(jLabel50)
                            .addComponent(jLabel45)
                            .addComponent(jLabel44))))
                .addContainerGap(375, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel9)
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jLabel42)
                    .addComponent(jLabel44))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel43)
                    .addComponent(jLabel45))
                .addGap(40, 40, 40)
                .addComponent(jLabel10)
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jLabel48)
                    .addComponent(jLabel50))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jLabel49)
                    .addComponent(jLabel51))
                .addGap(40, 40, 40)
                .addComponent(jLabel11)
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jLabel54)
                    .addComponent(jLabel56))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jLabel55)
                    .addComponent(jLabel57))
                .addGap(50, 50, 50)
                .addComponent(jLabel12)
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jLabel60)
                    .addComponent(jLabel62))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jLabel61)
                    .addComponent(jLabel63))
                .addGap(40, 40, 40)
                .addComponent(jLabel13)
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(jLabel66)
                    .addComponent(jLabel68))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(jLabel67)
                    .addComponent(jLabel69))
                .addGap(40, 40, 40)
                .addComponent(jLabel14)
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jLabel72)
                    .addComponent(jLabel74))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(jLabel73)
                    .addComponent(jLabel75))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Products", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jTabbedPane4.addTab("Owned Assets", jPanel1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1098, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel143.setText("Num of cows:");

        jButton1.setText("-");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel144.setText("0");

        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel145.setText("Num of goats:");

        jButton3.setText("-");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel146.setText("0");

        jButton4.setText("+");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel147.setText("0");

        jButton5.setText("+");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("-");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel148.setText("Num of horses:");

        jLabel149.setText("0");

        jButton7.setText("+");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("-");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel150.setText("Num of pigs:");

        jLabel151.setText("0");

        jButton9.setText("+");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("-");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel152.setText("Num of chickens:");

        jButton12.setText("Random");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Go To Farm");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jButton15.setText("Reset");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jLabel153.setFont(new java.awt.Font("OCR A Std", 1, 24)); // NOI18N
        jLabel153.setText("Welcome to Financial Analysis and Risk Mangement (FARM)");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel143)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel145)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel148)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton6))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel150)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton8))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel152)
                                        .addGap(135, 135, 135)
                                        .addComponent(jButton10)))
                                .addGap(88, 88, 88)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel144, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel146, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel147, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel149, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel151, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(85, 85, 85)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton7)
                                    .addComponent(jButton9)
                                    .addComponent(jButton5)
                                    .addComponent(jButton2)
                                    .addComponent(jButton4)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton15)
                                .addGap(150, 150, 150)
                                .addComponent(jButton12)
                                .addGap(79, 79, 79))))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(309, 309, 309))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton13)
                        .addGap(482, 482, 482))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel153)
                        .addGap(53, 53, 53))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel153)
                .addGap(67, 67, 67)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(25, 25, 25)
                        .addComponent(jButton4)
                        .addGap(21, 21, 21)
                        .addComponent(jButton5)
                        .addGap(25, 25, 25)
                        .addComponent(jButton7)
                        .addGap(25, 25, 25)
                        .addComponent(jButton9))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel144)
                                    .addComponent(jButton1)
                                    .addComponent(jLabel143))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel146)
                                    .addComponent(jButton3)
                                    .addComponent(jLabel145))
                                .addGap(16, 16, 16)
                                .addComponent(jLabel147)
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton6)
                                    .addComponent(jLabel148))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8)
                            .addComponent(jLabel149)
                            .addComponent(jLabel150))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton10)
                            .addComponent(jLabel151)
                            .addComponent(jLabel152))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton15)
                            .addComponent(jButton12))))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton13)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //add cow button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (numCows == 0)
            jButton1.setEnabled(true);  //enable remove cow button
        numCows++;  //add cow
        init();
    }//GEN-LAST:event_jButton2ActionPerformed
    //remove cow button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        numCows--;  //remove cow
        init(); //update
        if(numCows == 0)
            jButton1.setEnabled(false); //disable remove cow button
    }//GEN-LAST:event_jButton1ActionPerformed
    //remove goat button
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        numGoats--; //remove goat
        init(); //update
        if(numGoats == 0)
            jButton3.setEnabled(false); //disable remove goat button
    }//GEN-LAST:event_jButton3ActionPerformed
    //remove horse button
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        numHorses--;    //remove horse
        init(); //update
        if(numHorses == 0)
            jButton6.setEnabled(false); //disable remove horse button
    }//GEN-LAST:event_jButton6ActionPerformed
    //remove pig button
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        numPigs--;  //remove pig
        init(); //update
        if(numPigs == 0)
            jButton8.setEnabled(false);//disabe remove pig button
    }//GEN-LAST:event_jButton8ActionPerformed
    //remove chicken button
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        numChickens--;  //remove chicken
        init(); //update
        if(numChickens == 0)
            jButton10.setEnabled(false);    //disable remove chicken button
    }//GEN-LAST:event_jButton10ActionPerformed
    //add goat button
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (numGoats ==0)
            jButton3.setEnabled(true);  //enable remove goat button 
        numGoats++; //add goat
        init();//update
    }//GEN-LAST:event_jButton4ActionPerformed
    //add horse button
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (numHorses ==0)
            jButton6.setEnabled(true);  //enable remove horse button
        numHorses++;    //add horse
        init(); //update
    }//GEN-LAST:event_jButton5ActionPerformed
    //add pig button
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (numPigs ==0)
            jButton8.setEnabled(true);  //enable remove pig button
        numPigs++;  //add pig
        init(); //update
    }//GEN-LAST:event_jButton7ActionPerformed
    //add chicken button
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (numChickens ==0)
            jButton10.setEnabled(true); //enable remove chicken button
        numChickens++;  //add chicken
        init(); //start
    }//GEN-LAST:event_jButton9ActionPerformed
    //Random button
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        //Random number of animals between 1 to 50
        numCows = r.nextInt(50)+1;
        numGoats = r.nextInt(50)+1;
        numHorses = r.nextInt(50)+1;
        numPigs = r.nextInt(50)+1;
        numChickens = r.nextInt(50)+1;
        jButton1.setEnabled(true);
        jButton3.setEnabled(true);
        jButton6.setEnabled(true);
        jButton8.setEnabled(true);
        jButton10.setEnabled(true);
        init(); //update
    }//GEN-LAST:event_jButton12ActionPerformed
    //Go to farm button
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        start();//go to farm
    }//GEN-LAST:event_jButton13ActionPerformed
    //back to create farm button
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        //go to create farm
        jPanel7.setVisible(true);   
        jPanel6.setVisible(false);
    }//GEN-LAST:event_jButton14ActionPerformed
    //reset button
    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        //reset everything
        animals.clear();
        numCows=1;
        numPigs=1;
        numChickens=1;
        numHorses=1;
        numGoats=1;
        cowUnhealthy = 0;
        pigUnhealthy = 0;
        chickenUnhealthy = 0;
        horseUnhealthy = 0;
        goatUnhealthy = 0;
        jButton1.setEnabled(true);
        jButton3.setEnabled(true);
        jButton6.setEnabled(true);
        jButton8.setEnabled(true);
        jButton10.setEnabled(true);
        jTextArea2.setText("");
        init();
    }//GEN-LAST:event_jButton15ActionPerformed
    //update
    public void init(){
        //update number of animals
        jLabel144.setText(Integer.toString(numCows));
        jLabel146.setText(Integer.toString(numGoats));
        jLabel147.setText(Integer.toString(numHorses));
        jLabel149.setText(Integer.toString(numPigs));
        jLabel151.setText(Integer.toString(numChickens));
        animals.clear();
        addAnimals();   //make animals
        printMessage(); //print message
    }
    public void start(){
        //get Values
        getVals();
        //set Values
        setVals();
        //switch screen
        jPanel7.setVisible(false);
        jPanel6.setVisible(true);
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FarmGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FarmGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FarmGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FarmGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        final FarmGUI farm = new FarmGUI();
        //create farm
        farm.init();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //go to create
                farm.setVisible(true);
                farm.jPanel7.setVisible(true);
                farm.jPanel6.setVisible(false);     
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
