
<%-- 
    Document   : infologin
    Created on : Jan 19, 2013, 9:28:49 AM
    Author     : rafa
--%>
<%@page import="net.rafaelaznar.bean.Usuario"%>
<%Usuario user = (Usuario) request.getSession().getAttribute("usuarioBean");%>                   
 <p class="navbar-text pull-right">           
<%if (user != null) {%>
Estas logueado como <%=user.getNombre()%>&nbsp;&nbsp;&nbsp;&nbsp;
<a class="navbar-link" href="jsp?ob=usuario&op=logout">(Salir del sistema)</a>
<%} else {%>
<a class="navbar-link" href="jsp?op=login01&ob=usuario">Login</a>
<%}%>
 </p>