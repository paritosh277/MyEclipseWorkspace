package facadeDesignPattern;

public class Pizza implements Food {
	public String preparedItem;

	@Override
	public void prepareFood(String itemsRequired) {
		// TODO Auto-generated method stub
		preparedItem = "Thin crust pizza with ingredients - "+ itemsRequired;

	}

	@Override
	public String deliverFood() {
		// TODO Auto-generated method stub
		return preparedItem;
	}

}
