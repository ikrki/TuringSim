package com.ikrki.turingsim.utils;
public class ALU {
    public enum ALUOps {
        add,sub,and,or,not,xor,mul,div,shl,shr,sar
    }
    public static byte exec(ALUOps op, byte p1, byte p2){
        return switch (op) {
            case add -> (byte)(p1 + p2);
            case sub -> (byte)(p1 - p2);
            case and -> (byte)(p1 & p2);
            case or -> (byte)(p1 | p2);
            case not -> (byte)(~p1);
            case xor -> (byte)(p1 ^ p2);
            case mul -> (byte)(p1 * p2);
            case div -> (byte)(p1 / p2);
            case shl -> (byte)(p1 << p2);
            case shr -> (byte)((p1 >> p2)&0x7f);
            case sar -> (byte)(p1 >> p2);
        };
    }
}
