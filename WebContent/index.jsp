<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Início</title>
	<%@ include file="header.jsp" %>
</head>
<body>
	<div class="container-fluid" style="margin-top:2rem;">
        <div class="mx-auto col-md-4 col-sm-12">
        	<c:if test="${not empty msg }">
        		<div class="alert alert-success">${msg}</div>
        	</c:if>
        	
            <form class="card" action="login" method="post">
                <div class="card-body text-center">
                    <img src="resources/img/logo.png" width="72" height="72">
                    <h4 class="logo-font">Health Track</h4>
                        <div style="margin-top: 3rem;">
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="desc-user"><i class="fas fa-envelope"></i></span>
                                </div>
                                <input type="text" name="email" class="form-control" placeholder="Email" aria-label="email"
                                    aria-describedby="desc-user">
                            </div>

                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="desc-pass"><i class="fas fa-lock"></i></span>
                                </div>
                                <input type="password" name="senha" class="form-control" placeholder="Senha" aria-label="Senha"
                                    aria-describedby="desc-pass">
                            </div>
                        </div>
                        <button style="margin-top: 1.5rem;" type="button" class="btn col-5 custom-btn"
                            type="submit">Entrar</button>
                        <p class="cadastro">Não possui conta? <a href="cadastro.jsp">Cadastra-se</a>.</p>
                   </div>
            </form>
        </div>
    </div>
</body>
</html>