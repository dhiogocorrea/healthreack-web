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
                    <h5 class="text-format-secondary"><i class="fas fa-utensils"></i> Refeições</h5>
                </div>
            </div>
        </div>

        <div class="mx-auto col-md-6 col-sm-12 card-content" style="margin-top:1rem;">
            <div class="card">
                <div class="card-body ">
                    <table class="table table-hover text-center">
                        <thead>
                            <tr>
                                <th colspan="3" class="text-format-primary">
                                    <button type="button" style="border: none;" class="text-format-primary">
                                        <input class="form-control" type="date" value="2020-06-09" id="inputData">
                                    </button>
                                    <button type="button" style="border: none;" class="text-format-primary">
                                        <i class="fas fa-search"></i>
                                    </button>

                                </th>
                            </tr>
                            <tr>
                                <th scope="col" class="text-format-primary">Refeição</th>
                                <th scope="col" class="text-format-primary">Calorias</th>
                                <th scope="col" class="text-format-primary">Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Café da manhã</td>
                                <td>275 Kcal</td>
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
                                <td>Almoço</td>
                                <td>830 Kcal</td>
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
                                <td>Janta</td>
                                <td>720 Kcal</td>
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
                                        <input class="form-control" type="text" value="Pasta de amendoim"
                                            id="inputAlimento1">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="inputQuantidade1" class="col-sm-4 col-form-label">Quantidade (g)</label>
                                    <div class="col-sm-8">
                                        <input class="form-control" type="number" value="15" id="inputQuantidade1">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="inputCalorias1" class="col-sm-4 col-form-label">Calorias</label>
                                    <div class="col-sm-8">
                                        <input class="form-control" readonly type="number" value="130"
                                            id="inputCalorias1">
                                    </div>
                                </div>

                                <div style="border-top: 0.5px solid gray; margin-top: 1rem; padding: 10px;">
                                    <h5 class="text-format-primary">Alimento 2</h5>
                                    <div class="form-group row">
                                        <label for="inputAlimento2" class="col-sm-4 col-form-label">Alimento</label>
                                        <div class="col-sm-8">
                                            <input class="form-control" type="text" value="Banana" id="inputAlimento2">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="inputQuantidade2" class="col-sm-4 col-form-label">Quantidade
                                            (g)</label>
                                        <div class="col-sm-8">
                                            <input class="form-control" type="number" value="100" id="inputQuantidade2">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="inputCalorias2" class="col-sm-4 col-form-label">Calorias</label>
                                        <div class="col-sm-8">
                                            <input class="form-control" readonly type="number" value="145"
                                                id="inputCalorias2">
                                        </div>
                                    </div>

                                </div>
                                <button type="button" style="border: none;" class="text-format-primary">
                                    <i class="fas fa-plus-circle"></i>
                                </button>
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