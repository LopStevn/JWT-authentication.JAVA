<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <jsp:include page="/Views/Shared/title.jsp"/>
        <title>Home</title>

    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container"> 
            <div class="row">
                <div class="col l12 s12">
                    <h1>AUTENTICACION POR JWT Y GOOGLE</h1> 
                    <span>Este sistema permite autenticacion por JasonWebTooken</span> 
                </div>
            </div>            
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />      
    </body>
</html>
