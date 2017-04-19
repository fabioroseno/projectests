package com.teste.threads;

public class Programa implements Runnable {

	private int id;
	
	public Programa(int id) {
		this.id = id;
	}

	public void run() {
		System.out.println("Programa " + id);
		for (int i = 0; i <= 10000; i++) {
			System.out.print(i + " - ");
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}