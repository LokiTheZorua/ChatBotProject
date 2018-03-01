package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;
import chat.view.ChatFrame;
import chat.model.CTECTwitter;

/**
 * Manages the Chatbot application including the model and frame of the view package
 * @author Alec Jones
 * @version 18.11.1 Added Frame 1.2
 */

public class ChatbotController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	private CTECTwitter myTwitter;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Alec Jones");
		myTwitter = new CTECTwitter(this);
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	
	public void start()
	{
		display.collectResponse("What do you want to talk about?");
		
//		while (chatbot.lengthChecker(response)  && !chatbot.quitChecker(response))
//		{
//			response = popupChat(response);
//			response =  display.collectResponse(response);
//		}
		String results = IOController.loadFromFile(this, "commonWords.txt");
		IOController.SaveToFile(this, results, "");
	}
	
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	public String useCheckers(String text)
	{
		String response = "";
		
		if(chatbot.contentChecker(text))
		{
			response += "This text matches the special Content/n";
		}
		if(chatbot.cuteAnimalMemeChecker(text))
		{
			response += "";
		}
		// need to add more checkers
		
		return response;
	}
	
	public String interactWithChatbot(String input)
	{
		String chatbotSays = "";
		
		if(chatbot.quitChecker(input))
		{
			close();
		}
		chatbotSays += chatbot.processConversation(input);
		
		return chatbotSays;
	}
	private void close()
	{
		display.displayText("Goodbye");
		System.exit(0);
	}
	public void tweet(String text)
	{
		myTwitter.sendTweet(text);
	}
	public void handleErrors(Exception error)
	{
		display.displayText(error.getMessage());
	}
	
	public String search(String text)
	{
		return myTwitter.getMostCommonWord(text);
	}
}
