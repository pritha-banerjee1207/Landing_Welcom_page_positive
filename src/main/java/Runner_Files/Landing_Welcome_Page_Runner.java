package Runner_Files;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src\\main\\java\\Landing_Welcome_Page\\Landing_welcome_positive.feature",
		glue= {"Landing_Welcome_Page"},
		monochrome = true,publish = true)

public class Landing_Welcome_Page_Runner extends AbstractTestNGCucumberTests{

}
