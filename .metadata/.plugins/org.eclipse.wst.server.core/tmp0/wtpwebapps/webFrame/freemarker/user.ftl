<html lang="en-US">
    <head>
        <meta charset="UTF-8">
        <title>���ص�HTML�ĵ�����FreeMarker����</title>
    </head>
    <body>
        <h3>�û����ر�</h3>
        <table border="1">
        	<#list users as user>
        	<tr><td>${user.userid}<td>${user.username} Euros
        	</#list>
        </table>
    </body>
</html>