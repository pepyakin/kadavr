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
   while (true) {
            int opcodeValue = reader.readU1();
            Opcode opcode = Opcode.getOpcode(opcodeValue);
            visitor.preVisit(opcode);
			byte[] operandData = new byte[opcode.opSize];
            reader.read(operandData);
            
            ClassFileReader isolated = new ClassFileReader(new ByteArrayInputStream(operandData));
            switch (opcode) {


	case NOP: visitor.visitNop(isolated);
	
	case ACONST_NULL: visitor.visitAconst_null(isolated);
	
	case ICONST_M1: visitor.visitIconst_m1(isolated);
	
	case ICONST_0: visitor.visitIconst_0(isolated);
	
	case ICONST_1: visitor.visitIconst_1(isolated);
	
	case ICONST_2: visitor.visitIconst_2(isolated);
	
	case ICONST_3: visitor.visitIconst_3(isolated);
	
	case ICONST_4: visitor.visitIconst_4(isolated);
	
	case ICONST_5: visitor.visitIconst_5(isolated);
	
	case LCONST_0: visitor.visitLconst_0(isolated);
	
	case LCONST_1: visitor.visitLconst_1(isolated);
	
	case FCONST_0: visitor.visitFconst_0(isolated);
	
	case FCONST_1: visitor.visitFconst_1(isolated);
	
	case FCONST_2: visitor.visitFconst_2(isolated);
	
	case DCONST_0: visitor.visitDconst_0(isolated);
	
	case DCONST_1: visitor.visitDconst_1(isolated);
	
	case BIPUSH: visitor.visitBipush(isolated);
	
	case SIPUSH: visitor.visitSipush(isolated);
	
	case LDC: visitor.visitLdc(isolated);
	
	case LDC_W: visitor.visitLdc_w(isolated);
	
	case LDC2_W: visitor.visitLdc2_w(isolated);
	
	case ILOAD: visitor.visitIload(isolated);
	
	case LLOAD: visitor.visitLload(isolated);
	
	case FLOAD: visitor.visitFload(isolated);
	
	case DLOAD: visitor.visitDload(isolated);
	
	case ALOAD: visitor.visitAload(isolated);
	
	case ILOAD_0: visitor.visitIload_0(isolated);
	
	case ILOAD_1: visitor.visitIload_1(isolated);
	
	case ILOAD_2: visitor.visitIload_2(isolated);
	
	case ILOAD_3: visitor.visitIload_3(isolated);
	
	case LLOAD_0: visitor.visitLload_0(isolated);
	
	case LLOAD_1: visitor.visitLload_1(isolated);
	
	case LLOAD_2: visitor.visitLload_2(isolated);
	
	case LLOAD_3: visitor.visitLload_3(isolated);
	
	case FLOAD_0: visitor.visitFload_0(isolated);
	
	case FLOAD_1: visitor.visitFload_1(isolated);
	
	case FLOAD_2: visitor.visitFload_2(isolated);
	
	case FLOAD_3: visitor.visitFload_3(isolated);
	
	case DLOAD_0: visitor.visitDload_0(isolated);
	
	case DLOAD_1: visitor.visitDload_1(isolated);
	
	case DLOAD_2: visitor.visitDload_2(isolated);
	
	case DLOAD_3: visitor.visitDload_3(isolated);
	
	case ALOAD_0: visitor.visitAload_0(isolated);
	
	case ALOAD_1: visitor.visitAload_1(isolated);
	
	case ALOAD_2: visitor.visitAload_2(isolated);
	
	case ALOAD_3: visitor.visitAload_3(isolated);
	
	case IALOAD: visitor.visitIaload(isolated);
	
	case LALOAD: visitor.visitLaload(isolated);
	
	case FALOAD: visitor.visitFaload(isolated);
	
	case DALOAD: visitor.visitDaload(isolated);
	
	case AALOAD: visitor.visitAaload(isolated);
	
	case BALOAD: visitor.visitBaload(isolated);
	
	case CALOAD: visitor.visitCaload(isolated);
	
	case SALOAD: visitor.visitSaload(isolated);
	
	case ISTORE: visitor.visitIstore(isolated);
	
	case LSTORE: visitor.visitLstore(isolated);
	
	case FSTORE: visitor.visitFstore(isolated);
	
	case DSTORE: visitor.visitDstore(isolated);
	
	case ASTORE: visitor.visitAstore(isolated);
	
	case ISTORE_0: visitor.visitIstore_0(isolated);
	
	case ISTORE_1: visitor.visitIstore_1(isolated);
	
	case ISTORE_2: visitor.visitIstore_2(isolated);
	
	case ISTORE_3: visitor.visitIstore_3(isolated);
	
	case LSTORE_0: visitor.visitLstore_0(isolated);
	
	case LSTORE_1: visitor.visitLstore_1(isolated);
	
	case LSTORE_2: visitor.visitLstore_2(isolated);
	
	case LSTORE_3: visitor.visitLstore_3(isolated);
	
	case FSTORE_0: visitor.visitFstore_0(isolated);
	
	case FSTORE_1: visitor.visitFstore_1(isolated);
	
	case FSTORE_2: visitor.visitFstore_2(isolated);
	
	case FSTORE_3: visitor.visitFstore_3(isolated);
	
	case DSTORE_0: visitor.visitDstore_0(isolated);
	
	case DSTORE_1: visitor.visitDstore_1(isolated);
	
	case DSTORE_2: visitor.visitDstore_2(isolated);
	
	case DSTORE_3: visitor.visitDstore_3(isolated);
	
	case ASTORE_0: visitor.visitAstore_0(isolated);
	
	case ASTORE_1: visitor.visitAstore_1(isolated);
	
	case ASTORE_2: visitor.visitAstore_2(isolated);
	
	case ASTORE_3: visitor.visitAstore_3(isolated);
	
	case IASTORE: visitor.visitIastore(isolated);
	
	case LASTORE: visitor.visitLastore(isolated);
	
	case FASTORE: visitor.visitFastore(isolated);
	
	case DASTORE: visitor.visitDastore(isolated);
	
	case AASTORE: visitor.visitAastore(isolated);
	
	case BASTORE: visitor.visitBastore(isolated);
	
	case CASTORE: visitor.visitCastore(isolated);
	
	case SASTORE: visitor.visitSastore(isolated);
	
	case POP: visitor.visitPop(isolated);
	
	case POP2: visitor.visitPop2(isolated);
	
	case DUP: visitor.visitDup(isolated);
	
	case DUP_X1: visitor.visitDup_x1(isolated);
	
	case DUP_X2: visitor.visitDup_x2(isolated);
	
	case DUP2: visitor.visitDup2(isolated);
	
	case DUP2_X1: visitor.visitDup2_x1(isolated);
	
	case DUP2_X2: visitor.visitDup2_x2(isolated);
	
	case SWAP: visitor.visitSwap(isolated);
	
	case IADD: visitor.visitIadd(isolated);
	
	case LADD: visitor.visitLadd(isolated);
	
	case FADD: visitor.visitFadd(isolated);
	
	case DADD: visitor.visitDadd(isolated);
	
	case ISUB: visitor.visitIsub(isolated);
	
	case LSUB: visitor.visitLsub(isolated);
	
	case FSUB: visitor.visitFsub(isolated);
	
	case DSUB: visitor.visitDsub(isolated);
	
	case IMUL: visitor.visitImul(isolated);
	
	case LMUL: visitor.visitLmul(isolated);
	
	case FMUL: visitor.visitFmul(isolated);
	
	case DMUL: visitor.visitDmul(isolated);
	
	case IDIV: visitor.visitIdiv(isolated);
	
	case LDIV: visitor.visitLdiv(isolated);
	
	case FDIV: visitor.visitFdiv(isolated);
	
	case DDIV: visitor.visitDdiv(isolated);
	
	case IREM: visitor.visitIrem(isolated);
	
	case LREM: visitor.visitLrem(isolated);
	
	case FREM: visitor.visitFrem(isolated);
	
	case DREM: visitor.visitDrem(isolated);
	
	case INEG: visitor.visitIneg(isolated);
	
	case LNEG: visitor.visitLneg(isolated);
	
	case FNEG: visitor.visitFneg(isolated);
	
	case DNEG: visitor.visitDneg(isolated);
	
	case ISHL: visitor.visitIshl(isolated);
	
	case LSHL: visitor.visitLshl(isolated);
	
	case ISHR: visitor.visitIshr(isolated);
	
	case LSHR: visitor.visitLshr(isolated);
	
	case IUSHR: visitor.visitIushr(isolated);
	
	case LUSHR: visitor.visitLushr(isolated);
	
	case IAND: visitor.visitIand(isolated);
	
	case LAND: visitor.visitLand(isolated);
	
	case IOR: visitor.visitIor(isolated);
	
	case LOR: visitor.visitLor(isolated);
	
	case IXOR: visitor.visitIxor(isolated);
	
	case LXOR: visitor.visitLxor(isolated);
	
	case IINC: visitor.visitIinc(isolated);
	
	case I2L: visitor.visitI2l(isolated);
	
	case I2F: visitor.visitI2f(isolated);
	
	case I2D: visitor.visitI2d(isolated);
	
	case L2I: visitor.visitL2i(isolated);
	
	case L2F: visitor.visitL2f(isolated);
	
	case L2D: visitor.visitL2d(isolated);
	
	case F2I: visitor.visitF2i(isolated);
	
	case F2L: visitor.visitF2l(isolated);
	
	case F2D: visitor.visitF2d(isolated);
	
	case D2I: visitor.visitD2i(isolated);
	
	case D2L: visitor.visitD2l(isolated);
	
	case D2F: visitor.visitD2f(isolated);
	
	case I2B: visitor.visitI2b(isolated);
	
	case I2C: visitor.visitI2c(isolated);
	
	case I2S: visitor.visitI2s(isolated);
	
	case LCMP: visitor.visitLcmp(isolated);
	
	case FCMPL: visitor.visitFcmpl(isolated);
	
	case FCMPG: visitor.visitFcmpg(isolated);
	
	case DCMPL: visitor.visitDcmpl(isolated);
	
	case DCMPG: visitor.visitDcmpg(isolated);
	
	case IFEQ: visitor.visitIfeq(isolated);
	
	case IFNE: visitor.visitIfne(isolated);
	
	case IFLT: visitor.visitIflt(isolated);
	
	case IFGE: visitor.visitIfge(isolated);
	
	case IFGT: visitor.visitIfgt(isolated);
	
	case IFLE: visitor.visitIfle(isolated);
	
	case IF_ICMPEQ: visitor.visitIf_icmpeq(isolated);
	
	case IF_ICMPNE: visitor.visitIf_icmpne(isolated);
	
	case IF_ICMPLT: visitor.visitIf_icmplt(isolated);
	
	case IF_ICMPGE: visitor.visitIf_icmpge(isolated);
	
	case IF_ICMPGT: visitor.visitIf_icmpgt(isolated);
	
	case IF_ICMPLE: visitor.visitIf_icmple(isolated);
	
	case IF_ACMPEQ: visitor.visitIf_acmpeq(isolated);
	
	case IF_ACMPNE: visitor.visitIf_acmpne(isolated);
	
	case GOTO: visitor.visitGoto(isolated);
	
	case JSR: visitor.visitJsr(isolated);
	
	case RET: visitor.visitRet(isolated);
	
	case TABLESWITCH: visitor.visitTableswitch(isolated);
	
	case LOOKUPSWITCH: visitor.visitLookupswitch(isolated);
	
	case IRETURN: visitor.visitIreturn(isolated);
	
	case LRETURN: visitor.visitLreturn(isolated);
	
	case FRETURN: visitor.visitFreturn(isolated);
	
	case DRETURN: visitor.visitDreturn(isolated);
	
	case ARETURN: visitor.visitAreturn(isolated);
	
	case RETURN: visitor.visitReturn(isolated);
	
	case GETSTATIC: visitor.visitGetstatic(isolated);
	
	case PUTSTATIC: visitor.visitPutstatic(isolated);
	
	case GETFIELD: visitor.visitGetfield(isolated);
	
	case PUTFIELD: visitor.visitPutfield(isolated);
	
	case INVOKEVIRTUAL: visitor.visitInvokevirtual(isolated);
	
	case INVOKESPECIAL: visitor.visitInvokespecial(isolated);
	
	case INVOKESTATIC: visitor.visitInvokestatic(isolated);
	
	case INVOKEINTERFACE: visitor.visitInvokeinterface(isolated);
	
	case XXXUNUSEDXXX1: visitor.visitXxxunusedxxx1(isolated);
	
	case NEW: visitor.visitNew(isolated);
	
	case NEWARRAY: visitor.visitNewarray(isolated);
	
	case ANEWARRAY: visitor.visitAnewarray(isolated);
	
	case ARRAYLENGTH: visitor.visitArraylength(isolated);
	
	case ATHROW: visitor.visitAthrow(isolated);
	
	case CHECKCAST: visitor.visitCheckcast(isolated);
	
	case INSTANCEOF: visitor.visitInstanceof(isolated);
	
	case MONITORENTER: visitor.visitMonitorenter(isolated);
	
	case MONITOREXIT: visitor.visitMonitorexit(isolated);
	
	case WIDE: visitor.visitWide(isolated);
	
	case MULTIANEWARRAY: visitor.visitMultianewarray(isolated);
	
	case IFNULL: visitor.visitIfnull(isolated);
	
	case IFNONNULL: visitor.visitIfnonnull(isolated);
	
	case GOTO_W: visitor.visitGoto_w(isolated);
	
	case JSR_W: visitor.visitJsr_w(isolated);
	
	case BREAKPOINT: visitor.visitBreakpoint(isolated);
	
	case IMPDEP1: visitor.visitImpdep1(isolated);
	
	case IMPDEP2: visitor.visitImpdep2(isolated);
	
                
            }
			visitor.postVisit(opcode);
        }
	} catch (EOFException e) {
	  return;
	}
}
}
