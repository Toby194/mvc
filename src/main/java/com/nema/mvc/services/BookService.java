package com.nema.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nema.mvc.models.Book;

@Service
public class BookService {
	private final BookRespository bookRepository;

	public BookService(BookRespository bookRepository) {
		this.bookRepository = bookRepository;

	}

	// returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

	// creates a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}

	// retrieves a book
	public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Optional<Book> optionalBook = bookRepository.findById(id);
        Book newBook = optionalBook.get();
        newBook.setTitle(title);
        newBook.setDescription(desc);
        newBook.setLanguage(lang);
        newBook.setNumberOfPages(numOfPages);
        return bookRepository.save(newBook);
    }
	
	// update a book ()
    public Book updateBook(Book book) {
    	return bookRepository.save(book);
    }
	
	 // delete a book
 	@RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
 	public String deleteBook(@PathVariable("id") Long id) {
 	    bookRepository.deleteById(id);
 	    return "redirect:/books";
 	
    }

}찀