<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSTLの利用の宣言 -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TwitterClicker-TL</title>
<link href="/css/style.css" rel="stylesheet" type = "text/css" />
</head>
<body>
<h1>タイムライン一覧</h1>


<%-- JSTLでリクエスト属性の値を表示する --%>

<% for(int i = 0; i < 19; i++) {%>
<div class = "tweet">
<%-- ユーザ名を出力する --%>
<%= request.getAttribute("userName["+i+"]") %>
<br />
<br />
<%-- ツイート文を出力する --%>
<%= request.getAttribute("tweet["+i+"]") %>
<br />
<%-- ツイート文に含まれているURLを出力する --%>
<%= request.getAttribute("url["+i+"]") %>
<br />
<br />
<%-- 音声ボタン --%>
<% if(i==0){%><a class="button0" href="#">音声</a> <% }%>
<% if(i==1){%><a class="button1" href="#">音声2</a> <% }%>
<% if(i==2){%><a class="button2" href="#">音声3</a> <% }%>
<% if(i==3){%><a class="button3" href="#">音声4</a> <% }%>
<% if(i==4){%><a class="button4" href="#">音声5</a> <% }%>
<% if(i==5){%><a class="button5" href="#">音声6</a> <% }%>
<% if(i==6){%><a class="button6" href="#">音声7</a> <% }%>
<% if(i==7){%><a class="button7" href="#">音声8</a> <% }%>
<% if(i==8){%><a class="button8" href="#">音声9</a> <% }%>
<% if(i==9){%><a class="button9" href="#">音声10</a> <% }%>
<% if(i==10){%><a class="button10" href="#">音声11</a> <% }%>
<% if(i==11){%><a class="button11" href="#">音声12</a> <% }%>
<% if(i==12){%><a class="button12" href="#">音声13</a> <% }%>
<% if(i==13){%><a class="button13" href="#">音声14</a> <% }%>
<% if(i==14){%><a class="button14" href="#">音声15</a> <% }%>
<% if(i==15){%><a class="button15" href="#">音声16</a> <% }%>
<% if(i==16){%><a class="button16" href="#">音声17</a> <% }%>
<% if(i==17){%><a class="button17" href="#">音声18</a> <% }%>
<% if(i==18){%><a class="button18" href="#">音声19</a> <% }%>
<br />
<br />
</div>
<%} %>

<p><a href="/index">ホームに戻る</a></p>


</body>
</html>
