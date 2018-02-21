package chat.view;

import javax.swing.*;
//import javax.swing.JPanel;
//import javax.swing.JButton;
//import javax.swing.JTextField;
//import javax.swing.JTextArea;
//import javax.swing.SpringLayout;
import chat.controller.ChatbotController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.JLabel;
//import javax.swing.JScrollPane;

public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JButton checkerButton;
	private JLabel infoLabel;
	private JScrollPane chatScrollPane;
	private JButton loadButton;
	private JButton saveButton;
	private JButton tweetButton;
	private JButton searchButton;
	
/**
 * 
 * This formats everything that is put into the Frame
 * @param appController
 */
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;

		// Initialize GUI data members
		chatButton = new JButton("chat");
		checkerButton= new JButton("Check");
		chatArea = new JTextArea();
		inputField = new JTextField(20);
		infoLabel = new  JLabel("Type to chat with the chatbot");
		appLayout = new SpringLayout();
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 4, SpringLayout.SOUTH, inputField);
		appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -30, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 49, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -70, SpringLayout.EAST, this);
		chatScrollPane= new JScrollPane();
		appLayout.putConstraint(SpringLayout.SOUTH, chatScrollPane, -200, SpringLayout.SOUTH, this);
		loadButton = new JButton("load", new ImageIcon(getClass().getResource("/chat/view/images/load.png")));
		appLayout.putConstraint(SpringLayout.SOUTH, loadButton, 0, SpringLayout.SOUTH, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, loadButton, -17, SpringLayout.WEST, chatButton);
		saveButton = new JButton("save", new ImageIcon(getClass().getResource("/chat/view/images/save.png")));
		tweetButton = new JButton("tweet", new ImageIcon(getClass().getResource("/chat/view/images/tweet.png")));
		searchButton = new JButton("search", new ImageIcon(getClass().getResource("/chat/view/images/search.png")));
		
		
		
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
/**
 * this is what builds the panel
 */
	private void setupPanel()
	{
		this.setBackground(Color.BLUE);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(checkerButton);
		this.add(inputField);
		this.add(chatScrollPane);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		this.add(loadButton);
		this.add(saveButton);
		this.add(tweetButton);
		this.add(searchButton);

	}
/**
 * 
 *   sets the locations of all the item in the frame.
 */
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -27, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 174, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 49, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -70, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 26, SpringLayout.NORTH, this);

	}
/**
 * this will setup the listeners that will work on Chat Frame/ Panel
 */
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
		checkerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText= inputField.getText();
				String displayText= appController.useCheckers(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
	}
/**
 * This makes the scrolling text pane
 */
	private void setupScrollPane()
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}
}
