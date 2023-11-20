package com.utfpr.newsapi.repository;

import com.utfpr.newsapi.entity.Comentary;
import com.utfpr.newsapi.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComentaryRepository extends JpaRepository<Comentary, Long> {
    @Query("select c from Comentary c where c.report.id =: id")
    List<Comentary> listComentaryByIdReport(@Param("id") Long id);



}
