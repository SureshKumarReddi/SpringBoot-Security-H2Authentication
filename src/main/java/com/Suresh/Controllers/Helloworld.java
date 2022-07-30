package com.Suresh.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld {

	@GetMapping("/home")
	public String getHome() {
		return "<h1>This is HomePage </h1>";
	}
	
	@GetMapping("/loan")
	public String getLoan() {
		return "<h3>This is LoanPage </h3>";
	}
	
	@GetMapping("/balance")
	public String getBalance() {
		return "<h3>This is BalancePage </h3>";
	}
	
	@GetMapping("/statement")
	public String getStatement() {
		return "<h3>This is StatementPage </h3>";
	}
	
	@GetMapping("/contact")
	public String getContact() {
		return "<h3>This is ContactPage </h3>";
	}
}
