<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem de batimentos cardíacos</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<%@ include file="menu.jsp"%>

	<!-- CONTENT -->
	<div class="container-fluid card-content">
		<div class="mx-auto col-md-6 col-sm-12 card-content"
			style="margin-top: 1rem;">
			<%@ include file="alert.jsp"%>
			<div class="card">
				<div class="card-body text-center">
					<h5 class="text-format-secondary">
						<i class="fas fa-heartbeat"></i> Batimentos
					</h5>
				</div>
			</div>
		</div>

		<div class="mx-auto col-md-6 col-sm-12 card-content"
			style="margin-top: 1rem;">
			<div class="card">
				<div class="card-body ">
					<table class="table table-hover text-center">
						<thead>
							<tr>
								<th scope="col" class="text-format-primary"
									style="display: none;">ID</th>
								<th scope="col" class="text-format-primary">Data</th>
								<th scope="col" class="text-format-primary">Máximo</th>
								<th scope="col" class="text-format-primary">Mínimo</th>
								<th scope="col" class="text-format-primary">Média</th>
								<th scope="col" class="text-format-primary">Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="batimentosCardiacos" var="b">
								<tr>
									<td style="display: none;">${b.codBatimentoCardiaco}</td>
									<td>${b.dtMedicao}</td>
									<td>${b.batimentoMaximo}</td>
									<td>${b.batimentoMinimo}</td>
									<td>${b.batimentoMedio}</td>
									<td>
										<button type="button" style="border: none;"
											class="text-format-primary" data-toggle="modal"
											data-target="#modal-${b.codBatimentoCardiaco}">
											<i class="fas fa-edit"></i>
										</button>
										<form action="batimentocardiaco" method="post">
											<input type="hidden" value="excluir" name="acao" />
											<button type="submit" style="border: none;"
												class="text-format-primary">
												<i class="fas fa-trash-alt"></i>
											</button>
										</form>
									</td>

								</tr>

								<!-- Modal -->
								<div class="modal fade" id="modal-${b.codBatimentoCardiaco}"
									tabindex="-1" role="dialog"
									aria-labelledby="modal-${b.codBatimentoCardiaco}Label"
									aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<form action="batimentocardiaco" method="post">
												<div class="modal-header">
													<h5 class="modal-title"
														id="modal-${b.codBatimentoCardiaco}Label">Edição de
														batimentos</h5>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="modal-body">
													<input type="hidden" value="editar" name="acao" />
													<input
														type="hidden" value="${b.codBatimentoCardiaco}"
														name="codBatimentoCardiaco" />

													<div class="form-group row">
														<label for="inputBatimento"
															class="col-sm-2 col-form-label">Data Medição</label>
														<div class="col-sm-10">
															<input type="date" value="${b.dtMedicao}"
																name="dtMedicao" class="form-control"
																id="inputDtMedicao">
														</div>
													</div>

													<div class="form-group row">
														<label for="inputBatimento"
															class="col-sm-2 col-form-label">Batimento Máximo</label>
														<div class="col-sm-10">
															<input type="number" value="${b.batimentoMaximo}"
																name="batimentoMaximo" class="form-control"
																id="inputBatimentoMaximo">
														</div>
													</div>

													<div class="form-group row">
														<label for="inputBatimento"
															class="col-sm-2 col-form-label">Batimento Médio</label>
														<div class="col-sm-10">
															<input type="number" value="${b.batimentoMedio}"
																name="batimentoMedio" class="form-control"
																id="inputBatimentoMedio">
														</div>
													</div>

													<div class="form-group row">
														<label for="inputBatimento"
															class="col-sm-2 col-form-label">Batimento Mínimo</label>
														<div class="col-sm-10">
															<input type="number" value="${b.batimentoMinimo}"
																name="batimentoMinimo" class="form-control"
																id="inputBatimentoMinimo">
														</div>
													</div>

												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary"
														data-dismiss="modal">Cancelar</button>
													<button type="submit" class="btn btn-primary custom-btn">Salvar</button>
												</div>
											</form>
										</div>

									</div>
								</div>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- END CONTENT -->
	</div>
</body>
</html>