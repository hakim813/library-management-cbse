package com.libmanage.repo;

import com.libmanage.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepo extends MongoRepository<Book, String> {
    @Query("{ 'title': { $regex: ?0, $options: 'i' }}")
    List<Book> findByTitleContainingIgnoreCase(String title);
}