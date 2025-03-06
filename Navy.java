abstract public class Navy extends WarMachines {

    String subType;
    int advantageOnAF;

    Navy() {
        super.type = "Navy";
    }
}

class Frigate extends Navy {

    Frigate() {
        super.id = 0;
        super.level = 0;
        super.defense = 25;
        super.attack = 10;
        super.subType = "Frigate";
        super.advantageOnAF = 5;
        System.out.println("Frigate constructor");

    }

    public void showCard(int l, int d, int a, String t, String sT) {
        System.out.println(l);
        System.out.println(d);
        System.out.println(a);
        System.out.println(t);
        System.out.println(sT);
    }
}

class Sida extends Navy {

    int advantageSPEC = 10;

    Sida() {
        super.id = 0;
        super.level = 0;
        super.defense = 15;
        super.attack = 10;
        super.subType = "Sida";
        super.advantageOnAF = 10;
        System.out.println("Sida constructor");
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