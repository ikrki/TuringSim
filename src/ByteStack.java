import java.util.Stack;

public class ByteStack {
    private Stack<Byte> stack;
    public void push(byte value){stack.push(value);}
    public byte pop(){return stack.pop();}
}
