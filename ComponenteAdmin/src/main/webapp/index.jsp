<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="UsuarioServlet" method="post" enctype="multipart/form-data">
            <label>Nome</label>
            <input type="text" name="nome" id="nome"/><br>
            <label>CPF</label>
            <input type="text" name="cpf" id="cpf"/><br>
            <label>E-mail</label>
            <input type="text" name="email" id="email"/><br>
            <label>Tif</label>
            <input type="text" name="tif" id="tif"/><br>
            <label>Imagem 1</label>
            <input type="file" name="imagem1" id="imagem1"/><br>
            <label>Imagem 2</label>
            <input type="file" name="imagem2" id="imagem2"/><br>
            <label>Imagem 3</label>
            <input type="file" name="imagem3" id="imagem3"/><br>
            <label>Imagem 4</label>
            <input type="file" name="imagem4" id="imagem4"/><br>
            <input type="submit" value="enviar"/>
        </form>
    </body>
</html>
