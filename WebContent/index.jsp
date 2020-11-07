<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <form class="card">
                <div class="card-body text-center">
                    <img src="resources/img/logo.png" width="72" height="72">
                    <h4 class="logo-font">Health Track</h1>
                        <div style="margin-top: 3rem;">
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="desc-user"><i class="fas fa-envelope"></i></span>
                                </div>
                                <input type="text" class="form-control" placeholder="Usuário" aria-label="Usuario"
                                    aria-describedby="desc-user">
                            </div>

                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="desc-pass"><i class="fas fa-lock"></i></span>
                                </div>
                                <input type="password" class="form-control" placeholder="Senha" aria-label="Senha"
                                    aria-describedby="desc-pass">
                            </div>
                        </div>
                        <button style="margin-top: 1.5rem;" type="button" class="btn col-5 custom-btn"
                            type="submit" onclick="window.location='home.jsp'">Entrar</button>
                        <p class="cadastro">Não possui conta? <a href="cadastro.jsp">Cadastra-se</a>.</p>
            </form>
        </div>
    </div>
</body>
</html>