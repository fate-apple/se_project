package com.hieucao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hieucao.model.Book;
import com.hieucao.model.Category;
import com.hieucao.model.BookRepository;
import com.hieucao.model.CategoryRepository;
import com.hieucao.model.User;
import com.hieucao.model.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository catrepository, UserRepository urepository) {
		return (args) -> {
			log.info("Save some books");
			catrepository.save(new Category("Fiction"));
			catrepository.save(new Category("Drama"));
			catrepository.save(new Category("Adventure"));
			catrepository.save(new Category("Textbook"));
			
			repository.save(new Book("The Light Between Oceans", "M.L. Stedman", "978-1501127977", 7.56, catrepository.findByName("Fiction").get(0)));
			repository.save(new Book("The Nightingale", "Kristin Hannah", "978-0312577223", 13.99, catrepository.findByName("Drama").get(0)));
			
			
			//users: admin/admin & user/user
			User user1 = new User("user",
					"$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@bookstore.fi", "USER");
			User user2 = new User("admin",
					"$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@bookstore.fi", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("Fetch books");
			for (Book book: repository.findAll()){
				log.info(book.toString());
			}
		};
	}
}
