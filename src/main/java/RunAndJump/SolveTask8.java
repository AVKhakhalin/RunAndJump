package RunAndJump;

public class SolveTask8
{
    SolveTask8()
    {

        Barriers[] barriers = new Barriers[4];
        barriers[0] = new Wall();
        barriers[1] = new RaceTrack();
        barriers[2] = new Wall();
        barriers[3] = new RaceTrack();

        Participators[] participators = new Participators[3];
        participators[0] = new Cat(8);
        participators[1] = new Human(8);
        participators[2] = new Robot(8);

        RaceTrack newRaceTrack = new RaceTrack();
        Wall newWall = new Wall();

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (barriers[j] instanceof Wall)
                {
                    newWall.high = barriers[j].high;
                    if (participators[i].jumpSolveTask6(newWall) == false)
                    {
                        break;
                    }
                }
                else
                {
                    newRaceTrack.distance = barriers[j].distance;
                    if (participators[i].runSolveTask6(newRaceTrack) == false)
                    {
                        break;
                    }
                }
            }
        }
    }
}
