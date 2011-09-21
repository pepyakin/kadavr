package org.knott.kadavr;

import java.io.File;
import org.knott.kadavr.metadata.KClass;
import org.knott.kadavr.metadata.Method;

/**
 * @author Sergey Shulepov
 */
public class App {
    
    private CLIOpts opts;
    
    public App(CLIOpts opts) {
        this.opts = opts;
    }
    
    protected void processEach() {
        // Перемолоть аргументы.
        String[] inputFiles = opts.getInputFiles();
        for (String input : inputFiles) {
            process(input);
        }
    }
    
    protected void process(String input) {
        KClass cl = loadClass(input);
        Method[] methods = cl.getMethodTable();
        
        for (Method method : methods) {
            System.out.println(method.getFullName());
        }
    }
    
    protected KClass loadClass(String file) {
        return ClassLoader.loadClass(file);
    }
    
    /**
     * 
     * @param args Аргументы коммандерй строки.
     */
    public static void main(String[] args) {
        // Нужно сделать:
        // 1. Узнать какой файл.
        // 2. Открыть файл
        // 3. Считать его.
        // 4. Обработать.
        // 5. Вывести результат.
        CLIOpts opts = new CLIOpts();
        opts.setArgs(args);
        opts.parse();
        
        App app = new App(opts);
        app.processEach();
    }    
}
