public class Inst {
    byte op,p1,p2,p3;
    public enum Parameters{
        op,p1,p2,p3
    }
    public Inst(IMemory program,PC pc){
        int addr=pc.get();
        op=program.load(addr);
        p1=program.load(addr+1);
        p2=program.load(addr+2);
        p3=program.load(addr+3);
        pc.next();
    }
    public int asIndex(Parameters p){
        return switch (p) {
            case op -> op&0b00001111;
            case p1 -> p1&0b00001111;
            case p2 -> p2&0b00001111;
            case p3 -> p3&0b00001111;
        };
    }
    public byte asValue(Parameters p){
        return switch (p) {
            case op -> op;
            case p1 -> p1;
            case p2 -> p2;
            case p3 -> p3;
        };
    }
    public boolean isALU(){
        return (op&0b00110000)==0;
    }
    public boolean isCond(){
        return (op&0b00111000)==0b00100000;
    }
    public boolean isMem() {
        return (op&0b00011000)==0b00010000;
    }
    public boolean isMov(){
        return (op&0b00011000)==0b00011000;
    }
    public boolean isExit(){
        return op==(byte)0b11111111;
    }
    public boolean isImm1(){
        return (op&0b10000000)==0b10000000;
    }
    public boolean isImm2(){
        return (op&0b01000000)==0b01000000;
    }
}
