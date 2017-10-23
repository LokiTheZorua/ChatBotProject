package chat.controller;

import chat.view.PopupDisplay;

public class ChatRunner
{
	public static void main(String [] args)
	{
		PopupDisplay test = new PopupDisplay();
		test.displayText("Words go here");
		test.collectResponse("ask a question");
	}
}
