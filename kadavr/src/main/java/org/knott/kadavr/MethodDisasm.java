package org.knott.kadavr;

import java.io.IOException;
import org.knott.kadavr.metadata.Method;

/**
 *
 * @author Sergey
 */
public class MethodDisasm {
    
    private Method method;
    private MethodFormatter formatter;

    public MethodDisasm(MethodFormatter formatter, Method method) {
        this.method = method;
        this.formatter = formatter;
    }
    
    public MethodDisasm(IdentTextWriter writer, Method method) {
        this(new MethodFormatter(writer), method);
    }
    
    public MethodDisasm(IdentTextWriter writer) {
        this(writer, null);
    }

    public MethodFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(MethodFormatter formatter) {
        this.formatter = formatter;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
    
    /**
     * Разобрать текущий метод
     */
    public void parse() 
            throws IOException {
        if (method == null) {
            throw new NullPointerException("method can't be null");
        }
        
        if (formatter == null) {
            throw new NullPointerException("formatter can't be null");
        }
        
        formatter.beginMethod(
                method.getAccessFlags(), 
                method.getName(),
                method.getDescriptor());
        
        // TODO: do stuuffff
        
        formatter.endMethod();
    }
}
