<%-- 
    Document   : panelAdministrador
    Created on : 10-jun-2018, 12:50:15
    Author     : Pedro
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
                                <s:form action="irLogin"><button type="submit" class="btn btn-light">Login</button></s:form>
                                <s:form action="irRegistro"><button type="submit" class="btn btn-dark">Registro</button></s:form>
                            </s:if><s:else>
                                <s:form action="irPerfil"><button type="submit" class="btn btn-light">Ver Perfil</button></s:form>
                                <s:form action="logout"><button type="submit" class="btn btn-dark">Logout</button></s:form>
                            </s:else>
                            <s:if test="%{#session.rol == \"admin\"}">
                                <s:form action="irAdmin"><s:submit cssClass="btn btn-light" value="Panel Administración"></s:submit></s:form>
                            </s:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container accordion mt-5">
            <h1 class="text-center">Administración</h1>
            <div class="card">
                <div class="card-header list-group-item-warning" id="headingTwo">
                    <h5 class="mb-0">
                        <button class="btn btn-link collapsed text-body" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                            Administrar Categorías
                        </button>
                    </h5>
                </div>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                    <div class="card-body">
                        
                        <s:form action="crearCategoria" theme="simple">
                            <div class="form-inline my-3">
                            <s:textfield placeholder="Nueva categoría" name="nombreCategoria" cssClass="form-control"></s:textfield>
                                <button type="submit" class="btn btn-outline-success col-md-3 mx-3" data-toggle="tooltip" data-placement="bottom" title="Guardar cambios">
                                    <i class="fas fa-save"></i>
                                </button>
                                </div>
                        </s:form>
                        
                        <table id="myTableCat" class="table table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">Nombre</th>
                                    <th>Acción</th>
                                </tr>
                            </thead> 
                            <s:iterator value="categorias" var="categoria">
                                <tr>
                                    <td><s:property value="nombreCategoria"></s:property></td> 
                                        <td>
                                        <s:url var="borrarCategoria" action="borrarCategoria">
                                            <s:param name="nombreCategoria"><s:property value="nombreCategoria"></s:property></s:param>
                                        </s:url>
                                        <a href="<s:property value="#borrarCategoria" />" class="btn btn-outline-danger col-md-3 mx-1" data-toggle="tooltip" data-placement="bottom" title="Borrar categoria">
                                            <i class="fas fa-trash-alt"></i>
                                        </a>
                                    </td>
                                </tr>
                            </s:iterator>
                        </table>
                    </div> 
                </div>
            </div>
        </div>
        <div class="container accordion">
            <div class="">
                <div class="card">
                    <div class="card-header list-group-item-warning" id="headingOne">
                        <h5 class="mb-0 text-white">
                            <button class="btn btn-link text-body" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                Administrar Roles
                            </button>
                        </h5>
                    </div>
                    <div id="collapseOne" class="collapse text-body" aria-labelledby="headingOne" data-parent="#accordionExample">
                        <div class="card-body">
                            <input type="text" id="myInput" class="my-3 form-control" placeholder="Filtrar usuarios" onkeyup="busqueda()">
                            <table id="myTable" class="table table-bordered table-hover">
                                <thead>
                                <th scope="col">Usuario</th>
                                <th scope="col">Rol</th>
                                <th scope="col">Acción</th>
                                </tr>
                                </thead>
                                <s:iterator value="usuarios" var="usuario">
                                    <tr>
                                        <s:if test="%{rol != \"admin\"}">
                                            <td><s:property value="nombreUsuario"></s:property> </td> 
                                            <td><s:property value="rol"></s:property><br/></td>
                                                <td>
                                                    <div class="row">
                                                    <s:form cssClass="col-md-8" theme="simple" action="modRol">
                                                        <select name="rol">
                                                            <option value="lector">Lector</option>
                                                            <option value="redactor">Redactor</option>
                                                        </select>
                                                        <s:hidden value="%{nombreUsuario}" name="nombreUsuario"></s:hidden>
                                                            <button type="submit" class="btn btn-outline-success col-md-3 mx-3" data-toggle="tooltip" data-placement="bottom" title="Guardar cambios">
                                                                <i class="fas fa-save"></i>
                                                            </button>
                                                    </s:form>
                                                </div>
                                            </td>
                                        </s:if>
                                    </s:iterator>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
