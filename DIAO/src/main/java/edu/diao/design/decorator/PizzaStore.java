package edu.diao.design.decorator;

public class PizzaStore {

	
    public static void main(String args[]) 
    { 
        // create new Combo pizza 
        Pizza pizza = new Combo(); 
        System.out.println( pizza.getDescription() + 
                         " Cost :" + pizza.getCost()); 
  
        // create new BBQChicken pizza 
        Pizza pizza2 = new BBQChicken(); 
  
        // decorate it/ Add   topping 1
        pizza2 = new ConcreteTopping1(pizza2); 
  
        //decorate it with paneer topping 
        pizza2 = new ConcreteTopping2(pizza2); 
  
        System.out.println( pizza2.getDescription() + 
                         " Cost :" + pizza2.getCost()); 
    }
}
