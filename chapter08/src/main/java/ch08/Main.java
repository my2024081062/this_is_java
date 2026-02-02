package ch08;
import ch08.sec.electronics.*;
import ch08.sec.mjc813.Mjc813Human;
import ch08.sec.test.DoInterfaces;
import ch08.sec.test.*;
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

        Nurse nur1 = new Nurse("김");
        Nurse nur2 = new Nurse("박");
        myClinic.addNerse(nur1);
        myClinic.addNerse(nur2);

        AnimalOwner aniow1 = new AnimalOwner("정");
        AnimalOwner aniow2 = new AnimalOwner("이");

        Animal ani1 = new Animal("뽀삐",EnableAnimal.DOG,true);
        Animal ani2 = new Animal("삐삐",EnableAnimal.DOG,false);

        Animal ani3 = new Animal("나비",EnableAnimal.CAT,true);

        aniow1.requestCareAnimal(ani1,vet1,nur1);
        aniow1.requestCareAnimal(ani2,vet1,nur2);

        aniow2.requestCareAnimal(ani3,vet1,nur1);
        //병원에 '현재 있는' 간호사가 자동으로 담당하게 하면 좋을듯
        aniow1.visitAnimal(ani1,nur2);
        aniow1.visitAnimal(ani3,nur1);
        aniow1.visitAnimal(ani1,nur1);
        aniow1.visitAnimal(ani2,nur2);

        myClinic.nurses_job0816(nur1);
    }
}