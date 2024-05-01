package test;

import com.ikrki.turingsim.utils.ALU;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ALUTest {
    @Test
    public void addTest(){
        assertEquals((byte)2, ALU.exec(ALU.ALUOps.add,(byte)1,(byte)1));
    }
    @Test
    public void shrTest(){
        assertEquals((byte)0b01000000,ALU.exec(ALU.ALUOps.shr,(byte)0b10000000,(byte)1));
        assertEquals((byte)0b00100000,ALU.exec(ALU.ALUOps.shr,(byte)0b01000000,(byte)1));
    }
    @Test
    public void sarTest(){
        assertEquals((byte)0b11000000,ALU.exec(ALU.ALUOps.sar, (byte) 0b10000000, (byte) 1));
        assertEquals((byte)0b00100000,ALU.exec(ALU.ALUOps.sar, (byte) 0b01000000, (byte) 1));
    }
}
