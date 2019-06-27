package com.sia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.ServletException;

import org.json.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sia.utilities.ProcessData;

@SpringBootApplication
@RestController
public class SiaMsEiAesApplication {
	public static Connection conn; // Cloud SQL connection
	static String url = "";

	static {
		try {
			url = System.getProperty("cloudsql");
			try {
				if(conn == null)
					conn = DriverManager.getConnection(url);								
			} catch (SQLException e) {
				throw new ServletException("Unable to connect to SQL server", e);
			}			
		} catch (Exception e) {
			System.out.println("Bloque de inicializacion error:" + e.getMessage());
		} finally {
			// Nothing really to do here.
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(SiaMsEiAesApplication.class, args);
	}

	/*
	@GetMapping("/")
	public String hello() {
		String response = "Hola desde Spring Boot url=" + this.url;
		try {
			PreparedStatement ps = conn.prepareStatement("select texto from prueba");
			JSONArray result = new ProcessData().toJSONArray(ps);
			response = result.toString();
		} catch(Exception e) {
			response = e.getMessage();
		}
		return response;
	}

	@GetMapping("/time")
	public String time() {
		return Calendar.getInstance().getTime().toString();
	}*/
}
