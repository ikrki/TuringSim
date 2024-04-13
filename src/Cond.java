public class Cond {
    public enum CondOps {
        je,jne,jl,jle,jg,jge,jmp
    }
    public static boolean exec(CondOps op, byte p1,byte p2){
        return switch (op) {
            case je -> p1 == p2;
            case jne -> !(p1 == p2);
            case jl -> p1 < p2;
            case jle -> p1 <= p2;
            case jg -> p1 > p2;
            case jge -> p1 >= p2;
            case jmp -> true;
        };
    }
}
