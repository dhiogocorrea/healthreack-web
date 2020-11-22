<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <%@ include file="header.jsp" %>
</head>

<body>
    <div class="container-fluid" style="margin-top:2rem;">
        <div class="mx-auto col-md-4 col-sm-12">
        	<c:if test="${not empty msg }">
        		<div class="alert alert-success">${msg}</div>
        	</c:if>
        	<c:if test="${not empty error }">
        		<div class="alert alert-error">${error}</div>
        	</c:if>
            <form class="card" action="usuario" method="post">
                <div class="card-body text-center">
                    <img src="resources/img/logo.png" width="72" height="72">
                    <h4 class="logo-font">Health Track</h4>
                        <div style="margin-top: 3rem;">
                        	<input type="hidden" value="cadastrar" name="acao" />
                            <div class="form-group row">
                                <label for="inputNome"
                                    class="col-sm-4 col-form-label form-cadastro text-format-primary">Nome:</label>
                                <div class="col-sm-12">
                                    <input class="form-control" name="nome" type="text" id="inputNome">
                                </div>
                            </div>
                            
                            <div class="form-group row">
                                <label for="inputSobrenome"
                                    class="col-sm-4 col-form-label form-cadastro text-format-primary">Sobrenome:</label>
                                <div class="col-sm-12">
                                    <input class="form-control" name="sobrenome" type="text" id="inputSobrenome">
                                </div>
                            </div>
                            
                            <div class="form-group row">
	                            <label for="labelDataNascimento" class="col-sm-4 col-form-label form-cadastro text-format-primary">Data de Nascimento:</label>
	                            <div class="col-sm-12">
	                                <input type="text" name="dtNascimento" class="form-control" id="labelDataNascimento">
	                            </div>
                        	</div>
                        	
                        	<div class="form-group row">
	                            <label for="labelCPF" class="col-sm-4 col-form-label form-cadastro text-format-primary">CPF:</label>
	                            <div class="col-sm-12">
	                                <input type="text" name="cpf" class="form-control" id="labelCPF">
	                            </div>
                        	</div>

                            <div class="form-group row">
                                <label for="inputEmail"
                                    class="col-sm-4 col-form-label form-cadastro text-format-primary">E-mail:</label>
                                <div class="col-sm-12">
                                    <input class="form-control" name="email" placeholder="@exemplo.com" type="text" id="inputEmail">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="inputSenha"
                                    class="col-sm-4 col-form-label form-cadastro text-format-primary">Senha:</label>
                                <div class="col-sm-12">
                                    <input class="form-control" name="senha"  type="password" id="inputSenha">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="inputSenha2"
                                    class="col-sm-6 col-form-label form-cadastro text-format-primary">Repita a senha:</label>
                                <div class="col-sm-12">
                                    <input class="form-control"  type="password" id="inputSenha2">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="inputSexo"
                                    class="col-sm-4 col-form-label form-cadastro text-format-primary">Sexo:</label>
                                <div class="col-sm-12">
                                    <select name="sexo" class="form-control" id="inputSexo">
                                        <option>Selecione</option>
                                        <option>Masculino</option>
                                        <option>Feminino</option>                                        
                                    </select>
                                </div>
                            </div>
                            
                            <div class="form-group row">
	                            <label for="labelTelefone" class="col-sm-4 col-form-label form-cadastro text-format-primary">Telefone:</label>
	                            <div class="col-sm-12">
	                                <input type="text" name="telefone" class="form-control" id="labelTelefone">
	                            </div>
                        	</div>

                            <div class="form-group row">
                                <label for="inputPeso"
                                    class="col-sm-4 col-form-label form-cadastro text-format-primary">Peso:</label>
                                <div class="col-sm-12">
                                    <input class="form-control" name="peso" type="number" step=".1" placeholder="ex: 70,0" type="number" id="inputPeso" />
                                </div>
                            </div>
                            
                            <div class="form-group row">
                                <label for="inputPlano"
                                    class="col-sm-4 col-form-label form-cadastro text-format-primary">Plano:</label>
                                <div class="col-sm-12">
                                    <input class="form-control" name="plano" value="BRONZE" disabled />
                                </div>
                            </div>

                        </div>
                        <button style="margin-top: 1.5rem;" type="submit" class="btn col-5 custom-btn" type="submit"
                            onclick="window.location='home.jsp'">Cadastrar</button>
                </div>
            </form>
        </div>
    </div>
    
    <script>
	    $(document).ready(function(){
	    	  $("#labelCPF").inputmask("999.999.999-99");
	    	  $("#labelDataNascimento").inputmask("99/99/9999");
	    	  $("#labelTelefone").inputmask("(99) 99999-9999");
	    });
    </script>
</body>
</html>