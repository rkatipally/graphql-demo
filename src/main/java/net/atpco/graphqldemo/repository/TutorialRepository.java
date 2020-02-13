package net.atpco.graphqldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.atpco.graphqldemo.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}