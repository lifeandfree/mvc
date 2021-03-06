<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="RU">
<head>
    <%@include file="head-common.jsp" %>
</head>
<body>
<div id="wrapper">
    <%@include file="navbar-common.jsp" %>
    <div class="container">
        <div class="panel-primary">
            <form class="well form-horizontal" action="${pageContext.request.contextPath}/reg" method="post"
                  name="userForm">
                <fieldset>
                    <legend><h2 class="text-center">Регистрация нового пользователя</h2></legend>
                    <br>
                    <div class="form-group">
                        <label class="col-md-5 control-label">Имя пользователя</label>
                        <div class="col-md-5 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input required type="text" name="username" class="form-control" placeholder="Имя пользователя"
                                       value="${pageContext.request.getParameter("username")}">
                            </div>
                            <c:if test="${result.getFieldError('username') != null}">
                                <div class="alert alert-danger"><i:message
                                        code="${result.getFieldError('username').code}"/></div>
                            </c:if>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-5 control-label">Пароль</label>
                        <div class="col-md-5 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-wrench"></i></span>
                                <input required type="password" name="password" class="form-control"
                                       placeholder="Пароль.."
                                       value="${pageContext.request.getParameter("password")}">
                            </div>
                            <c:if test="${result.getFieldError('password') != null}">
                                <div class="alert alert-danger">
                                    <i:message code="${result.getFieldError('password').code}"/></div>
                            </c:if>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-5 control-label">Повторите пароль</label>
                        <div class="col-md-5 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-wrench"></i></span>
                                <input required type="password" name="repeatpassword" class="form-control"
                                       placeholder="Повторите пароль"
                                       value="${pageContext.request.getParameter("repeatpassword")}">
                            </div>
                            <c:if test="${result.getFieldError('repeatpassword') != null}">
                                <div class="alert alert-danger">
                                    <i:message code="${result.getFieldError('repeatpassword').code}"/></div>
                            </c:if>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-5 control-label">Email</label>
                        <div class="col-md-5 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                                <input required type="email" name="email" class="form-control" placeholder="Email"
                                       value="${pageContext.request.getParameter("email")}">
                            </div>
                            <c:if test="${result.getFieldError('email') != null}">
                                <div class="alert alert-danger">
                                    <i:message code="${result.getFieldError('email').code}"/></div>
                            </c:if>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="">
                            <button type="submit" class="btn btn-primary btn-block"
                                    style="width:50%;margin-left:auto;margin-right:auto">Зарегистрироваться<span
                                    class="glyphicon glyphicon-send"></span></button>
                        </div>
                    </div>
                    <h4 class="text-center"><a href="${pageContext.request.contextPath}/">Вернуться</a></h4>
                </fieldset>
            </form>
        </div>
    </div>
<%--    <%@include file="footer-common.jsp" %>--%>
</div>
</body>
</html>