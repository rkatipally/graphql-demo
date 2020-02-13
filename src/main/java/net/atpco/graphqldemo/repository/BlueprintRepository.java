package net.atpco.graphqldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.atpco.graphqldemo.model.Blueprint;

public interface BlueprintRepository extends JpaRepository<Blueprint, Long> {
}
