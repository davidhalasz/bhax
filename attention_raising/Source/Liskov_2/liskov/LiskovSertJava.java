// ez a T az LSP-ben
class Madar {
    public void repul() {
        System.out.println("Tud repülni.\n");
     }
}


// itt jönnek az LSP-s S osztályok
class Sas extends Madar {
    public void repul() {
        System.out.println("A sas repül.\n");
    }
}

class Pingvin extends Madar {

}

class LiskovSertJava {
    public static void repulok(Madar r) {
        r.repul();
    }
    public static void main(String[] args) {
        Madar sas = new Sas();
        Madar pingvin = new Pingvin(); 
        
        repulok(sas);
        repulok(pingvin); // sérül az LSP, mert a P::fgv röptetné a Pingvint, ami ugye lehetetlen.

    }

}

