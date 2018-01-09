package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;

public class ChatFrame extends JFrame 
{
	private ChatbotController appController;
	private ChatPanel appPanel;
/**
 * 	runs the frame for the app
 * @param appController
 */
	public ChatFrame(ChatbotController appController)
	{
		super();
		this.appController = appController;
		appPanel = new ChatPanel(appController);
		setupFrame();
	}
	
	public void getBaseController()
	{
		baseController = appController;
	}
	/**
	 * Constructor for the frame
	 */
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("Chatting with the Chatbot");
		this.setResizable(false);
		this.setSize(600, 600);
		this.setVisible(true);
	}
	
}
