package test;

public class ProductVO {
	private int pk;
	private String name;
	private int price;
	
	public ProductVO(int pk, String name, int price) {
		this.pk = pk;
		this.name = name;
		this.price = price;
	}

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return this.pk + "번 " + this.name +" 상품 [" + this.price +"]원 입니다.";
	}
	
	
	
}
