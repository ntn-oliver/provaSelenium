package pages;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Metodos extends Browser {

	public void clicar(By elemento) {
/**
 * Metodo para clicar 
 * @author Natan
 * @param elemento
 */
		try {
			driver.findElement(elemento).click();
		} catch (Exception e) {
			System.err.println("-------- erro ao ao clicar -------- " + e.getMessage());
			System.err.println("-------- causa do erro -------- " + e.getCause());
		}
	}

	public void escrever(By elemento, String texto) {
		
		/**
		 * Metodo para escrever
		 * @param elemento
		 * @param texto
		 * @author Natan
		 */
		try {
			
			driver.findElement(elemento).sendKeys(texto);
		} catch (Exception e) {
			System.err.println("-------- erro ao escrever -------- " + e.getMessage());
			System.err.println("-------- causa do erro -------- " + e.getCause());
		}
	}
	
	
	public void scrolUp() {
		/**
		 * Metodo para dar page up a fim de visualizar o que est� no topo dela
		 * @author Natan
		 */
		 try {

			 JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		} catch (Exception e) {
			
			System.err.println("-------- erro ao dar scrol Up -------- " + e.getMessage());
			System.err.println("-------- causa do erro -------- " + e.getCause());
		}
		 
	}
	
	public void validarTexto() {
		/**
		 * Metodo para validar o texto que aparece ao concluir o envio da cota��o
		 * @author natan
		 */
		try {
			
			String textoElement = driver.findElement(By.xpath("/html/body/div[4]/h2")).getText();
	        assertEquals("Sending e-mail success!", textoElement);
	        System.out.println("Texto validado com sucesso");
		} catch (Exception e) {
			
			System.err.println("-------- erro ao validar texto -------- " + e.getMessage());
			System.err.println("-------- causa do erro -------- " + e.getCause());
			
		}
	}
	
	public void screenShot(String nomeEvidencia) {
		/**
		 * Metodo para tirar evid�ncia ap�s sucesso no envio da cota��o
		 * Para visualizar o print da tela, atualizar o projeto (refresh)  e abrir a pasta evid�ncias
		 * @author natan
		 */
		try {
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./evidencias/" + nomeEvidencia + ".png");
			FileUtils.copyFile(scrFile, destFile);

		} catch (Exception e) {
			System.err.println("----------Erro ao tirar evidencia-----------" + e.getMessage());
			System.err.println("----------Causa do erro-------------" + e.getCause());
		}
	}
	
	public void esperar() {
		try {
			
			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {
			
			System.err.println("----------Erro ao esperar-----------" + e.getMessage());
			System.err.println("----------Causa do erro-------------" + e.getCause());
		}
	
	}
	
	public void esperarElementoClicavel(By elemento, int tempo) {
		
		try {
	WebDriverWait wait = new WebDriverWait(driver, tempo);
	wait.until(ExpectedConditions.elementToBeClickable(elemento));
	
	
		}catch (Exception e) {
			System.err.println("----------Erro ao esperar o elemento ser clicavel -----------"+e.getMessage());
			System.err.println("----------Causa do erro-------------"+e.getCause());
		}

	}
	
	
}
