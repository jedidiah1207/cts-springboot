package com.example.azure.springsecurityazure.validation;
import com.microsoft.aad.msal4j.ClientCredentialFactory;
import com.microsoft.aad.msal4j.ConfidentialClientApplication;
import com.microsoft.aad.msal4j.IAuthenticationResult;

import java.net.URI;
import java.util.Collections;
import java.util.Set;

// ...
import org.springframework.stereotype.Component;

@Component
public class Msal {
    // Create an instance of the MSAL ConfidentialClientApplication using your Azure AD configuration
    ConfidentialClientApplication app = ConfidentialClientApplication.builder("f17a0992-6158-4f51-9427-02d079069634", ClientCredentialFactory.createFromSecret("ZxR8Q~weGayZ6_L5zm42GJP5u~iOTLn5KcXbQbj6"))
            .authority("https://login.microsoftonline.com/7b2fa4e2-9c83-4edf-82bc-a68adb3c3b09")
            .build();

    // Extract the access token from the request header or any other location
    String accessToken = extractAccessTokenFromRequest();

try {
        // Call the token introspection endpoint to validate the access token
        IAuthenticationResult result = app.validateToken(Collections.singleton("fc5aea5e-989b-475b-b891-aedd6592a5a7"), accessToken).get();

        // Check the validation result
        if (result.getAuthenticationStatus().equals(AuthenticationStatus.SUCCESS)) {
            // Access token is valid, allow the request to proceed to your actual application
            // Perform any necessary business logic here
        } else {
            // Access token is invalid or expired, return an error response to the client
            // Optionally, you can redirect the user to authenticate again
        }
    } catch (Exception e) {
        // Handle any exceptions that occur during the validation process
    }
    }
