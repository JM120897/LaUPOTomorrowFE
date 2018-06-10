<%-- 
    Document   : administracion
    Created on : 10-jun-2018, 12:43:08
    Author     : Juanma
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
        <h1>Hello World!</h1>
        <s:form action="crearCategoria">
                <s:textfield name="nombreCategoria"></s:textfield>
                <s:submit value="Crear"></s:submit>
            </s:form>
        <s:iterator value="categorias" var="categoria">
            
        <s:property value="nombreCategoria"></s:property>
            <s:form action="borrarCategoria">
                <s:hidden value="%{nombreCategoria}" name="nombreCategoria"></s:hidden>
                <s:submit value="borrar %{nombreCategoria}"></s:submit>
            </s:form>
        </s:iterator>
        
        <s:iterator value="usuarios" var="usuario">
            <s:if test="%{nombreUsuario != \"admin\"}">
            <s:property value="nombreUsuario"></s:property> - 
            <s:property value="rol"></s:property><br/>
            <s:form action="modRol">
                <select name="rol">
                    <option value="lector">Lector</option>
                    <option value="redactor">Redactor</option>
                </select>
                <s:hidden value="%{nombreUsuario}" name="nombreUsuario"></s:hidden>
                <s:submit value="Guardar %{nombreUsuario}"></s:submit>
            </s:form>
            </s:if>
        </s:iterator>
        
    </body>
</html>
