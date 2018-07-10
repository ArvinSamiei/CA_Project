package DataPathModule;

public class Reg {
    private int value;


    Reg(int value) {
        this.value = value;
    }

    void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
