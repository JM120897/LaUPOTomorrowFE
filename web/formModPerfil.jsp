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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hasdasdasda!</h1>
       <s:form action="modPerfil">
            <s:hidden name="nombreUsuario" value="%{nombreUsuario}"> </s:hidden>
            <s:textfield key="Nombre y Apellidos" name="nombreReal" value="%{nombreReal}"> </s:textfield>
            <s:textfield key="Contraseña" name="password" value="%{password}"> </s:textfield>
            <s:textfield key="Email" name="email" value="%{email}"> </s:textfield>
            <s:textfield key="Localizacacion" name="localizacion" value="%{localizacion}"> </s:textfield>
            <s:hidden name="rol" value="%{rol}"> </s:hidden>
            <s:submit name="Modificar" value="Modificar"></s:submit>
        </s:form>
    </body>
</html>
