package com.example.onetomany.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onetomany.model.Parent;

public interface ParentRepo extends JpaRepository<Parent,Long>{

}
