package RunAndJump;

public class Wall
{
    float high;
    float maxHigh = 1.5f;

    Wall()
    {
        this.high = (float) (Math.random() * maxHigh);
    }

    public float getHigh()
    {
        return high;
    }
}
