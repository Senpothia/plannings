package com.michel.plannings.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.plannings.models.Suite;

public interface SuiteRepository extends JpaRepository<Suite, Integer> {

}
