package com.velan.restapp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AddTest {
	
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeEach
	void setUp() {
		 driver = new ChromeDriver();
		 js = (JavascriptExecutor) driver;
		 vars = new HashMap<String, Object>();
		}
	
	@AfterEach
    void tearDown() {
	 driver.quit();
	}
	

	@Test
	void addPropertySuccess() {
	 driver.get("http://localhost:3000/add");
	 driver.findElement(By.name("address")).click();
	 driver.findElement(By.name("address")).sendKeys("Perumal Kovil Street,Nilakkottai");
	 driver.findElement(By.name("type")).click();
	 driver.findElement(By.name("type")).sendKeys("Apartment");
	 driver.findElement(By.name("status")).click();
	 driver.findElement(By.name("status")).sendKeys("Sale");
	 driver.findElement(By.name("submit")).click();
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
	    assertEquals("Property added Successfully", txt);
	}

	@Test
	void addPropertyFailure1() {
	 driver.get("http://localhost:3000/add");
	 driver.findElement(By.name("address")).click();
	 driver.findElement(By.name("address")).sendKeys("");
	 driver.findElement(By.name("type")).click();
	 driver.findElement(By.name("type")).sendKeys("Apartment");
	 driver.findElement(By.name("status")).click();
	 driver.findElement(By.name("status")).sendKeys("Sale");
	 driver.findElement(By.name("submit")).click();
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
	    assertEquals("Please enter Property Address !!!",txt);
	}

	@Test
	void addPropertyFailure2() {
	 driver.get("http://localhost:3000/add");
	 driver.findElement(By.name("address")).click();
	 driver.findElement(By.name("address")).sendKeys("Perumal Kovil Street,Nilakkottai");
	 driver.findElement(By.name("type")).click();
	 driver.findElement(By.name("type")).sendKeys("");
	 driver.findElement(By.name("status")).click();
	 driver.findElement(By.name("status")).sendKeys("Sale");
	 driver.findElement(By.name("submit")).click();
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
	    assertEquals("Please enter Property type !!!", txt);
	}

	@Test
	void addPropertyFailure3() {
	 driver.get("http://localhost:3000/add");
	 driver.findElement(By.name("address")).click();
	 driver.findElement(By.name("address")).sendKeys("Perumal Kovil Street,Nilakkottai");
	 driver.findElement(By.name("type")).click();
	 driver.findElement(By.name("type")).sendKeys("Apartment");
	 driver.findElement(By.name("status")).click();
	 driver.findElement(By.name("status")).sendKeys("");
	 driver.findElement(By.name("submit")).click();
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
	    assertEquals("Please enter Property Status !!!",txt);
	}

}

