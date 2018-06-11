<%-- 
    Document   : noticia
    Created on : 07-jun-2018, 17:59:41
    Author     : Pedro
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
                    
                </div>
            </div>
        </div>

        <s:if test="%{mensajeError != null}">
        <div class="container my-4">
            <div class="alert alert-danger" role="alert">
                <s:property value="mensajeError"></s:property>
            </div>
        </div>
    </s:if>
        <div class="container my-4">
            <div class="row">
                <div class="col-md-8 offset-md-2">
                    <h1 class="text-center">Registro</h1>
                    <s:form action="registrar" theme="simple" validate="true">
                        <div class="form-group">
                            <div class="form-group">
                                <s:fielderror fieldName="nombre_usuario" cssClass="alert alert-danger"/>
                                <label>Usuario</label>
                                <s:textfield cssClass="form-control" type="text" name="nombre_usuario"/>
                            </div>
                            <div class="form-group">
                                <s:fielderror fieldName="password" cssClass="alert alert-danger"/>
                                <label>Contrase&ntilde;a</label>
                                <s:textfield cssClass="form-control" type="password" name="password"/>
                            </div>
                            <div class="form-group">
                                <s:fielderror fieldName="nombre_real" cssClass="alert alert-danger"/>
                                <label>Nombre Real</label>
                                <s:textfield cssClass="form-control" type="text" name="nombre_real"/>
                            </div>
                            <div class="form-group">
                                <s:fielderror fieldName="email" cssClass="alert alert-danger"/>
                                <label>E-Mail</label>
                                <s:textfield cssClass="form-control" type="email" name="email"/>
                            </div>
                            <div class="form-group">
                                <s:fielderror fieldName="localizacion" cssClass="alert alert-danger"/>
                                <label>Localización</label>
                                <s:textfield cssClass="form-control" type="text" name="localizacion"/>
                            </div>
                            <s:submit cssClass="btn btn-primary" value="Registro"/>
                        </div>

                    </s:form>

                </div>
            </div>
        </div>
    </body>
</html>
