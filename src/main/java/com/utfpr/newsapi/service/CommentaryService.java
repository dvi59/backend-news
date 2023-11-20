package com.utfpr.newsapi.service;

import com.utfpr.newsapi.entity.Comentary;
import com.utfpr.newsapi.repository.ComentaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaryService {

    @Autowired
    private ComentaryRepository comentaryRepository;

    private List<Comentary> listComentary(Long reportId){
        return comentaryRepository.listComentaryByIdReport(reportId);
    };


}
