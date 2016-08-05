package telegrambot.test;

import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.logging.BotLogger;

public class Main {

	private static final String LOGTAG = null;

	public static void main(String[] args) {

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
//            telegramBotsApi.registerBot(new MyProjectHandler());
//            telegramBotsApi.registerBot(new MyProjectHandler2());
//            telegramBotsApi.registerBot(new MyProjectHandler3());
//            telegramBotsApi.registerBot(new MyProjectHandler4());
//            telegramBotsApi.registerBot(new MyProjectHandler5());
            telegramBotsApi.registerBot(new MyProjectHandler6());



        } catch (TelegramApiException e) {
            BotLogger.error(LOGTAG, e);
        }//end catch()
    }//end main()

}
