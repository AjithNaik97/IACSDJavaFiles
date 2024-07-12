package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.Category;
import com.app.entity.Railway;

public interface RailwayRepository extends JpaRepository<Railway, Long> {
	@Query("select r from Railway r where r.cat=:category")
	List<Railway> searchByCat(@Param("category") Category category);
}