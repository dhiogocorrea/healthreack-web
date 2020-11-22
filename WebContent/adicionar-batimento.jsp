<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Adicionar batimento</title>
	<%@ include file="header.jsp" %>
</head>
<body>
    <%@ include file="menu.jsp" %>

    <!-- CONTENT -->
    <div class="container-fluid card-content">
        <div class="mx-auto col-md-6 col-sm-12 card-content" style="margin-top:1rem;">
            <div class="card">
                <div class="card-body text-center">
                    <h5 class="text-format-secondary"><i class="fas fa-heartbeat"></i> Batimentos</h5>
                </div>
            </div>
        </div>

        <div class="mx-auto col-md-6 col-sm-12 card-content" style="margin-top:1rem;">
            <div class="card">
                <div class="card-body ">
                    <form action="batimentocardiaco" method="post">
                        <div class="form-group row">
                            <label for="inputData" class="col-sm-2 col-form-label">Data</label>
                            <div class="col-sm-10">
                                <input class="form-control" placeholder="dd/MM/yyyy" type="date" name="dtMedicao" id="inputData">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="inputBatimento" class="col-sm-2  col-form-label">Batimentos (Mínimo)</label>
                            <div class="col-sm-10">
                                <input type="number" class=" form-control" name="batimentoMinimo" id="inputBatimentoMinimo">
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label for="inputBatimento" class="col-sm-2  col-form-label">Batimentos Batimentos (Máximo)</label>
                            <div class="col-sm-10">
                                <input type="number" class=" form-control" name="batimentoMaximo" id="inputBatimentoMaximo">
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label for="inputBatimento" class="col-sm-2  col-form-label">Batimentos Batimentos (Médio)</label>
                            <div class="col-sm-10">
                                <input type="number" class=" form-control" name="batimentoMedio" id="inputBatimentoMedio">
                            </div>
                        </div>
                        <div class="text-right"> <button type="button" style="margin-top: 2rem;"
                                class="btn btn-primary custom-btn pull-right">Adicionar batimento</button></div>

                    </form>
                </div>
            </div>
        </div>
        <!-- END CONTENT -->
    </div>
</body>

</html>