package com.example.clientbackseries.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.clientbackseries.model.Genre;
import com.example.clientbackseries.model.Response;
import com.example.clientbackseries.model.Serie;
import com.example.clientbackseries.resources.SeriesService;

@RestController
@CrossOrigin( origins = "*" )
public class SerieController {
	
	@Autowired
	private SeriesService service;
	
	@GetMapping( value="/genrelist", produces = MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public List<Genre> createGenreList() {
		return service.getListGenre();
	}
	
	@GetMapping( value="/findbygenre", produces = MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public Page<Serie> getSeriesByGenre( @RequestParam( name = "page") int page, 
			                             @RequestParam( name="size" ) int size, 
			                             @RequestParam( name="genre" ) String genre ){
		Pageable pageable = PageRequest.of(page, size );
		return service.findSerieByGenre(genre, pageable);
	}
	
	@PostMapping( value="/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public Response insertSerieInStore( @RequestBody Serie serie ) {
		 return service.createSerieInRepository( serie );
	}
	
	@PostMapping( value="/delete", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public Response deleteSerieInStore( @RequestBody Serie serie ) {
		 return service.deleteSerieInRepository( serie );
	}
	
	@GetMapping( value="/serieslist", produces = MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public Page<Serie> getSeriesList( Pageable pageable ) {
		return service.getListSerieByPage( pageable );
	}

}
