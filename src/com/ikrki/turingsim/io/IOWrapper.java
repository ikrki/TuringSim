package com.ikrki.turingsim.io;

import com.ikrki.turingsim.io.IO;
import com.ikrki.turingsim.reg.Register;

public class IOWrapper extends Register {
    IO io;
    public IOWrapper(IO io){
        this.io=io;
    }
    @Override
    public byte get(){byte a=io.getInput();System.out.println(a);return a;}
    @Override
    public void set(byte newValue){io.setOutput(newValue);}
}
