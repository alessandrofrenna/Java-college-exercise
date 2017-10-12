package geometria.figurepiane;

public class Cerchio
{
    private static final double PI = 3.1415;

    public static double calculateArea(double radious)
    {
        return Math.pow(radious, 2) * PI;
    }
}