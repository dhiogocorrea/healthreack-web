<%@page import="com.grupo30.enums.TipoRefeicao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem de refeições</title>
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
						<i class="fas fa-utensils"></i> Refeições
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
								<th scope="col" class="text-format-primary">Data Refeição</th>
								<th scope="col" class="text-format-primary">Refeição</th>
								<th scope="col" class="text-format-primary">Calorias</th>
								<th scope="col" class="text-format-primary">Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${refeicoes}" var="r">
								<tr>
									<td style="display: none;">${r.codRefeicao}</td>
									<td>${r.dtRefeicao}</td>
									<td>${r.tipoRefeicao}</td>
									<td>${r.calorias}Kcal</td>
									<td>
										<button type="button" style="border: none;"
											class="text-format-primary" data-toggle="modal"
											data-target="#modal-${r.codRefeicao}">
											<i class="fas fa-edit"></i>
										</button>
										<form action="refeicao" method="post">
											<input type="hidden" value="excluir" name="acao" />
											<button type="submit" style="border: none;"
												class="text-format-primary">
												<i class="fas fa-trash-alt"></i>
											</button>
										</form>
									</td>
								</tr>

								<!-- Modal -->
								<div class="modal fade" id="modal-${r.codRefeicao}"
									tabindex="-1" role="dialog"
									aria-labelledby="modal-${r.codRefeicao}Label"
									aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<form action="refeicao" method="post">
												<div class="modal-header">
													<h5 class="modal-title" id="modal-${r.codRefeicao}Label">Edição
														de Refeição</h5>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="modal-body">
													<input type="hidden" value="editar" name="acao" />
													<input type="hidden" value="${codUsuario}" />
													<input type="hidden" value="${r.codRefeicao}" name="codRefeicao" />
													<div class="form-group row">
														<label for="inputData" class="col-sm-2 col-form-label">Data</label>
														<div class="col-sm-10">
															<input class="form-control" type="date" name="dtRefeicao"
																value="${r.dtRefeicao}" id="inputData">
														</div>
													</div>

													<div class="form-group row">
														<label for="tipoRefeicao"
															class="col-sm-2 col-form-label">Refeição</label>
														<div class="col-sm-10">
															<select name="tipoRefeicao"
																class="form-control" id="tipoRefeicao">
																<option value="CAFEMANHA" ${r.tipoRefeicao == TipoRefeicao.CAFEMANHA ? 'selected' : ''}>Café da manhã</option>
																<option value="ALMOCO"  ${r.tipoRefeicao == TipoRefeicao.ALMOCO ? 'selected' : ''}>Almoço</option>
																<option value="CAFETARDE"  ${r.tipoRefeicao == TipoRefeicao.CAFETARDE ? 'selected' : ''}>Café da Tarde</option>
																<option value="JANTA"  ${r.tipoRefeicao == TipoRefeicao.JANTA ? 'selected' : ''}>Janta</option>
															</select>
														</div>
													</div>
													<div class="form-group row">
														<label for="inputData" class="col-sm-2 col-form-label">Calorias</label>
														<div class="col-sm-10">
															<input class="form-control" type="date" name="calorias"
																value="${r.calorias}" id="inputCalorias">
														</div>
													</div>
													<button type="button" style="border: none;"
														class="text-format-primary">
														<i class="fas fa-plus-circle"></i>
													</button>
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