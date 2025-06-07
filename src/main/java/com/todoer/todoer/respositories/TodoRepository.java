package com.todoer.todoer.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoer.todoer.models.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
