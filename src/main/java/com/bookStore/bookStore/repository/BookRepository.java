package com.bookStore.bookStore.repository;

import com.bookStore.bookStore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "select * from bag_table s where s.type like %:keyword%", nativeQuery = true)
    List<Book> findBooksByKeyword(@Param("keyword") String keyword);


}
