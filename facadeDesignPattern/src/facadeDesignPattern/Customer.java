package facadeDesignPattern;

public class Customer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//normal scenario without facade
		
		Ingredient ingredient = new Ingredient();
		Food pizza = new Pizza();
		String pizzaItems = ingredient.getPizzaItems();
		pizza.prepareFood(pizzaItems);
		System.out.println(pizza.deliverFood());
		
		Food pasta = new Pasta();
		String pastaItems = ingredient.getPastaItems();
		pasta.prepareFood(pastaItems);
		System.out.println(pasta.deliverFood());
		
		System.out.println("FACADE");
		Waiter waiter = new Waiter();
		System.out.println(waiter.deliverFood(FoodType.PIZZA));
		System.out.println(waiter.deliverFood(FoodType.PASTA));

	}

}
