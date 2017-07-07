
package rhsit.taglib.templates;

import java.util.Hashtable;
import java.util.Stack;
import javax.servlet.jsp.JspException;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import javax.servlet.jsp.tagext.TagSupport;
import static javax.servlet.jsp.tagext.TagSupport.findAncestorWithClass;

/**
 * 
 * PutTag from java documentation examples
 *
 */
public class PutTag extends TagSupport {

    private String name, content, direct = "false";

    public void setName(String s) {
        name = s;
    }

    public void setContent(String s) {
        content = s;
    }

    public void setDirect(String s) {
        direct = s;
    }

    public int doStartTag() throws JspException {
        InsertTag parent
                = (InsertTag) findAncestorWithClass(this, rhsit.taglib.templates.InsertTag.class
        );
		if (parent == null) {
            throw new JspException("PutTag.doStartTag(): "
                    + "No InsertTag ancestor");
        }

        Stack template_stack = parent.getStack();

        if (template_stack == null) {
            throw new JspException("PutTag: no template stack");
        }

        Hashtable params = (Hashtable) template_stack.peek();

        if (params == null) {
            throw new JspException("PutTag: no hashtable");
        }

        params.put(name, new PageParameter(content, direct));

        return SKIP_BODY;
    }
}
