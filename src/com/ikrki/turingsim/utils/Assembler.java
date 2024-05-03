package com.ikrki.turingsim.utils;
import java.util.HashMap;
import java.util.Map;

public class Assembler {
    private static final Map<String,Byte> m=new HashMap<>();
    static{
        m.put("mov", (byte)0b00011000);
        m.put("movi",(byte)0b10011000);
        m.put("add", (byte)0b00000000);
        m.put("addi",(byte)0b01000000);
        m.put("sub", (byte)0b00000001);
        m.put("subi",(byte)0b01000001);
        m.put("mul", (byte)0b00000110);
        m.put("muli",(byte)0b01000110);
        m.put("div", (byte)0b00000111);
        m.put("divi",(byte)0b01000111);
        m.put("and", (byte)0b00000010);
        m.put("andi",(byte)0b01000010);
        m.put("or",  (byte)0b00000011);
        m.put("ori", (byte)0b01000011);
        m.put("not", (byte)0b00000100);
        m.put("xor", (byte)0b00000101);
        m.put("xori",(byte)0b01000101);
        m.put("je",  (byte)0b00100000);
        m.put("jei", (byte)0b01100000);
        m.put("jne", (byte)0b00100001);
        m.put("jnei",(byte)0b01100001);
        m.put("jl",  (byte)0b00100010);
        m.put("jli", (byte)0b01100010);
        m.put("jle", (byte)0b00100011);
        m.put("jlei",(byte)0b01100011);
        m.put("jg",  (byte)0b00100100);
        m.put("jgi", (byte)0b01100100);
        m.put("jge", (byte)0b00100101);
        m.put("jgei",(byte)0b01100101);
        m.put("jmp", (byte)0b00100110);
        m.put("load",(byte)0b00010000);
        m.put("save",(byte)0b00010001);
        m.put("push",(byte)0b00010010);
        m.put("pop", (byte)0b00010011);
        m.put("call",(byte)0b01010100);
        m.put("ret", (byte)0b00010101);
        m.put("r0",  (byte)0b00000000);
        m.put("r1",  (byte)0b00000001);
        m.put("r2",  (byte)0b00000010);
        m.put("r3",  (byte)0b00000011);
        m.put("r4",  (byte)0b00000100);
        m.put("r5",  (byte)0b00000101);
        m.put("in",  (byte)0b00000111);
        m.put("out", (byte)0b00000111);
        m.put("_",   (byte)0b00000000);
        m.put("exit",(byte)0b11111111);
    }
    public static byte assemble(String str){
        if(m.containsKey(str))
            return m.get(str);
        else {
            try {
                int number;
                if(str.startsWith("0x")){
                    number=Integer.parseInt(str.substring(2),16);
                }
                else if(str.startsWith("0b")){
                    number=Integer.parseInt(str.substring(2),2);
                }
                else {
                    number=Integer.parseInt(str);
                }
                return (byte)(number);
            } catch (NumberFormatException e) {
                System.out.println("Illegal assembly code.");
                System.exit(0);
                return 0;
            }
        }
    }
    public static void insert(String key,byte value){
        m.put(key,value);//System.out.println(value);
    }
}
