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
                    <h5 class="text-format-secondary"><i class="fas fa-running"></i> Exercícios</h5>
                </div>
            </div>
        </div>

        <div class="mx-auto col-md-6 col-sm-12 card-content" style="margin-top:1rem;">
            <div class="card">
                <div class="card-body ">
                    <h5>Junho</h5>
                    <table class="table table-hover text-center">
                        <thead>
                            <tr>
                                <th scope="col" class="text-format-primary">Data</th>
                                <th scope="col" class="text-format-primary">Exercício</th>
                                <th scope="col" class="text-format-primary">Calorias</th>
                                <th scope="col" class="text-format-primary">Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Segunda, 1 de junho</td>
                                <td>Corrida</td>
                                <td>200 Kcal</td>
                                <td>
                                    <button type="button" style="border: none;" class="text-format-primary"
                                        data-toggle="modal" data-target="#exampleModal">
                                        <i class="fas fa-edit"></i>
                                    </button>
                                    <button type="button" style="border: none;" class="text-format-primary">
                                        <i class="fas fa-trash-alt"></i>
                                    </button>
                                </td>
                            </tr>
                            <tr>
                                <td>Quarta, 3 de junho</td>
                                <td>Natação</td>
                                <td>530 Kcal</td>

                                <td>
                                    <button type="button" style="border: none;" class="text-format-primary"
                                        data-toggle="modal" data-target="#exampleModal">
                                        <i class="fas fa-edit"></i>
                                    </button>
                                    <button type="button" style="border: none;" class="text-format-primary">
                                        <i class="fas fa-trash-alt"></i>
                                    </button>
                                </td>
                            </tr>
                            <tr>
                                <td>Sábado, 13 de junho</td>
                                <td>Basquete</td>
                                <td>800 Kcal</td>

                                <td>
                                    <button type="button" style="border: none;" class="text-format-primary"
                                        data-toggle="modal" data-target="#exampleModal">
                                        <i class="fas fa-edit"></i>
                                    </button>
                                    <button type="button" style="border: none;" class="text-format-primary">
                                        <i class="fas fa-trash-alt"></i>
                                    </button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- END CONTENT -->

        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
            aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Edição de peso</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group row">
                                <label for="inputData" class="col-sm-2 col-form-label">Data</label>
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

                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn btn-primary custom-btn">Salvar</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>