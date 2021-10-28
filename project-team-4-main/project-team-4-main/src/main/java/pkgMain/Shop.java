package pkgMain;

public class Shop {
	public String name;
	public String address;
	public String phone;
	public int rating;
	
	public Shop(String name, String address, String phone, int rating) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.rating = rating;
	}

	public String rateToStars() {
		String stars = "";
		for(int i=0;i<rating;i++) {
			stars=stars+"*";
		}
		return stars;
	}
	
	
	
	
}
