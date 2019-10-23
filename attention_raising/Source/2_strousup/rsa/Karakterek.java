class Karakterek {

    private String encrypted;
    private char karakter = ' ';
    private int gyakorisag = 0;

    public Karakterek(String str, char k) {
        encrypted = str;
        karakter = k;
    }

    public Karakterek(String str) {
        encrypted = str;
    }

    public void setEncrypted(String str) {
        encrypted = str;
    }

    public String getEncrypted() {
        return encrypted;
    }

    public void setKarakter(char k) {
        karakter = k;
    }

    public char getKarakter() {
        return karakter;
    }

    public void increment() {
        gyakorisag += 1;
    }

    public int getGyak() {
        return gyakorisag;
    }
}