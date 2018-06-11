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
            <div class="col-md-6 mx-5">
                <s:form theme="simple">
                    <div class="row">
                        <s:textfield placeholder="Busca!" cssClass="form-control col-md-8 mx-1"/>
                        <button type="submit" class="btn btn-outline-warning col-md-3 mx-1" ><i class="fas fa-search"></i></button>
                    </div>
                </s:form>
                <s:hidden name="idNoticia"  value="%{idNoticia}"></s:hidden>
                <h2 class="my-3"><s:property value="tituloNoticia"></s:property>.</h2>
                <h4 class="my-3"><s:property value="subtituloNoticia"></s:property>.</h4>
                <h4 class="my-3"><s:property value="nombreCategoria"></s:property></h4>
                <div class="text-muted"><s:property value="nombreUsuario"></s:property> - <s:property value="fechaNoticia"></s:property></div>
                <image><img src = "<s:property value="imagen"></s:property>" </img></image>
                    <hr class="my-4">
                    <p class="my-3"><s:property value="cuerpoNoticia"></s:property></p>
                <s:iterator value="tags" var="tag">
                    <span class="badge badge-secondary"><s:property value="nombreTag" ></s:property></span> 
                </s:iterator>
                <div class="mt-5">
                    <s:if test="%{#session.usuario == nombreUsuario}">
                        <s:url var="irModNot" action="irModNot">
                            <s:param name="idNoticia"><s:property value="idNoticia"></s:property></s:param>
                        </s:url>
                        <a href="<s:property value="#irModNot" />" class="btn btn-outline-warning col-md-3 mx-1" data-toggle="tooltip" data-placement="bottom" title="Modificar noticia">
                            <i class="fas fa-pencil-alt"></i>
                        </a>

                        <s:url var="borrarNot" action="borrarNot">
                            <s:param name="idNoticia"><s:property value="idNoticia"></s:property></s:param>
                        </s:url>
                        <a href="<s:property value="#borrarNot" />" class="btn btn-outline-danger col-md-3 mx-1" data-toggle="tooltip" data-placement="bottom" title="Borrar noticia">
                            <i class="fas fa-trash-alt"></i>
                        </a>
                    </s:if>
                </div>
                <div class="mt-5">
                    <h4>Cometarios</h4>
                    <s:if test="%{#session.usuario != null}">
                        <s:form action="comentar" theme="simple"> 
                            <s:textarea cssClass="form-control" col="5" rows="5"  name="mensaje">
                            </s:textarea>
                            <s:hidden name="nombreUsuario" value="%{#session.usuario}"></s:hidden>
                            <s:hidden name="idNoticia"  value="%{idNoticia}"></s:hidden>
                            <s:submit value="Enviar"></s:submit>
                        </s:form>
                    </s:if> 
                    <div class="container card">
                        <s:iterator value="listaComentarios" var="comentario">
                            <div class="card-body">
                                <div class="text-muted">
                                    <s:property value="nombreUsuario"></s:property> -   <s:property value="fechaComentario"></s:property><br><br>
                                    </div>
                                <s:property value="mensaje"></s:property> <br>



                                <s:if test="%{#session.usuario == nombreUsuario}">
                                    <s:url var="irModCom" action="irModCom">

                                        <s:param name="idComentario"><s:property value="idComentario"></s:property></s:param>

                                        <s:param name="idNoticia"><s:property value="idNoticia2"></s:property></s:param>
                                    </s:url>
                                    <a href="<s:property value="#irModCom" />" class="btn btn-outline-warning col-md-3 mx-1" data-toggle="tooltip" data-placement="bottom" title="Modificar comentario">
                                        <i class="fas fa-pencil-alt"></i>
                                    </a>

                                    <s:url var="borrarCom" action="borrarCom">
                                        <s:param name="idNoticia"><s:property value="idNoticia2"></s:property></s:param>
                                        <s:param name="idComentario"><s:property value="idComentario"></s:property></s:param>
                                    </s:url>
                                    <a href="<s:property value="#borrarCom" />" class="btn btn-outline-danger col-md-3 mx-1" data-toggle="tooltip" data-placement="bottom" title="Borrar comentario">
                                        <i class="fas fa-trash-alt"></i>
                                    </a>
                                </s:if>
                            </div>
                        </div>
                        <hr class="my-4">
                    </s:iterator>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
