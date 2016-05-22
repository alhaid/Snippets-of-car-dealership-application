package testpack;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class welcomeTag extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		JspWriter out = getJspContext().getOut();
		out.print("<div style=\"text-align:left;\">Welcome User:  &nbsp;&nbsp;");
		getJspBody().invoke(null);
		out.print("</div>");
	}
}




