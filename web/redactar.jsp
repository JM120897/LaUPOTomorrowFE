<%-- 
    Document   : redactar
    Created on : 08-jun-2018, 13:39:32
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
        <s:form action="nuevaNoticia" theme="simple">
            <h1>Titulo</h1>
            <s:textfield name="tituloNoticia"></s:textfield><br/>
            <h1>Subtitulo</h1>
            <s:textfield name="subtituloNoticia"></s:textfield><br/>
            <h1>Cuerpo</h1>
            <s:textfield name="cuerpoNoticia"></s:textfield><br/>
            <h1>URL IMATGE</h1>
            <s:textfield name="imagen"></s:textfield><br/>
            <h1>TAGS</h1>
            <s:textfield name="tag"></s:textfield><br/>
            <h1>LOCALIZACION</h1>
            <s:textfield name="localizacion"></s:textfield><br/>
            <s:select list="categorias" name="categoria" listValue="nombreCategoria" listKey="nombreCategoria" >
            </s:select>
            <s:select list="historias" name="historia" listValue="tituloHistoria" listKey="idHistoria" headerValue="Ninguna" headerKey="-1">
            </s:select>
            <s:hidden name="nombreUsuario" value="%{nombreUsuario}"></s:hidden>
            <s:submit value="Enviar"></s:submit>
        </s:form>
    </body>
    </body>
</html>
