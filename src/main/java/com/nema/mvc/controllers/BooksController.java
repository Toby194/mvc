package com.nema.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nema.mvc.models.Book;
import com.nema.mvc.services.BookService;

@Controller
public class BooksController {
	private final BookService bookService;
	
	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/boooks")
	public String index(Model model) {
			List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";

	}

	@RequestMapping("/books/new")
public String newBook(@ModelAttribute("book") Book book) {
		return "books.jsp";
	}
	
	@RequestMapping(value="/books", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "books.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books";
			
		}
	}
	@RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}
}