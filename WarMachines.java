abstract class WarMachines {

    int id;
    int level = 0;
    int defense;
    int attack;
    String type;

    public abstract void showCard(int level, int defense, int attack, String type, String subType);

    WarMachines() {
    }
}