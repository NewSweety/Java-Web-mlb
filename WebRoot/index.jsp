<%@page import="com.entity.Article"%>
<%@page import="com.entity.Nav"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List <Map>resultList=(List)request.getAttribute("resultList");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>LuGodNews</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="LuGod,LuGodNews,News">
	<meta http-equiv="description" content="LuGodNews,find your true life">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/mlb/css/style.css">
	
  </head>
  <body>
    <jsp:include page="top.jsp"></jsp:include>
    <jsp:include page="nav.jsp"></jsp:include>
    <div class="index-main-box w">
       <%
       for(Map map:resultList){
    	   Nav nav=(Nav)map.get("nav");
    	   List <Article>articleList=(List)map.get("articleList");//过来的是对象，需要进行类型转换
       %>
      <div class="panel">
	      <div>
	           <h2>&nbsp;&nbsp;<%=nav.getNav_name() %><a href="articleList.html?nav_id=<%=nav.getNav_id() %>" class="more" target="_blank" >MORE</a></h2>  
	           <ul>
	              <%if(articleList.size()<1){
	            	  out.println("<li>没有数据显示</li>");
	              }else for(Article a:articleList){%>
	              <li><a href="item.html?article_id=<%=a.getArticle_id()%>"  target="_blank"  title="<%=a.getArticle_title() %>"><%=a.getArticle_title() %></a><span><%=a.getArticle_data()%></span></li>
	              <%} %>
	      </div>
      </div>
      <%} %>
    </div>
    <img src="images/p1.png"no-repeat style="margin-left:-650px; margin-top:150px;">
    <jsp:include page="footer.jsp"></jsp:include>
    <div style="position:absolute; margin-left:354px;margin-top:-635px">
    <img src="images/p2.png"/>
    	</div>
    	<div style="position:absolute; margin-left:190px; margin-top:-300px; font-size:13px;">
    	<p>贵州师范学院学生工作部</br>（处）是学校党委和行政</br>的领导下，贯彻执行国家、</br>上级主管部门和学校的有</br>关法律、法规、
    	政策和规</br>定的职能部门，与校人民武装部实行合署办公，主要负</br>责大学生思想政治教育、学生管理工作、国防与军事教</br>育工作、学生宿舍管
    	理等工作。它既是学校学生管理</br>任务的实施者，也是学生的服务者。秉承着“一切为了</br>学生，为了一切学生，为了学生的一切”的服务
    	理念，</br>我校党委学生工作部全面贯彻党和国家的教育方针，实</br>施和推进素质教育，为培养德、智、体、美  . . . <a href="http://localhost:8080/mlb/item.html?article_id=c769637f-4505-4eb1-9aba-4ac3c1bad4b2">[详情]</a></p>
    	</div>
     </body>
</html>
