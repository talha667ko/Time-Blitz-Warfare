abstract public class Army extends WarMachines {

    String subType;
    int advantageOnN;

    Army() {
        super.type = "Army";
    }

    public void updatePlayer() {
        System.out.println("ARMY updatePlayer");
    }
}

class Bombshell extends Army {

    Bombshell() {
        super.id = 0;
        super.level = 0;
        super.defense = 20;
        super.attack = 10;
        super.subType = "Bombshell";
        super.advantageOnN = 5;
        System.out.println("Bombshell constructor");
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

class Kfs extends Army {

    int advantageSPEC = 20;

    Kfs() {
        super.id = 0;
        super.level = 0;
        super.defense = 10;
        super.attack = 10;
        super.subType = "Kfs";
        super.advantageOnN = 10;
        System.out.println("kfs constructor");
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