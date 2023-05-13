package com.example.azure.springsecurityazure.controller;

import com.azure.core.annotation.Get;
import com.example.azure.springsecurityazure.models.TokenDetails;
import com.example.azure.springsecurityazure.validation.Msal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import java.security.Principal;
import java.util.Map;
@RestController
@CrossOrigin
public class HelloController{
//    @GetMapping({"/group1", ""})
//    @PreAuthorize("hasRole('APPROLE_group1')")
//    public String group1(){
//        return "Hello Group1 users";
//    }
//    @GetMapping("/group2")
//    @PreAuthorize("hasRole('ROLE_group2')")
//    public String group2(){
//        return "Hello Group2 users";
//    }
    @Autowired
   private Msal msal;
@PostMapping("/hello")
public String myApi(@RequestBody TokenDetails tokenDetails ){

    System.out.println(tokenDetails.getSecret());
     String token= tokenDetails.getSecret();

    //String message = requestBody.get("message");
//    String username = principal.;
    // Perform any necessary business logic using the authenticated user's username and the message
    return " You sent the message: " + tokenDetails.getSecret();
}
    @GetMapping("/secretParams")
    public String secretParam(@RequestParam String secret){

        //String message = requestBody.get("message");
//    String username = principal.;
        // Perform any necessary business logic using the authenticated user's username and the message
        return " You sent the message: " + secret;
    }

}
