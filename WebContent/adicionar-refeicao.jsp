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
                    <h5 class="text-format-secondary"><i class="fas fa-utensils"></i> Adicionar refeição</h5>
                </div>
            </div>
        </div>

        <div class="mx-auto col-md-6 col-sm-12 card-content" style="margin-top:1rem;">
            <div class="card">
                <div class="card-body ">
                    <form>
                        <div class="form-group row">
                            <label for="inputData" class="col-sm-2 col-form-label">Data</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="date" value="2020-06-09" id="inputData">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="inputExercicio" class="col-sm-2 col-form-label">Refeição</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="inputExercicio">
                                    <option>Café da manhã</option>
                                    <option>Almoço</option>
                                    <option>Lanche</option>
                                    <option>Janta</option>
                                </select>
                            </div>
                        </div>

                        <div style="border-top: 0.5px solid gray; margin-top: 1rem; padding: 10px;">
                            <h5 class="text-format-primary">Alimento 1</h5>
                            <div class="form-group row">
                                <label for="inputAlimento1" class="col-sm-4 col-form-label">Alimento</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" id="inputAlimento1">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="inputQuantidade1" class="col-sm-4 col-form-label">Quantidade (g)</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="number" id="inputQuantidade1">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="inputCalorias1" class="col-sm-4 col-form-label">Calorias</label>
                                <div class="col-sm-8">
                                    <input class="form-control" readonly type="number" id="inputCalorias1">
                                </div>
                            </div>

                            <button type="button" style="border: none;" class="text-format-primary">
                                <i class="fas fa-plus-circle"></i>
                            </button>

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