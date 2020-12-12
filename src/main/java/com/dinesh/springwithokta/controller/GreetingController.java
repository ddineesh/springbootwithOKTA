package com.dinesh.springwithokta.controller;

import java.security.Principal;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GreetingController {

	
	/*
	 * The below 3 Variables need to be set in the environment variables so that spring security starter
	 * will get these values on start up by contacting OKTA
	 * OKTA_OAUTH2_CLIENT_ID= 
	 * OKTA_OAUTH2_CLIENT_SECRET= 
	 * OKTA_OAUTH2_ISSUER=
	 */
	
	@GetMapping("/")
	 public String helloWorld(Model model, @AuthenticationPrincipal OidcUser user) {
        model.addAttribute("name", user.getGivenName());
        return "hello-world";
    }

	
	
	/* The below code is used before OKTA when we use local web security configuration
	 * 
	 * 
	 * @GetMapping("/hello/{name}") public String
	 * greetingsMessage(@PathVariable(required = false) String name, Model model) {
	 * model.addAttribute("name", name); return "hello-world"; }
	 */

	
}
