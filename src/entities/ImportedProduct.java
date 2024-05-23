package entities;

public class ImportedProduct extends Product{
	private Double customsFree;
	
	public ImportedProduct () {
		super();
	}
	
	public ImportedProduct (String name, Double price, Double customsFree) {
		super(name, price);
		this.customsFree = customsFree;
	}

	public Double getCustomsFree() {
		return customsFree;
	}

	public void setCustomsFree(Double customsFree) {
		this.customsFree = customsFree;
	}
	
	public final Double totalPrice () {
		return price += customsFree;
	}
	
	@Override
	public String priceTag () {
		return name + " $ " + totalPrice() + " (Customs free: $ " + customsFree + ")";
	}
	
}
