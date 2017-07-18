package com.test;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@RepositoryRestResource
public interface BookRepository extends MongoRepository<Book,Integer>{

}
