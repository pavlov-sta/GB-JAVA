package Marathon;



public class Course {
    Obstacle[] let = new Obstacle[3];


    public Course() {
        Cross track = new Cross(100);
        Wall wall = new Wall(10);
        Water water = new Water(100);
        let[0] = (Obstacle) track;
        let[1] = (Obstacle) wall;
        let[2] = (Obstacle) water;
    }

    public void printInformationAboutTheObstacle() {
        System.out.println("Длина беговой дорожки: " + ((Cross) let[0]).length);
        System.out.println("Высота стены: " + ((Wall) let[1]).height);
        System.out.println("Длини босейна: " + ((Water) let[2]).length);
    }

    public void passObstacles(Team team){
        for (Competitor c : team.teamAnimal) {
            for (Obstacle o : let) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
        for (Competitor c : team.teamAnimal) {
            c.info();
        }
    }
}
