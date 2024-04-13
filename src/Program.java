import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program implements IMemory{
    public Program(String file){
        super();
        init(file);
    }
    private void init(String file){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" +");
                int i=0;
                for (String token : tokens) {
                    byte value=Assembler.assemble(token);
                    ram[i++]=value;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Excessive insts: " + e.getMessage());
        }
    }

    @Override
    public byte load(int addr) {
        return ram[addr];
    }

    @Override
    public void save(int i, byte b) {
        System.out.println("The program is readonly");
    }
}
