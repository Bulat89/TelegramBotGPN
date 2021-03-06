import ecxelHandler.ReadExcel
import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton



fun main() {
    ApiContextInitializer.init()
    val bot = Bot()
    TelegramBotsApi().registerBot(bot)

}

class Bot : TelegramLongPollingBot() {

    override fun getBotUsername() = "t.me/JobGazpromNeftBot"
    override fun getBotToken()  = "2037431443:AAFQ_7p6gTYgjqJU4E8P4Zo0Ozgd-5wgEo8"
    val button = Button()



    override fun onUpdateReceived(update: Update) {

        if (update.hasMessage()) {
            startMenu(update)
            findToSitys(update)
        }


        if (update.hasCallbackQuery()){
            if (update.callbackQuery.data == "Moscow") {
                    execute(SendMessage()
                        .setText("Вакансии москвы")
                        .setChatId(update.callbackQuery.message.chatId)
                        .setReplyMarkup(InlineKeyboardMarkup().apply {
                            keyboard = listOf(
                                listOf(
                                    InlineKeyboardButton("Москва").apply { callbackData = "Moscow" },
                                    InlineKeyboardButton("Москва1").apply { callbackData = "Moscow1" },
                                ),
                            )
                        }
                        )
                    )

                }
            }
        }




    fun startMenu(update : Update){

        if (update.message.text == "/start") {
            button.startButton(update)
            execute(SendMessage().setReplyMarkup(button.keyboard)
                .setText("Все показаные вакансии являются внутреними")
                .setChatId(update.message.chatId))
        }
    }

    fun findToSitys (update : Update){
        if (update.message.text == "фильтр по городам") {
            execute(SendMessage()
                .setText("Выберите город:")
                .setChatId(update.message.chatId)
                .setReplyMarkup(
                    InlineKeyboardMarkup().apply { keyboard = button.CreateButtonCities()}
                )

            )

        }
    }

    fun findToSity (update : Update){
        if (update.message.text == "x") {

        }
    }



}







