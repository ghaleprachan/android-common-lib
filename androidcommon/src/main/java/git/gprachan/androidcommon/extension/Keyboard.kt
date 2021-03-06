package git.gprachan.androidcommon.extension

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * Hide keyboard*/
fun Activity.hideKeyboard() {
    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager?
    var view = currentFocus
    if (view == null) {
        view = View(this)
    }
    imm?.hideSoftInputFromWindow(view.windowToken, 0)
}