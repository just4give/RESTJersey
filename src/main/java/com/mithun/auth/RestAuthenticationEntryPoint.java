package com.mithun.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component( "restAuthenticationEntryPoint" )
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint{
 
   public void commence(HttpServletRequest request,
		HttpServletResponse response, AuthenticationException authException)
		throws IOException, ServletException {
	   System.out.println("Inside restAuthenticationEntryPoint");
	   //response.sendError( HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized" );
	
}
}
