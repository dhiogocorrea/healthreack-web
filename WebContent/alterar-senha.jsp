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
                <h5 class="text-format-secondary"><i class="fas fa-lock"></i> Alterar senha</h5>
            </div>
        </div>
    </div>

    <div class="mx-auto col-md-6 col-sm-12 card-content" style="margin-top:1rem;">
        <div class="card">
            <div class="card-body ">
                <form>
                    <div class="form-group row">
                        <label for="inputOldPass" class="col-sm-2 col-form-label">Senha antiga</label>
                        <div class="col-sm-10">
                            <input class="form-control" type="password" id="inputOldPass">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="inputNewPass" class="col-sm-2 col-form-label">Nova senha</label>
                        <div class="col-sm-10">
                            <input class="form-control" type="password" id="inputNewPass">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputRenewPass" class="col-sm-2 col-form-label">Repita a senha</label>
                        <div class="col-sm-10">
                            <input class="form-control" type="password" id="inputRenewPass">
                        </div>
                    </div>
                    <div class="text-right">
                        <button type="submit" style="margin-top: 2rem;"
                                class="btn btn-primary custom-btn pull-right">Salvar senha
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- END CONTENT -->
</div>
</body>
</html>