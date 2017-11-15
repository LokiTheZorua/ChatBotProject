package chat.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import chat.controller.ChatbotController;
import java.awt.Color;


public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController= appController;
		
		//Initialize GUI data members
		chatButton = new JButton("chat");
		chatArea = new JTextArea(10,25);
		inputField = new JTextField(20);
		appLayout = new SpringLayout();
		
		
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.BLUE);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatArea);
		chatArea.setEnabled(false);
		chatArea.setEnabled(false);
		
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, -201, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, 0, SpringLayout.EAST, chatButton);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 227, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 227, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 49, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 0, SpringLayout.WEST, inputField);
		appLayout.putConstraint(SpringLayout.SOUTH, chatArea, -22, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 6, SpringLayout.EAST, inputField);
		
	}
	
	private void setupListeners()
	{
		
		
	}
}
