package com.utfpr.newsapi.controller;

import com.utfpr.newsapi.dto.PublishReportDTO;
import com.utfpr.newsapi.entity.Report;
import com.utfpr.newsapi.service.ReportService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("news")
public class ReportController {

    @Autowired
    private ReportService reportService;


    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Report> getNews(){
        return reportService.latestNews();
    };

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity addNews(@RequestBody PublishReportDTO report) throws UnsupportedEncodingException {
        var token = "bananw";

        this.reportService.addNews(report);

        return ResponseEntity.ok().build();

    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Report showNews(@PathVariable("id")Long id){
             return reportService.showNews(id);
    }
}
