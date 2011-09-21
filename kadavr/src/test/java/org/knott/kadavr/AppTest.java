package org.knott.kadavr;

import org.knott.kadavr.metadata.KClass;
import junit.framework.TestCase;

import org.knott.kadavr.metadata.Method;
import static org.mockito.Mockito.*;

/**
 * Тестирование класса приложения.
 */
public class AppTest 
    extends TestCase
{
    
    
    class MyApp extends org.knott.kadavr.App {
        MyApp(CLIOpts opts) { super(opts); }
        
        @Override
        protected KClass loadClass(String file) {
            return mockClass;
        }
    }
    
    private KClass mockClass;
    
    @Override
    public void setUp() {
        Method mockMethod = mock(Method.class);
        when(mockMethod.getFullName()).thenReturn(
                "java/lang/String#toString!()V");

        mockClass = mock(KClass.class);
        when(mockClass.getMethodTable()).thenReturn(new Method[] { mockMethod });
    }
    
    /**
     * Протестировать процессинг.
     */
    public void testTwoFiles() {
        CLIOpts opts = mock(CLIOpts.class);
        when(opts.getInputFiles()).thenReturn(
                new String[] { "Hello.class", "Main.class" } );
        when(opts.getInputCount()).thenReturn(2);
        
        MyApp app = new MyApp(opts);
        app.processEach();
    }
    
    /**
     * Протестировать процессинг.
     */
    public void testZeroFiles() {
        CLIOpts opts = mock(CLIOpts.class);
        when(opts.getInputFiles()).thenReturn(
                new String[] { } );
        when(opts.getInputCount()).thenReturn(0);
        
        MyApp app = new MyApp(opts);
        app.processEach();
    }
}
