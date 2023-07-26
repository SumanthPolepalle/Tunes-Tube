import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SkipFunctionality {
	WebDriver driver;

	public SkipFunctionality(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='ytp-ad-skip-button-icon']")
	WebElement SkipButton;

	@FindBy(xpath = "//button[@aria-label='No thanks']")
	WebElement AlertsButton;

	public void ClickSkipButton() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(SkipButton));
			SkipButton.click();
			try {
				AlertsButton.click();
			} catch (Exception e) {
				System.out.println("No Alerts, Enjoy");
			}
		} catch (Exception e) {
			System.out.println("No Ads, Enjoy");
			try {
				AlertsButton.click();
			} catch (Exception ea) {
				System.out.println("No Alerts, Enjoy");
			}
		}
	}

	public void ClickSkipButtonLoop() {
		while (true)
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));
				wait.until(ExpectedConditions.elementToBeClickable(SkipButton));
				SkipButton.click();
			} catch (Exception e) {
			}
	}
}