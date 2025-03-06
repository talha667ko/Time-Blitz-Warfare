abstract class WarMachines {

    int level = 0;
    int defense;
    int attack;
    String type;

    public abstract void showCard(int level, int defense, int attack, String type, String subType);

    public abstract void updatePlayer(int level, int defense, boolean used);

    WarMachines() {
    }
}