import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow

class TelegramBotApplication

fun main() {
    ApiContextInitializer.init()
    val bot = Bot()
    TelegramBotsApi().registerBot(bot)

}

class Bot : TelegramLongPollingBot() {


    override fun getBotUsername() = "t.me/JobGazpromNeftBot"

    override fun getBotToken()  = "2037431443:AAFQ_7p6gTYgjqJU4E8P4Zo0Ozgd-5wgEo8"


    override fun onUpdateReceived(update: Update) {
        if (update.hasMessage()) {
            if (update.message.text == "/start") {
                val keyboard = ReplyKeyboardMarkup();
                keyboard.keyboard = listOf(
                    KeyboardRow().apply {
                        add(KeyboardButton("Все вакансии"))
                    },
                    KeyboardRow().apply {
                        add(KeyboardButton("фильтр по городам"))
                    },
                    KeyboardRow().apply {
                        add(KeyboardButton("фильтр по рабочему направлению"))
                    })
                execute(SendMessage().setReplyMarkup(keyboard)
                    .setText("Привет")
                    .setChatId(update.message.chatId))
            }



            if (update.message.text == "фильтр по городам") {
                execute(SendMessage()
                    .setText("Выберите город:")
                    .setChatId(update.message.chatId)
                    .setReplyMarkup(InlineKeyboardMarkup().apply {
                        keyboard = listOf(
                            listOf(
                                InlineKeyboardButton("Москва").apply { callbackData = "Moscow" },
                                InlineKeyboardButton("Ноябрьск").apply { callbackData = "Moscow" }),
                        )
                    }
                    )
                )
            }
        }
            if (update.hasCallbackQuery()){
                if (update.callbackQuery.data == "Moscow") {
                    execute(SendMessage()
                        .setText("Вакансии Москвы")
                        .setChatId(update.callbackQuery.message.chatId)
                    )}
            }
        }
}







