package Marathon;

public class Main {
    public static void main(String[] args) {
        Team team1 = new Team("Zoo");
        team1.printInformationAboutTheTeam();

        Course course = new Course();
        course.printInformationAboutTheObstacle();
        course.passObstacles(team1);

        team1.passedTheDistance();

    }
}