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
            case "-ex3":
                new ex3.Driver(args);
                break;
            case "-ex4":
                new ex4.Driver(args);
                break;
            default:
                System.err.println("Unknown argument");
                break;
        }
    }
}
