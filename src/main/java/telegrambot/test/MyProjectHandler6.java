package telegrambot.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class MyProjectHandler6 extends TelegramLongPollingBot {

	public void onUpdateReceived(Update update) {
		if (update.hasMessage()) {
			Message message = update.getMessage();
			if (message.hasText()) {
				try {
                    SendMessage sendMessageRequest = new SendMessage();
                    sendMessageRequest.setChatId(message.getChatId().toString());
                    sendMessageRequest.setText("ok i seeking: " + message.getText());
					sendMessage(sendMessageRequest);
                    sendMessageRequest.setText(parser(message.getText()));
                    sendMessage(sendMessageRequest);
				} catch (TelegramApiException | IOException e1) {
                    e1.printStackTrace();
                }
			}
		}
	}

	private String parser(String seek) throws IOException {
        Elements elements = Jsoup.connect("http://bash.im/best" + seek).get().select("div.text");
        StringBuilder sb = new StringBuilder();
        for (Element element : elements) {
            if (sb.length() > 1024) break;
            sb.append(element.text());
        }
        return sb.toString();
	}

	public String getBotUsername() {
		return BotConfig.USERNAMEMYPROJECT;
	}

	@Override
	public String getBotToken() {
		return BotConfig.TOKENMYPROJECT;
	}

}
