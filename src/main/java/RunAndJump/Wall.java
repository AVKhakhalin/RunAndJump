package RunAndJump;

public class Wall implements Barriers
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

    public void setHigh(float high)
    {
        this.high = high;
    }
}
