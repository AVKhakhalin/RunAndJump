package RunAndJump;

import javax.swing.*;

public class SolveTask6
{
    SolveTask6()
    {
        RaceTrack newRaceTrack = new RaceTrack();
        Wall newWall = new Wall();
        Human newHuman = new Human(6);
        Cat newCat = new Cat(6);
        Robot newRobot = new Robot(6);

        System.out.println("Созданы два экземпляра класса: беговая дорожка (протяжённостью " + roundFloat(newRaceTrack.getDistance()) + " метров) и стена (высотой " + roundFloat(newWall.getHigh()) + " метров).");
        JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">Созданы два класса: беговая дорожка (протяжённостью " + roundFloat(newRaceTrack.getDistance()) + " метров) и стена (высотой " + roundFloat(newWall.getHigh()) + " метров).</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);

        newHuman.jumpSolveTask6(newWall);
        newHuman.runSolveTask6(newRaceTrack);
        newCat.jumpSolveTask6(newWall);
        newCat.runSolveTask6(newRaceTrack);
        newRobot.jumpSolveTask6(newWall);
        newRobot.runSolveTask6(newRaceTrack);
    }

    public String roundFloat(float number)
    {
        return String.format("%(.1f", number);
    }
}
