<%-- 
    Document   : modPerfil
    Created on : 07-jun-2018, 16:56:02
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
        <script type="text/javascript">
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
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
                    <h1 class="text-center">Modificar Perfil</h1>
                    <s:form action="modPerfil" theme="simple" validate="true">
                        <s:hidden name="nombreUsuario" value="%{nombreUsuario}"> </s:hidden>
                            <s:fielderror fieldName="nombreReal" cssClass="alert alert-danger"/>
                            <div class="form-group">
                                <label>Nombre y Apellidos</label>
                            <s:textfield cssClass="form-control" key="Nombre y Apellidos" name="nombreReal" value="%{nombreReal}"> </s:textfield>
                            </div>
                            <s:fielderror fieldName="password" cssClass="alert alert-danger"/>
                            <div class="form-group">
                                <label>Contraseña</label>
                            <s:textfield type="password" cssClass="form-control" key="Contraseña" name="password" value="%{password}"> </s:textfield>
                            </div>
                            <s:fielderror fieldName="email" cssClass="alert alert-danger"/>
                            <div class="form-group">
                                <label>Email</label>
                            <s:textfield cssClass="form-control" key="Email" name="email" value="%{email}"> </s:textfield>
                            </div>
                            <s:fielderror fieldName="localizacion" cssClass="alert alert-danger"/>
                            <div class="form-group">
                                <label>Localizacacion</label>
                            <s:textfield cssClass="form-control" key="Localizacacion" name="localizacion" value="%{localizacion}"> </s:textfield>
                            </div>
                        <s:hidden name="rol" value="%{rol}"> </s:hidden>
                        <button type="submit" class="btn btn-outline-success col-md-3" data-toggle="tooltip" data-placement="bottom" title="Guardar cambios">
                                    <i class="fas fa-save"></i>
                                </button>
                    </s:form>
                </div>
            </div>
        </div>
    </body>
</html>
