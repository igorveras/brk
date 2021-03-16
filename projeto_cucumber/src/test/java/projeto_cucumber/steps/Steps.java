package projeto_cucumber.steps;

import static projeto_cucumber.steps.Utils.click;
import static projeto_cucumber.steps.Utils.setText;
import static projeto_cucumber.steps.Utils.validateObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.sukgu.Shadow;

public class Steps {

	WebDriver driver;
	
	@Before
	public void before() {
		
		String projectPath = System.getProperty("user.dir");
		String pathChromeDriver = projectPath + "\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", pathChromeDriver);
		
	}
	
	@After
	public void after() {
		
		System.out.println("FECHANDO BROWSER...");
		driver.quit();
		
	}

	@Given("que acesse o site da BRK ambiental")
	public void que_acesse_o_site_da_brk_ambiental() {
	
		System.out.println("INICIANDO O BROWSER...");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://minhabrk.com.br");
		
	}

	@And("clicar em ENCONTRAR SUA CIDADE")
	public void clicar_em_encontrar_sua_cidade() throws InterruptedException {
		
		Shadow shadow = new Shadow(driver);
		WebElement selecionarCidade = shadow.findElement("acn-button.button");
		click(driver, selecionarCidade);
		
	}

	@And("selecionar o estado de {string}")
	public void selecionar_o_estado_de(String estado) {
		
		//NÃO ENCONTREI A POSSIBILIDADE DE INSERIR O ESTADO
		
	}

	@When("selecionar a cidade de {string}")
	public void selecionar_a_cidade_de(String cidade) {
		
		Shadow shadow = new Shadow(driver);
		WebElement textCidade = shadow.findElement("input[placeholder='Digite o nome da cidade']");
		setText(driver, textCidade, cidade);
		WebElement option = shadow.findElement("acn-form-auto-complete > acn-form-select-option[class = 'hydrated']");
		click(driver, option);
		WebElement confirmaCidade = driver.findElement(By.xpath("//acn-button"));
		click(driver, confirmaCidade);
		
	}

	@When("fechar o quadro de aviso")
	public void fechar_o_quadro_de_aviso() {
		
		//NÃO FOI EXIBIDO NENHUM QUADRO DE AVISO
		
	}

	@Then("validar a mensagem da cidade {string}")
	public void validar_a_mensagem_da_cidade(String cidade) {
		
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Você está em:')]")));
		
		WebElement mensagemCidade = driver.findElement(By.xpath("//span[contains(text(), 'Você está em:')]"));
		WebElement cidadeSelecionada = driver.findElement(By.xpath("//span[contains(text(), '" + cidade + "')]"));
		
		validateObject(driver, mensagemCidade);
		validateObject(driver, cidadeSelecionada);
		
	}
	
}
