package xyz.stasiak.kochbuch.ui.recipedetails

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class TimeVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return TransformedText(
            AnnotatedString(formatTextFields(text.text)),
            object : OffsetMapping {
                override fun originalToTransformed(offset: Int): Int {
                    return if (text.isEmpty()) {
                        2
                    } else if (text.length == 1) {
                        if (offset == 0) 1 else 2
                    } else {
                        offset
                    }
                }

                override fun transformedToOriginal(offset: Int): Int {
                    return if (text.isEmpty()) {
                        0
                    } else if (text.length == 1) {
                        if (offset == 2) 1 else 0
                    } else {
                        offset
                    }
                }
            }
        )
    }

    private fun formatTextFields(value: String): String {
        val intValue = value.toIntOrNull() ?: 0
        return if (intValue >= 10)
            value
        else if (intValue > 0)
            "0$value"
        else
            "00"
    }
}
