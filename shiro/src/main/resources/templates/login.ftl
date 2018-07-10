<html xmlns="http://www.w3.org/1999/html">
<body>
<#if failureMsg??>
失败：${failureMsg!}
</#if>
<form action="login" method="post">
    <input type="text" name="username"/>
    <input type="password" name="password"/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>