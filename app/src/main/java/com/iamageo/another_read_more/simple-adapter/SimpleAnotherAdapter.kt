import android.content.Context
import android.graphics.Color
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iamageo.another_read_more.R
import com.iamageo.library.AnotherReadMore
import java.util.*

internal class SimpleAnotherAdapter internal constructor(private val context: Context) :
    RecyclerView.Adapter<SimpleAnotherAdapter.ViewHolder>() {

    private val readMoreOption: AnotherReadMore = AnotherReadMore.Builder()
        .moreLabelColor(Color.RED)
        .lessLabelColor(Color.BLUE)
        .underlineVisible(false)
        .build()
    internal class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var mTextView: TextView = v.findViewById(R.id.tv)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false) as View
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position % 2 == 0) {
            readMoreOption.addReadMoreTo(
                holder.mTextView,
                Html.fromHtml(context.getString(R.string.big_text))
            )
        } else {
            readMoreOption.addReadMoreTo(
                holder.mTextView,
                Html.fromHtml(context.getString(R.string.big_text)).toString()
            )
        }
    }

    override fun getItemCount(): Int {
        return 50
    }
}