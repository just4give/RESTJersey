package com.mithun.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mithun.model.Book;

import junit.framework.TestCase;

public class RESTClientBookTest extends TestCase {

	private Client client;
	private WebTarget target;
	
	
	@Override
	protected void setUp() throws Exception {
		System.out.println("Calling setup");
		client = ClientBuilder.newClient();
		target = client.target("http://localhost:8080/RESTJersey/webapi");
		super.setUp();
	}
	
	
//	public void testSuccessGetBookById() {
//		Response response = target.path("book/1234/response?j_username=temporary&j_password=temporary")
//				.request(MediaType.APPLICATION_JSON).get();
//		System.out.println("Response code :"+response.getStatus());
//		Book book = response.readEntity(Book.class);
//		System.out.println(book);
//		assertNotNull(book);
//	}

//	public void test404NotFoundGetBookById() {
//		Response response = target.path("book/123/response")
//				.request(MediaType.APPLICATION_JSON).get();
//		System.out.println("Response code :"+response.getStatus());		
//		assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
//	}
	
	public void testSuccessGetAllBooks() {
		Response response = target.path("book/all")
				.request(MediaType.APPLICATION_JSON).get();
		//List<Book> books = response.readEntity(new GenericType<List<Book>>(){});
		System.out.println("Response code(all books) :"+response.getStatus());		
		//System.out.println("No of books: "+books.size());
		//assertNotNull(books);
		//assertTrue(books.size()>0);
	}

//	public void testSuccessCreate() {
//		
//		Book input = new Book();
//		input.setTitle("Maven");
//		input.setNoOfPages(45);
//		
//		Response response = target.path("book/create")
//				.request(MediaType.APPLICATION_JSON).
//				post(Entity.entity(input, MediaType.APPLICATION_JSON));
//		
//		System.out.println("Response code :"+response.getStatus());		
//		
//		Book output = response.readEntity(Book.class);			
//		assertNotNull(output);
//		
//		System.out.println("Title:"+output.getTitle());
//		System.out.println("Pages:"+output.getNoOfPages());
//		
//		assertTrue("Maven".equals(output.getTitle()));
//	}
	
}
