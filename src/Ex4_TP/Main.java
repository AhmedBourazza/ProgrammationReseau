package Ex4_TP;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        Bat_Computer bat = new Bat_Computer(2);


           Police p1 = new Police("1", bat);
           Police p2 = new Police("2", bat);
           Police p3 = new Police("3", bat);
           Police p4 = new Police("4", bat);
           Police p5 = new Police("5", bat);



         Bat_Family bf1 = new Bat_Family(String.valueOf(1), bat);
         Bat_Family bf2 = new Bat_Family(String.valueOf(2), bat);
         Bat_Family bf3 = new Bat_Family(String.valueOf(3), bat);
         Bat_Family bf4 = new Bat_Family(String.valueOf(4), bat);
         Bat_Family bf5 = new Bat_Family(String.valueOf(5), bat);

         p1.start();
         p2.start();

         bf2.start();



    }
}
