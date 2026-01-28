package ch07.sec;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SamsungTV extends Television {
    private String model;

//	public String getSerialNumber() {
//		return serialNumber;
//	}
//
//	public void setSerialNumber(String serialNumber) {
//		this.serialNumber = serialNumber;
//	}
//
//	public String getModel() {
//		return model;
//	}
//
//	public void setModel(String model) {
//		this.model = model;
//	}

    private String serialNumber;

    public SamsungTV() {
        this.setModel("");
        this.setSerialNumber("");
    }

    public SamsungTV( String model, String serialNumber, double tvPanel, int madeYear ) {
//		this.setTvPanel(tvPanel);
//		this.setMadeYear(madeYear);
        super(tvPanel, madeYear);
        this.setModel(model);
        this.setSerialNumber(serialNumber);
    }

    @Override
    public String getInfo() {
        return String.format("SamsungTv(model=%s, serialNumber=%s, tvpanel=%s, year=%d)"
                , this.getModel(), this.getSerialNumber(), String.valueOf(this.getTvPanel()), this.getMadeYear());
    }

//	public void print(SamsungTv stv) {
//		System.out.println("SamsungTv print : " + stv.getInfo());
//	}
}

