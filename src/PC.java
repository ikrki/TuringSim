public class PC {
    private byte pc;
    public PC(){pc=0;}
    public byte get(){return pc;}
    public void next(){pc+=4;}
    public void set(byte value){pc=value;}
}
