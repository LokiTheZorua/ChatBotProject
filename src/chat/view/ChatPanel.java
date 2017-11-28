package chat.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import chat.controller.ChatbotController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JButton checkerButton;
	private JLabel infoLabel;

	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;

		// Initialize GUI data members
		chatButton = new JButton("chat");
		checkerButton= new JButton("Check");
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(20);
		infoLabel = new  JLabel("Type to chat with the chatbot");
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
		this.add(checkerButton);
		this.add(inputField);
		this.add(chatArea);
		chatArea.setEnabled(false);
		chatArea.setEnabled(false);

	}

	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, -33, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 174, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -4, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 26, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatArea, -39, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 0, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 6, SpringLayout.EAST, inputField);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 49, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -70, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatArea);
		appLayout.putConstraint(SpringLayout.SOUTH, inputField, -30, SpringLayout.SOUTH, this);
	}

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
}
