package Marathon.Animals;


import Marathon.Obstrances.Competitor;

import java.util.Random;

public class Team {
    private String nameTeam = "";
    Animal[] zoo = {new Hen("Коко"), new Cat("Барсик"), new Dog("Бобик"), new Elephant("Дамбо")};
    public Animal[] teamAnimal = new Animal[4];

    Random random = new Random();

    public Team(String nameTeam) {
        this.nameTeam = nameTeam;

        for(int i = 0; i < 4; i++){
            int ran = random.nextInt(3);
            teamAnimal[i] = zoo[ran];
        }
    }

    public void printInformationAboutTheTeam() {
        System.out.println("Команда: " + nameTeam);
        for(Animal a : teamAnimal) {

            System.out.println("Дистанция - бег: " + a.maxRunDistance);
            if (a instanceof Competitor)
                System.out.println("Дистанция - паванье: " + ((Competitor) a).isOnDistance());
            if (a instanceof Competitor)
                System.out.println("Дистанция - прыжки: " + ((Competitor) a).isOnDistance());
        }

    }
    // Вывод информации кто прошел дистанцию
    public void passedTheDistance(){
        System.out.println(nameTeam + "\n");
        for (Animal a : teamAnimal){
            if(a.onDistance){
                System.out.println(a + " успешно прошел дистанцию.\n");
            } else {
                System.out.println(a + " не прошел дистанцию.\n");
            }
        }

    }
}
