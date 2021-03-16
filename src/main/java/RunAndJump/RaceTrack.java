package RunAndJump;

public class RaceTrack implements Barriers
{
    float distance;
    float maxDistance = 200;

    RaceTrack()
    {
        this.distance = (float) (Math.random() * maxDistance);
    }

    public float getDistance()
    {
        return distance;
    }

    public void setDistance(float distance)
    {
        this.distance = distance;
    }
}
