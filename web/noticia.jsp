<%-- 
    Document   : noticia
    Created on : 07-jun-2018, 17:59:41
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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <link rel="stylesheet" href="stylesheet.css">
        <link href="https://fonts.googleapis.com/css?family=Merriweather" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
        <s:url id="url" action="index">
        </s:url>
        <title>UPO Tomorrow</title>
    </head>

    <body>
        <div class="container-fluid DarkBlue">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 text-center align-self-end">
                        <img class="rounded my-4" src='http://placekitten.com/88/88' alt='' />
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
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row my-3">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <s:form theme="simple">
                        <div class="row">
                            <s:textfield placeholder="Busca!" cssClass="form-control col-md-8 mx-1"/>
                            <button type="submit" class="btn btn-outline-warning col-md-3 mx-1" ><i class="fas fa-search"></i></button>
                        </div>
                    </s:form>
                </div>
                <div class="col-md-3"></div>
            </div>
            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-md-10">
                    <h2 class="my-3"><s:property value="tituloNoticia"></s:property>.</h2>
                    <h4 class="my-3"><s:property value="subtituloNoticia"></s:property>.</h4>
                     <h4 class="my-3"><s:property value="nombreCategoria"></s:property></h4>
                    <div class="text-muted"><s:property value="nombreUsuario"></s:property> - <s:property value="fechaNoticia"></s:property></div>
                        <image></image>
                        <hr class="my-4">
                            <p class="my-3"><s:property value="cuerpoNoticia"></s:property></p>
                        <span class="badge badge-secondary"></span> 
                    </div>
                <s:if test="%{#session.usuario == nombreUsuario}">
                    <s:form action="irModNot">
                        <s:hidden name="idNoticia"  value="%{idNoticia}"></s:hidden>
                        <s:submit  value="Modificar Noticia"></s:submit>

                    </s:form>
                </s:if>
                <div class="col-md-1">

                </div>
            </div>
        </div>
    </body>
</html>
