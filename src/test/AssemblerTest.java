package test;

import com.ikrki.turingsim.utils.Assembler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssemblerTest {
    @Test
    public void hexValuesTest(){
        assertEquals((byte)17, Assembler.assemble("0x11"));
    }
    @Test
    public void binValuesTest(){
        assertEquals((byte)3, Assembler.assemble("0b11"));
    }
    @Test
    public void decValuesTest(){
        assertEquals((byte)11, Assembler.assemble("11"));
    }
}
