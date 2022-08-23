package models;

public class Product {
	
	private Integer id;
	private String name;
	private Double price;
	private String description;
	private String resumedDescription;
	private String imageUri;
	
	public Product() {}
	
	public Product(Integer id, String name, Double price, String description, String imageUri) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imageUri = imageUri;
		this.resumedDescription = this.description;

	}
	
	public Product(String name, Double price, String description, String imageUri) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.imageUri = imageUri;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImageUri() {
		return imageUri;
	}
	
	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}
	
	public String getResumedDescription() {
				
		if(this.resumedDescription.length() > 50) {
			return this.resumedDescription.substring(0, 50) + "...";
		}
		
		return this.resumedDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
