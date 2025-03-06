abstract public class Navy extends WarMachines {

    String subType;
    int advantageOnAF;

    Navy() {
        super.type = "Army";
    }
}

class Frigate extends Navy {

    Frigate() {
        super.level = 0;
        super.defense = 25;
        super.attack = 10;
        super.subType = "Frigate";
        super.advantageOnAF = 5;

    }

    public void updatePlayer(int l, int d, boolean status) {

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
        super.level = 0;
        super.defense = 15;
        super.attack = 10;
        super.subType = "Sida";
        super.advantageOnAF = 10;
    }

    public void updatePlayer(int l, int d, boolean status) {

    }

    public void showCard(int l, int d, int a, String t, String sT) {
        System.out.println(l);
        System.out.println(d);
        System.out.println(a);
        System.out.println(t);
        System.out.println(sT);
    }
}