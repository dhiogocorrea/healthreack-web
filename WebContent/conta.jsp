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
            <form>
                <div class="card">
                    <div class="card-body ">

                        <div class="form-group row">
                            <label for="labelNome" class="col-sm-3 col-form-label">Nome:</label>
                            <div class="col-sm-9">
                                <input type="text" style="font-weight: bold;"
                                    class="form-control text-format-primary"
                                    value="Guilherme de Oliveira" id="labelNome">
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label for="labelSobrenome" class="col-sm-3 col-form-label">Sobrenome:</label>
                            <div class="col-sm-9">
                                <input type="text" style="font-weight: bold;"
                                    class="form-control text-format-primary"
                                    value="Santos" id="labelSobrenome">
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label for="labelDataNascimento" class="col-sm-3 col-form-label">Data de Nascimento:</label>
                            <div class="col-sm-9">
                                <input type="text" style="font-weight: bold;"
                                    class="form-control text-format-primary"
                                    value="06/08/1992" id="labelDataNascimento">
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label for="labelCPF" class="col-sm-3 col-form-label">CPF:</label>
                            <div class="col-sm-9">
                                <input type="text" style="font-weight: bold;"
                                    class="form-control text-format-primary"
                                    value="405.180.970-64" id="labelCPF">
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label for="labelSexo" class="col-sm-3 col-form-label">Sexo</label>
                            <div class="col-sm-9">
                                <select class="form-control" id="labelSexo">
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
                                    value="guilherme.santos07@outlook.com.br" id="labelEmail">
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label for="labelTelefone" class="col-sm-3 col-form-label">Telefone:</label>
                            <div class="col-sm-9">
                                <input type="text" style="font-weight: bold;"
                                    class="form-control text-format-primary"
                                    value="(16) 99999-5431" id="labelTelefone">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="labelPlano" class="col-sm-3 col-form-label">Plano:</label>
                            <div class="col-sm-9">
                                <input type="text" style="font-weight: bold;" readonly
                                    class="form-control-plaintext text-format-primary" value="Premium" id="labelPlano">
                            </div>
                        </div>
                        
                        <div class="text-right"> <a href="home.jsp" style="margin-top: 2rem;"
                                class="btn btn-primary custom-btn pull-right"><i class="fas fa-save"></i> Atualizar dados</a>
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