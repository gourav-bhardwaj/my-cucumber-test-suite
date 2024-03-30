package com.sp.test.steps;

import com.sp.test.config.CommonConfig;
import com.sp.test.model.GreetingRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;

@Slf4j
public class GreetingsStepDefinitions {

    @Autowired
    CommonConfig config;

    @Value("${greeting.endpoint}")
    String greetingEndpoint;

    GreetingRequest request;

    String response;

    @Given("Create a greeting request object with {string}, {string} and {string}")
    public void createGreetingRequestObject(String greeting, String name, String message) {
        this.request = GreetingRequest.builder().greeting(greeting).name(name).message(message)
                .build();
    }

    @When("Call the greetings endpoint and fetch the result")
    public void callGreetingAPI() {
       this.response = config.restClient.post().uri(greetingEndpoint)
               .body(request)
               .contentType(MediaType.APPLICATION_JSON).retrieve().body(String.class);
       log.info("Response: {}", this.response);
    }

    @Then("Validate the result is expected or not")
    public void validateGreetingResponse() {
        String msg = request.getGreeting()
                .concat(" - ").concat(request.getName().toUpperCase())
                .concat(" - ").concat(request.getMessage());
        Assert.assertNotNull(this.response);
        Assert.assertEquals(this.response, msg);
    }

}
