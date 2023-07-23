import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloseFunctionality {
	WebDriver driver;

	public CloseFunctionality(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-title-no-tooltip='Replay']")
	WebElement ReplayButton;

	public void ClickCloseButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofHours(10));
		wait.until(ExpectedConditions.visibilityOf(ReplayButton));
		driver.close();
	}
}
