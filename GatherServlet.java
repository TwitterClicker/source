package com.appspot.twitterclicker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet.Response;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import twitter4j.Status;

@SuppressWarnings("serial")
public class GatherServlet extends HttpServlet{
  private static final Pattern httpPattern = Pattern.compile(
    "(http://|https://){1}[¥¥w¥¥.¥¥-/:¥¥#¥¥?¥¥=¥¥&¥¥;¥¥%¥¥~¥¥+]+",Pattern.CASE_INSENSITIVE);
  private static final Pattern retweetPattern = Pattern.compile("(^|¥¥s)[RQ]T¥¥s");
  
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    PersistenceManager pm = PMF.get().getPersistenceManager();
    try{
      // タイムライン上のツイート一覧を取得する
      String screeName = TwitterHelper.getScreenName();
      List<Status> statuses = TwitterHelper.getStatuses();
      // ツイートを一つずつ解析して、データストアに保存する
      for (Status status : statuses){
        analyzaStatus(pm, status);
      }
    } catch(Exception e){
      throw new ServletException(e);
    } finally {
      pm.close();
    }
  }
  
  // ツイートを解析する
  private 
        
