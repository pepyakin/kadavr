/**
 * AUTO-GENERATED FILE. DO NOT EDIT.
 */
 
package org.knott.kadavr.tools;
 
public enum Opcode {
NOP(0,"nop",0),
ACONST_NULL(1,"aconst_null",0),
ICONST_M1(2,"iconst_m1",0),
ICONST_0(3,"iconst_0",0),
ICONST_1(4,"iconst_1",0),
ICONST_2(5,"iconst_2",0),
ICONST_3(6,"iconst_3",0),
ICONST_4(7,"iconst_4",0),
ICONST_5(8,"iconst_5",0),
LCONST_0(9,"lconst_0",0),
LCONST_1(10,"lconst_1",0),
FCONST_0(11,"fconst_0",0),
FCONST_1(12,"fconst_1",0),
FCONST_2(13,"fconst_2",0),
DCONST_0(14,"dconst_0",0),
DCONST_1(15,"dconst_1",0),
BIPUSH(16,"bipush",1),
SIPUSH(17,"sipush",2),
LDC(18,"ldc",1),
LDC_W(19,"ldc_w",2),
LDC2_W(20,"ldc2_w",2),
ILOAD(21,"iload",1),
LLOAD(22,"lload",1),
FLOAD(23,"fload",1),
DLOAD(24,"dload",1),
ALOAD(25,"aload",1),
ILOAD_0(26,"iload_0",0),
ILOAD_1(27,"iload_1",0),
ILOAD_2(28,"iload_2",0),
ILOAD_3(29,"iload_3",0),
LLOAD_0(30,"lload_0",0),
LLOAD_1(31,"lload_1",0),
LLOAD_2(32,"lload_2",0),
LLOAD_3(33,"lload_3",0),
FLOAD_0(34,"fload_0",0),
FLOAD_1(35,"fload_1",0),
FLOAD_2(36,"fload_2",0),
FLOAD_3(37,"fload_3",0),
DLOAD_0(38,"dload_0",0),
DLOAD_1(39,"dload_1",0),
DLOAD_2(40,"dload_2",0),
DLOAD_3(41,"dload_3",0),
ALOAD_0(42,"aload_0",0),
ALOAD_1(43,"aload_1",0),
ALOAD_2(44,"aload_2",0),
ALOAD_3(45,"aload_3",0),
IALOAD(46,"iaload",0),
LALOAD(47,"laload",0),
FALOAD(48,"faload",0),
DALOAD(49,"daload",0),
AALOAD(50,"aaload",0),
BALOAD(51,"baload",0),
CALOAD(52,"caload",0),
SALOAD(53,"saload",0),
ISTORE(54,"istore",1),
LSTORE(55,"lstore",1),
FSTORE(56,"fstore",1),
DSTORE(57,"dstore",1),
ASTORE(58,"astore",1),
ISTORE_0(59,"istore_0",0),
ISTORE_1(60,"istore_1",0),
ISTORE_2(61,"istore_2",0),
ISTORE_3(62,"istore_3",0),
LSTORE_0(63,"lstore_0",0),
LSTORE_1(64,"lstore_1",0),
LSTORE_2(65,"lstore_2",0),
LSTORE_3(66,"lstore_3",0),
FSTORE_0(67,"fstore_0",0),
FSTORE_1(68,"fstore_1",0),
FSTORE_2(69,"fstore_2",0),
FSTORE_3(70,"fstore_3",0),
DSTORE_0(71,"dstore_0",0),
DSTORE_1(72,"dstore_1",0),
DSTORE_2(73,"dstore_2",0),
DSTORE_3(74,"dstore_3",0),
ASTORE_0(75,"astore_0",0),
ASTORE_1(76,"astore_1",0),
ASTORE_2(77,"astore_2",0),
ASTORE_3(78,"astore_3",0),
IASTORE(79,"iastore",0),
LASTORE(80,"lastore",0),
FASTORE(81,"fastore",0),
DASTORE(82,"dastore",0),
AASTORE(83,"aastore",0),
BASTORE(84,"bastore",0),
CASTORE(85,"castore",0),
SASTORE(86,"sastore",0),
POP(87,"pop",0),
POP2(88,"pop2",0),
DUP(89,"dup",0),
DUP_X1(90,"dup_x1",0),
DUP_X2(91,"dup_x2",0),
DUP2(92,"dup2",0),
DUP2_X1(93,"dup2_x1",0),
DUP2_X2(94,"dup2_x2",0),
SWAP(95,"swap",0),
IADD(96,"iadd",0),
LADD(97,"ladd",0),
FADD(98,"fadd",0),
DADD(99,"dadd",0),
ISUB(100,"isub",0),
LSUB(101,"lsub",0),
FSUB(102,"fsub",0),
DSUB(103,"dsub",0),
IMUL(104,"imul",0),
LMUL(105,"lmul",0),
FMUL(106,"fmul",0),
DMUL(107,"dmul",0),
IDIV(108,"idiv",0),
LDIV(109,"ldiv",0),
FDIV(110,"fdiv",0),
DDIV(111,"ddiv",0),
IREM(112,"irem",0),
LREM(113,"lrem",0),
FREM(114,"frem",0),
DREM(115,"drem",0),
INEG(116,"ineg",0),
LNEG(117,"lneg",0),
FNEG(118,"fneg",0),
DNEG(119,"dneg",0),
ISHL(120,"ishl",0),
LSHL(121,"lshl",0),
ISHR(122,"ishr",0),
LSHR(123,"lshr",0),
IUSHR(124,"iushr",0),
LUSHR(125,"lushr",0),
IAND(126,"iand",0),
LAND(127,"land",0),
IOR(128,"ior",0),
LOR(129,"lor",0),
IXOR(130,"ixor",0),
LXOR(131,"lxor",0),
IINC(132,"iinc",2),
I2L(133,"i2l",0),
I2F(134,"i2f",0),
I2D(135,"i2d",0),
L2I(136,"l2i",0),
L2F(137,"l2f",0),
L2D(138,"l2d",0),
F2I(139,"f2i",0),
F2L(140,"f2l",0),
F2D(141,"f2d",0),
D2I(142,"d2i",0),
D2L(143,"d2l",0),
D2F(144,"d2f",0),
I2B(145,"i2b",0),
I2C(146,"i2c",0),
I2S(147,"i2s",0),
LCMP(148,"lcmp",0),
FCMPL(149,"fcmpl",0),
FCMPG(150,"fcmpg",0),
DCMPL(151,"dcmpl",0),
DCMPG(152,"dcmpg",0),
IFEQ(153,"ifeq",2),
IFNE(154,"ifne",2),
IFLT(155,"iflt",2),
IFGE(156,"ifge",2),
IFGT(157,"ifgt",2),
IFLE(158,"ifle",2),
IF_ICMPEQ(159,"if_icmpeq",2),
IF_ICMPNE(160,"if_icmpne",2),
IF_ICMPLT(161,"if_icmplt",2),
IF_ICMPGE(162,"if_icmpge",2),
IF_ICMPGT(163,"if_icmpgt",2),
IF_ICMPLE(164,"if_icmple",2),
IF_ACMPEQ(165,"if_acmpeq",2),
IF_ACMPNE(166,"if_acmpne",2),
GOTO(167,"goto",2),
JSR(168,"jsr",2),
RET(169,"ret",1),
TABLESWITCH(170,"tableswitch",0),
LOOKUPSWITCH(171,"lookupswitch",0),
IRETURN(172,"ireturn",0),
LRETURN(173,"lreturn",0),
FRETURN(174,"freturn",0),
DRETURN(175,"dreturn",0),
ARETURN(176,"areturn",0),
RETURN(177,"return",0),
GETSTATIC(178,"getstatic",2),
PUTSTATIC(179,"putstatic",2),
GETFIELD(180,"getfield",2),
PUTFIELD(181,"putfield",2),
INVOKEVIRTUAL(182,"invokevirtual",2),
INVOKESPECIAL(183,"invokespecial",2),
INVOKESTATIC(184,"invokestatic",2),
INVOKEINTERFACE(185,"invokeinterface",4),
XXXUNUSEDXXX1(186,"xxxunusedxxx1",0),
NEW(187,"new",2),
NEWARRAY(188,"newarray",1),
ANEWARRAY(189,"anewarray",2),
ARRAYLENGTH(190,"arraylength",0),
ATHROW(191,"athrow",0),
CHECKCAST(192,"checkcast",2),
INSTANCEOF(193,"instanceof",2),
MONITORENTER(194,"monitorenter",0),
MONITOREXIT(195,"monitorexit",0),
WIDE(196,"wide",0),
MULTIANEWARRAY(197,"multianewarray",3),
IFNULL(198,"ifnull",2),
IFNONNULL(199,"ifnonnull",2),
GOTO_W(200,"goto_w",4),
JSR_W(201,"jsr_w",4),
BREAKPOINT(202,"breakpoint",0),
IMPDEP1(254,"impdep1",0),
IMPDEP2(255,"impdep2",0);

public final int opcode;
public final String mnemonic;
public final int opSize;

private Opcode(int opcode, String mnemonic, int opSize) {
this.opcode = opcode;
this.mnemonic = mnemonic;
this.opSize = opSize;
}

public static Opcode getOpcode(int opcodeValue) {
    for (Opcode opcode : values()) {
        if (opcode.ordinal() == opcodeValue) {
            return opcode;
        }
    }
    
    return null;
}
}
