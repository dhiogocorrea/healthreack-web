<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Minha conta</title>
	<%@ include file="header.jsp" %>
</head>
<body>
    <%@ include file="menu.jsp" %>

    <!-- CONTENT -->
    <div class="container-fluid card-content">
        <div class="mx-auto col-md-6 col-sm-12 card-content" style="margin-top:1rem;">
            <div class="card">
                <div class="card-body text-center">
                    <h5 class="text-format-secondary"><i class="fas fa-address-card"></i> Sua conta</h5>
                </div>
            </div>
        </div>

        <div class="mx-auto col-md-6 col-sm-12 card-content" style="margin-top:1rem;">
        	<%@ include file="alert.jsp" %>
            <form class="card" action="usuario" method="post">
            		<input type="hidden" value="editar" name="acao" />
                    <div class="card-body ">
                        <div class="form-group row">
                            <label for="labelNome" class="col-sm-3 col-form-label">Nome:</label>
                            <div class="col-sm-9">
                                <input type="text" style="font-weight: bold;"
                                    class="form-control text-format-primary"
                                    value="${user.nome}" id="labelNome">
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label for="labelSobrenome" class="col-sm-3 col-form-label">Sobrenome:</label>
                            <div class="col-sm-9">
                                <input type="text" style="font-weight: bold;"
                                    class="form-control text-format-primary"
                                    value="${user.sobrenome}" id="labelSobrenome">
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label for="labelDataNascimento" class="col-sm-3 col-form-label">Data de Nascimento:</label>
                            <div class="col-sm-9">
                                <input type="text" style="font-weight: bold;" class="form-control text-format-primary"
                                    value='<fmt:formatDate value="${user.dtNascimento}" pattern="dd/MM/yyyy" />' id="labelDataNascimento">
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label for="labelCPF" class="col-sm-3 col-form-label">CPF:</label>
                            <div class="col-sm-9">
                                <input type="text" style="font-weight: bold;"
                                    class="form-control text-format-primary"
                                    value="${user.cpf}" id="labelCPF">
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label for="labelSexo" class="col-sm-3 col-form-label">Sexo</label>
                            <div class="col-sm-9">
                                <select value="${user.sexo} class="form-control" id="labelSexo">
                                    <option>Masculino</option>
                                    <option>Feminino</option>
                                </select>
                            </div>
                        </div>
                        

                        <div class="form-group row">
                            <label for="labelEmail" class="col-sm-3 col-form-label">E-mail:</label>
                            <div class="col-sm-9">
                                <input type="text" style="font-weight: bold;"
                                    class="form-control text-format-primary"
                                    value="${user.email}" id="labelEmail">
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label for="labelTelefone" class="col-sm-3 col-form-label">Telefone:</label>
                            <div class="col-sm-9">
                                <input type="text" style="font-weight: bold;"
                                    class="form-control text-format-primary"
                                    value="${user.telefone}" id="labelTelefone">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="labelPlano" class="col-sm-3 col-form-label">Plano:</label>
                            <div class="col-sm-9">
                                <input type="text" style="font-weight: bold;" readonly
                                    class="form-control-plaintext text-format-primary" value="${user.plano}" id="labelPlano">
                            </div>
                        </div>
                        
                        <div class="text-right">
                        <button type="submit" style="margin-top: 2rem;" class="btn btn-primary custom-btn pull-right"><i class="fas fa-save"></i> Atualizar dados</button>
                    </div>
                </div>
            </form>
        </div>
        <!-- END CONTENT -->
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