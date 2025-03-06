abstract public class AirForce extends WarMachines {

    String subType;
    int advantageOnA;

    AirForce() {
        super.type = "Air";
    }

    public void updatePlayer() {
        System.out.println("AIR updatePlayer");
    }

}

class Plane extends AirForce {

    Plane() {
        super.id = 0;
        super.level = 0;
        super.defense = 20;
        super.attack = 10;
        super.subType = "Plane";
        super.advantageOnA = 10;
        System.out.println("Plane constructor");
    }

    @Override
    public void showCard(int l, int d, int a, String t, String sT) {
        System.out.println(l);
        System.out.println(d);
        System.out.println(a);
        System.out.println(t);
        System.out.println(sT);
    }
}

class Siha extends AirForce {

    int advantageSPEC = 10;

    Siha() {
        super.id = 0;
        super.level = 0;
        super.defense = 15;
        super.attack = 10;
        super.subType = "Siha";
        super.advantageOnA = 10;
        System.out.println("Siha constructor");
    }

    @Override
    public void showCard(int l, int d, int a, String t, String sT) {
        System.out.println(l);
        System.out.println(d);
        System.out.println(a);
        System.out.println(t);
        System.out.println(sT);
    }
}