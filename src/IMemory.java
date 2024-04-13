public interface IMemory {
    byte[] ram = new byte[256];
    byte load(int addr);
    void save(int addr,byte value);
}
