<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="top-box">
        <div class="sys-logo"></div>
       
        <form id="frm" action="search.html" method="get">
       
         <input name="searchTxt" placeholder="请输入关键字" autocomplete="off" value="<%=request.getAttribute("searchTxt")==null?"":request.getAttribute("searchTxt")%>"/>
         <input name="p" id="p" type="hidden" complete="off" value=""/> 
         <input type="submit" id="submit" value="搜索">
         
        </form>
       
</div>