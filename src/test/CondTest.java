package test;

import com.ikrki.turingsim.utils.Cond;
import org.junit.Test;

import static org.junit.Assert.*;

public class CondTest {
    @Test
    public void jeTest(){
        assertTrue(Cond.exec(Cond.CondOps.je, (byte) 0b10001000, (byte) 0b10001000));
        assertFalse(Cond.exec(Cond.CondOps.je, (byte) 0b10001000, (byte) 0b00001000));
    }
}
