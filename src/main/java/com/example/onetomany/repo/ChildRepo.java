package com.example.onetomany.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onetomany.model.Child;

public interface ChildRepo extends JpaRepository<Child, Long>{

}
