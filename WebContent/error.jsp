<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Início</title>
    <%@ include file="header.jsp" %>
    <meta http-equiv="Refresh" content="5;url=home.jsp">
</head>

<body>
    <%@ include file="menu.jsp" %>

    <!-- CONTENT -->
    <div class="container-fluid card-content">
        <div class="mx-auto col-md-6 col-sm-12 card-content" style="margin-top:1rem;">
            <div class="card">
                <div class="card-body text-center">
                    <h5 class="text-format-primary"><i class="fas fa-exclamation-triangle"></i> Oops!</h5>
                </div>
            </div>
        </div>

        <div class="mx-auto col-md-6 col-sm-12 card-content" style="margin-top:1rem;">
            <form>
                <div class="card">
                    <div style="font-size: 20px;" class="card-body text-center text-format-primary">
                        Parece que você tentou fazer algo que não deu muito certo, não?
                        <br>
                        Mas não se preocupe, estaremos lhe redirecionando para a tela inicial em breve.
                    </div>
                    <div id="forward-div"></div>
                </div>
            </form>
        </div>
        <!-- END CONTENT -->
    </div>
</body>

</html>