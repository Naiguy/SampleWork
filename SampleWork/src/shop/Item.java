package shop;

public class Item {

	String name;
	Double price;
	Boolean isExempt;
	Boolean isImported;
	Integer numberOf;
	
	public Item(String name, Double price, Boolean isExempt, Boolean isImported, Integer numberOf) {
		super();
		this.name = name;
		this.price = price;
		this.isExempt = isExempt;
		this.isImported = isImported;
		this.numberOf = numberOf;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getIsExempt() {
		return isExempt;
	}

	public void setIsExempt(Boolean isExempt) {
		this.isExempt = isExempt;
	}

	public Boolean getIsImported() {
		return isImported;
	}

	public void setIsImported(Boolean isImported) {
		this.isImported = isImported;
	}
	
	public Integer getNumberOf() {
		return numberOf;
	}
	
	public void setNumberOf(Integer numberOf) {
		this.numberOf = numberOf;
	}
	
	
	
	
	
	
	
	
}
