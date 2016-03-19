package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <title>Demo Project</title>\n    <meta   charset = \"utf-8\">\n    <meta   name    = \"viewport\"\n            content = \"width=device-width, initial-scale=1\">\n    <link   rel     = \"stylesheet\"\n            href    = \"css/bootstrap.min.css\">\n    <script src     = \"js/jquery-1.11.1.min.js\"></script>\n    <script src     = \"js/bootstrap.min.js\"></script>\n</head>\n<body>\n\n    <div class=\"container\">\n        <div class=\"jumbotron\">\n            <h1>Welcome to the Demo Project</h1>\n            <p>This is simple example of Java web application</p>\n        </div>\n\n        <div class=\"row\">\n\n            <div class=\"col-sm-4\">\n                <h3>Servlets</h3>\n                <p>A Java servlet is a Java programming language program that extends the capabilities of a server. Although servlets can respond to any types of requests, they most commonly implement applications hosted on Web servers.</p>\n                <a href=\"https://en.wikipedia.org/wiki/Java_servlet\">\n                    <i class=\"fa fa-external-link\">More</i>\n");
      out.write("                </a>\n            </div>\n\n            <div class=\"col-sm-4\">\n                <h3>JSP</h3>\n                <p>JavaServer Pages (JSP) is a technology that helps software developers create dynamically generated web pages based on HTML, XML, or other document types. Released in 1999 by Sun Microsystems, JSP is similar to PHP, but it uses the Java programming language.</p>\n                <a href=\"https://en.wikipedia.org/wiki/JavaServer_Pages\">\n                    <i class=\"fa fa-external-link\">More</i>\n                </a>\n            </div>\n\n            <div class=\"col-sm-4\">\n                <h3>Let's try</h3>\n                <a href=\"/Servlets_demo/Blog?action=toCommentsPage\" >\n                    <button type=\"button\" class=\"btn btn-success\">Push Me</button>\n                </a>\n            </div>\n        </div>\n    </div>\n\n</body>\n</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
