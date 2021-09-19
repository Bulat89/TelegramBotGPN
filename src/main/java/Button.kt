import ecxelHandler.ReadExcel
import org.apache.poi.ss.usermodel.Cell
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow


class Button {
    val keyboard = ReplyKeyboardMarkup()
    val ReadExcel = ReadExcel()

    private var finalListCities : MutableList<MutableList<InlineKeyboardButton>> = mutableListOf()
    private var list: MutableList<InlineKeyboardButton> = mutableListOf()
    private var AllCities: MutableList<String> = mutableListOf()
    private var allCities: HashSet<String> = hashSetOf()
    private var iter = 1


    fun startButton(update: Update) {

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

    fun CreateButtonCities(): List<List<InlineKeyboardButton>> {

        allCities = ReadExcel.getCites()
        AllCities.addAll(allCities)
        allCities.clear()

            val iterline = (AllCities.size/4) - 3
            for ( i in 1..iterline ) {

                finalListCities.add(
                    mutableListOf(
                        lineCities(),
                        lineCities(),
                        lineCities(),
                        lineCities(),
                    )
                )
            }
        return finalListCities
    }


    fun lineCities() : InlineKeyboardButton {

            val  d = (InlineKeyboardButton("${AllCities[iter]}").apply { callbackData = "${AllCities[iter]}" })
            iter++
        return d
    }

}