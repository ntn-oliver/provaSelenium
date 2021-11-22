package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	
	static protected WebDriver driver;

public void abrirNavegador(String navegador, String site) {
	/**
	 * Metodo para abrir o navegador 
	 * @param navegador
	 * @param site
	 */
		
		try {
			if(navegador.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			}else if(navegador.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}else if(navegador.equalsIgnoreCase("edge")) {
				
				System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
				driver = new EdgeDriver();
			}
			driver.get(site);
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.err.println("-------- erro ao abrir navegedor -------- " + e.getMessage());
			System.err.println("-------- causa do erro -------- " + e.getCause());
		}
	}

	public void fecharNavegador() {
		
		/**
		 * Metodo para fechar o navegador
		 */
		try {
			driver.quit();
		} catch (Exception e) {
			System.err.println("-------- erro ao fechar navegedor -------- " + e.getMessage());
			System.err.println("-------- causa do erro -------- " + e.getCause());
		}

	}

}
