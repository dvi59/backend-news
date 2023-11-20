package com.utfpr.newsapi.controller;

import com.utfpr.newsapi.entity.Report;
import com.utfpr.newsapi.service.ReportService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("news")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private HttpServletRequest request;

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Report> getNews(){
        return reportService.latestNews();
    };

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Report addNews(@RequestBody Report report){
        return reportService.addNews(report);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Report showNews(@PathVariable("id")Long id){
        HttpSession session = request.getSession();
        session.setAttribute("reportId",id);
        return reportService.showNews(id);
    }
}
