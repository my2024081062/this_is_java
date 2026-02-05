package ch08.sec.veterinaryClinic;

import ch08.sec.veterinaryClinic.petFoods.*;
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
        for(Nurse n : nurses){
            System.out.println(n.getName() + "간호사가 출근합니다.");
        }
        CatFood catFood = CatFood.getInstance();
        ChickenFood chickenFood = ChickenFood.getInstance();
        DogFood dogFood = DogFood.getInstance();
        HedgehogFood hedgehogFood = HedgehogFood.getInstance();
        ParrotPood parrotPood = ParrotPood.getInstance();
        RabbitFood rabbitFood = RabbitFood.getInstance();

        PetFood[] petFoods = new PetFood[]{catFood,chickenFood,dogFood,hedgehogFood,parrotPood,rabbitFood};
        for (PetFood petFood : petFoods) {
            if (petFood.getAmount() >= 100) {
                continue;
            }
            petFood.addFood(10);
        }

        while (true){ //실험용으로 true
            for(PetChart pc : this.getPetCharts()){
                for(int i = 0; i < pc.getEatFoodTimes().length; i++){
                    if(LocalTime.now().equals(pc.getEatFoodTimes()[i]) || true){
                        System.out.println(pc.getPet().getName() + "에게 먹이를 " + pc.getEatFoodAmount() + "만큼 먹입니다.");
                        for (PetFood petFood : petFoods) {
                            if (pc.getPet().getEnableAnimal() == petFood.getEnableAnimal()) {
                                petFood.subtractFood(pc.getEatFoodAmount());
                                System.out.println(petFood.getEnableAnimal().toString() + "종의 사료가 " +petFood.getAmount() + "만큼 남았습니다.");
                            }
                        }
                    }
                }
            }
            if(LocalTime.now() == LocalTime.of(8,0,0) || true){
                for(PetChart petChart : this.getPetCharts()){
                    if(!petChart.isExtern()){
                        System.out.println("아침에 " + petChart.getPet().getName() + "에게 " + petChart.getApproximately().getName() +"을 먹입니다.");
                    }
                }
            }
            if(LocalTime.now() == LocalTime.of(13,0,0) || true){
                for(PetChart petChart : this.getPetCharts()){
                    if(!petChart.isExtern()){
                        System.out.println("점심에 " + petChart.getPet().getName() + "에게 " + petChart.getApproximately().getName() +"을 먹입니다.");
                    }
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
        for(Nurse n : nurses){
            System.out.println(n.getName() + "간호사가 출근합니다.");
        }
        for (int i = 0; i < this.getPetCharts().length; i++) {
            if(LocalDate.now().equals(this.getPetCharts()[i].getExternalClinicDate())){
                this.getPetCharts()[i].setExtern(true);
                System.out.println(this.getPetCharts()[i].getPet().getName() + "이(가) 치료가 완료되어 퇴원합니다.");
            }
        }
        while (true){
            if(LocalTime.now() == LocalTime.of(18,0,0) || true){
                for(PetChart petChart : this.getPetCharts()){
                    if(!petChart.isExtern()){
                        System.out.println("저녁에 " + petChart.getPet().getName() + "에게 " + petChart.getApproximately().getName() +"을 먹입니다.");
                    }
                }
            }
            if(LocalTime.now() == LocalTime.of(23,59,0) || true){
                for(Nurse n : nurses){
                    System.out.println(n.getName() + "간호사가 퇴근합니다.");
                }
                break;
            }
        }
    }
}
