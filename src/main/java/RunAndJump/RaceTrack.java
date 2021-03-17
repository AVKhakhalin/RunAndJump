package RunAndJump;

public class RaceTrack implements Barriers
{
    float distance;
    float maxDistance = 200;

    private Cat newCat;
    private Human newHuman;
    private Robot newRobot;

    RaceTrack()
    {
        this.distance = (float) (Math.random() * maxDistance);
        if (this.distance == 0)
        {
            this.distance = maxDistance / 10;
        }
    }

    public float getDistance()
    {
        return distance;
    }

    public void setDistance(float distance)
    {
        this.distance = distance;
    }

    @Override
    public float getBarrier()
    {
        return distance;
    }
}
