import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IO {
    private final byte[] inputs=new byte[256];
    private int index;
    public IO(String file){
        init(file);
    }
    private void init(String file){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" +");
                int i=0;
                for (String token : tokens) {
                    byte value=(byte)Integer.parseInt(token);
                    inputs[i++]=value;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Excessive inputs: " + e.getMessage());
        }
    }
    public byte getInput(){
        return inputs[index++];
    }
    public void setOutput(byte value){
        System.out.printf("Output: %d", value);
    }
}
