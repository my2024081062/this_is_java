package ch08.sec.veterinaryClinic;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class Clinic {
    private final static Clinic clinic = new Clinic();
    private PetChart[] PetCharts = new PetChart[0];
    private Veterinarian[] veterinarians = new Veterinarian[0];
    private Nurse[] nurses = new Nurse[0];

    private void setPetCharts(PetChart[] PetCharts) {
        this.PetCharts = PetCharts;
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

    public void addAnimalChart(PetChart ac){
        PetChart[] addPetCharts = new PetChart[this.getPetCharts().length+1];
        System.arraycopy(this.getPetCharts(),0, addPetCharts,0,this.getPetCharts().length);
        addPetCharts[this.getPetCharts().length] = ac;
        this.setPetCharts(addPetCharts);
    }

    public void nurses_job0816(Nurse[] n){
        Pet[] pets = new Pet[this.getPetCharts().length];
        for (int i = 0; i < pets.length; i++) {
            if(LocalDate.now().equals(this.getPetCharts()[i].getExternalClinicDate())){
                this.getPetCharts()[i].setExtern(true);
            }
            pets[i] = this.getPetCharts()[i].getPet(); // 필드 추출
        }
        while (true){ //실험용으로 true
            if(LocalTime.now() == LocalTime.of(8,0,0) || true){
                for(Pet pet : pets){
                    System.out.println(pet.getName() + "에게 아침 약을 먹입니다.");
                }
            }
            if(LocalTime.now() == LocalTime.of(13,0,0) || true){
                for(Pet pet : pets){
                    System.out.println(pet.getName() + "에게 점심 약을 먹입니다.");
                }
            }
            if(LocalTime.now() == LocalTime.of(16,0,0) || true){
                System.out.println(n.getName() + "간호사가 퇴근합니다.");
                this.nurses_job1624(this.getNurses()[1]);
            }
            break;
        }
    }
    public void nurses_job1624(Nurse[] n){
        Pet[] pets = new Pet[this.getPetCharts().length];
        for (int i = 0; i < pets.length; i++) {
            pets[i] = this.getPetCharts()[i].getPet(); // 필드 추출
        }
        while (true){
            if(LocalTime.now() == LocalTime.of(18,0,0) || true){
                for(Pet pet : pets){
                    System.out.println(pet.getName() + "에게 저녁 약을 먹입니다.");
                }
            }
            if(LocalTime.now() == LocalTime.of(24,0,0) || true){
                System.out.println(n.getName() + "간호사가 퇴근합니다.");
                break;
            }
            break;
        }
    }
}
