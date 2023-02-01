package Cuisine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public abstract class Plat {
	private int id;
	private String name;
	private int number;

	public Plat(int id, String name, int number) {
		this.id = id;
		this.name = name;
		this.number = number;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [id=" + id + ", name=" + name + ", number=" + number + "]";
	}
}
