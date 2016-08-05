package telegrambot.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class MyProjectHandler6 extends TelegramLongPollingBot {

	private char[] arrChars;

	public void onUpdateReceived(Update update) {
		if (update.hasMessage()) {
			Message message = update.getMessage();
			if (message.hasText()) {
				SendMessage sendMessageRequest = new SendMessage();
				SendMessage sendMessageRequestClient = new SendMessage();
				sendMessageRequest.setChatId(message.getChatId().toString());
				sendMessageRequestClient.setChatId(message.getChatId().toString());
				sendMessageRequest.setText("ok i seeking: " + message.getText());
				try {
					sendMessage(sendMessageRequest);
				} catch (TelegramApiException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sendMessageRequestClient.setText(toStringElements(parser(message.getText())));
//				sendMessageRequestClient.setText(parserTitle(message.getText()));

				try {
					sendMessage(sendMessageRequestClient);
				} catch (TelegramApiException e) {
					// do some error handling
				}
			}
		}
	}

	public String toStringElements(Elements text) {
		String s = text.first().text();
		arrChars = null;
		for (int i = 0; i < 50; i++) {
			arrChars[i] = s.charAt(i);
		}
		String s1 = new String(arrChars, 0, 20);
		return s;
	}

	public Elements parser(String seek) {
		Elements text = null;
		Document doc;
		try {
			doc = (Document) Jsoup.connect("http://bash.im/best" + seek).get();
			for (Element element : doc.select("div.text")) {
				System.out.println(element.text());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;
	}

	public String parserTitle(String seek){
		String text = null;
		Document doc;
		try {
			doc = (Document) Jsoup.connect("http://bash.im/best" + seek).get();
			text = doc.title();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;
	}
	
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return BotConfig.USERNAMEMYPROJECT;
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return BotConfig.TOKENMYPROJECT;
	}

}
