package ch08.sec.veterinaryClinic;

import lombok.Getter;

import java.time.LocalTime;

@Getter
public class Clinic {
    private final static Clinic clinic = new Clinic();
    private AnimalChart[] animalCharts = new AnimalChart[0];
    private Veterinarian[] veterinarians = new Veterinarian[0];
    private Nurse[] nurses = new Nurse[0];

    private void setAnimalCharts(AnimalChart[] animalCharts) {
        this.animalCharts = animalCharts;
    }

    private void setVeterinarians(Veterinarian[] veterinarians) {
        this.veterinarians = veterinarians;
    }

    private void setNurses(Nurse[] nurses) {
        this.nurses = nurses;
    }

    private Clinic(){
    }
    public static Clinic getInstance(){
        return Clinic.clinic;
    }

    public void addNerse(Nurse n){
        Nurse[] addNerses = new Nurse[this.getNurses().length+1];
        System.arraycopy(this.getNurses(),0,addNerses,0,this.getNurses().length);
        addNerses[this.getNurses().length] = n;
        this.setNurses(addNerses);
    }

    public void addVeterinarian(Veterinarian v){
        Veterinarian[] addVeterinarians = new Veterinarian[this.getVeterinarians().length+1];
        System.arraycopy(this.getVeterinarians(),0,addVeterinarians,0,this.getVeterinarians().length);
        addVeterinarians[this.getVeterinarians().length] = v;
        this.setVeterinarians(addVeterinarians);
    }

    public void addAnimalChart(AnimalChart ac){
        AnimalChart[] addAnimalCharts = new AnimalChart[this.getAnimalCharts().length+1];
        System.arraycopy(this.getAnimalCharts(),0,addAnimalCharts,0,this.getAnimalCharts().length);
        addAnimalCharts[this.getAnimalCharts().length] = ac;
        this.setAnimalCharts(addAnimalCharts);
    }

    public void nurses_job(){
        while (true){
            if(LocalTime.now() == LocalTime.of(20,0,0)){
                System.out.println("간호사가 퇴근합니다.");
                break;
            }
        }
    }
}
