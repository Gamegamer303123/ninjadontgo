package net.gamegamer.ninjago;

public class PowerData {
    private final String power;
    private boolean active;
    private int level;

    public PowerData(String power, int level, boolean active) {
        this.power = power;
        this.level = level;
        this.active = active;
    }

    public String getPower() {
        return power;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
