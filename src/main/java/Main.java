public class Main
{
    public static void main(String[] args)
    {
        switch (args[0])
        {
            case "-ex1":
                new ex1.Driver(args);
                break;
            case "-ex2":
                new ex2.Driver(args);
                break;
            default:
                System.err.println("Unknown argument");
        }
    }
}
