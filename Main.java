/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Project 2 for POO
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;

import Comparators.*;
import Exceptions.*;

import java.util.Arrays;
import java.util.Collections;

import ShowPedia.*;

public class Main {
    
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
    public static final String MESSAGE_NO_SEASON                = "Unknown season!";
    public static final String MESSAGE_NO_SEASON_DETAILED       = "%s does not have season %d!\n";
    public static final String MESSAGE_NO_EPISODE               = "%s S%d does not have episode %d!\n";
    public static final String MESSAGE_NO_CHARACTER             = "Who is %s?\n";
    public static final String MESSAGE_NO_LOVE                  = "Love is not in the air. :-(";
    public static final String MESSAGE_DUPLICATE_CHARACTER      = "Duplicate character names are not allowed!";
    public static final String MESSAGE_DUPLICATE_PARENT         = "%s cannot be parent and child at the same time!\n";
    public static final String MESSAGE_DUPLICATE_ROMANCE        = "%s cannot be in a single person romantic relationship!\n";
    public static final String MESSAGE_DUPLICATE_RELATIONSHIP   = "What else is new? We already know about those two...";
    public static final String MESSAGE_EVENT_ADDED              = "Event added.";
    public static final String MESSAGE_QUOTE_ADDED              = "Quote added.";
    public static final String MESSAGE_EXISTING_SHOW            = "Show already exists!";
    public static final String MESSAGE_NON_EXISTING_SHOW        = "Unknown show!";
    public static final String MESSAGE_INVALID_INTERVAL         = "Invalid seasons interval!";
    public static final String MESSAGE_EXISTING_CHARACTER       = "Duplicate character names are not allowed!";
    public static final String MESSAGE_NO_VIRTUAL_CHARACTERS    = "This is the real thing, this is art!";
    public static final String MESSAGE_UNEXISTING_QUOTE       	= "First time I hear that!";
    public static final String MESSAGE_NO_RELATIONSHIP          = "These characters are not related!";
    public static final String MESSAGE_SAME_RELATIONSHIP        = "Like... you know, they are THE SAME character! duuuuh...";
    public static final String MESSAGE_INVALID_TYPE             = "Unknown actor category!";
    public static final String MESSAGE_INVALID_FEE              = "Slavery is long gone and this is outrageous!";
    public static final String MESSAGE_VIRTUAL_ACTOR            = "%s is played by a virtual actor!\n";
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
         System.out.print("> ");
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
    				switchToShow(in, sPedia);
    				break;
    			case COMMAND_CHARACTER_RESUME:
    				characterResume(in, sPedia);
    				break;
    			case COMMAND_ACTOR_ALSOIN:
    				alsoApearsOn(in, sPedia);
    				break;
    			case COMMAND_SEASON_OUTLINE:
    				seasonOutline(in, sPedia);
    				break;
    			case COMMAND_QUOTE_QUOTER:
    				famousQuote(in, sPedia);
    				break;
    			case COMMAND_KINGCGI:
    				kingOfCGI(sPedia);
    				break;
    			case COMMAND_CHARACTER_ADD:
    				addCharacter(in, sPedia);
    				break;
    			case COMMAND_SHOW_ADD:
    				addShow(in, sPedia);
    				break;
    			case COMMAND_QUOTE_ADD:
    				addQuote(in, sPedia);
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
    			case COMMAND_RELATIONSHIP_ADD:
    			    addRelationship(in, sPedia);
    			    break;
    			case COMMAND_ROMANCE_ADD:
    			    addRomance(in, sPedia);
    			    break;
    			case COMMAND_CHARACTER_COMPARE:
    			    compareRelations(in, sPedia);
    			    break;
    			case COMMAND_ACTOR_ROMANCE:
    			    mostRomantic(in, sPedia);
    			    break;
    			case COMMAND_SHOW_CURRENT:
    				currentShow(sPedia);
    				break;
    			default:
    				System.out.println(MESSAGE_UNKNOWN_COMMAND);
    				break;
			}

     // Get another command
     System.out.print("> ");
     comm = getCommand(in);
     }
         
     // Say goodbye and terminate the program  
     System.out.println(MESSAGE_EXIT);
     in.close();
		in.close();
	}
     
     private static void currentShow(ShowPedia sPedia) {
         try {
             Show tmp = sPedia.getCurrent();
             System.out.printf("%s. Seasons: %d Episodes: %d\n", tmp.getName(), tmp.getNrSeasons(), tmp.getNrEpisodes());
         } catch (NoShowSelectedException e) {
             System.out.println(MESSAGE_NO_SHOW_SELECTED);
         }
     }
     

     private static void characterResume(Scanner in, ShowPedia sPedia) {
         
         String name = in.nextLine();
         
         try {
             // Print Parents
             Show current = sPedia.getCurrent();
             
             System.out.print("Parents: ");
             if(current.getCharacter(name).getParents().size() == 0) {
                 System.out.println("None.");
             } else {
                 Iterator<String> it = current.getCharacter(name).getParentsNames().iterator();
                 while(it.hasNext()) {
                     System.out.printf("%s", it.next());
                     if(it.hasNext())
                         System.out.print(", ");
                 }
                 System.out.println();
             }
             
             // Print Kids
             System.out.print("Kids: ");
             if(current.getCharacter(name).getChildren().size() == 0) {
                 System.out.println("None.");
             } else {
                 Iterator<String> it = current.getCharacter(name).getChildrenNames().iterator();
                 while(it.hasNext()) {
                     System.out.printf("%s", it.next());
                     if(it.hasNext())
                         System.out.print(", ");
                 }
                 System.out.println();
             }
             
             // Print Siblings
             System.out.print("Siblings: ");
             if(current.getCharacter(name).getSiblings().size() == 0) {
                 System.out.println("None.");
             } else {
                 Iterator<String> it = current.getCharacter(name).getSiblingsNames().iterator();
                 while(it.hasNext()) {
                     System.out.printf("%s", it.next());
                     if(it.hasNext())
                         System.out.print(", ");
                 }
                 System.out.println();
             }
             
             // Print Lovers
             System.out.print("Romantic relationships: ");
             if(current.getCharacter(name).getLovers().size() == 0) {
                 System.out.println("None.");
             } else {
                 Iterator<String> it = current.getCharacter(name).getLoversNames().iterator();
                 while(it.hasNext()) {
                     System.out.printf("%s", it.next());
                     if(it.hasNext())
                         System.out.print(", ");
                 }
                 System.out.println();
             }
             
             // Print events
             Map<Integer, SortedMap<Integer, List<Event>>> events = current.getEvents();
             int numseasons = events.size();
             for (int i=0; i<numseasons; i++) {
                 SortedMap<Integer, List<Event>> seasoneventlist = events.get(i+1);
                 for (int j=0; j<seasoneventlist.size(); j++) {
                     Boolean printedEpisode = false;
                     List<Event> listevents = seasoneventlist.get(j+1);
                     for (int k=0; k<listevents.size(); k++) {
                         if (listevents.get(k).getCharacters().containsKey(current.getCharacter(name).getCharacterName())) {
                             if (printedEpisode == false) {
                                 System.out.printf("S%d EP%d: %s\n",i+1,j+1,current.getEpisodeName(i+1,j+1));
                                 printedEpisode = true;
                             }
                             System.out.println(listevents.get(k).getDescription());
                         }
                     }
                 }
                 
             }
             
         }catch (NoShowSelectedException e) {
             System.out.println(MESSAGE_NO_SHOW_SELECTED);
         } catch (NoCharacterException e) {
             System.out.printf(MESSAGE_NO_CHARACTER, name);
         }
     }
     
     
     private static void alsoApearsOn(Scanner in, ShowPedia sPedia) {
		String character = in.nextLine();
		try {
			sPedia.alsoAppearsOn(character); 
			CharacterRealClass tmp = (CharacterRealClass) sPedia.getCharacter(character);
			Iterator<String> it = tmp.getActor().getShows().keySet().iterator();
			String shows[] = new String[tmp.getActor().getShows().size()];
			int i=0;
    		while(it.hasNext()) {
    		    shows[i] = it.next();
    		    i++;
    		}
    		Arrays.sort(shows);
    		for (int j=0; j<i; j++)
    		    System.out.println(shows[j]);
		}catch (NoShowSelectedException e) {
			System.out.println(MESSAGE_NO_SHOW_SELECTED);
		} catch (NoCharacterException e) {
			System.out.printf(MESSAGE_NO_CHARACTER, character);
		}catch (VirtualActorException e) {
			System.out.printf(MESSAGE_VIRTUAL_ACTOR, character);
		}
		
	}

	private static void famousQuote(Scanner in, ShowPedia sPedia){
		String quote = in.nextLine();
		try {
			sPedia.famousQuote(quote);			
			
			Iterator<String> it =sPedia.getCurrent().getQuote(quote).getCharacters().keySet().iterator();
			List<String> names = new ArrayList<>();
			while(it.hasNext()) {
			    names.add(it.next());
            }
			Collections.sort(names, new AlphabeticalComparatorClass());
            
			it = names.iterator();
			while(it.hasNext()) {
    			String name = it.next();
    			if(it.hasNext()) {
    				System.out.printf("%s, ", name);
    			}else {
    				System.out.printf("%s\n", name);
    			}
			}
		
		}catch (NoShowSelectedException e) {
    	    System.out.println(MESSAGE_NO_SHOW_SELECTED);
		}catch (UnexistingQuoteException e) {
    	    System.out.println(MESSAGE_UNEXISTING_QUOTE);
		}
	}

	private static void seasonOutline(Scanner in, ShowPedia sPedia) {
		int startSeason = in.nextInt();	
		int endSeason = in.nextInt();in.nextLine();
	
		try {
		
		if(!isValidInterval(startSeason, endSeason, sPedia.getCurrent())) {
			throw new InvalidIntervalException();
		}
		
		System.out.println(sPedia.getCurrent().getName());
		for(int i=startSeason; i<=endSeason;i++) {
		    Iterator<Episode> it = sPedia.getCurrent().getSeason(i).values().iterator();
    		int j = 0;
            while(it.hasNext()) {
            	Episode tmp = it.next();
            	j++;
            	System.out.printf("S%d EP%d: %s\n", i,j,tmp.getName());
            	Iterator<Event> itEvent = tmp.getEvents().iterator();
            	while(itEvent.hasNext()) {
            	    System.out.println(itEvent.next().getDescription());
            	}
            }
		}
		
	
     }catch (NoShowSelectedException e) {
    	    System.out.println(MESSAGE_NO_SHOW_SELECTED);
     }catch (InvalidIntervalException e) {
 	    System.out.println(MESSAGE_INVALID_INTERVAL);
     }
	}

	private static boolean isValidInterval(int startSeason, int endSeason, Show show) {
		if(endSeason>=startSeason && startSeason > 0 && show.getNrSeasons() >= endSeason)
			return true;
		return false;
	}

	private static void addQuote(Scanner in, ShowPedia sPedia) {
		int season = in.nextInt();
		int episode = in.nextInt();
		in.nextLine();
		String character = in.nextLine();
		String quote = in.nextLine();
		String showName = null;

		try {
			showName = sPedia.getCurrent().getName();
			sPedia.addQuote(season, episode, character, quote);
			System.out.println(MESSAGE_QUOTE_ADDED);
		} catch (NoShowSelectedException e) {
			System.out.println(MESSAGE_NO_SHOW_SELECTED);
		} catch (NoSeasonException e) {
			System.out.printf(MESSAGE_NO_SEASON_DETAILED, showName, season, episode);
		} catch (NoEpisodeException e) {
			System.out.printf(MESSAGE_NO_EPISODE, showName, season, episode);
		} catch (NoCharacterException e) {
			System.out.printf(MESSAGE_NO_CHARACTER, character);
		}
	}

	private static void addEvent(Scanner in, ShowPedia sPedia) {
		String description = in.nextLine();
		int season = in.nextInt();
		int episode = in.nextInt();
		int nrCharacters = in.nextInt();
		in.nextLine();
		String showName = null;
		List<String> characters = new ArrayList<String>();
		for (int i = 0; i < nrCharacters; i++) {
			characters.add(in.nextLine());
		}

		try {
			showName = sPedia.getCurrent().getName();
			sPedia.addEvent(description, season, episode, characters);
			System.out.println(MESSAGE_EVENT_ADDED);
		} catch (NoShowSelectedException e) {
			System.out.println(MESSAGE_NO_SHOW_SELECTED);
		} catch (NoSeasonException e) {
			System.out.printf(MESSAGE_NO_SEASON_DETAILED, showName, season, episode);
		} catch (NoEpisodeException e) {
			System.out.printf(MESSAGE_NO_EPISODE, showName, season, episode);
		} catch (NoCharacterException e) {
			System.out.printf(MESSAGE_NO_CHARACTER, characters);
		} catch (DuplicateCharacterException e) {
			System.out.println(MESSAGE_DUPLICATE_CHARACTER);
		}

	}

	private static void kingOfCGI(ShowPedia sPedia) {
		try {
		Company company = sPedia.kingOfCGI();
		System.out.printf("%s %d\n",company.getName(), company.getRevenue());
		}catch (NoVirtualCharactersException e) {
			System.out.println(MESSAGE_NO_VIRTUAL_CHARACTERS);
		}
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
		in.nextLine();
		
		try {
			sPedia.addCharacter(type, characterName, name, fee);

			if (type.equalsIgnoreCase("virtual")) {
				System.out.printf("%s is now part of %s. This is a virtual actor.\n", characterName,
						sPedia.getCurrent().getName());
			} else {
				System.out.printf("%s is now part of %s. This is %s role %d.\n", characterName,
						sPedia.getCurrent().getName(), name, sPedia.getActor(name).getNrCharacters());
			}

		} catch (NoShowSelectedException e) {
			System.out.println(MESSAGE_NO_SHOW_SELECTED);
		} catch (InvalidTypeException e) {
			System.out.println(MESSAGE_INVALID_TYPE);
		} catch (ExistingCharacterException e) {
			System.out.println(MESSAGE_EXISTING_CHARACTER);
		} catch (InvalidFeeException e) {
			System.out.println(MESSAGE_INVALID_FEE);
		}

	}

	private static void addEpisode(Scanner in, ShowPedia sPedia) {
		int season = in.nextInt();
		String episode = in.nextLine().trim();

		try {
			sPedia.addEpisode(season, episode);
			Show tmp = sPedia.getCurrent();
			System.out.printf("%s S%d, Ep%d: %s.\n", tmp.getName(), season, tmp.getSeason(season).size(), episode);
		} catch (NoShowSelectedException e) {
			System.out.println(MESSAGE_NO_SHOW_SELECTED);
		} catch (NoSeasonException e) {
			System.out.println(MESSAGE_NO_SEASON);
		}
	}

	private static void addSeason(Scanner in, ShowPedia sPedia) {
		try {
			sPedia.addSeason();
			currentShow(sPedia);
		} catch (NoShowSelectedException e) {
			System.out.println(MESSAGE_NO_SHOW_SELECTED);
		}
	}

	private static void switchToShow(Scanner in, ShowPedia sPedia) {
		String show = in.nextLine();
		try {
			sPedia.switchToShow(show);
			currentShow(sPedia);
		} catch (NonExistingShowException e) {
			System.out.println(MESSAGE_NON_EXISTING_SHOW);
		}
	}

	private static void addShow(Scanner in, ShowPedia sPedia) {
		String show = in.nextLine();
		try {
			sPedia.addShow(show);
			System.out.printf("%s created.\n", show);
		} catch (ExistingShowException e) {
			System.out.println(MESSAGE_EXISTING_SHOW);
		}
	}
    
    private static void addRelationship(Scanner in, ShowPedia sPedia) {
        String parent = in.nextLine();
        String child = in.nextLine();
        
        try {
            sPedia.addRelationship(parent, child);
            System.out.printf("%s has now %d kids. %s has now %d parent(s).\n", parent, sPedia.getCurrent().getCharacter(parent).getNumChildren(), child, sPedia.getCurrent().getCharacter(child).getNumParents());
        } catch (NoShowSelectedException e) {
            System.out.println(MESSAGE_NO_SHOW_SELECTED);
        } catch (SingleRelationshipException e) {
            System.out.printf(MESSAGE_DUPLICATE_PARENT, parent);
        } catch (ExistingRelationshipException e) {
            System.out.println(MESSAGE_DUPLICATE_RELATIONSHIP);
        } catch (NoCharacterException e) {
            System.out.printf(MESSAGE_NO_CHARACTER, parent);
        } catch (NoChildException e) {
            System.out.printf(MESSAGE_NO_CHARACTER, child);
        }
    }
    
    private static void addRomance(Scanner in, ShowPedia sPedia) {
        String lover1 = in.nextLine();
        String lover2 = in.nextLine();
        
        try {
            sPedia.addLovers(lover1, lover2);
            System.out.printf("%s and %s are now a couple.\n", lover1, lover2);
        } catch (NoShowSelectedException e) {
            System.out.println(MESSAGE_NO_SHOW_SELECTED);
        } catch (SingleRelationshipException e) {
            System.out.printf(MESSAGE_DUPLICATE_ROMANCE, lover1);
        } catch (ExistingRelationshipException e) {
            System.out.println(MESSAGE_DUPLICATE_RELATIONSHIP);
        } catch (NoCharacterException e) {
            System.out.printf(MESSAGE_NO_CHARACTER, lover1);
        } catch (NoChildException e) {
            System.out.printf(MESSAGE_NO_CHARACTER, lover2);
        }
    }
    
    private static void mostRomantic(Scanner in, ShowPedia sPedia) {
        String actorname = in.nextLine();
        
        try {         
            List<Actor> moresexy = sPedia.mostRomantic(actorname);
                        
            // Print everyone in order
            Iterator<Actor> it = moresexy.iterator();
            Collections.sort(moresexy, new LoversComparatorClass());
            while (it.hasNext()) {
                Actor actor = it.next();
                System.out.println(actor.getName()+" "+actor.getNrRomances());
            }
            
            // Print self
            System.out.println(actorname+" "+sPedia.getActor(actorname).getNrRomances());
        } catch (NoCharacterException e) {
            System.out.printf(MESSAGE_NO_CHARACTER, actorname);
        } catch (NoLoveException e) {
            System.out.println(MESSAGE_NO_LOVE);
        }
    }
    
	private static void compareRelations(Scanner in, ShowPedia sPedia) {
        String character1 = in.nextLine();
        String character2 = in.nextLine();

		try {
			List<String> result = sPedia.getRelation(character1, character2);
	        for (int i=0; i<result.size(); i++)
	            if (i == 0)
	                System.out.print(result.get(i)+"; ");
	            else if (!result.get(i-1).equals(result.get(i)))
	                System.out.print(result.get(i)+"; ");
	        System.out.println();
		} catch (NoShowSelectedException e) {
			System.out.println(MESSAGE_NO_SHOW_SELECTED);
		} catch (NoCharacterException e) {
            System.out.printf(MESSAGE_NO_CHARACTER, character1);
		} catch (NoChildException e) {
		    System.out.printf(MESSAGE_NO_CHARACTER, character2);
		} catch (SingleRelationshipException e) {
		    System.out.println(MESSAGE_SAME_RELATIONSHIP);
        } catch (NoRelationshipException e) {
            System.out.println(MESSAGE_NO_RELATIONSHIP);
        }
	}

}