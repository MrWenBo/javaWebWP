<html lang="en-US">
    <head>
        <meta charset="UTF-8">
        <title>返回的HTML文档基于FreeMarker生成</title>
    </head>
    <body>
        <h3>用户返回表：</h3>
        <table border="1">
        	<#list users as user>
        	<tr><td>${user.userid}<td>${user.username} Euros
        	</#list>
        </table>
    </body>
</html>