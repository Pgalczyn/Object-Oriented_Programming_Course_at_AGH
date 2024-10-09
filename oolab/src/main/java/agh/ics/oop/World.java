package agh.ics.oop;

public class World {

    public static void main(String[] args) {

        System.out.println("system wystartowal");
        run(args);
        System.out.println("system zakonczyl dzialanie");
    }

    public static void run(String[] args){
        System.out.println("start");

        for(int i = 0; i<args.length;i++ ){

            switch (args[i]){

                case "f":  System.out.println("Zwierzak idzie do przodu");
                    break;
                case "b": System.out.println("Zwierzak idzie do tylu");
                    break;
                case "r": System.out.println("Zwierzak skreca w prawo");
                    break;
                case "l": System.out.println("Zwierzak skreca w lewo");
                    break;
            }

        }
        System.out.println("stop");
    }
}

