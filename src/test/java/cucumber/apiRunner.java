package cucumber;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"stepDef"},
        features = {"src/test/java/features/"},
        tags = "@api",
        plugin = {"pretty", "html:reports/api-reports.html", "json:reports/api-reports.json"}
)
public class apiRunner {
}
