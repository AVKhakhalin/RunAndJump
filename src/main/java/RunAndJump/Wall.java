package RunAndJump;

public class Wall implements Barriers
{
    float high;
    float maxHigh = 1.5f;

    private Cat newCat;
    private Human newHuman;
    private Robot newRobot;

    Wall()
    {
        this.high = (float) (Math.random() * maxHigh);
        if (this.high == 0)
        {
            this.high = maxHigh / 10;
        }
    }

    public float getHigh()
    {
        return high;
    }

    public void setHigh(float high)
    {
        this.high = high;
    }

    @Override
    public float getBarrier()
    {
        return high;
    }
}
