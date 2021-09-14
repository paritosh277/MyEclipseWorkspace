package facadeDesignPattern;

public class Pasta implements Food {
	public String preparedItem;

	@Override
	public void prepareFood(String itemsRequired) {
		// TODO Auto-generated method stub
		preparedItem = "Tomato pasta with ingredients- "+ itemsRequired;

	}

	@Override
	public String deliverFood() {
		// TODO Auto-generated method stub
		return preparedItem;
	}

}
