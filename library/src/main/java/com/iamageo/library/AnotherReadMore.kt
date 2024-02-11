package com.iamageo.library

import android.animation.LayoutTransition
import android.content.Context
import android.graphics.Color
import android.os.Handler
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.TextView

class AnotherReadMore(
    private val textLength: Int = 0,
    private val textLengthType: Int = 0,
    private val moreLabel: String? = null,
    private val lessLabel: String? = null,
    private val moreLabelColor: Int,
    private val lessLabelColor: Int,
    private val underlineVisible: Boolean,
) {

    private constructor(builder: Builder) : this(
        builder.textLength,
        builder.textLengthType,
        builder.moreLabel,
        builder.lessLabel,
        builder.moreLabelColor,
        builder.lessLabelColor,
        builder.underlineVisible
    )

    fun addReadMoreTo(textView: TextView, text: CharSequence) {
        if (textLengthType == TYPE_CHARACTER) {
            if (text.length <= textLength) {
                textView.text = text
                return
            }
        } else {
            textView.setLines(textLength)
            textView.text = text
        }
        textView.post(Runnable {
            var textLengthNew = textLength
            if (textLengthType == TYPE_LINE) {
                if (textView.layout.lineCount <= textLength) {
                    textView.text = text
                    return@Runnable
                }
                val lp = textView.layoutParams as MarginLayoutParams
                val endLine = (textLength - 1).coerceAtMost(textView.layout.lineCount - 1);
                val subString = text.toString().substring(
                    textView.layout.getLineStart(0),
                    textView.layout.getLineEnd(endLine)
                )
                textLengthNew = subString.length - (moreLabel!!.length + 4 + lp.rightMargin / 6)
            }
            val spannableStringBuilder = SpannableStringBuilder(text.subSequence(0, textLengthNew))
                .append("...")
                .append(moreLabel)
            val ss = SpannableString.valueOf(spannableStringBuilder)

            val clickableSpan: ClickableSpan = CustomClickableSpan { addReadLess(textView, text) }

            ss.setSpan(
                clickableSpan,
                ss.length - moreLabel!!.length,
                ss.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            ss.setSpan(
                ForegroundColorSpan(moreLabelColor),
                ss.length - moreLabel.length,
                ss.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            if (underlineVisible) {
                ss.setSpan(
                    UnderlineSpan(),
                    ss.length - moreLabel.length,
                    ss.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }

            val layoutTransition = LayoutTransition()
            layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
            (textView.parent as ViewGroup).layoutTransition = layoutTransition
            textView.text = ss
            textView.movementMethod = LinkMovementMethod.getInstance()
        })
    }

    private fun addReadLess(textView: TextView, text: CharSequence) {
        textView.maxLines = Int.MAX_VALUE
        val spannableStringBuilder = SpannableStringBuilder(text)
            .append("...")
            .append(lessLabel)
        val ss = SpannableString.valueOf(spannableStringBuilder)

        val clickableSpan: ClickableSpan = CustomClickableSpan { Handler().post { addReadMoreTo(textView, text) } }

        ss.setSpan(
            clickableSpan,
            ss.length - lessLabel!!.length,
            ss.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        ss.setSpan(
            ForegroundColorSpan(lessLabelColor),
            ss.length - lessLabel.length,
            ss.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        if (underlineVisible) {
            ss.setSpan(
                UnderlineSpan(),
                ss.length - lessLabel.length,
                ss.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

        textView.text = ss
        textView.movementMethod = LinkMovementMethod.getInstance()
    }

    class Builder() {

        var textLength = 100
            private set
        var textLengthType = TYPE_CHARACTER
            private set
        var moreLabel = "mais"
            private set
        var lessLabel = "menos"
            private set
        var moreLabelColor: Int = Color.BLACK
            private set
        var lessLabelColor: Int = Color.BLACK
            private set
        var underlineVisible: Boolean = true
            private set

        fun textLengthType(type: Int) = apply { textLengthType = type }
        fun moreLabel(more: String) = apply { moreLabel = more }
        fun lessLabel(less: String) = apply { lessLabel = less }
        fun moreLabelColor(color: Int) = apply { moreLabelColor = color }
        fun lessLabelColor(color: Int) = apply { lessLabelColor = color }
        fun underlineVisible(visible: Boolean) = apply { underlineVisible = visible }

        fun build() = AnotherReadMore(this)
    }

    companion object {
        const val TYPE_LINE = 1
        const val TYPE_CHARACTER = 2
    }

}