package com.mithun.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mithun.model.Author;
import com.mithun.model.Book;
import com.mithun.repository.BookRepositoryStub;
import com.mithun.repository.IBookRepository;


@Path("/book")
public class BookResource {
	
	private IBookRepository bookRepository = new BookRepositoryStub();

	@Path("/get")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getBookName(){
		return "Got it!";
	}
	
	
	@Path("/all")
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Book> getAllBooks(){
		return bookRepository.getAllBooks();
		
	}
	
	/*
	 * http://localhost:8080/RESTJersey/webapi/book/1234
	 * Example of PathParam
	 * Produces XML or JSON based on "accept" header type
	 */
	@Path("/{id}")
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		
	public Book getBookById(@PathParam("id") String id){
		System.out.println("Book ID Searched : "+id);
		return bookRepository.getBookById(id);
		
	}
	
	
	
	
	/*
	 * http://localhost:8080/RESTJersey/webapi/book/1234
	 * Example of PathParam
	 * Produces XML or JSON based on "accept" header type
	 * Return type is Response which makes client error handling easy
	 */
	@Path("/{id}/response")
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		
	public Response getBookByIdWithResponse(@PathParam("id") String id){
		System.out.println("Book ID Searched : "+id);
		if(id == null || id.length()<4){
			System.out.println("Returning 404 Not Found");
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		List<Author> authors= new ArrayList<Author>();
		Author author1 = new Author();
		author1.setAuthorName("Author-1");
		
		Author author2 = new Author();
		author2.setAuthorName("Author-2");
		
		authors.add(author1);
		authors.add(author2);
		
		Book book = bookRepository.getBookById(id);
		book.setAuthors(authors);
		
		return Response.status(Response.Status.OK).entity(book).build();
		
	}
	
	
	
	/*
	 * http://localhost:8080/RESTJersey/webapi/book/search?title=Spring
	 * Example of PathParam
	 * Produces XML or JSON based on "accept" header type
	 */
	@Path("/search")
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		
	public Book getBookByTitle(@QueryParam("title") String title){
		System.out.println("Book Title Searched : "+title);
		return bookRepository.getBookByTitle(title);
		
	}
	
	/*
	 * http://localhost:8080/RESTJersey/webapi/book/create
	 * Pass JSON data as {"noOfPages": 101,"title": "AOP3"}
	 */
	
	
	@Path("/create")
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response create(Book book){
		System.out.println("Create Book is called :"+book);
		if(book == null || book.getNoOfPages()== -1){
			System.out.println("Returning 400 Bad Request");
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		book.setNoOfPages(101);
		return Response.status(Response.Status.OK).entity(book).build();
	}
}
