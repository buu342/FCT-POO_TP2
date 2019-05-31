/**
 * @author André Enes 51099
 * @author Lourenco Soares 54530
 * Project 2 for POO
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ShowPedia.*;
import exceptions.*;
 
public class Main 
{
    // Command Constants
    public static final String COMMAND_SHOW_CURRENT             = "CURRENTSHOW";
    public static final String COMMAND_SHOW_ADD                 = "ADDSHOW";   
    public static final String COMMAND_SHOW_SWITCHTO            = "SWITCHTOSHOW";
    public static final String COMMAND_SEASON_ADD               = "ADDSEASON";
    public static final String COMMAND_EPISODE_ADD              = "ADDEPISODE";
    public static final String COMMAND_CHARACTER_ADD            = "ADDCHARACTER";
    public static final String COMMAND_RELATIONSHIP_ADD         = "ADDRELATIONSHIP";
    public static final String COMMAND_ROMANCE_ADD              = "ADDROMANCE";
    public static final String COMMAND_EVENT_ADD                = "ADDEVENT";
    public static final String COMMAND_QUOTE_ADD                = "ADDQUOTE";
    public static final String COMMAND_SEASON_OUTLINE           = "SEASONSOUTLINE";
    public static final String COMMAND_CHARACTER_RESUME         = "CHARACTERRESUME";
    public static final String COMMAND_CHARACTER_COMPARE        = "HOWARETHESETWORELATED";
    public static final String COMMAND_QUOTE_QUOTER             = "FAMOUSQUOTES";
    public static final String COMMAND_ACTOR_ALSOIN             = "ALSOAPPEARSON";
    public static final String COMMAND_ACTOR_ROMANCE            = "MOSTROMANTIC";
    public static final String COMMAND_KINGCGI                  = "KINGOFCGI";
    public static final String COMMAND_HELP                     = "HELP";
    public static final String COMMAND_QUIT                     = "EXIT";
     
    // Message Constants
    public static final String MESSAGE_UNKNOWN_COMMAND          = "Unknown command. Type help to see available commands.";
    public static final String MESSAGE_NO_SHOW_SELECTED         = "No show is selected!";
    public static final String MESSAGE_NO_SEASON                = "Unknown Season!";
    public static final String MESSAGE_NO_SEASON_DETAILED       = "%s does not have season %d!\n";
    public static final String MESSAGE_NO_EPISODE               = "%s S%d does not have episode %d!\n";
    public static final String MESSAGE_NO_CHARACTER             = "Who is %s?\n";
    public static final String MESSAGE_DUPLICATE_CHARACTER      = "Duplicate character names are not allowed!";
    public static final String EVENT_ADDED                		= "Event added.";
    public static final String MESSAGE_EXISTING_SHOW            = "Show already exists!";
    public static final String MESSAGE_NON_EXISTING_SHOW        = "Unknown show!";
    public static final String MESSAGE_EXISTING_CHARACTER       = "Duplicate character names are not allowed!";
    public static final String MESSAGE_INVALID_TYPE             = "Unknown actor category!";
    public static final String MESSAGE_INVALID_FEE              = "Slavery is long gone and this is outrageous!";
    public static final String MESSAGE_EXIT                     = "Bye!";
    public static final String MESSAGE_HELP                     = "currentShow - show the current show\r\n" + 
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
         // Initialize the program
         Scanner in = new Scanner(System.in);
         ShowPedia sPedia = new ShowPediaClass();
         String comm = getCommand(in);
      
         // Get commands until the user writes EXIT
         while (!comm.equals(COMMAND_QUIT)) {
             
             // Decide what to do depending on the command
             switch (comm) {
                 case COMMAND_HELP:
                     System.out.println(MESSAGE_HELP);
                     break;
                 case COMMAND_SHOW_SWITCHTO:
                     switchToShow(in,sPedia);
                     break;
                 case COMMAND_KINGCGI:
                     kingOfCGI(sPedia);
                     break;
                 case COMMAND_CHARACTER_ADD:
                     addCharacter(in,sPedia);
                     break;
                 case COMMAND_SHOW_ADD:
                     addShow(in, sPedia);
                     break;
                 case COMMAND_EPISODE_ADD:
                     addEpisode(in, sPedia);
                     break;
                 case COMMAND_SEASON_ADD:
                     addSeason(in, sPedia);
                     break;
                 case COMMAND_EVENT_ADD:
                     addEvent(in, sPedia);
                     break;
                 case COMMAND_SHOW_CURRENT:
                     currentShow(sPedia);
                     break;
                 default:
                     System.out.println(MESSAGE_UNKNOWN_COMMAND);
                     break;
             }
             
             // Get another command
             System.out.println();
             comm = getCommand(in);
         }
         
         // Say goodbye and terminate the program  
         System.out.println(MESSAGE_EXIT);
         System.out.println();
         in.close();
     }
    
     
     private static void addEvent(Scanner in, ShowPedia sPedia){
		String description = in.nextLine();
		int season = in.nextInt();
		int episode = in.nextInt();
		int nrCharacters = in.nextInt();in.nextLine();
		String showName = null;
		List<String> characters = new ArrayList<String>();
		for(int i = 0; i<nrCharacters; i++) {
			characters.add(in.nextLine());
		}
		
		try {
			showName =sPedia.getCurrent().getName();
			sPedia.addEvent(description, season, episode, characters);
			System.out.println(EVENT_ADDED);
		}catch (NoShowSelectedException e) {
            System.out.println(MESSAGE_NO_SHOW_SELECTED);
        }catch (NoSeasonException e) {
            System.out.printf(MESSAGE_NO_SEASON_DETAILED, showName, season, episode);
        }catch (NoEpisodeException e) {
            System.out.println(MESSAGE_NO_EPISODE);
        }catch (NoCharacterException e ) {
            System.out.printf(MESSAGE_NO_CHARACTER, sPedia.hasCharacters(characters));
        }catch (DuplicateCharacterException e ) {
            System.out.println(MESSAGE_DUPLICATE_CHARACTER);
        }
		
	}


	private static void kingOfCGI(ShowPedia sPedia) {
        //try {
            sPedia.kingOfCGI();
        //}
    }


    // Standardize the input by forcing everything to upper case
     private static String getCommand(Scanner in) {
         String input;
         input = in.nextLine().toUpperCase();
         return input;
     }
     
    private static void addCharacter(Scanner in, ShowPedia sPedia) {
        String type = in.nextLine();
        String characterName = in.nextLine();
        String name = in.nextLine();
        int fee = in.nextInt();
        
        try {
            sPedia.addCharacter(type, characterName, name, fee);
            System.out.printf("%s is now part of %s. This is %s role %d.", characterName, sPedia.getCurrent().getName(), name, sPedia.getActor(name).getNrShows()); 
        }catch (NoShowSelectedException e) {
            System.out.println(MESSAGE_NO_SHOW_SELECTED);
        }catch (InvalidTypeException e) {
            System.out.println(MESSAGE_INVALID_TYPE);
        }catch (ExistingCharacterException e) {
            System.out.println(MESSAGE_EXISTING_CHARACTER);
        }catch (InvalidFeeException e) {
            System.out.println(MESSAGE_EXISTING_CHARACTER);
        }
        
    }

    private static void addEpisode(Scanner in, ShowPedia sPedia) {
        int season = in.nextInt();
        String episode = in.nextLine().trim();
        
        try {
            sPedia.addEpisode(season, episode);
            Show tmp = sPedia.getCurrent();
            System.out.printf("%s S%d, Ep%d: %s.\n",tmp.getName(), season, tmp.getSeason(season).size(), episode);
        }catch (NoShowSelectedException e) {
            System.out.println(MESSAGE_NO_SHOW_SELECTED);
        }catch (NoSeasonException e) {
            System.out.println(MESSAGE_NO_SEASON);
        }
    }

    private static void addSeason(Scanner in, ShowPedia sPedia) {
        try {
            sPedia.addSeason();
            currentShow(sPedia);
        }catch (NoShowSelectedException e) {
            System.out.println(MESSAGE_NO_SHOW_SELECTED);
        }
    }

    private static void switchToShow(Scanner in, ShowPedia sPedia) {
        String show = in.nextLine();
        try {
            sPedia.switchToShow(show);
            currentShow(sPedia);
        }catch(NonExistingShowException e) {
            System.out.println(MESSAGE_NON_EXISTING_SHOW);
        }
    }

    private static void addShow(Scanner in, ShowPedia sPedia) {
        String show = in.nextLine();
        try {
            sPedia.addShow(show);
            System.out.printf("%s created.", show);
        }catch(ExistingShowException e) {
            System.out.println(MESSAGE_EXISTING_SHOW);
        }
    }

    private static void currentShow(ShowPedia sPedia) {
        try {
            Show tmp = sPedia.getCurrent();
            System.out.printf("%s. Seasons: %d Episodes: %d", tmp.getName(), tmp.getNrSeasons(), tmp.getNrEpisodes());
        }catch (NoShowSelectedException e) {
            System.out.println(MESSAGE_NO_SHOW_SELECTED);
        }
    }

}