package git.gprachan.androidcommon.extension

import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior

fun BottomSheetBehavior<View>.expanded() {
    state = BottomSheetBehavior.STATE_EXPANDED
}

fun BottomSheetBehavior<View>.collapsed() {
    state = BottomSheetBehavior.STATE_COLLAPSED
}

fun BottomSheetBehavior<View>.hidden() {
    state = BottomSheetBehavior.STATE_HIDDEN
}