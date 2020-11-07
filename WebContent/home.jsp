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
        <div class="mx-auto col-md-8 col-sm-12 card-content" style="margin-top:1rem;">
            <div class="card">
                <div class="card-body row">
                    <div class="col-md-6 col-sm-12 chart-border">
                        <canvas id="pie-chart-calorias" width="500" height="450"></canvas>
                    </div>
                    <div class="col-md-6 col-sm-12 chart-border" >
                        <canvas id="line-chart-peso" width="500" height="450"></canvas>
                    </div>
                </div>
                <hr />
                <div class="card-body row">
                    <div class="col-md-6 col-sm-12 chart-border" >
                        <canvas id="line-chart-batimentos" width="500" height="450"></canvas>
                    </div>
                    <div class="col-md-6 col-sm-12 chart-border">
                        <canvas id="pie-chart-exercicios" width="500" height="450"></canvas>
                    </div>
                </div>
            </div>
        </div>
        <!-- END CONTENT -->
    </div>
</body>
</html>