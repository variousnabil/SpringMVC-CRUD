package com.nabil.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

import com.nabil.pojo.Feedback;

@Component
@RepositoryRestResource
public interface FeedbackDAO extends JpaRepository<Feedback, Integer>{
//	@Query("From Feedback order by name desc")
//	List<Feedback> findAllOrderByName();
}
