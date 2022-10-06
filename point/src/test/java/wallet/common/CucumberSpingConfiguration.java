package wallet.common;


import wallet.PointApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { PointApplication.class })
public class CucumberSpingConfiguration {
    
}
