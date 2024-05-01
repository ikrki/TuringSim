package test;

import com.ikrki.turingsim.utils.Assembler;
import com.ikrki.turingsim.inst.Inst;
import org.junit.Test;

import static org.junit.Assert.*;

public class InstTest {
    @Test
    public void movTest(){
        String[] str= new String[]{"mov", "r0", "_", "r1"};
        byte[] bys=new byte[4];
        for (int i=0;i<4;i++) {
            bys[i]=Assembler.assemble(str[i]);
        }
        Inst inst=new Inst(bys);
        assertTrue(inst.isMov());
        assertFalse(inst.isALU());
    }
}
