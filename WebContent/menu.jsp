<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01"
            aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
            <a class="navbar-brand" href="home.jsp">
                <img src="resources/img/logo.png" width="52" height="52">
            </a>

            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item">
                    <a class="nav-link " href="home.jsp"><strong><i class="fas fa-home"></i> Início</strong> </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                        aria-haspopup="true" aria-expanded="false"><strong><i class="fas fa-utensils"></i>
                            Alimentação</strong></a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item text-format-primary" href="adicionar-refeicao.jsp"><i
                                class="fas fa-plus-square"></i>
                            Adicionar refeição</a>
                        <a class="dropdown-item text-format-primary" href="listagem-refeicoes.jsp"><i
                                class="fas fa-clipboard-list"></i>
                            Mostrar refeições</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                        aria-haspopup="true" aria-expanded="false"><strong><i class="fas fa-running"></i>
                            Exercícios</strong></a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item text-format-primary" href="adicionar-exercicio.jsp"><i
                                class="fas fa-plus-square"></i>
                            Adicionar exercício</a>
                        <a class="dropdown-item text-format-primary" href="listagem-exercicios.jsp"><i
                                class="fas fa-clipboard-list"></i>
                            Mostrar exercícios </a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                        aria-haspopup="true" aria-expanded="false"><strong><i class="fas fa-weight"></i>
                            Peso</strong></a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item text-format-primary" href="adicionar-peso.jsp"><i
                                class="fas fa-plus-square"></i>
                            Adicionar peso</a>
                        <a class="dropdown-item text-format-primary" href="listagem-pesos.jsp"><i
                                class="fas fa-clipboard-list"></i>
                            Mostrar pesos</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                        aria-haspopup="true" aria-expanded="false"><strong><i class="fas fa-heartbeat"></i>
                            Batimentos</strong></a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item text-format-primary" href="adicionar-batimento.jsp"><i
                                class="fas fa-plus-square"></i>
                            Adicionar batimento</a>
                        <a class="dropdown-item text-format-primary" href="listagem-batimentos.jsp"><i
                                class="fas fa-clipboard-list"></i>
                            Mostrar batimentos</a>
                    </div>
                </li>
            </ul>

        </div>

        <div class="form-inline" id="navbarTogglerDemo02">
            <div class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" style="margin-left: 1rem; margin-right: 2rem;"
                    data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"><strong><i
                            class="fas fa-user"></i>
                        Perfil</strong></a>
                <div class="dropdown-menu">
                    <a class="dropdown-item text-format-primary" href="conta.jsp"><i class="fas fa-address-card"></i>
                        Sua
                        conta</a>
                    <a class="dropdown-item text-format-primary" href="mailto:guilherme.santos97@outlook.com.br"><i
                            class="fas fa-headset"></i> Suporte</a>
                    <a class="dropdown-item text-format-primary" href="index.jsp"><i class="fas fa-sign-out-alt"></i>
                        Sair</a>
                </div>
            </div>
        </div>
    </nav>