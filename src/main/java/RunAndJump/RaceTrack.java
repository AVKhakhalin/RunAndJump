package RunAndJump;

public class RaceTrack
{
    float distance;
    float maxDistance;

    RaceTrack()
    {
        this.distance = (float) (Math.random() * maxDistance);
    }

    public float getDistance()
    {
        return distance;
    }
}
