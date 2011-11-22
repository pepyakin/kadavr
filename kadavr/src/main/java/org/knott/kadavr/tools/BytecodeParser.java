/**
 * AUTO-GENERATED FILE. DO NOT EDIT.
 */
package org.knott.kadavr.tools;

import java.io.*;
import org.knott.kadavr.metadata.ClassFileReader;

public class BytecodeParser {

private BytecodeVisitor visitor;
private ClassFileReader reader;

public BytecodeParser(BytecodeVisitor visitor, ClassFileReader reader) {
this.visitor = visitor;
this.reader = reader;
}

public void parse() throws IOException {
   try {
   int pc = 0;
   while (true) {
            int opcodeValue = reader.readU1();
            Opcode opcode = Opcode.getOpcode(opcodeValue);
            visitor.preVisit(pc, opcode);
            byte[] operandData = new byte[opcode.opSize];
            reader.read(operandData);

            ClassFileReader isolated = new ClassFileReader(new ByteArrayInputStream(operandData));
            switch (opcode) {


	case NOP: visitor.visitNop(isolated);break;

	case ACONST_NULL: visitor.visitAconst_null(isolated);break;

	case ICONST_M1: visitor.visitIconst_m1(isolated);break;

	case ICONST_0: visitor.visitIconst_0(isolated);break;

	case ICONST_1: visitor.visitIconst_1(isolated);break;

	case ICONST_2: visitor.visitIconst_2(isolated);break;

	case ICONST_3: visitor.visitIconst_3(isolated);break;

	case ICONST_4: visitor.visitIconst_4(isolated);break;

	case ICONST_5: visitor.visitIconst_5(isolated);break;

	case LCONST_0: visitor.visitLconst_0(isolated);break;

	case LCONST_1: visitor.visitLconst_1(isolated);break;

	case FCONST_0: visitor.visitFconst_0(isolated);break;

	case FCONST_1: visitor.visitFconst_1(isolated);break;

	case FCONST_2: visitor.visitFconst_2(isolated);break;

	case DCONST_0: visitor.visitDconst_0(isolated);break;

	case DCONST_1: visitor.visitDconst_1(isolated);break;

	case BIPUSH: visitor.visitBipush(isolated);break;

	case SIPUSH: visitor.visitSipush(isolated);break;

	case LDC: visitor.visitLdc(isolated);break;

	case LDC_W: visitor.visitLdc_w(isolated);break;

	case LDC2_W: visitor.visitLdc2_w(isolated);break;

	case ILOAD: visitor.visitIload(isolated);break;

	case LLOAD: visitor.visitLload(isolated);break;

	case FLOAD: visitor.visitFload(isolated);break;

	case DLOAD: visitor.visitDload(isolated);break;

	case ALOAD: visitor.visitAload(isolated);break;

	case ILOAD_0: visitor.visitIload_0(isolated);break;

	case ILOAD_1: visitor.visitIload_1(isolated);break;

	case ILOAD_2: visitor.visitIload_2(isolated);break;

	case ILOAD_3: visitor.visitIload_3(isolated);break;

	case LLOAD_0: visitor.visitLload_0(isolated);break;

	case LLOAD_1: visitor.visitLload_1(isolated);break;

	case LLOAD_2: visitor.visitLload_2(isolated);break;

	case LLOAD_3: visitor.visitLload_3(isolated);break;

	case FLOAD_0: visitor.visitFload_0(isolated);break;

	case FLOAD_1: visitor.visitFload_1(isolated);break;

	case FLOAD_2: visitor.visitFload_2(isolated);break;

	case FLOAD_3: visitor.visitFload_3(isolated);break;

	case DLOAD_0: visitor.visitDload_0(isolated);break;

	case DLOAD_1: visitor.visitDload_1(isolated);break;

	case DLOAD_2: visitor.visitDload_2(isolated);break;

	case DLOAD_3: visitor.visitDload_3(isolated);break;

	case ALOAD_0: visitor.visitAload_0(isolated);break;

	case ALOAD_1: visitor.visitAload_1(isolated);break;

	case ALOAD_2: visitor.visitAload_2(isolated);break;

	case ALOAD_3: visitor.visitAload_3(isolated);break;

	case IALOAD: visitor.visitIaload(isolated);break;

	case LALOAD: visitor.visitLaload(isolated);break;

	case FALOAD: visitor.visitFaload(isolated);break;

	case DALOAD: visitor.visitDaload(isolated);break;

	case AALOAD: visitor.visitAaload(isolated);break;

	case BALOAD: visitor.visitBaload(isolated);break;

	case CALOAD: visitor.visitCaload(isolated);break;

	case SALOAD: visitor.visitSaload(isolated);break;

	case ISTORE: visitor.visitIstore(isolated);break;

	case LSTORE: visitor.visitLstore(isolated);break;

	case FSTORE: visitor.visitFstore(isolated);break;

	case DSTORE: visitor.visitDstore(isolated);break;

	case ASTORE: visitor.visitAstore(isolated);break;

	case ISTORE_0: visitor.visitIstore_0(isolated);break;

	case ISTORE_1: visitor.visitIstore_1(isolated);break;

	case ISTORE_2: visitor.visitIstore_2(isolated);break;

	case ISTORE_3: visitor.visitIstore_3(isolated);break;

	case LSTORE_0: visitor.visitLstore_0(isolated);break;

	case LSTORE_1: visitor.visitLstore_1(isolated);break;

	case LSTORE_2: visitor.visitLstore_2(isolated);break;

	case LSTORE_3: visitor.visitLstore_3(isolated);break;

	case FSTORE_0: visitor.visitFstore_0(isolated);break;

	case FSTORE_1: visitor.visitFstore_1(isolated);break;

	case FSTORE_2: visitor.visitFstore_2(isolated);break;

	case FSTORE_3: visitor.visitFstore_3(isolated);break;

	case DSTORE_0: visitor.visitDstore_0(isolated);break;

	case DSTORE_1: visitor.visitDstore_1(isolated);break;

	case DSTORE_2: visitor.visitDstore_2(isolated);break;

	case DSTORE_3: visitor.visitDstore_3(isolated);break;

	case ASTORE_0: visitor.visitAstore_0(isolated);break;

	case ASTORE_1: visitor.visitAstore_1(isolated);break;

	case ASTORE_2: visitor.visitAstore_2(isolated);break;

	case ASTORE_3: visitor.visitAstore_3(isolated);break;

	case IASTORE: visitor.visitIastore(isolated);break;

	case LASTORE: visitor.visitLastore(isolated);break;

	case FASTORE: visitor.visitFastore(isolated);break;

	case DASTORE: visitor.visitDastore(isolated);break;

	case AASTORE: visitor.visitAastore(isolated);break;

	case BASTORE: visitor.visitBastore(isolated);break;

	case CASTORE: visitor.visitCastore(isolated);break;

	case SASTORE: visitor.visitSastore(isolated);break;

	case POP: visitor.visitPop(isolated);break;

	case POP2: visitor.visitPop2(isolated);break;

	case DUP: visitor.visitDup(isolated);break;

	case DUP_X1: visitor.visitDup_x1(isolated);break;

	case DUP_X2: visitor.visitDup_x2(isolated);break;

	case DUP2: visitor.visitDup2(isolated);break;

	case DUP2_X1: visitor.visitDup2_x1(isolated);break;

	case DUP2_X2: visitor.visitDup2_x2(isolated);break;

	case SWAP: visitor.visitSwap(isolated);break;

	case IADD: visitor.visitIadd(isolated);break;

	case LADD: visitor.visitLadd(isolated);break;

	case FADD: visitor.visitFadd(isolated);break;

	case DADD: visitor.visitDadd(isolated);break;

	case ISUB: visitor.visitIsub(isolated);break;

	case LSUB: visitor.visitLsub(isolated);break;

	case FSUB: visitor.visitFsub(isolated);break;

	case DSUB: visitor.visitDsub(isolated);break;

	case IMUL: visitor.visitImul(isolated);break;

	case LMUL: visitor.visitLmul(isolated);break;

	case FMUL: visitor.visitFmul(isolated);break;

	case DMUL: visitor.visitDmul(isolated);break;

	case IDIV: visitor.visitIdiv(isolated);break;

	case LDIV: visitor.visitLdiv(isolated);break;

	case FDIV: visitor.visitFdiv(isolated);break;

	case DDIV: visitor.visitDdiv(isolated);break;

	case IREM: visitor.visitIrem(isolated);break;

	case LREM: visitor.visitLrem(isolated);break;

	case FREM: visitor.visitFrem(isolated);break;

	case DREM: visitor.visitDrem(isolated);break;

	case INEG: visitor.visitIneg(isolated);break;

	case LNEG: visitor.visitLneg(isolated);break;

	case FNEG: visitor.visitFneg(isolated);break;

	case DNEG: visitor.visitDneg(isolated);break;

	case ISHL: visitor.visitIshl(isolated);break;

	case LSHL: visitor.visitLshl(isolated);break;

	case ISHR: visitor.visitIshr(isolated);break;

	case LSHR: visitor.visitLshr(isolated);break;

	case IUSHR: visitor.visitIushr(isolated);break;

	case LUSHR: visitor.visitLushr(isolated);break;

	case IAND: visitor.visitIand(isolated);break;

	case LAND: visitor.visitLand(isolated);break;

	case IOR: visitor.visitIor(isolated);break;

	case LOR: visitor.visitLor(isolated);break;

	case IXOR: visitor.visitIxor(isolated);break;

	case LXOR: visitor.visitLxor(isolated);break;

	case IINC: visitor.visitIinc(isolated);break;

	case I2L: visitor.visitI2l(isolated);break;

	case I2F: visitor.visitI2f(isolated);break;

	case I2D: visitor.visitI2d(isolated);break;

	case L2I: visitor.visitL2i(isolated);break;

	case L2F: visitor.visitL2f(isolated);break;

	case L2D: visitor.visitL2d(isolated);break;

	case F2I: visitor.visitF2i(isolated);break;

	case F2L: visitor.visitF2l(isolated);break;

	case F2D: visitor.visitF2d(isolated);break;

	case D2I: visitor.visitD2i(isolated);break;

	case D2L: visitor.visitD2l(isolated);break;

	case D2F: visitor.visitD2f(isolated);break;

	case I2B: visitor.visitI2b(isolated);break;

	case I2C: visitor.visitI2c(isolated);break;

	case I2S: visitor.visitI2s(isolated);break;

	case LCMP: visitor.visitLcmp(isolated);break;

	case FCMPL: visitor.visitFcmpl(isolated);break;

	case FCMPG: visitor.visitFcmpg(isolated);break;

	case DCMPL: visitor.visitDcmpl(isolated);break;

	case DCMPG: visitor.visitDcmpg(isolated);break;

	case IFEQ: visitor.visitIfeq(isolated);break;

	case IFNE: visitor.visitIfne(isolated);break;

	case IFLT: visitor.visitIflt(isolated);break;

	case IFGE: visitor.visitIfge(isolated);break;

	case IFGT: visitor.visitIfgt(isolated);break;

	case IFLE: visitor.visitIfle(isolated);break;

	case IF_ICMPEQ: visitor.visitIf_icmpeq(isolated);break;

	case IF_ICMPNE: visitor.visitIf_icmpne(isolated);break;

	case IF_ICMPLT: visitor.visitIf_icmplt(isolated);break;

	case IF_ICMPGE: visitor.visitIf_icmpge(isolated);break;

	case IF_ICMPGT: visitor.visitIf_icmpgt(isolated);break;

	case IF_ICMPLE: visitor.visitIf_icmple(isolated);break;

	case IF_ACMPEQ: visitor.visitIf_acmpeq(isolated);break;

	case IF_ACMPNE: visitor.visitIf_acmpne(isolated);break;

	case GOTO: visitor.visitGoto(isolated);break;

	case JSR: visitor.visitJsr(isolated);break;

	case RET: visitor.visitRet(isolated);break;

	case TABLESWITCH: visitor.visitTableswitch(isolated);break;

	case LOOKUPSWITCH: visitor.visitLookupswitch(isolated);break;

	case IRETURN: visitor.visitIreturn(isolated);break;

	case LRETURN: visitor.visitLreturn(isolated);break;

	case FRETURN: visitor.visitFreturn(isolated);break;

	case DRETURN: visitor.visitDreturn(isolated);break;

	case ARETURN: visitor.visitAreturn(isolated);break;

	case RETURN: visitor.visitReturn(isolated);break;

	case GETSTATIC: visitor.visitGetstatic(isolated);break;

	case PUTSTATIC: visitor.visitPutstatic(isolated);break;

	case GETFIELD: visitor.visitGetfield(isolated);break;

	case PUTFIELD: visitor.visitPutfield(isolated);break;

	case INVOKEVIRTUAL: visitor.visitInvokevirtual(isolated);break;

	case INVOKESPECIAL: visitor.visitInvokespecial(isolated);break;

	case INVOKESTATIC: visitor.visitInvokestatic(isolated);break;

	case INVOKEINTERFACE: visitor.visitInvokeinterface(isolated);break;

	case XXXUNUSEDXXX1: visitor.visitXxxunusedxxx1(isolated);break;

	case NEW: visitor.visitNew(isolated);break;

	case NEWARRAY: visitor.visitNewarray(isolated);break;

	case ANEWARRAY: visitor.visitAnewarray(isolated);break;

	case ARRAYLENGTH: visitor.visitArraylength(isolated);break;

	case ATHROW: visitor.visitAthrow(isolated);break;

	case CHECKCAST: visitor.visitCheckcast(isolated);break;

	case INSTANCEOF: visitor.visitInstanceof(isolated);break;

	case MONITORENTER: visitor.visitMonitorenter(isolated);break;

	case MONITOREXIT: visitor.visitMonitorexit(isolated);break;

	case WIDE: visitor.visitWide(isolated);break;

	case MULTIANEWARRAY: visitor.visitMultianewarray(isolated);break;

	case IFNULL: visitor.visitIfnull(isolated);break;

	case IFNONNULL: visitor.visitIfnonnull(isolated);break;

	case GOTO_W: visitor.visitGoto_w(isolated);break;

	case JSR_W: visitor.visitJsr_w(isolated);break;

	case BREAKPOINT: visitor.visitBreakpoint(isolated);break;

	case IMPDEP1: visitor.visitImpdep1(isolated);break;

	case IMPDEP2: visitor.visitImpdep2(isolated);break;


            }
			visitor.postVisit(opcode);
                        pc += 1 + opcode.opSize;
        }
	} catch (EOFException e) {
	  return;
	}
}
}
