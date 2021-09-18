import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow

class Button {
   val keyboard = ReplyKeyboardMarkup()

    fun startbutton (update: Update){

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


   }


}