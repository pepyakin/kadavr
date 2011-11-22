/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.knott.kadavr;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.knott.kadavr.metadata.AType;
import org.knott.kadavr.metadata.ClassFile;
import org.knott.kadavr.metadata.ClassFileReader;
import org.knott.kadavr.metadata.ClassItem;
import org.knott.kadavr.metadata.ConstPool;
import org.knott.kadavr.metadata.ConstValueItem;
import org.knott.kadavr.metadata.MemberItem;
import org.knott.kadavr.metadata.attr.Code;
import org.knott.kadavr.tools.BytecodeParser;
import org.knott.kadavr.tools.BytecodeVisitor;
import org.knott.kadavr.tools.Opcode;

/**
 * Дизассемблер java байт кода.
 *
 * @author knott
 */
public class BytecodeDisasm {

    private BytecodeFormatter formatter;
    private ClassFileReader reader;

    private Code code;
    private ClassFile cf;
    private BytecodeParser parser;
    private ConstPool pool;

    /**
     * Создать экземпляр {@link BytecodeDisasm дизассемблера байт кода}.
     *
     * @param writer Выходной поток.
     * @param code Аттрибут кода.
     * @param cf Файл класса.
     */
    public BytecodeDisasm(IdentTextWriter writer, Code code, ClassFile cf) {
        this(new BytecodeFormatter(writer), code, cf);
    }

    /**
     * Создать экземпляр {@link BytecodeDisasm дизассемблера байт кода}.
     *
     * @param formatter Форматировщик байткода.
     * @param code Аттрибут кода.
     */
    public BytecodeDisasm(BytecodeFormatter formatter, Code code, ClassFile cf) {
        this.formatter = formatter;
        this.code = code;
        this.cf = cf;

        // Создать считыватель кода на основе
        // данных из массива.
        this.reader = new ClassFileReader(
                new ByteArrayInputStream(code.getCode()));

        pool = cf.getPool();
    }

    /**
     * Выполнить разбор кода.
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void parse() throws IOException {
        formatter.writeLimitLocals(code.getMaxLocals());
        formatter.writeLimitStack(code.getMaxStack());

        formatter.newline();

        parser = new BytecodeParser(visitor, reader);
        parser.parse();
    }


    private BytecodeVisitor visitor = new BytecodeVisitor() {

        private boolean wide = false;
        private int pc;

        @Override
        public void preVisit(int pc, Opcode opcode) throws IOException {
            formatter.writeLabelDecl(pc);

            formatter.writeInstruction(opcode.mnemonic);
            formatter.whitespace();

            if (opcode == Opcode.WIDE) {
                wide = true;
            }

            this.pc = pc;
        }

        @Override
        public void postVisit(Opcode opcode) throws IOException {
            if (opcode != Opcode.WIDE) {
                formatter.newline();

                if (wide) {
                    wide = false;
                }
            }
        }

        private void ldc(int index) throws IOException {
            ConstValueItem item = pool.get(index);
            formatter.writeOperand(item.getValueString());
        }

        private void memberOperand(int index) throws IOException {
            MemberItem item = pool.get(index);
            formatter.writeOperand(item.getOperandString());
        }

        private void integerOperand(int value) throws IOException {
            formatter.writeOperand(Integer.toString(value));
        }

        private void typeOperand(int index) throws IOException {
            ClassItem item = pool.get(index);
            formatter.writeOperand(item.getTypeName());
        }

        private void localVarOrRet(ClassFileReader r) throws IOException {
            int index;

            if (wide) {
                index = r.readU2();
            } else {
                index = r.readU1();
            }

            integerOperand(index);
        }

        private void iinc(int idx, int val) throws IOException {
            formatter.writeOperand(Integer.toString(idx));
            formatter.whitespace();
            formatter.writeOperand(Integer.toString(val));
        }

        private void branch(int to) throws IOException {
            formatter.writeLabel(to);
        }

        @Override
        public void visitLdc(ClassFileReader r) throws IOException {
            ldc(r.readU1());
        }

        @Override
        public void visitLdc2_w(ClassFileReader r) throws IOException {
            ldc(r.readU2());
        }

        @Override
        public void visitLdc_w(ClassFileReader r) throws IOException {
            ldc(r.readU2());
        }

        @Override
        public void visitInvokevirtual(ClassFileReader r) throws IOException {
            memberOperand(r.readU2());
        }

        @Override
        public void visitGetfield(ClassFileReader r) throws IOException {
            memberOperand(r.readU2());
        }

        @Override
        public void visitGetstatic(ClassFileReader r) throws IOException {
            memberOperand(r.readU2());
        }

        @Override
        public void visitInvokeinterface(ClassFileReader r) throws IOException {
            memberOperand(r.readU2());
            r.readU2();
        }

        @Override
        public void visitInvokespecial(ClassFileReader r) throws IOException {
            memberOperand(r.readU2());
        }

        @Override
        public void visitInvokestatic(ClassFileReader r) throws IOException {
            memberOperand(r.readU2());
        }

        @Override
        public void visitPutfield(ClassFileReader r) throws IOException {
            memberOperand(r.readU2());
        }

        @Override
        public void visitPutstatic(ClassFileReader r) throws IOException {
            memberOperand(r.readU2());
        }

        @Override
        public void visitBipush(ClassFileReader r) throws IOException {
            integerOperand((byte)r.readU1());
        }

        @Override
        public void visitSipush(ClassFileReader r) throws IOException {
            integerOperand((short)r.readU2());
        }

        @Override
        public void visitAload(ClassFileReader r) throws IOException {
            localVarOrRet(r);
        }

        @Override
        public void visitAstore(ClassFileReader r) throws IOException {
            localVarOrRet(r);
        }

        @Override
        public void visitDload(ClassFileReader r) throws IOException {
            localVarOrRet(r);
        }

        @Override
        public void visitDstore(ClassFileReader r) throws IOException {
            localVarOrRet(r);
        }

        @Override
        public void visitFload(ClassFileReader r) throws IOException {
            localVarOrRet(r);
        }

        @Override
        public void visitFstore(ClassFileReader r) throws IOException {
            localVarOrRet(r);
        }

        @Override
        public void visitIload(ClassFileReader r) throws IOException {
            localVarOrRet(r);
        }

        @Override
        public void visitIstore(ClassFileReader r) throws IOException {
            localVarOrRet(r);
        }

        @Override
        public void visitLload(ClassFileReader r) throws IOException {
            localVarOrRet(r);
        }

        @Override
        public void visitLstore(ClassFileReader r) throws IOException {
            localVarOrRet(r);
        }

        @Override
        public void visitRet(ClassFileReader r) throws IOException {
            localVarOrRet(r);
        }

        @Override
        public void visitIinc(ClassFileReader r) throws IOException {
            int index, constValue;

            if (wide) {
                index = r.readU2();
                constValue = (short)r.readU2();
            } else {
                index = r.readU1();
                constValue = (byte)r.readU1();
            }

            iinc(index, constValue);
        }

        @Override
        public void visitIf_acmpeq(ClassFileReader r) throws IOException {
            branch(r.readU2());
        }

        @Override
        public void visitIf_acmpne(ClassFileReader r) throws IOException {
            branch(r.readU2());
        }

        @Override
        public void visitIf_icmpeq(ClassFileReader r) throws IOException {
            branch(r.readU2());
        }

        @Override
        public void visitIf_icmpge(ClassFileReader r) throws IOException {
            branch(r.readU2());
        }

        @Override
        public void visitIf_icmpgt(ClassFileReader r) throws IOException {
            branch(r.readU2());
        }

        @Override
        public void visitIf_icmple(ClassFileReader r) throws IOException {
            branch(r.readU2());
        }

        @Override
        public void visitIf_icmplt(ClassFileReader r) throws IOException {
            branch(r.readU2());
        }

        @Override
        public void visitIf_icmpne(ClassFileReader r) throws IOException {
            branch(r.readU2());
        }

        @Override
        public void visitIfeq(ClassFileReader r) throws IOException {
            branch(r.readU2());
        }

        @Override
        public void visitIfge(ClassFileReader r) throws IOException {
            branch(r.readU2());
        }

        @Override
        public void visitIfgt(ClassFileReader r) throws IOException {
            branch(r.readU2());
        }

        @Override
        public void visitIfle(ClassFileReader r) throws IOException {
            branch(r.readU2());
        }

        @Override
        public void visitIflt(ClassFileReader r) throws IOException {
            branch(r.readU2());
        }

        @Override
        public void visitIfne(ClassFileReader r) throws IOException {
            branch(r.readU2());
        }

        @Override
        public void visitIfnonnull(ClassFileReader r) throws IOException {
            branch(r.readU2());
        }

        @Override
        public void visitIfnull(ClassFileReader r) throws IOException {
            branch(r.readU2());
        }

        @Override
        public void visitGoto(ClassFileReader r) throws IOException {
            int offset = r.readU2();
            branch(pc + (short)offset);
        }

        @Override
        public void visitGoto_w(ClassFileReader r) throws IOException {
            // TODO: потенциальный баг.
            int offset = (int)r.readU4();
            branch(pc + offset);
        }

        @Override
        public void visitNew(ClassFileReader r) throws IOException {
            typeOperand(r.readU2());
        }

        @Override
        public void visitNewarray(ClassFileReader r) throws IOException {
            int acode = r.readU1();

            formatter.writeOperand(AType.byACode(acode).getMnemonic());
        }

        @Override
        public void visitAnewarray(ClassFileReader r) throws IOException {
            typeOperand(r.readU2());
        }

        @Override
        public void visitCheckcast(ClassFileReader r) throws IOException {
            typeOperand(r.readU2());
        }

        @Override
        public void visitInstanceof(ClassFileReader r) throws IOException {
            typeOperand(r.readU2());
        }

        @Override
        public void visitJsr(ClassFileReader r) throws IOException {
            branch(r.readU2());
        }

        @Override
        public void visitJsr_w(ClassFileReader r) throws IOException {
            branch((int)r.readU4());
        }

        @Override
        public void visitMultianewarray(ClassFileReader r) throws IOException {
            typeOperand(r.readU2());
            formatter.whitespace();
            integerOperand(r.readU1());
        }

        @Override
        public void visitLookupswitch(ClassFileReader r) throws IOException {
            throw new UnsupportedOperationException("lookupswitch opcode");
        }

        @Override
        public void visitTableswitch(ClassFileReader r) throws IOException {
            throw new UnsupportedOperationException("tableswitch opcode");
        }
    };
}
