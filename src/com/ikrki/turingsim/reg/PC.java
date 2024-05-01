package com.ikrki.turingsim.reg;

import com.ikrki.turingsim.reg.Register;

public class PC extends Register {
    public PC(){value=0;}

    public void next(){value+=4;}
}
