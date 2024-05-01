package com.ikrki.turingsim;

import com.ikrki.turingsim.inst.Inst;
import com.ikrki.turingsim.io.IO;
import com.ikrki.turingsim.io.IOWrapper;
import com.ikrki.turingsim.mem.*;
import com.ikrki.turingsim.reg.PC;
import com.ikrki.turingsim.reg.Register;
import com.ikrki.turingsim.utils.ALU;
import com.ikrki.turingsim.utils.Cond;

public class CPU {
    IO io;
    IMemory ram,program;
    ByteStack userStack,funcStack;
    PC pc;
    Register[] regs;
    Inst.Parameters op,p1,p2,p3;
    public CPU(String source,String input){
        io=new IO("/input/"+input);
        program=new Program("/programs/"+source);
        ram=new RAM();
        userStack=new ByteStack();
        funcStack=new ByteStack();
        pc=new PC();
        regs=new Register[8];
        for (int i = 0; i < 6; i++) {
            regs[i] = new Register();
        }
        regs[6]=pc;
        regs[7]=new IOWrapper(io);
        op=Inst.Parameters.op;
        p1=Inst.Parameters.p1;
        p2=Inst.Parameters.p2;
        p3=Inst.Parameters.p3;
    }
    public void run(){
        while(true){
            Inst inst=new Inst(program,pc);
            if(inst.isExit()){
                System.out.println("Program exited.");
                return;
            }
            boolean imm1=inst.isImm1();
            boolean imm2=inst.isImm2();
            if(inst.isMov()){
                regs[inst.asIndex(p3)].set(
                        imm1? inst.asValue(p1):regs[inst.asIndex(p1)].get()
                );
            }
            else if(inst.isALU()){
                regs[inst.asIndex(p3)].set(
                        ALU.exec(
                                ALU.ALUOps.values()[inst.asIndex(op)],
                                imm1?inst.asValue(p1):regs[inst.asIndex(p1)].get(),
                                imm2?inst.asValue(p2):regs[inst.asIndex(p2)].get()
                        )
                );
            }
            else if(inst.isCond()){
                if(Cond.exec(
                        Cond.CondOps.values()[inst.asValue(op)],
                        imm1?inst.asValue(p1):regs[inst.asIndex(p1)].get(),
                        imm2?inst.asValue(p2):regs[inst.asIndex(p2)].get()
                )){
                    pc.set(inst.asValue(p3));
                }
            }
            else if(inst.isMem()){
                switch (inst.asIndex(op)){
                    case 0 -> regs[inst.asIndex(p3)].set(
                            ram.load(imm1?inst.asValue(p1):regs[inst.asIndex(p1)].get())
                    );
                    case 1 -> ram.save(
                            imm1?inst.asValue(p1):regs[inst.asIndex(p1)].get(),
                            imm2?inst.asValue(p2):regs[inst.asIndex(p2)].get()
                    );
                    case 2 -> userStack.push(
                            imm1?inst.asValue(p1):regs[inst.asIndex(p1)].get()
                    );
                    case 3 -> regs[inst.asIndex(p3)].set(
                            userStack.pop()
                    );
                    case 4 -> {
                            funcStack.push(pc.get());
                            pc.set(inst.asValue(p1));
                    }
                    case 5 -> pc.set(funcStack.pop());
                }
            }
        }
    }
}
