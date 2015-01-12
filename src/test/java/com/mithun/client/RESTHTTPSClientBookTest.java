package com.mithun.client;

import java.util.List;

import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import junit.framework.TestCase;

import org.glassfish.jersey.SslConfigurator;

import com.mithun.model.Book;

public class RESTHTTPSClientBookTest extends TestCase {

	private Client client;
	private WebTarget target;
	
	
	@Override
	protected void setUp() throws Exception {
		System.out.println("Calling setup");
		//client = ClientBuilder.newClient();
		
		SslConfigurator sslConfig = SslConfigurator.newInstance()
				.trustStoreFile("/Users/mithundas/Development/tools/apache-tomcat-7.0.55/conf/tomcatcertstore")
				.trustStorePassword("tomcat")
				.keyStoreFile("/Users/mithundas/Development/tools/apache-tomcat-7.0.55/conf/tomcatcertstore")
		        .keyPassword("tomcat");
		 
		SSLContext sslContext = sslConfig.createSSLContext();
		client = ClientBuilder.newBuilder().sslContext(sslContext).build();
		
		javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
			    new javax.net.ssl.HostnameVerifier(){
			 
			        public boolean verify(String hostname,
			                javax.net.ssl.SSLSession sslSession) {
			            if (hostname.equals("localhost")) {
			                return true;
			            }
			            return false;
			        }
			    });
		
		target = client.target("https://localhost:8443/RESTJersey/webapi");
		super.setUp();
	}
	
	public void testSuccessGetBookById() {
		Response response = target.path("book/1234/response")
				.queryParam("j_username", "temporary2")
				.queryParam("j_password", "temporary")
				.request(MediaType.APPLICATION_JSON).get();
		System.out.println("Response code :"+response.getStatus());
		System.out.println("Status message:"+response.getStatusInfo().getReasonPhrase());
		
		Book book = response.readEntity(Book.class);
		System.out.println(book);
		assertNotNull(book);
	}
	
	public void test404NotFoundGetBookById() {
		Response response = target.path("book/123/response")
				.request(MediaType.APPLICATION_JSON).get();
		System.out.println("Response code :"+response.getStatus());		
		assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
	}
	
	public void testSuccessGetAllBooks() {
		Response response = target.path("book/all")
				.request(MediaType.APPLICATION_JSON).get();
		List<Book> books = response.readEntity(new GenericType<List<Book>>(){});
		System.out.println("Response code :"+response.getStatus());
		System.out.println("Status message:"+response.getStatusInfo().getReasonPhrase());
		System.out.println("No of books: "+books.size());
		assertNotNull(books);
		assertTrue(books.size()>0);
	}

	public void testSuccessCreate() {
		
		Book input = new Book();
		input.setTitle("Maven");
		input.setNoOfPages(45);
		
		Response response = target.path("book/create")
				.request(MediaType.APPLICATION_JSON).
				post(Entity.entity(input, MediaType.APPLICATION_JSON));
		
		System.out.println("Response code :"+response.getStatus());		
		
		Book output = response.readEntity(Book.class);			
		assertNotNull(output);
		
		System.out.println("Title:"+output.getTitle());
		System.out.println("Pages:"+output.getNoOfPages());
		
		assertTrue("Maven".equals(output.getTitle()));
	}
	
}
