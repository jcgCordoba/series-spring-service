package com.example.clientbackseries.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.clientbackseries.model.Genre;
import com.example.clientbackseries.model.Response;
import com.example.clientbackseries.model.Serie;

@Service
public class SeriesService {
	
	
	@Value( "${series.app.genre.types}" )
	private String seriesGenres;
	
	private List<Genre> listGenre;
	
	@Autowired
	private SeriesRepository repository;
	
	
	@PostConstruct
	private void loadResources() {
	   createListGenres();	
	}
	
	private int index;

	private void createListGenres() {
	   String values[] = seriesGenres.split( ";" );
	   Stream<String> stream = Arrays.stream( values );
	   listGenre = new ArrayList<>(); 
	   stream.forEach( ( String value ) -> { 
		  Genre genre = new Genre( index, value );
		  listGenre.add( genre );
		  index++;
	   });
	}
	
	public List<Genre> getListGenre(){
		return listGenre;
	}
	
	
	public Page<Serie> findSerieByGenre( String genre, Pageable pageable ){
		return repository.findSerieByGenre( genre, pageable );
	}
	
	public Response createSerieInRepository( Serie serie ) {
		Response response = null;
		try{
		  repository.save( serie );
		  response = new Response( HttpStatus.OK.value(), "Transaction processed correctly" );
		}
		catch( Exception error ) {
			System.out.println( "  ---> " + HttpStatus.BAD_REQUEST.value() + " Failed porcess transaction caused by " +error.toString() );
			response = new Response( HttpStatus.BAD_REQUEST.value(), "Failed porcess transaction caused by " + error.toString() );
		}
	   return response;
	}
	
	public Response deleteSerieInRepository( Serie serie ) {
		Response response = null;
		try{
		  repository.delete(serie);
		  response = new Response( HttpStatus.OK.value(), "Transaction processed correctly" );
		}
		catch( Exception error ) {
			System.out.println( "  ---> " + HttpStatus.BAD_REQUEST.value() + " Failed porcess transaction caused by " +error.toString() );
			response = new Response( HttpStatus.BAD_REQUEST.value(), "Failed porcess transaction caused by " + error.toString() );
		}
	   return response;
	}
	
	public Page<Serie> getListSerieByPage( Pageable pageable ){
		return repository.findAll( pageable );
	}
	

}
