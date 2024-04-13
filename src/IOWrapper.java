public class IOWrapper extends Register {
    IO io;
    public IOWrapper(IO io){
        this.io=io;
    }
    @Override
    public byte get(){return io.getInput();}
    @Override
    public void set(byte newValue){io.setOutput(newValue);}
}
