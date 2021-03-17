package RunAndJump;

public class SolveTask8
{
    int numberParticipators;
    int numberBarriers;

    SolveTask8(int _numberParticipators, int _numberBarriers)
    {
        this.numberParticipators = _numberParticipators;
        this.numberBarriers = _numberBarriers;

        int tempRandom = 0;
        Participators[] participators = new Participators[numberParticipators];
        for (int i = 0; i < numberParticipators; i++)
        {
            tempRandom = (int) Math.round(Math.random() * 2);
            if (tempRandom == 0)
            {
                participators[i] = new Human(8);
            }
            else if (tempRandom == 1)
            {
                participators[i] = new Cat(8);
            }
            else
            {
                participators[i] = new Robot(8);
            }
        }

        Barriers[] barriers = new Barriers[numberBarriers];
        for (int i = 0; i < numberBarriers; i++)
        {
            if (Math.round(Math.random()) == 0)
            {
                barriers[i] = new Wall();
            }
            else
            {
                barriers[i] = new RaceTrack();
            }
        }

        RaceTrack newRaceTrack = new RaceTrack();
        Wall newWall = new Wall();

        for (int i = 0; i < numberParticipators; i++)
        {
            System.out.println("Лимит высоты участника = " + roundFloat(participators[i].getLimitHigh()) + "; лимит расстояния участника = " + roundFloat(participators[i].getLimitDistance()));
            for (int j = 0; j < numberBarriers; j++)
            {
                if (barriers[j] instanceof Wall)
                {
                    if (participators[i].jumpSolveTask6(barriers[j]) == false)
                    {
                        break;
                    }
                }
                else if (barriers[j] instanceof RaceTrack)
                {
                    if (participators[i].runSolveTask6(barriers[j]) == false)
                    {
                        break;
                    }
                }
            }
        }
    }

    public String roundFloat(float number)
    {
        return String.format("%(.1f", number);
    }
}
