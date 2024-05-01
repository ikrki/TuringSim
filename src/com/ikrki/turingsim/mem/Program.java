package com.ikrki.turingsim.mem;
import com.ikrki.turingsim.Main;
import com.ikrki.turingsim.mem.IMemory;
import com.ikrki.turingsim.utils.Assembler;

import java.io.*;

public class Program implements IMemory {
    public Program(String file){
        super();
        init(file);
    }
    private void init(String file){
        try (InputStream inputStream = Main.class.getResourceAsStream(file);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            int i=0;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" +");

                for (String token : tokens) {
                    byte value= Assembler.assemble(token);
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
