package Entities;

public class Customer {
	private String name;
	private String id;

	public Customer() {
		super();
	}

	public Customer(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Customer [id = " + id + ", name = " + name + "]";
	}
}
