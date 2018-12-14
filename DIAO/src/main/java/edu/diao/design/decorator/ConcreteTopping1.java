package edu.diao.design.decorator;

public class ConcreteTopping1 extends ToppingDecorator{
	Pizza pizza;
	
	public ConcreteTopping1(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pizza.getDescription() + ", Topping1 ";
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return pizza.getCost() + 40;
	}
	
}
