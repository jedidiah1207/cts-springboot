package com.example.azure.springsecurityazure.models;

import lombok.Data;

@Data
public class TokenDetails{
	private String credentialType;
	private String environment;
	private String clientId;
	private String realm;
	private String secret;
	private String homeAccountId;
}