package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sumy.javacourse.webdemo.model.DBStub;
import sumy.javacourse.webdemo.controller.Main;
import sumy.javacourse.webdemo.model.Comment;

public final class comments_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  // Methods example... It's deprecated approach too.
  int getParameterAsInteger(HttpSession session, String key){
    Object o = session.getAttribute(key);
    if (o != null) {
      return Integer.valueOf( o.toString() );
    }
    return 0;
  }

  float calculatePercent(int value, float total) {
    return value != 0? value/total*100 : value;
  }

  String cutFractionalDigits(float value){
    return String.format("%.0f", value);
  }

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

      out.write("\n\n\n");

  // Simple usage of HttpSession. Please do not use it in real applications/labs.
  int agreeAmount     = getParameterAsInteger( session, Main.AGREE     );
  int disagreeAmount  = getParameterAsInteger( session, Main.DISAGREE  );
  int tentativeAmount = getParameterAsInteger( session, Main.TENTATIVE );

  float total = agreeAmount + disagreeAmount + tentativeAmount;

  float agreePercent      = calculatePercent( agreeAmount,     total );
  float disagreePercent   = calculatePercent( disagreeAmount,  total );
  float tentativePercent  = calculatePercent( tentativeAmount, total );

      out.write('\n');
      out.write('\n');
      out.write("\n\n\n\n<!--\n  Warning: this is obsolete technology.\n  Current approach implemented for example of pure Servlet/JSP technologies.\n-->\n\n\n<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n  <title>Demo Project</title>\n  <meta   charset = \"utf-8\">\n  <meta   name    = \"viewport\"\n          content = \"width=device-width, initial-scale=1\">\n  <link   rel     = \"stylesheet\"\n          href    = \"css/bootstrap.min.css\">\n  <script src     = \"js/jquery-1.11.1.min.js\"></script>\n</head>\n<body>\n\n<div class=\"container\">\n  <div class=\"jumbotron\">\n    <h2>Are the Servlet & JSP simple technologies?</h2>\n\n    <div    class = \"progress\">\n      <div  class = \"progress-bar progress-bar-success\"\n            role  = \"progressbar\"\n            style = \"width: ");
      out.print( agreePercent );
      out.write("%\">\n        Agree\n      </div>\n\n      <div  class = \"progress-bar progress-bar-danger\"\n            role  = \"progressbar\"\n            style = \"width:  ");
      out.print( disagreePercent );
      out.write("%\">\n        Disagree\n      </div>\n\n      <div  class = \"progress-bar progress-bar-warning\"\n            role  = \"progressbar\"\n            style = \"width: ");
      out.print( tentativePercent );
      out.write("%\">\n        Tentative\n      </div>\n    </div>\n\n    <table class=\"table\">\n      <thead>\n        <tr>\n          <th style=\"width: 30px\">Vote</th>\n          <th>Percent</th>\n        </tr>\n      </thead>\n\n      <tbody>\n        <tr>\n          <td>Agree</td>\n          <td>");
      out.print( cutFractionalDigits( agreePercent ) );
      out.write("%</td>\n        </tr>\n        <tr>\n          <td>Disagree</td>\n          <td>");
      out.print( cutFractionalDigits( disagreePercent ) );
      out.write("%</td>\n        </tr>\n        <tr>\n          <td>Tentative</td>\n          <td>");
      out.print( cutFractionalDigits( tentativePercent) );
      out.write("%</td>\n        </tr>\n        <tr>\n          <th>Total</th>\n          <th>");
      out.print( cutFractionalDigits( total ) );
      out.write("</th>\n        </tr>\n      </tbody>\n    </table>\n\n    <form role=\"form\" action=\"/Servlets_demo/Blog\">\n\n      <div class=\"radio\">\n        <label>\n          <input    type      = \"radio\"\n                    name      = \"voteType\"\n                    value     = \"agree\"\n                    checked   = \"checked\">Agree</label>\n      </div>\n\n      <div class=\"radio\">\n        <label>\n          <input    type      = \"radio\"\n                    name      = \"voteType\"\n                    value     = \"disagree\">Disagree</label>\n      </div>\n\n      <div class=\"radio\">\n        <label>\n          <input    type      = \"radio\"\n                    name      = \"voteType\"\n                    value     = \"tentative\">Tentative</label>\n      </div>\n\n      <input        type      = \"hidden\"\n                    name      = \"action\"\n                    value     = \"saveVote\">\n\n      <button       type      = \"submit\"\n                    class     = \"btn btn-success\">Vote</button>\n    </form>\n  </div>\n\n  <div class=\"row\">\n    <div            class     = \"col-sm-3 col-md-6 col-lg-4\">\n");
      out.write("      <form         role      = \"form\"\n                    action    = \"/Servlets_demo/Blog\">\n\n        <div        class     = \"form-group\">\n          <label    for       = \"author\">Author:</label>\n          <input    type      = \"text\"\n                    class     = \"form-control\"\n                    id        = \"author\"\n                    name      = \"author\"\n                    required  = \"true\">\n        </div>\n\n        <div        class     = \"form-group\">\n          <label    for       = \"email\">Email:</label>\n          <input    type      = \"text\"\n                    class     = \"form-control\"\n                    id        = \"email\"\n                    name      = \"email\"\n                    required  = \"true\"\n                    pattern   = \"[^@]+@[^@]+\\.[a-zA-Z]{2,6}\"\n                    title     = \"xxx@xxx.xx\">\n        </div>\n\n        <div        class     = \"form-group\">\n          <label    for       = \"comment\">Comment:</label>\n          <textarea class     = \"form-control\"\n                    rows      = \"5\"\n");
      out.write("                    id        = \"comment\"\n                    name      = \"comment\"\n                    required  = \"true\"\n                    maxlength = \"3000\"></textarea>\n        </div>\n\n        <input      type      = \"hidden\"\n                    name      = \"action\"\n                    value     = \"saveComment\">\n\n        <button     type      = \"submit\"\n                    class     = \"btn btn-success\">Send</button>\n      </form>\n    </div>\n  </div>\n\n  <div class=\"row\">\n    <div class=\"col-sm-12\">\n      ");

      for(Comment comment : DBStub.comments()) {
      
      out.write("\n          <h3>");
      out.print(comment.getAuthor());
      out.write("</h3>\n          <p>");
      out.print(comment.getText() );
      out.write("</p>\n          <br/>\n      ");

        }
      
      out.write("\n    </div>\n  </div>\n</div>\n\n</body>\n</html>");
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
