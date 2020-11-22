<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem de exercícios</title>
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
						<i class="fas fa-running"></i> Exercícios
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
								<th scope="col" class="text-format-primary">Exercício</th>
								<th scope="col" class="text-format-primary">Duração</th>
								<th scope="col" class="text-format-primary">Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="atividades" var="a">
								<tr>
									<td style="display: none;">${a.codAtividade}</td>
									<td>${a.dtAtividade}</td>
									<td>${a.nome}</td>
									<td>${a.duracaoAtividade}</td>
									<td>
										<button type="button" style="border: none;"
											class="text-format-primary" data-toggle="modal"
											data-target="#modal-${a.codAtividade}">
											<i class="fas fa-edit"></i>
										</button>
										<form action="atividade" method="post">
											<input type="hidden" value="excluir" name="acao" />
											<button type="submit" style="border: none;"
												class="text-format-primary">
												<i class="fas fa-trash-alt"></i>
											</button>
										</form>
									</td>
								</tr>

								<!-- Modal -->
								<div class="modal fade" id="modal-${a.codAtividade}"
									tabindex="-1" role="dialog"
									aria-labelledby="modal-${a.codAtividade}Label"
									aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<form action="atividade" method="post">
												<div class="modal-header">
													<h5 class="modal-title" id="modal-${a.codAtividade}Label">Edição
														de Exercícios</h5>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="modal-body">

													<input type="hidden" value="editar" name="acao" /> <input
														type="hidden" value="${a.codAtividade}"
														name="codAtividade" />

													<div class="form-group row">
														<label for="inputData" class="col-sm-2 col-form-label">Data</label>
														<div class="col-sm-10">
															<input class="form-control" type="date"
																value="${a.dtAtividade}" name="dtAtividade"
																id="inputData">
														</div>
													</div>

													<div class="form-group row">
														<label for="inputExercicio"
															class="col-sm-2 col-form-label">Exercício</label>
														<div class="col-sm-10">
															<select name="nome" value="${a.nome}"
																class="form-control" id="inputExercicio">
																<option>Corrida</option>
																<option>Basquete</option>
																<option>Natação</option>
																<option>Futebol</option>
															</select>
														</div>
													</div>

													<div class="form-group row">
														<label for="inputCalorias" class="col-sm-2 col-form-label">Duração</label>
														<div class="col-sm-10">
															<input type="number" value="200" nome="duracaoAtividade"
																value="${a.duracaoAtividade}" class="form-control"
																id="inputCalorias">
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