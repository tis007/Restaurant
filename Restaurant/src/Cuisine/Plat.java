package Cuisine;

public abstract class Plat {
	private int id;
	private String description;
	private int qty;

	public Plat(int id, String name, int number) {
		this.id = id;
		this.description = name;
		this.qty = number;
	}

	public void rmQty(int nbr) {
		qty -= nbr;
	}

	public int getQty() {
		return qty;
	}

	public int getId() {
		return id;
	}
	
	public String description() {
		return "id=" + id + "\n" + "name=" + description + "\n" + "qty=" + qty + "\n";
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [id=" + id + ", name=" + description + ", qty=" + qty + "]";
	}
}
