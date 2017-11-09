package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = null;
		this.currentTime = null;
		this.questions = new String [10];
		this.username = username;
		this.content = null;
		this.intro = null;
		this.currentTime = null;
		this.topics = new  String [4];
		this.verbs = new String[4];
		this.followUps = null;
		
		buildVerbs();
		buildShoppingList();
//		buildfollowUps();
		buildQuestions();
		buildShoppingList();
	}

	private void buildVerbs()
	{
		verbs[0]= " like";
		verbs[1]= " dislike";
		verbs[2]= " am ambivalent about";
		verbs[3]= " am thinking about";
	}
	public void buildMovieList()
	{
		
	}
	
	public void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
	}
	
	public void buildCuteAnimals()
	{
		
	}
	
	private void buildQuestions()
	{
		questions[0] = "What's your favorite flavor of dirt?";
		questions[1] = "On a scale of one to ten what is your favorite color in the alphabet?";
		questions[2] = "What is your favorite animal to pet?";
		questions[3] = "What is the most entertaining animal to watch?";
		questions[4] = "When is your favorite time of year?";
		questions[5] = "Is Christmas the most wonderful time of the year? Why?";
		questions[6] = "How much wood would a woodchuck chuck if a woodchuck could chuck wood?";
		questions[7] = "If Sally is selling sea shells by the sea shore, how much would each sold sea shell sell for?";
		questions[8] = "What do I have in my pocket?";
		questions[9] = "How do you get to Narnia?";
	}
	
	/**
	 * This will take what the person said and the uses it in a conversation, generating a random reply
	 * @param input  The person would say something to it.
	 * @return It will return a popup with an opinion about what they said and another question
	 */
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said:" + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	/**
	 *  This will generate a random opinion about what the person said
	 * @return returns the random opinion
	 */
	private String buildChatbotResponse()
	{
		String response = "I";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " +topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		if (random % 2 == 0)
		{
			random = (int) (Math.random() * movieList.size());
			response += "\n" + movieList.get(random).getTitle() + "Is a great movie!";
		}
		return response;
	}
	public boolean lengthChecker(String input)		//.length() > ! = null (first)
	{
		boolean validLength = false;
		if (input != null)
		{
			if (input.length() > 2)
			{
				validLength = true;
			}
		}

	return validLength;	
	}
	/*
	 * if (input != null && input.length() >2) 
	 */
	public boolean htmlTagChecker(String input)
	{
		return false;
	}
	
	public boolean userNameChecker(String input)
	{
		return false;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		
		if(username.contains("@@"))
		{
			return false;
		}
		else if(!username.contains("@"))
		{
			return false;
		}
		else if(username.isEmpty())
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		if(shoppingList.contains(shoppingItem))
		{
			return true;
		}
		else
			return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		if (exitString != (null) && exitString.equalsIgnoreCase("quit"))
		{
			return true;
		}
		return false;
	}

	public boolean keyboardMashChecker(String sample)
	{
		return false;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return null;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return null;
	}
	
	public LocalTime getCurrentTime()
	{
		return null;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
