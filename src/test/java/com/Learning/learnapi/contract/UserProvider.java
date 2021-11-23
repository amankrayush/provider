package com.Learning.learnapi.contract;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.loader.PactBrokerAuth;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import com.Learning.learnapi.data.UserRepository;
import com.Learning.learnapi.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Provider("User")
/*
@PactBroker(
        host = "${pactBroker.url:localhost}",
        port = "9293")

 */
@PactBroker(host = "pdeshpande.pactflow.io", scheme = "https",
        authentication = @PactBrokerAuth(scheme = "bearer", username = "W7TcLFaIApgUOYnCx66h4g", password = "catalyst"))
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserProvider {

    @LocalServerPort
    int port;

    @Autowired
    private UserRepository userRepository;

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void pactVerificationTestTemplate(PactVerificationContext context) {
        context.verifyInteraction();
    }

    @BeforeAll
    static void enablePublishingPact() {
        System.setProperty("pact.verifier.publishResults", "true");
    }

    @BeforeEach
    void before(PactVerificationContext context) {
        context.setTarget(new HttpTestTarget("localhost", port));
    }

    @State("user exists")
    public void validUserProvider() {
//        Optional<User> user = userRepository.findByEmail("rohan@gmail.com");
//        System.out.println("user details : " +user.orElse(null));
//        System.out.println("********************");
//        RestTemplate restTemplate = new RestTemplate();
//        User user1 = restTemplate.getForObject("http://localhost:" + port + "/getUser/rohan@gmail.com", User.class);
//        System.out.println("User1 : " + user1);
//        System.out.println("********************");
//        Map<String, String> requestParameter = new HashMap<>();
//        requestParameter.put("email", "rohan@gmail.com");
//
//        return requestParameter;
    }

}
