
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"
            +request.getServerName()+":"
            +request.getServerPort()+path+"/";
%>

<base href="<%=basePath%>">

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <meta name="format-detection" content="telephone=no">
    <meta charset="UTF-8">
    <meta name="description" content="Violate Responsive Admin Template">
    <meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">
    <!-- CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/form.css" rel="stylesheet">
    <link href="css/calendar.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/icons.css" rel="stylesheet">
    <link href="css/generics.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Check</title>
</head>
<body id="skin-blur-violate">


<header id="header" class="media">
    <a href="" id="menu-toggle"></a>
    <a class="logo pull-left" >作业管理系统1.0</a>
    <!--------------------------------- 顶部时间栏 ---------------------------------------->
    <div class="media-body">
        <div class="media" id="top-menu">

            <div id="time" class="pull-right">
                <span id="hours"></span>
                :
                <span id="min"></span>
                :
                <span id="sec"></span>
            </div>

        </div>
    </div>
</header>

<div class="clearfix"></div>

<section id="main" class="p-relative" role="main">

    <!--------------------------------- 左侧栏 ---------------------------------------->
    <aside id="sidebar">

        <!-- Sidbar Widgets -->
        <div class="side-widgets overflow">
            <!-- Profile Menu -->
            <div class="text-center s-widget m-b-25 dropdown" id="profile-menu">
                <a href="" data-toggle="dropdown">
                    <img class="profile-pic animated" src="img/11.png" alt="">
                </a>

                <h4 class="m-0">老师</h4>
            </div>

            <!-- Calendar -->
            <div class="s-widget m-b-25">
                <div id="sidebar-calendar"></div>
            </div>

        </div>

        <!--------------------------------- 最左侧老师功能栏 ---------------------------------------->
        <ul class="list-unstyled side-menu">
            <li class="active">
                <a class="sa-side-ui" href="TeaLogin.jsp">
                    <span class="menu-item">返回主页</span>
                </a>
            </li>
            <li>
                <a class="sa-side-home" href="TeaChoose.jsp">
                    <span class="menu-item">返回老师端主页</span>
                </a>
            </li>
            <li>
                <a class="sa-side-widget" href="${pageContext.request.contextPath}/Search">
                    <span class="menu-item">查看老师和学生列表</span>
                </a>
            </li>
            <li>
                <a class="sa-side-form" href="${pageContext.request.contextPath}/TAdd">
                    <span class="menu-item">添加学生</span>
                </a>
            </li>
            <li>
                <a class="sa-side-typography" href="${pageContext.request.contextPath}/TDelete">
                    <span class="menu-item">删除学生</span>
                </a>
            </li>
            <li class="active">
                <a class="sa-side-table" href="${pageContext.request.contextPath}/TADDHomework">
                    <span class="menu-item">布置作业</span>
                </a>
            </li>
            <li class="active">
                <a class="sa-side-form" href="${pageContext.request.contextPath}/Check">
                    <span class="menu-item">检查作业</span>
                </a>
            </li>

        </ul>

    </aside>

    <section id="content" class="container">
        <div class="block-area" id="basic">
            <h3 class="block-title">提交作业</h3>
            <form action="${pageContext.request.contextPath}/CheckHomework3" role="form">

                <div class="form-group">
                    <label for="sId">学生学号</label>
                    <input type="text" class="form-control input-sm" name="sId" id="sId" readonly value="${pageContext.request.getParameter("sId")}">
                </div>

                <div class="form-group">
                    <label for="hwId">作业编号</label>
                    <input type="text" class="form-control input-sm" name="hwId" id="hwId" readonly value="${pageContext.request.getParameter("hwId")}">
                </div>

                <div class="form-group">
                    <label for="hwTitle">作业标题</label>
                    <input type="text" class="form-control input-sm"id="hwTitle" name="hwTitle" readonly  value="${pageContext.request.getParameter("hwTitle")}">
                </div>

                <div class="form-group">
                    <label for="hwContent">作业内容</label>
                    <input type="text" class="form-control input-sm"id="hwContent" name="hwContent" readonly  value="${pageContext.request.getParameter("hwContent")}">
                </div>

                <div class="form-group">
                    <label for="score">分数</label>
                    <input type="text" name="score" class="form-control input-sm" id="score" placeholder="score">
                </div>


                <button type="submit" name="submit" class="btn btn-sm m-t-10">提交</button>
            </form>

            <form action="/TCheck2.jsp" method=post >
                <a href="${pageContext.request.contextPath}/CheckHomework?hwId=${pageContext.request.getParameter("hwId")}"><input type="button" value="返回" class="btn btn-sm m-t-10"></a>
            </form>

        </div>



    </section>

    <br/><br/>
</section>

<!-- Javascript Libraries -->
<!-- jQuery -->
<script src="js/jquery.min.js"></script> <!-- jQuery Library -->
<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>
<!--  Form Related -->
<script src="js/select.min.js"></script> <!-- Custom Select -->
<script src="js/icheck.js"></script> <!-- Custom Checkbox + Radio -->
<script src="js/fileupload.min.js"></script> <!-- File Upload -->
<script src="js/autosize.min.js"></script> <!-- Textare autosize -->
<!-- UX -->
<script src="js/scroll.min.js"></script> <!-- Custom Scrollbar -->
<!-- Other -->
<script src="js/calendar.min.js"></script> <!-- Calendar -->
<script src="js/feeds.min.js"></script> <!-- News Feeds -->
<!-- All JS functions -->
<script src="js/functions.js"></script>


</body>
</html>
