package minggu11.exercise2;

public class TelevisiModern extends Elektronik {
    private String modeInput;
    public TelevisiModern() {
        super();
        this.modeInput = "HDMI";
    }
    
    public String getModeInput() {
        return modeInput;
    }
}