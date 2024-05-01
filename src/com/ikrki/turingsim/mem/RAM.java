package com.ikrki.turingsim.mem;

import com.ikrki.turingsim.mem.IMemory;

public class RAM implements IMemory {
    @Override
    public byte load(int addr){return ram[addr];}
    @Override
    public void save(int addr,byte value){ram[addr]=value;}

}
