abstract public class Army extends WarMachines {

    String subType;
    int advantageOnN;

    Army() {
        super.type = "Army";
    }

}

class Bombshell extends Army {

    Bombshell() {
        super.level = 0;
        super.defense = 20;
        super.attack = 10;
        super.subType = "Bombshell";
        super.advantageOnN = 5;
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

class Kfs extends Army {

    int advantageSPEC = 20;

    Kfs() {
        super.level = 0;
        super.defense = 10;
        super.attack = 10;
        super.subType = "Kfs";
        super.advantageOnN = 10;
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