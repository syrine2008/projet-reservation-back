package com.example.tpSpring.singleton;

import java.sql.*;

public class Singleton {

	private static Singleton instance;
	private static Connection connection;

	private Singleton() {
	}

	public static Singleton getInstance() {

		if (instance == null) {
			String url = "jdbc:mysql://localhost:3306/reservation";
			String utilisateur = "root";
			try {
				connection = DriverManager.getConnection(url, utilisateur, "");
			} catch (SQLException e) {
				e.printStackTrace();
			}

			instance = new Singleton();
		}

		return instance;
	}

	public Connection getConnection() {
		return connection;
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
