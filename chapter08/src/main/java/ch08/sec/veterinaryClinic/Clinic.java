package ch08.sec.veterinaryClinic;

import ch08.sec.veterinaryClinic.petCharts.CatChart;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class Clinic {
    private final static Clinic clinic = new Clinic();
    private PetChart[] PetCharts = new PetChart[0];
    private Veterinarian[] veterinarians = new Veterinarian[0];
    private Nurse[] nurses0816 = new Nurse[0];
    private Nurse[] nurses1624 = new Nurse[0];
    private void setPetCharts(PetChart[] PetCharts) {
        this.PetCharts = PetCharts;
    }

    private void setVeterinarians(Veterinarian[] veterinarians) {
        this.veterinarians = veterinarians;
    }

    private void setNurses0816(Nurse[] nurses) {
        this.nurses0816 = nurses;
    }
    private void setNurses1624(Nurse[] nurses) {
        this.nurses1624 = nurses;
    }

    private Clinic(){
    }
    public static Clinic getInstance(){
        return Clinic.clinic;
    }

    public void addNerse(Nurse n){
        if(n.isWork_from_8_to_16()){
            Nurse[] addNerses = new Nurse[this.getNurses0816().length+1];
            System.arraycopy(this.getNurses0816(),0,addNerses,0,this.getNurses0816().length);
            addNerses[this.getNurses0816().length] = n;
            this.setNurses0816(addNerses);
        }
        else{
            Nurse[] addNerses = new Nurse[this.getNurses1624().length+1];
            System.arraycopy(this.getNurses1624(),0,addNerses,0,this.getNurses1624().length);
            addNerses[this.getNurses1624().length] = n;
            this.setNurses1624(addNerses);
        }
    }

    public void addVeterinarian(Veterinarian v){
        Veterinarian[] addVeterinarians = new Veterinarian[this.getVeterinarians().length+1];
        System.arraycopy(this.getVeterinarians(),0,addVeterinarians,0,this.getVeterinarians().length);
        addVeterinarians[this.getVeterinarians().length] = v;
        this.setVeterinarians(addVeterinarians);
    }

    public void addAnimalChart(PetChart ac){
        PetChart[] addPetCharts = new PetChart[this.getPetCharts().length+1];
        System.arraycopy(this.getPetCharts(),0, addPetCharts,0,this.getPetCharts().length);
        addPetCharts[this.getPetCharts().length] = ac;
        this.setPetCharts(addPetCharts);
    }

    public void nurses_job0816(Nurse[] nurses){
        for (int i = 0; i < this.getPetCharts().length; i++) {
            if(LocalDate.now().equals(this.getPetCharts()[i].getExternalClinicDate())){
                this.getPetCharts()[i].setExtern(true);
            }
        }
        while (true){ //실험용으로 true
            if(LocalTime.now() == LocalTime.of(8,0,0) || true){
                for(PetChart petChart : this.getPetCharts()){
                    System.out.println("아침에 " + petChart.getPet().getName() + "에게" + petChart.getApproximately().getName() +"을 먹입니다.");
                }
            }
            if(LocalTime.now() == LocalTime.of(13,0,0) || true){
                for(PetChart petChart : this.getPetCharts()){
                    System.out.println("점심에 " + petChart.getPet().getName() + "에게" + petChart.getApproximately().getName() +"을 먹입니다.");
                }
            }
            if(LocalTime.now() == LocalTime.of(16,0,0) || true){
                for(Nurse n : nurses){
                    System.out.println(n.getName() + "간호사가 퇴근합니다.");
                }
                this.nurses_job1624(this.getNurses1624());
                break;
            }
        }
    }
    public void nurses_job1624(Nurse[] nurses){
        while (true){
            if(LocalTime.now() == LocalTime.of(18,0,0) || true){
                for(PetChart petChart : this.getPetCharts()){
                    System.out.println("저녁에 " + petChart.getPet().getName() + "에게" + petChart.getApproximately().getName() +"을 먹입니다.");
                }
            }
            if(LocalTime.now() == LocalTime.of(24,0,0) || true){
                for(Nurse n : nurses){
                    System.out.println(n.getName() + "간호사가 퇴근합니다.");
                }
                break;
            }
        }
    }
}
