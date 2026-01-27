package ch07.sec;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SamsungTV extends Television{
    private String modelName;
    private int serialNumber;

    public SamsungTV(double panel, int madeYear, String modelName, int serialNumber) {
        super(panel, madeYear);
        this.modelName = modelName;
        this.serialNumber = serialNumber;
    }
}
