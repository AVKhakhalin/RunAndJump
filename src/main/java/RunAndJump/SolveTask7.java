package RunAndJump;

import javax.swing.*;

public class SolveTask7
{
    SolveTask7()
    {

        Barriers[] barriers = new Barriers[4];
        barriers[0] = new Wall();
        barriers[1] = new RaceTrack();
        barriers[2] = new Wall();
        barriers[3] = new RaceTrack();

        Participators[] participators = new Participators[3];
        participators[0] = new Cat(7);
        participators[1] = new Human(7);
        participators[2] = new Robot(7);

        RaceTrack newRaceTrack = new RaceTrack();
        Wall newWall = new Wall();

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (barriers[j] instanceof Wall)
                {
                    newWall.high = barriers[j].high;
                    participators[i].jumpSolveTask6(newWall);
                }
                else
                {
                    newRaceTrack.distance = barriers[j].distance;
                    participators[i].runSolveTask6(newRaceTrack);
                }
            }
        }
    }
}
