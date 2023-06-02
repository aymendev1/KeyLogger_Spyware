package main.handlers;

public class KeyStorage {
    private int KeyCode;
    private boolean pressed;
    private long systemsTimePressedMillis; // Time when the user pressed the Key

    public KeyStorage(int keyCode, boolean pressed, long systemsTimePressedMillis) {
        KeyCode = keyCode;
        this.pressed = pressed;
        this.systemsTimePressedMillis = systemsTimePressedMillis;
    }

    public int getKeyCode() {
        return KeyCode;
    }

    public boolean isPressed() {
        return pressed;
    }

    public long getSystemsTimePressedMillis() {
        return systemsTimePressedMillis;
    }

    @Override
    public String toString() {
        return "KeyStorage{" +
                "KeyCode=" + KeyCode +
                ", pressed=" + pressed +
                ", systemsTimePressedMillis=" + systemsTimePressedMillis +
                '}';
    }
}
