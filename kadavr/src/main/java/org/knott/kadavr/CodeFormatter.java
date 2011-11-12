package org.knott.kadavr;

import java.io.IOException;
import java.util.Stack;

/**
 * Классы потомки не являются потокобезопасными.
 * @author Sergey
 */
public class CodeFormatter {
    
    private IdentTextWriter writer;
    private Stack<Integer> identStack;

    /**
     * Создать райтер кода.
     * @param writer 
     */
    public CodeFormatter(IdentTextWriter writer) {
        if (writer == null) {
            throw new NullPointerException("writer can't be null");
        }
        this.writer = writer;
        identStack = new Stack<Integer>();
    }

    /**
     * Получить текущий райтер.
     * @return 
     */
    public IdentTextWriter getWriter() {
        return writer;
    }

    /**
     * Установить райтер.
     * @param writer 
     */
    public void setWriter(IdentTextWriter writer) {
        if (writer == null) {
            throw new NullPointerException("writer can't be null");
        }
        this.writer = writer;
    }
    
    public void writeDirective(String directive) throws IOException {
        writer.append(directive);
    }
    
    public void newline() throws IOException {
        writer.append('\n');
    }
    
    public void whitespace() throws IOException {
        writer.append(' ');
    }
    
    public void writeLabel(String label) throws IOException {
        writer.append(label);
    }
    
    public void writeInstruction(String insn) throws IOException {
        writer.append(insn);
    }
    
    public void writeComment(String comment) throws IOException {
        writer.append(comment);
    }
    
    public void writeIdentifier(String id) throws IOException {
        writer.append(id);
    }
    
    public void write(String str) throws IOException {
        writer.write(str);
    }

    public void setIdentLevel(int level) {
        writer.setIdentLevel(level);
    }
    
    public void writeIntermediate(Number value) throws IOException {
        writer.write(value.toString());
    }

    public void incIdent() {
        writer.incIdent();
    }

    public int getIdentLevel() {
        return writer.getIdentLevel();
    }

    public void decIdent() {
        writer.decIdent();
    }
    
    public void pushIdent() {
        identStack.push(writer.getIdentLevel());
    }
    
    public void popIdent() {
        writer.setIdentLevel(identStack.pop());
    }
}
