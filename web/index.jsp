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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
    <link rel="stylesheet" href="stylesheet.css">
    <link href="https://fonts.googleapis.com/css?family=Merriweather" rel="stylesheet">

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
                    <h1 class="text-center font-weight-bold pt-1">
                        <span class="align-middle">
                            LA UPO
                            <span class="Orange">TOMORROW</span>
                        </span>
                    </h1>
                    <p class="text-center font-italic pb-1">Tu medio de desinformaci&oacute;n preferido</p>
                </div>
                <div class="col-md-4 text-center align-self-end">
                    <div class="btn-group align-bottom mb-4">
                        <s:if test="%{#session.usuario == null}">
                        <s:form action="irLogin"><button type="submit" class="btn btn-light">Login</button></s:form>
                         <s:form action="irRegistro"><button type="submit" class="btn btn-dark">Registro</button></s:form>
                        </s:if><s:else>
                            <s:form action="irPerfil"><button type="submit" class="btn btn-light">Ver Perfil</button></s:form>
                         <s:form action="logout"><button type="submit" class="btn btn-dark">Logout</button></s:form>
                         <s:if test="%{#session.rol == \"redactor\"}">
                             <s:form action="irRedactar"><button type="submit" class="btn btn-primary">Redactar</button></s:form>
                         </s:if>
                        </s:else>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <s:form action="buscar">
        <s:textfield name="busqueda"/>
        <s:submit value="Buscar"/>
    </s:form>
    <s:if test="%{mensajeError != null}">
        <div class="container my-4">
            <div class="alert alert-danger" role="alert">
                <s:property value="mensajeError"></s:property>
            </div>
        </div>
    </s:if>
    <s:iterator value="coincidencias" var="noticia" >
                    
                    <s:url action="irNoticia" var="idNoticia" >
                        <s:param name="idNoticia"><s:property value="idNoticia"></s:property></s:param>
                    </s:url>
                    <a href="<s:property value="#idNoticia" />" > <s:property value="tituloNoticia"></s:property> </a>
                   <br>
                    
                   
    </s:iterator>
                   
    <s:iterator value="coincidencias" var="noticia">
        <s:property value="tituloNoticia"></s:property>
    </s:iterator>
    
    
</body>
