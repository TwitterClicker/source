<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TwitterClicker</title>
<!-- スタイルシート -->
<link href = "/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<!-- <form>タグ -->
<form action = "/index" method = "post">

<h1>TwitterClicker</h1>
<div style = "float: left;"><img src="/img/twitter.png" /></div>

<dl>
<p>「タイムラインを表示する」ボタンをクリックすると<br />
タイムラインが表示されます<br />
<p>「ランキングを表示する」ボタンをクリックすると<br />
ランキングが表示されます<br />
<br />
<input type = "submit" id = "timeline" value = "タイムラインを表示する" />
<br />
<br />
<input type = "submit" id = "ranking" value ="ランキングを表示する" />
</p>

</dl>

</form>
</body>
</html>
