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
                    <h5 class="text-format-secondary"><i class="fas fa-running"></i> Adicionar exercício</h5>
                </div>
            </div>
        </div>

        <div class="mx-auto col-md-6 col-sm-12 card-content" style="margin-top:1rem;">
            <div class="card">
                <div class="card-body ">
                    <form>
                        <div class="form-group row">
                            <label for="inputData" class="col-sm-2 col-form-label">Email</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="date" value="2020-06-01" id="inputData">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="inputExercicio" class="col-sm-2 col-form-label">Exercício</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="inputExercicio">
                                    <option>Corrida</option>
                                    <option>Basquete</option>
                                    <option>Natação</option>
                                    <option>Futebol</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="inputCalorias" class="col-sm-2 col-form-label">Calorias</label>
                            <div class="col-sm-10">
                                <input type="number" value="200" class="form-control" id="inputCalorias">
                            </div>
                        </div>

                        <div class="text-right"> <button type="button" style="margin-top: 2rem;"
                                class="btn btn-primary custom-btn pull-right">Adicionar exercício</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
        <!-- END CONTENT -->
    </div>
</body>
</html>