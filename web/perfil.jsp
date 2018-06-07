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
                            </s:else>
                        </div>
                    </div>
                    <s:form action="irModPerfil"><button type="submit" class="btn btn-light">Mod Perfil</button></s:form>
                    </div>
                </div>
            </div>
            <div>
            Nombre Usuario: <s:property value="nombreUsuario"></s:property>
            Nombre y Apellidos: <s:property value="nombreReal"></s:property>
            Email:<s:property value="email"></s:property>
            Localizacion: <s:property value="localizacion"></s:property>
            Rol: <s:property value="rol"></s:property>
        </div>



    </body>
</html>
