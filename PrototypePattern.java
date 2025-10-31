interface Cloneable{
   Cloneable clone();
}

class NPC implements Cloneable{
    String name;
    int power;
    int attack;
    NPC(String name, int power,int attack){
        this.name = name;
        this.attack = attack;
        this.power = power;
    }

    NPC (NPC other){
        name = other.name;
        power = other.power;
        attack = other.attack;
    }

    public Cloneable clone(){
        return new NPC(this);
    }

    void describe() {
        System.out.println("NPC " + name + " [Power=" + power + ", Attack=" + attack + "]");
    }
}


class PrototypePattern {
    public static void main(String[] args) {
        NPC alien = new NPC("Alien",30,5);
        alien.describe();
        NPC alien2 = (NPC) alien.clone();
        alien2.describe();

    }
}
