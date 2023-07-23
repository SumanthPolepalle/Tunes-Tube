import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchFunctionality {

	WebDriver driver;

	public SearchFunctionality(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='search']")
	WebElement SearchBox;;
	@FindBy(id = "search-icon-legacy")
	WebElement SearchButton;

	@FindBy(xpath = "//yt-formatted-string[text()='Sumanth Polepalle']")
	WebElement ChannelName;

	@FindBy(xpath = "//a[@title='Co-Working Playlist Curated By Sumanth Polepalle']")
	WebElement PlaylistName;

	@FindBy(xpath = "//button[@title='Full screen (f)']")
	WebElement MaximizeScreen;

	public void SearchMusic(String PlaylistCurator) throws InterruptedException {
		SearchBox.sendKeys(PlaylistCurator);
		Thread.sleep(3000);
		SearchButton.click();
		ChannelName.click();
		PlaylistName.click();
		MaximizeScreen.click();
	}
}
