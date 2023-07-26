import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SearchFunctionality {

	WebDriver driver;
	String Album;

	public SearchFunctionality(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Test(dataProvider = "getData", dataProviderClass = Starter.class)
	public void PlaylistProvider(String Album) {
		Album = this.Album;
	}

	@FindBy(xpath = "//input[@id='search']")
	WebElement SearchBox;

	@FindBy(id = "search-icon-legacy")
	WebElement SearchButton;

	@FindBy(xpath = "//button[@title='Full screen (f)']")
	WebElement MaximizeScreen;

	@FindBy(xpath = "//button[@aria-label='Shuffle playlist']")
	WebElement ShuffleButton;

	public void SearchMusic(String Album, String Artist) throws InterruptedException {
		SearchBox.sendKeys(Artist);
		Thread.sleep(3000);
		SearchButton.click();
		driver.findElement(By.xpath("//yt-formatted-string[text()='" + Artist + "']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Releases')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='" + Album + "']")).click();
		MaximizeScreen.click();
	}
}