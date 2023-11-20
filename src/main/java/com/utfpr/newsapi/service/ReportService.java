package com.utfpr.newsapi.service;

import com.utfpr.newsapi.entity.Report;
import com.utfpr.newsapi.entity.User;
import com.utfpr.newsapi.repository.ReportRepository;
import com.utfpr.newsapi.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpServletRequest request;

    public List<Report> latestNews(){
        return reportRepository.latestMews();
    }

    public Report addNews(Report report){
        HttpSession session = request.getSession();
        Long loggedInUserId = (Long) session.getAttribute("loggedInUserId");

        User author = userRepository.findRef(loggedInUserId);
        report.setPublicationDate(new Date());
        report.setUser(author);


        return reportRepository.save(report);
    }

    public Report edit(Report report){
        return reportRepository.save(report);
    }

    public Report showNews(Long id){
        return reportRepository.findRef(id);
    }

}
