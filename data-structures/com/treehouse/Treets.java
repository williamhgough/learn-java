package com.treehouse;

import java.io.*;

public class Treets {
	public static void save(Treet[] treets) {
		try (
			FileOutputStream fos = new FileOutputStream("treets.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		) {
			oos.writeObject(treets);
		} catch (IOException e) {
			System.out.printf("Problem saving Treets: %s%n", e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static Treet[] load() {
		Treet[] treets = new Treet[0];
		try (
			FileInputStream fis = new FileInputStream("treets.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
		) {
			treets = (Treet[]) ois.readObject();
		} catch (IOException e) {
			System.out.printf("Error reading file: %s%n", e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.printf("Error loading Treets: %s%n", c.getMessage());
		}
		return treets;
	}
}