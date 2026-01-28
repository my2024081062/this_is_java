package ch07.sec;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Television {
    private double tvPanel;
    private int madeYear;

//	public int getMadeYear() {
//		return madeYear;
//	}
//
//	public void setMadeYear(int madeYear) {
//		this.madeYear = madeYear;
//	}
//
//	public double getTvPanel() {
//		return tvPanel;
//	}
//
//	public void setTvPanel(double tvPanel) {
//		this.tvPanel = tvPanel;
//	}

    public Television() {
        this.setTvPanel(0.0);
        this.setMadeYear(2001);
    }

//	public Television(double tvPanel, int madeYear) {
//		this.setTvPanel(tvPanel);
//		this.setMadeYear(madeYear);
//	}

    public String getInfo() {
        return String.format("Television(year=%s, panel=%-8.2f )\n", this.getMadeYear(), this.getTvPanel());
    }

    public void print(Television stv) {
        System.out.println("Television print : " + stv.getInfo());
    }

    public void printAll(Object obj) {
        if ( obj instanceof Television ) {
            System.out.println(((Television) obj).getInfo());
        } else {
            System.out.println(obj.toString());
        }
    }
}
