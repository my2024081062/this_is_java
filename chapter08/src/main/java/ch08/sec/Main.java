package ch08.sec;
import ch08.sec.veterinaryClinic.*;

public class Main {
    public static void main(String[] args) {
//        Mjc813Human m8h = new Mjc813Human();
//        m8h.study();
//        MyCalculator<Integer> mci = new MyCalculator<>();
//        MyCalculator<Double> mcd = new MyCalculator<>();
//        System.out.println(mci.add(12,34));
//        System.out.println(mcd.add(1.2,3.4));
//
//        DoImpl di = new DoImpl();
//        di.doElectronics();
//        di.doService();
//
//        RemoteControl stv = new SmartTelevision();
//        stv.turnOn();
//        stv.turnOff();
//
//        Searchable sc = new SmartTelevision();
//        sc.search("https://www.youtube.com/");
//
//        InterfaceA ia = new DoInterfaces();
//        ia.methodA();
//        InterfaceB ib = new DoInterfaces();
//        ib.methodB();
//        InterfaceC ic = new DoInterfaces();
//        ic.methodC();

        Clinic myClinic = Clinic.getInstance();

        EnableAnimal[] enani1 = {EnableAnimal.CAT,EnableAnimal.DOG,EnableAnimal.PARROT,EnableAnimal.RABBIT};
        EnableAnimal[] enani2 = {EnableAnimal.CAT,EnableAnimal.DOG,EnableAnimal.PARROT,EnableAnimal.RABBIT,EnableAnimal.CHICKEN,EnableAnimal.HEDGEHOG};
        Veterinarian vet1 = new Veterinarian("차",enani1);
        Veterinarian vet2 = new Veterinarian("성",enani2);

        myClinic.addVeterinarian(vet1);
        myClinic.addVeterinarian(vet2);

        Nurse nur1 = new Nurse("김",true);
        Nurse nur2 = new Nurse("박",false);
        myClinic.addNerse(nur1);
        myClinic.addNerse(nur2);

        Pet ani1 = new Pet("뽀삐",EnableAnimal.DOG,true);
        Pet ani2 = new Pet("삐삐",EnableAnimal.DOG,false);
        Pet ani3 = new Pet("나비",EnableAnimal.CAT,true);

        Pet[] aniow1SPet = {ani1,ani2};
        Pet[] aniow2SPet = {ani3};

        PetOwner aniow1 = new PetOwner("정", aniow1SPet);
        PetOwner aniow2 = new PetOwner("이", aniow2SPet);


        aniow1.requestCareAnimal(ani1,vet1,nur1);
        aniow1.requestCareAnimal(ani2,vet1,nur2);

        aniow2.requestCareAnimal(ani3,vet1,nur1);
        aniow1.visitAnimal(ani1);
        aniow1.visitAnimal(ani3);
        aniow1.visitAnimal(ani1);
        aniow1.visitAnimal(ani2);

        myClinic.nurses_job0816(myClinic.getNurses0816());
    }
}
