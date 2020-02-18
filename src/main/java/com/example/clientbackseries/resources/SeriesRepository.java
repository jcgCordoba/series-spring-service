package com.example.clientbackseries.resources;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.clientbackseries.model.Serie;

@Repository
public interface SeriesRepository extends PagingAndSortingRepository<Serie, Integer>{
	
	@Transactional
	@Query( nativeQuery = true , value = "select * from Serie s where s.genre = ?1", 
	        countQuery = "select count(s) from Serie s where s.genre = ?1"  )
	public Page<Serie> findSerieByGenre( String genre, Pageable pageable ); 

}
