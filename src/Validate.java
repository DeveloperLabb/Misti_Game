public class Validate {
    public Validate(String[] parameters) {
        this.parameters = parameters;
    }
    private static String[] parameters;
    public static void validateNumOfPlayers(String a) throws IllegalArgumentException{
        boolean validate = a.matches("[234]");
        if(!validate){
            throw new IllegalArgumentException("Please type 2-3 or 4 as a number of player to first arguement.");
        }
    }
    public static void validateFile(String a) throws IllegalArgumentException{
        boolean validate = a.matches("[a-z]{1,}\\.txt");
        if (!validate){
            throw new IllegalArgumentException("Please type at least one lowercase and 5 character long as a file name and endswith \".txt\" to second argument.");
        }
    }
    public static void validateNameAndLevel(String a) throws IllegalArgumentException{
        boolean validate = a.matches("[A-Z][a-z]+-[1-4]{1}");
        if(!validate){
            throw new IllegalArgumentException("Please for use as a name startswith a uppercase letter and also use at least one lowercase letter and please type 1-2-3(These are the bot levels) or 4(That is human player level) as a player level.Write with \"-\" between the name as an third forth fifth sixth argument that depends on your first argument(Player number)\n\t like Mert-1 Baha-2 Aras-3");
        }
    }
    public static void validateVerbosenessLevel(String a) throws IllegalArgumentException{
        boolean validate =a.matches("[12]");
        if(!validate){
            throw new IllegalArgumentException("Please type 1 or 2 as an verbosness level to last argument\n 1 for Succinct 2 for Verbose");
        }
    }
}
