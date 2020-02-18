package com.example.clientbackseries.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="serie" )
public class Serie implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column( name="id" )
	@GeneratedValue( strategy =  GenerationType.IDENTITY )
	private Integer id;
	@Column( name="name" )
	private String name;
	@Column( name="genre" )
	private String genre;
	@Column( name="status" )
	private String status;
	@Column( name="publicationdate" )
	private String publicationDate;
	@Column( name="seasons" )
	private int seasons;
	@Column( name="producer" )
	private String producer;
	@Column( name="cover" )
	private String cover;
	
	public Serie() {
		super();
	}
	
	public Serie(int id, String name, String genre, String status, String publicationDate, int seasons,
			String producer, String cover ) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.status = status;
		this.publicationDate = publicationDate;
		this.seasons = seasons;
		this.producer = producer;
		this.cover = cover;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	public int getSeasons() {
		return seasons;
	}
	public void setSeasons(int seasons) {
		this.seasons = seasons;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}

}
