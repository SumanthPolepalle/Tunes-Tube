import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Starter {
	String Artist = "The Weeknd";

	@DataProvider
	public String[] getData() {
		String Album[] = { "Dawn FM (Alternate World)" };
		return Album;
	}

	@Test(dataProvider = "getData")
	public void Start(String Album) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		SearchFunctionality sf = new SearchFunctionality(driver);
		sf.SearchMusic(Album, Artist);
		SkipFunctionality skp = new SkipFunctionality(driver);
		skp.ClickSkipButton();
		skp.ClickSkipButtonLoop();
	}
}