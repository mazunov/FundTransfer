package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class FundTransferStepDefs {
    protected WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","D:\\drivers\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("the user is on Fund Transfer Page")
    public void the_user_is_on_fund_transfer_page() {
        driver.get("http://cookbook.seleniumacademy.com/fundTransfer.html");
    }

    @When("^he enters (.*) as payee name$")
    public void he_enters_jim_as_payee_name(String payeeName) {
        driver.findElement(By.id("payee")).sendKeys(payeeName);
    }

    @And("^he enters (.*) as amount$")
    public void he_enters_as_amount(String amount) {
        driver.findElement(By.id("amount")).sendKeys(amount);
    }

    @And("he submits request for Fund Transfer")
    public void he_submits_request_for_fund_transfer() {
        driver.findElement(By.id("transfer")).click();
    }


    @Then("^ensure a transaction failure (.*) is displayed$")
    public void ensureATransactionFailureMessageIsDisplayed(String msg) {
        WebElement message = driver.findElement(By.id("message"));
        assertEquals(message.getText(), msg);
    }

    @Then("^ensure the fund transfer is complete with (.*) message$")
    public void ensure_the_fund_transfer_is_complete_with_$_transferred_successfully_to_jim_message(String msg) {
        WebElement message = driver.findElement(By.id("message"));
        assertEquals(message.getText(), msg);
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
