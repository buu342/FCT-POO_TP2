import java.util.Scanner;
import ShowPedia.*;
//import java.util.InputMismatchException;
 

public class Main 
{
    // Command Constants
    public static final String COMMAND_SHOW_ADD                 = "ADDSHOW";
    public static final String COMMAND_SHOW_CURR                = "CURRENTSHOW";
    public static final String COMMAND_SHOW_SWITCHTO            = "SWITCHTOSHOW";
    public static final String COMMAND_SEASON_ADD               = "ADDSEASON";
    public static final String COMMAND_SEASON_OUTLINE           = "SEASONSOUTLINE";
    public static final String COMMAND_EPISODE_ADD              = "ADDEPISODE";
    public static final String COMMAND_CHARACTER_ADD            = "ADDCHARACTER";
    public static final String COMMAND_CHARACTER_RESUME         = "CHARACTERRESUME";
    public static final String COMMAND_CHARACTER_COMPARE        = "HOWARETHESETWORELATED";
    public static final String COMMAND_CHARACTER_FILMOGRAPHY    = "HOWARETHESETWORELATED";
    public static final String COMMAND_RELATIONSHIP_ADD         = "ADDRELATIONSHIP";
    public static final String COMMAND_ROMANCE_ADD              = "ADDROMANCE";
    public static final String COMMAND_EVENT_ADD                = "ADDEVENT";
    public static final String COMMAND_QUOTE_QUOTER             = "FAMOUSQUOTES";
    public static final String COMMAND_ACTOR_ROMANCE            = "MOSTROMANTIC";
    public static final String COMMAND_KINGCGI                  = "KINGOFCGI";
    public static final String COMMAND_HELP                     = "HELP";
    public static final String COMMAND_QUIT                     = "EXIT";
     
     // Message Constants
    public static final String MESSAGE_UNKNOWN_CMD      = "Unknown command. Type help to see available commands.";
    public static final String MESSAGE_EXIT             = "Bye!";
    public static final String MESSAGE_HELP             = "currentShow - show the current show\r\n" + 
            "addShow - add a new show\r\n" + 
            "switchToShow - change the context to a particular show\r\n" + 
            "addSeason - add a new season to the current show\r\n" + 
            "addEpisode - add a new episode to a particular season of the current show\r\n" + 
            "addCharacter - add a new character to a show\r\n" + 
            "addRelationship - add a family relationship between characters\r\n" + 
            "addRomance - add a romantic relationship between characters\r\n" + 
            "addEvent - add a significant event involving at least one character\r\n" + 
            "addQuote - add a new quote to a character\r\n" + 
            "seasonsOutline - outline the contents of the selected seasons for the selected show\r\n" + 
            "characterResume - outline the main information on a specific character\r\n" + 
            "howAreTheseTwoRelated - find out if and how two characters may be related\r\n" + 
            "famousQuotes - find out which character(s) said a particular quote\r\n" + 
            "alsoAppearsOn - which other shows and roles is the same actor on?\r\n" + 
            "mostRomantic - find out who is at least as romantic as X\r\n" + 
            "kingOfCGI - find out which company has earned more revenue with their CGI virtual actors\r\n" + 
            "help - shows the available commands\r\n" + 
            "exit - terminates the execution of the program";

     public static void main(String[] args) 
     {   
         Scanner in = new Scanner(System.in);
         ShowPedia sPedia = new ShowPediaClass();
         String comm = getCommand(in);
      
         while (!comm.equals(COMMAND_QUIT))
         {
             switch (comm) {
                 case COMMAND_HELP:
                     showHelp(in, sPedia);
                     break;
                 default:
                     System.out.println(MESSAGE_UNKNOWN_CMD);
                     break;
             }
             System.out.println();
             comm = getCommand(in);
         }
         System.out.println(MESSAGE_EXIT);
         System.out.println();
         in.close();
     }
    
    private static String getCommand(Scanner in) {
        String input;
        input = in.nextLine().toUpperCase();
        return input;
    }
    
    private static void showHelp(Scanner in, ShowPedia sPedia) {
        in.nextLine();
        System.out.println(MESSAGE_HELP);
    }
        
    
}
