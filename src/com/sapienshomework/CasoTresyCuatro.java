package com.sapienshomework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CasoTresyCuatro {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Caso  003 Verificar el carrito de compras y CP004 Verificar que los productos están cargando correctamente
		
		//Ruta de Webdriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\migue\\OneDrive\\Escritorio\\WebDrivers\\chromedriver.exe");
		
		//Instancia del navegador
		WebDriver customDriver = new ChromeDriver();
		
		//Ingreso a la página principal verificar nombre de página y Maximizar pantalla
		customDriver.get("https://winstoncastillo.com/robot-selenium/index.php?route=common/home");
		Assert.assertEquals(customDriver.getTitle(), "La tienda de Winston Castillo");
		customDriver.manage().window().maximize();
		
					
				//Obtener y comparar número de Items y precio
				System.out.println("El carrito tiene: " + " " + customDriver.findElement(By.id("cart-total")).getText() + " Puedes proceder");
				Assert.assertEquals(customDriver.findElement(By.id("cart-total")).getText(), "0 item(s) - $0.00");
				
				
				for (int Repeat = 1; Repeat < 4; Repeat++) {
					
							if(Repeat == 1 )
							
							{
								customDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[1]")).click();
								System.out.println("Producto n° "+ Repeat + " Agregado");
								Thread.sleep(2000);
								Repeat++;
							}
							if (Repeat == 2 )
							{
								customDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[3]/button[1]")).click();
								System.out.println("Producto n° "+ Repeat + " Agregado");
								Thread.sleep(2000);
								Repeat++;
							}
							if (Repeat == 3 )
							
							{
								customDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[3]/div/div[3]/button[1]")).click();
								System.out.println("Producto n° "+ Repeat + " Agregado");
								Thread.sleep(2000);
								Repeat++;
							}

					}
				
				
				
					//Verificar carrito
					customDriver.findElement(By.xpath("//*[@id=\"cart\"]/button")).click();
					Assert.assertTrue(customDriver.findElement(By.xpath("//*[@id=\"cart\"]/ul")).isEnabled());
					Assert.assertEquals(customDriver.findElement(By.id("cart-total")).getText(), "3 item(s) - $847.20");
					
					
					customDriver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong")).click();
					Assert.assertEquals(customDriver.getTitle(), "Shopping Cart");
					
					WebElement listaCarrito = customDriver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody"));
					List <WebElement> productosAgregados = listaCarrito.findElements(By.className("text-center"));
					Assert.assertEquals(productosAgregados.size(), 3);
					System.out.println("Número de productos diferentes agregados al carrito  :" + " " + productosAgregados.size());
				
					

	}

}
