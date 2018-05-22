<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー登録</title>
</head>

<body>
<form action="/WebSample/RegisterUser" method="post">
<h1>開発環境～テスト環境のCI</h1>
ログインID：<input type="text" name="id"><b></b>（Numeric Only）</b><br>
パスワード：<input type="text" name="pass"><br>
名前：<input type="text" name="name"><br>
<br>
<input type="submit" value="確認">
</form>

</body>
</html>