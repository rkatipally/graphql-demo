package net.atpco.graphqldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.atpco.graphqldemo.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
