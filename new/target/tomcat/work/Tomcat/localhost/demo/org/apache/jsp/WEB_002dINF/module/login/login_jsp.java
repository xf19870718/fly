/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2015-12-22 01:55:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.module.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("    <title>My JSP 'login.jsp' starting page</title>\r\n");
      out.write("\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\r\n");
      out.write("    <meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("    <meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("    <meta http-equiv=\"expires\" content=\"0\">\r\n");
      out.write("    <meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("    <meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("    <!--\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\r\n");
      out.write("        -->\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        function _onRegister(elClicked) {\r\n");
      out.write("            try {\r\n");
      out.write("\r\n");
      out.write("                var doc = document.loginform;\r\n");
      out.write("                doc.action = \"./logon\";\r\n");
      out.write("                doc.submit();\r\n");
      out.write("            } catch (e) {\r\n");
      out.write("                alert(\"failerd\");\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        function _onLogin(elClicked) {\r\n");
      out.write("            var username = document.getElementById(\"username\").value;\r\n");
      out.write("            var password = document.getElementById(\"password\").value;\r\n");
      out.write("            if (username == null || username == '') {\r\n");
      out.write("                alert('type your username!');\r\n");
      out.write("                return;\r\n");
      out.write("            }\r\n");
      out.write("            else if (password == null || password == '') {\r\n");
      out.write("                alert('type your password!');\r\n");
      out.write("                return;\r\n");
      out.write("            }\r\n");
      out.write("            try {\r\n");
      out.write("\r\n");
      out.write("                elClicked.form.submit();\r\n");
      out.write("            } catch (e) {\r\n");
      out.write("                alert(\"failerd\");\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<form action=\"./logon\" name=\"loginform\" method=\"post\">\r\n");
      out.write("测试添加12345678912213123\r\n");
      out.write("    <label for=\"username\">用户名</label> <input name=\"username\" id=\"username\"/>\r\n");
      out.write("    <label for=\"password\">密码</label> <input name=\"password\" id=\"password\"\r\n");
      out.write("                                            type=\"password\"/> <input type=\"button\" value=\"Login\"\r\n");
      out.write("                                                                     onClick=\"_onLogin(this);\"/> <input type=\"button\"\r\n");
      out.write("                                                                                                        name=\"register\"\r\n");
      out.write("                                                                                                        value=\"Register\"\r\n");
      out.write("                                                                                                        onClick=\"_onRegister(this);\"/>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}