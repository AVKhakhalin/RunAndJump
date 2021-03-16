package RunAndJump;

import javax.swing.*;

public class Cat
{
    float limitHigh;
    float limitDistance;

    float maxHigh = 2.5f;
    float maxDistance = 300f;
    String kind = "Кот";

    private Wall newWall;
    private RaceTrack newRaceTrack;

    Cat(int numberTask)
    {
        if (numberTask < 8)
        {
            this.limitHigh = maxHigh;
            this.limitDistance = maxDistance;
        }
        else
        {
            this.limitHigh = (float) (Math.random() * maxHigh);
            if (this.limitHigh == 0)
            {
                this.limitHigh = maxHigh / 10;
            }
            this.limitDistance = (float) (Math.random() * maxDistance);
            if (this.limitDistance == 0)
            {
                this.limitDistance = maxDistance / 10;
            }
        }
    }

    public void runSolveTask5()
    {
        System.out.println(kind + " пробежал " + roundFloat(limitDistance) + " метров.");
        JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">" + kind + " пробежал " + roundFloat(limitDistance) + " метров.</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
    }

    public void jumpSolveTask5()
    {
        System.out.println(kind + " прыгнул на " + roundFloat(limitHigh) + " метров.");
        JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">" + kind + " прыгнул на " + roundFloat(limitHigh) + " метров.</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
    }

    public void runSolveTask6(RaceTrack newRaceTrack)
    {
        if (newRaceTrack.distance <= maxDistance)
        {
            System.out.println(kind + " пробежал беговую дорожку длиною " + roundFloat(newRaceTrack.distance) + " метров.");
            JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">" + kind + " пробежал беговую дорожку длиною " + roundFloat(newRaceTrack.distance) + " метров.</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            System.out.println(kind + " не смог пробежать беговую дорожку длиною " + roundFloat(newRaceTrack.distance) + " метров.");
            JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">" + kind + " не смог пробежать беговую дорожку длиною " + roundFloat(newRaceTrack.distance) + " метров.</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void jumpSolveTask6(Wall newWall)
    {
        if (newWall.high <= maxHigh)
        {
            System.out.println(kind + " перепрыгнул стену высотой " + roundFloat(newWall.high) + " метров.");
            JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">" + kind + " перепрыгнул стену высотой " + roundFloat(newWall.high) + " метров.</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            System.out.println(kind + " не смог перепрыгнуть стену высотой " + roundFloat(newWall.high) + " метров.");
            JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">" + kind + " не смог перепрыгнуть стену высотой " + roundFloat(newWall.high) + " метров.</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public Wall getNewWall()
    {
        return newWall;
    }

    public RaceTrack getNewRaceTrack()
    {
        return newRaceTrack;
    }

    public String roundFloat(float number)
    {
        return String.format("%(.1f", number);
    }
}