<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Adicionar refeição</title>
	<%@ include file="header.jsp" %>
</head>
<body>
    <%@ include file="menu.jsp" %>

    <!-- CONTENT -->
    <div class="container-fluid card-content">
        <div class="mx-auto col-md-6 col-sm-12 card-content" style="margin-top:1rem;">
            <div class="card">
                <div class="card-body text-center">
                    <h5 class="text-format-secondary"><i class="fas fa-utensils"></i> Adicionar refeição</h5>
                </div>
            </div>
        </div>

        <div class="mx-auto col-md-6 col-sm-12 card-content" style="margin-top:1rem;">
            <div class="card">
                <div class="card-body ">
                    <form action="refeicao" method="post">
                        <div class="form-group row">
                            <label for="inputData" class="col-sm-2 col-form-label">Data</label>
                            <div class="col-sm-10">
                                <input class="form-control" name="dtRefeicao" type="date" placeholder="dd/MM/yyyy" id="inputData">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="inputRefeicao" class="col-sm-2 col-form-label">Refeição</label>
                            <div class="col-sm-10">
                                <select name="tipoRefeicao" class="form-control" id="inputRefeicao">
                                    <option>Café da manhã</option>
                                    <option>Almoço</option>
                                    <option>Lanche</option>
                                    <option>Janta</option>
                                </select>
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label for="inputCalorias" class="col-sm-2 col-form-label">Calorias</label>
                            <div class="col-sm-10">
                                <input type="number" name="calorias" class="form-control" id="inputCalorias">
                            </div>
                        </div>

                        <div class="text-right"> <button type="button" style="margin-top: 2rem;"
                                class="btn btn-primary custom-btn pull-right">Adicionar refeição</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- END CONTENT -->
    </div>
</body>
</html>