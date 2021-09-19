package ecxelHandler

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.WorkbookFactory
import java.io.FileInputStream
import java.util.stream.Collectors

class ReadExcel {
    private var allCities: HashSet<String> = hashSetOf()

    val input = FileInputStream("src/main/resources/career_portal_vacancys_1631528968.xls")
    val xLWd = WorkbookFactory.create(input)
    val Xlws = xLWd.getSheetAt(0)

    fun getCites(): HashSet<String> {
        getCitiesFromExcel()
        return allCities

    }

    fun getCitiesFromExcel() {
        var summCities = 0
        for (R: Row in Xlws) {
            summCities = R.rowNum
        }
        for (i in 1..summCities) {
                allCities.add((Xlws.getRow(i).getCell(3).toString()))
        }

    }
}


