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
                        </s:a>
                    <p class="text-center font-italic pb-1">Tu medio de desinformaci&oacute;n preferido</p>
                </div>
                <div class="col-md-4 text-center align-self-end">
                    <div class="btn-group align-bottom mb-4">
                    </div>
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
                  <h1 class="text-center">Login</h1>
                  <s:form action="login" theme="simple">
                       <div class="form-group">
                           <s:fielderror fieldName="usuario" cssClass="alert alert-danger"/>
                          <label>Usuario</label>
                          <input type="text" class="form-control" name="usuario" placeholder="Introduce Usuario">
                      </div>
                      <div class="form-group">
                          <s:fielderror fieldName="password" cssClass="alert alert-danger"/>
                          <label>Contrase&ntilde;a</label>
                          <input type="password" class="form-control" name="password" placeholder="Introduce Contrase&ntilde;a">
                      </div>
                      <button type="submit" class="btn btn-primary">Login</button>
                  </s:form>
                 
              </div>
        </div>
    </div>
    
    
</body>
