package Cuisine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public abstract class Plat {
	private int id;
	private String name;
	private int qty;

	public Plat(int id, String name, int number) {
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [id=" + id + ", name=" + name + ", qty=" + qty + "]";
	}
}
