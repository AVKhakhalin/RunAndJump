package RunAndJump;

import javax.swing.*;

public class Cat implements Participators, Barriers
{
    float limitHigh;
    float limitDistance;

//    float maxHigh = 2.5f;
//    float maxDistance = 300f;
    float maxHigh = 1f;
    float maxDistance = 100f;
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

    @Override
    public boolean runSolveTask6(Barriers newRaceTrack)
    {
        if (newRaceTrack instanceof RaceTrack)
        {
            if (newRaceTrack.getBarrier() <= limitDistance)
            {
                System.out.println("     " + kind + " пробежал беговую дорожку длиною " + roundFloat(newRaceTrack.getBarrier()) + " м.");
                JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">Лимит высоты участника = " + roundFloat(limitHigh) + " м; лимит расстояния участника = " + roundFloat(limitDistance) + " м.<br>" + kind + " пробежал беговую дорожку длиною " + roundFloat(newRaceTrack.getBarrier()) + " м.</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
            else
            {
                System.out.println("     " + kind + " не смог пробежать беговую дорожку длиною " + roundFloat(newRaceTrack.getBarrier()) + " м.");
                JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">Лимит высоты участника = " + roundFloat(limitHigh) + " м; лимит расстояния участника = " + roundFloat(limitDistance) + " м.<br>" + kind + " не смог пробежать беговую дорожку длиною " + roundFloat(newRaceTrack.getBarrier()) + " м.</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean jumpSolveTask6(Barriers newWall)
    {
        if (newWall instanceof Wall)
        {
            if (newWall.getBarrier() <= limitHigh)
            {
                System.out.println("     " + kind + " перепрыгнул стену высотой " + roundFloat(newWall.getBarrier()) + " м.");
                JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">Лимит высоты участника = " + roundFloat(limitHigh) + " м; лимит расстояния участника = " + roundFloat(limitDistance) + " м.<br>" + kind + " перепрыгнул стену высотой " + roundFloat(newWall.getBarrier()) + " м.</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
            else
            {
                System.out.println("     " + kind + " не смог перепрыгнуть стену высотой " + roundFloat(newWall.getBarrier()) + " м.");
                JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">Лимит высоты участника = " + roundFloat(limitHigh) + " м; лимит расстояния участника = " + roundFloat(limitDistance) + " м.<br>" + kind + " не смог перепрыгнуть стену высотой " + roundFloat(newWall.getBarrier()) + " м.</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);


                return false;
            }
        }
        else
        {
            return false;
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

    public float getLimitHigh()
    {
        return limitHigh;
    }

    public float getLimitDistance()
    {
        return limitDistance;
    }

    public float getBarrier()
    {
        return 0f;
    }
}
