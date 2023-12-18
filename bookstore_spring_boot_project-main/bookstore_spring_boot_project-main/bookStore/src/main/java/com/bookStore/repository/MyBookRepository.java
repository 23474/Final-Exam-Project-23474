package com.bookStore.repository;

import com.bookStore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookStore.entity.MyBookList;

import java.util.List;

@Repository
public interface MyBookRepository extends JpaRepository<MyBookList,Integer>{

}
