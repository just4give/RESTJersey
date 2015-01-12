package com.mithun.client;

import org.glassfish.jersey.internal.util.Base64;



public class Base64Test {

	public static void main(String[] args) {
		System.out.println("Encode:"+new Base64().encode("user:user".getBytes()));
		System.out.println("Decode:"+new Base64().decode("dXNlcjp1c2Vy".getBytes()));
		
	}

}
