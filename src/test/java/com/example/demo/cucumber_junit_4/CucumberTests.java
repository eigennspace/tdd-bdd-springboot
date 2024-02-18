package com.example.demo.cucumber_junit_4;

import com.example.demo.DemoApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

/***
 * @author : github.com/eigennspace
 * @since : Sat 17/02/2024 22:28
 * @Project : demo
 * @Created_by : IdeaU
 */

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@SpringBootTest(classes = {DemoApplication.class, CucumberTests.class},
                webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberOptions(plugin = "pretty", tags = "", features = "src/test/resources/features")
@AutoConfigureMockMvc
public class CucumberTests {
}
