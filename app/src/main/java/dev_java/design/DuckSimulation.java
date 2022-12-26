package dev_java.design;

public class DuckSimulation {
	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		mallard.performQuack();
		mallard.performFly();
		Duck yourDuck = new WoodDuck();
		yourDuck.performFly();
		yourDuck.performQuack();
		//Duck himDuck = new RubberDuck();
		//himDuck.performFly();
		//himDuck.performQuack();
	}
}
