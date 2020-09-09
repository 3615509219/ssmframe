<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
    <form method="post" action="index?action=query">
        用户编号：<input type="text" id="queryUserId" name="queryUserId">
        <input type="submit" value="查询">
    </form>
        <hr/>
    <form method="post" action="index?action=add">
        用户名字：<input type="text" id="addUserName" name="addUserName">
        用户金额：<input type="text" id="addUserMoney" name="addUserMoney">
        <input type="submit" value="增加">
    </form>
        <hr/>
    <form method="post" action="index?action=delete">
        用户编号：<input type="text" id="delUserId" name="delUserId">
        <input type="submit" value="删除">
    </form>
        <hr/>
    <form method="post" action="index?action=update">
        用户编号：<input type="text" id="updUserId" name="updUserId">
        用户名字：<input type="text" id="updUserName" name="updUserName">
        用户金额：<input type="text" id="updUserMoney" name="updUserMoney">
        <input type="submit" value="修改">
    </form>
    ${query.tbUserid}${query.tbUsername}${query.tbUsermoney}
    ${add}
    ${delete}
    ${update}
</body>
</html>