<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem de pesos</title>
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
						<i class="fas fa-weight"></i> Pesos
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
								<th scope="col" class="text-format-primary">Peso</th>
								<th scope="col" class="text-format-primary">Comparação</th>
								<th scope="col" class="text-format-primary">Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pesos}" var="p">
								<tr>
									<td style="display: none;">${p.codPeso}</td>
									<td>${p.dtPesagem}</td>
									<td>${p.valor}Kg</td>
									<td><i class="fas fa-arrow-up"></i></td>
									<td>
										<button type="button" style="border: none;"
											class="text-format-primary" data-toggle="modal"
											data-target="#modal-${p.codPeso}">
											<i class="fas fa-edit"></i>
										</button>
										<form action="peso" method="post">
											<input type="hidden" value="excluir" name="acao" />
											<button type="submit" style="border: none;"
												class="text-format-primary">
												<i class="fas fa-trash-alt"></i>
											</button>
										</form>
									</td>
								</tr>

								<!-- Modal -->
								<div class="modal fade" id="modal-${p.codPeso}" tabindex="-1"
									role="dialog" aria-labelledby="modal-${p.codPeso}Label"
									aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<form action="peso" method="post">
												<div class="modal-header">
													<h5 class="modal-title" id="modal-${p.codPeso}Label">Edição
														de peso</h5>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="modal-body">
													<input type="hidden" value="editar" name="acao" />
													<input type="hidden" value="${codUsuario}" />
													<input type="hidden" value="${p.codPeso}" name="codPeso" />
													<div class="form-group row">
														<label for="inputData" class="col-sm-2 col-form-label">Data</label>
														<div class="col-sm-10">
															<input class="form-control" type="date"
																value="${p.dtPesagem}" id="inputData">
														</div>
													</div>
													<div class="form-group row">
														<label for="inputPeso" class="col-sm-2 col-form-label">Peso</label>
														<div class="col-sm-10">
															<input type="number" step=".1" value="${p.valor}"
																class="form-control" id="inputPeso">
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