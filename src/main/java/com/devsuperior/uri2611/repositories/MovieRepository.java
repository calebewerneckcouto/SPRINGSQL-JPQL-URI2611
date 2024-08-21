package com.devsuperior.uri2611.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.uri2611.MovieMinProjection;
import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.entities.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	/*SQL RAIZ*/
     @Query(nativeQuery = true,value="SELECT movies.id, movies.name FROM movies INNER JOIN genres ON movies.id_genres = genres.id WHERE genres.description = :genreName")
	 List<MovieMinProjection> search1(String genreName);
     
   
     /*JPQL*/
     @Query("SELECT new  com.devsuperior.uri2611.dto.MovieMinDTO(obj.id,obj.name) FROM Movie obj WHERE obj.genre.description = :genreName")
	 List<MovieMinDTO> search2(String genreName);
}
