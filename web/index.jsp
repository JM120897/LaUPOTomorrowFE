<%-- 
    Document   : login
    Created on : 17-may-2018, 11:28:30
    Author     : Juanma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html lang="es">

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
        <div class="row my-3">
            <div class="col-md-2 mx-5">
                <div class="card card-body bg-warning">
                    <h4>Categorías</h4>
                    <ul class="list-group">
                        <s:url action="irCategoria" var="nombreCategoria" >
                            <s:param name="categoria"><s:property value="nombreCategoria"></s:property></s:param>
                        </s:url>
                        <s:iterator value="categorias" var="categoria">
                            
                            <li class="list-group-item">
                                <s:url action="irCategoria" var="idCategoria">
                                    <s:param name="categoria"><s:property value="nombreCategoria"></s:property></s:param>
                                </s:url>
                                <a href="<s:property value="#idCategoria" />" > <s:property value="nombreCategoria"></s:property> </a>
                            </li>
                        </s:iterator>
                    </ul>
                </div>
            </div>
            <div class="col-md-6 mx-5">
                <s:form action="buscar" theme="simple">
                    <div class="row mb-3">
                        <s:textfield name="busqueda" placeholder="Busca!" cssClass="form-control col-md-8 mx-1"/>
                        <s:submit cssClass="btn btn-outline-warning col-md-3 mx-1" value="Buscar"></s:submit>
                        </div>
                </s:form>
                <s:if test="%{mensajeError != null}">
                    <div class="container my-4">
                        <div class="alert alert-danger" role="alert">
                            <s:property value="mensajeError"></s:property>
                            </div>
                        </div>
                </s:if>
                <s:iterator value="coincidencias" var="noticia">
                    <div class="row">
                        <div class="col-md-8">
                            <h3 class="my-3">
                                <s:url action="irNoticia" var="idNoticia">
                                    <s:param name="idNoticia"><s:property value="idNoticia"></s:property></s:param>
                                </s:url>
                                <a href="<s:property value="#idNoticia" />" > <s:property value="tituloNoticia"></s:property> </a>
                                </h3><br/>
                            <s:property value="fechaNoticia"></s:property>
                            </div>
                            <div class="col align-self-center">
                                <image><img src="<s:property value="imagen"/>" width="100%"/></image>
                        </div>
                    </div>
                    <hr class="my-4">
                </s:iterator>



                </body>
                </html>
