package edu.diao.design.decorator;

public class ConcreteTopping2 extends ToppingDecorator{

	
	Pizza pizza;
	
	public ConcreteTopping2(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pizza.getDescription() + ", Topping2 ";
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return pizza.getCost() + 400;
	}
}
