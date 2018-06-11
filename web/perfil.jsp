<%-- 
    Document   : perfil
    Created on : 07-jun-2018, 16:48:31
    Author     : ferna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <!-- jQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!-- CSS -->
        <link rel="stylesheet" href="stylesheet.css">
        <!-- Fuentes e iconos -->
        <link href="https://fonts.googleapis.com/css?family=Merriweather" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
        <!-- Bootstrap JavaScript -->
        <script src="bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

        <s:url id="url" action="index">
        </s:url>
        <title>UPO Tomorrow</title>
    </head>
    <body>
        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });

            function busqueda() {
                // Declare variables 
                var input, filter, table, tr, td, i;
                input = document.getElementById("myInput");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");

                // Loop through all table rows, and hide those who don't match the search query
                for (i = 0; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[0];
                    if (td) {
                        if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
            }

            function busquedaHis() {
                // Declare variables 
                var input, filter, table, tr, td, i;
                input = document.getElementById("myInputHis");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTableHis");
                tr = table.getElementsByTagName("tr");

                // Loop through all table rows, and hide those who don't match the search query
                for (i = 0; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[0];
                    if (td) {
                        if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
            }
        </script>

        <div class="container-fluid DarkBlue">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 text-center align-self-end">
                        <img src='logo.png' alt='' width="80%"/>
                    </div>
                    <div class="col-md-4">
                        <s:a href="%{url}" cssStyle="text-decoration: none">
                            <h1 class="text-white text-center font-weight-bold pt-1">
                                <span class="align-middle">
                                    LA UPO
                                    <span class="Orange">TOMORROW</span>
                                </span>
                            </h1>
                            <p class="text-white text-center font-italic pb-1">Tu medio de desinformaci&oacute;n preferido</p>
                        </s:a>
                    </div>
                    <div class="col-md-4 text-center align-self-end">
                        <div class="btn-group align-bottom mb-4">
                            <s:if test="%{#session.usuario == null}">
                                <s:form action="irLogin"><s:submit cssClass="btn btn-light" value="Login"></s:submit></s:form>
                                <s:form action="irRegistro"><s:submit cssClass="btn btn-dark" value="Registro"></s:submit></s:form>
                            </s:if><s:else>
                                <s:form action="irPerfil"><s:submit cssClass="btn btn-light" value="Ver Perfil"></s:submit></s:form>
                                <s:form action="logout"><s:submit cssClass="btn btn-dark" value="Logout"></s:submit></s:form>
                                <s:if test="%{#session.rol == \"redactor\"}">
                                    <s:form action="irRedactar"><s:submit cssClass="btn btn-primary" value="Redactar"></s:submit></s:form>
                                    <s:form action="irCrearHistoria"><s:submit cssClass="btn btn-primary" value="Crear Historia"></s:submit></s:form>
                                    <s:form action="irNotificaciones"><s:submit cssClass="btn btn-warning" value="%{numNoti}"></s:submit></s:form>
                                </s:if>
                                <s:if test="%{#session.rol == \"admin\"}">
                                    <s:form action="irAdmin"><s:submit cssClass="btn btn-light" value="Panel Administración"></s:submit></s:form>
                                </s:if>
                            </s:else>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <div class="container my-4">
            <div class="row">
                <div class="col-md-8 offset-md-2">
                    <h1 class="text-center">Perfil</h1>
                    <div class="container card">
                        <div class="card-body">
                            <h5>Nombre de usuario</h5>
                            <s:property value="nombreUsuario"></s:property>
                                <hr class="my-4">
                                <h5>Nombre completo</h5>
                            <s:property value="nombreReal"></s:property>
                                <hr class="my-4">
                                <h5>Email</h5>
                            <s:property value="email"></s:property>
                                <hr class="my-4">
                                <h5>Dirección</h5>
                            <s:property value="localizacion"></s:property>
                            </div>
                        </div>
                        <div class="row justify-content-around mt-5">

                        <s:url var="modPerfil" action="irModPerfil">
                            <s:param name="nombreUsuario"><s:property value="nombreUsuario"></s:property></s:param>
                        </s:url>
                        <a href="<s:property value="#modPerfil" />" class="btn btn-outline-warning col-md-3 mx-1" data-toggle="tooltip" data-placement="bottom" title="Editar usuario">
                            <i class="fas fa-pencil-alt"></i>
                        </a>

                        <s:url var="borrarPerfil" action="borrarPerfil">
                            <s:param name="nombreUsuario"><s:property value="nombreUsuario"></s:property></s:param>
                        </s:url>
                        <a href="<s:property value="#borrarPerfil" />" class="btn btn-outline-danger col-md-3 mx-1" data-toggle="tooltip" data-placement="bottom" title="Borrar usuario">
                            <i class="fas fa-trash-alt"></i>
                        </a>
                    </div>
                    <s:if test="%{#session.rol=='redactor'}">
                        <div class="mt-5">
                            <h3>Noticias redactadas por ti:</h3>
                            <input type="text" id="myInput" class="my-3 form-control" placeholder="Filtrar noticias" onkeyup="busqueda()">
                            <table name="myTable" class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Título</th>
                                        <th scope="col">Fecha</th>
                                        <th scope="col">Opciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <s:iterator value="listaNoticia" var="noticia" >
                                        <tr>
                                            <th scope="row"><s:property value="idNoticia"></s:property></th>
                                                <td>
                                                <s:url action="irNoticia" var="idNoticia" >
                                                    <s:param name="idNoticia"><s:property value="idNoticia"></s:property></s:param>
                                                </s:url>
                                                <a href="<s:property value="#idNoticia" />" > <s:property value="tituloNoticia"></s:property> </a>
                                                </td>
                                                <td><s:property value="fechaNoticia"></s:property></td>
                                                <td>
                                                    <div class="row justify-content-around">
                                                    <s:url var="modNoticia" action="irModNot">
                                                        <s:param name="idNoticia"><s:property value="idNoticia"></s:property></s:param>
                                                    </s:url>
                                                    <s:url var="borrarNoticia" action="borrarNoticia">
                                                        <s:param name="idNoticia"><s:property value="idNoticia"></s:property></s:param>
                                                    </s:url>
                                                    <a href="<s:property value="#modNoticia" />" class="btn btn-outline-warning col-md-3 mx-1" data-toggle="tooltip" data-placement="bottom" title="Editar noticia">
                                                        <i class="fas fa-pencil-alt"></i>
                                                    </a>
                                                    <a href="<s:property value="#borrarNoticia" />" class="btn btn-outline-danger col-md-3 mx-1" data-toggle="tooltip" data-placement="bottom" title="Borrar noticia">
                                                        <i class="fas fa-trash-alt" ></i>
                                                    </a>
                                                </div>
                                            </td>
                                        </tr>
                                    </s:iterator>
                                </tbody>
                            </table>
                        </div>

                        <div class="mt-5">
                            <h3>Historias redactadas por ti:</h3>
                            <input type="text" id="myInputHis" class="my-3 form-control" placeholder="Filtrar noticias" onkeyup="busqueda()">
                            <table name="myTableHis" class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Título</th>
                                        <th scope="col">Fecha</th>
                                        <th scope="col">Opciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <s:iterator value="listaHistoriasUsuario" var="historia" >
                                        <tr>
                                            <th scope="row"><s:property value="idHistoria"></s:property></th>
                                            <td><s:url action="irHistoria" var="idHistoria" >
                                                    <s:param name="idHistoria"><s:property value="idHistoria"></s:property></s:param>
                                                </s:url>
                                                <a href="<s:property value="#idHistoria" />" > <s:property value="tituloHistoria"></s:property> </a></td>
                                            <td><s:property value="fechaHistoria"></s:property></td>
                                                <td>
                                                <s:url var="modHistoria" action="irModHis">
                                                    <s:param name="idHistoria"><s:property value="idHistoria"></s:property></s:param>
                                                </s:url>
                                                <s:url var="borrarHistoria" action="borrarHistoria">
                                                    <s:param name="idHistoria"><s:property value="idHistoria"></s:property></s:param>
                                                </s:url>
                                                <div class="row justify-content-around">
                                                    <a href="<s:property value="#modHistoria" />" class="btn btn-outline-warning col-md-3 mx-1" data-toggle="tooltip" data-placement="bottom" title="Editar historia">
                                                        <i class="fas fa-pencil-alt"></i>
                                                    </a>
                                                    <a href="<s:property value="#borrarHistoria" />" class="btn btn-outline-danger col-md-3 mx-1" data-toggle="tooltip" data-placement="bottom" title="Borrar historia">
                                                        <i class="fas fa-trash-alt" ></i>
                                                    </a>
                                                </div>
                                            </td>
                                        </tr>
                                    </s:iterator>
                                </tbody>
                            </table>
                        </div>
                    </s:if>
                </div>
            </div>
        </div>
    </body>
</html>
