package Lesson_4.sample

import javafx.fxml.FXML
import javafx.scene.control.TextArea
import javafx.scene.control.TextField

class Controller {

    @FXML
    internal var textArea: TextArea? = null

    @FXML
    internal var textField: TextField? = null

    fun sendMsg() {
        textArea!!.appendText(textField!!.text + "\n")
        textField!!.clear()
        textField!!.requestFocus()
    }
}
