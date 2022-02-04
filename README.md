# another-read-more-lib
📖 Another read more library.

[![](https://jitpack.io/v/iamageo/another-read-more-lib.svg)](https://jitpack.io/#iamageo/another-read-more-lib)

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	  implementation 'com.github.iamageo:another-read-more-lib:1.0.0'
	}

## How to use

### Basic example for Kotlin

<img src="https://user-images.githubusercontent.com/26925002/152575671-bea1c64f-3506-42a4-a106-8fc8460223e6.gif" align="right" width="32%"/>

```kotlin
val tv = findViewById<TextView>(R.id.mTextView)
        
val anotherReadMore: AnotherReadMore = AnotherReadMore.Builder(this)
    .textLength(100, AnotherReadMore.TYPE_LINE)
    .moreLabel("mais")
    .lessLabel("menos")
    .build()

anotherReadMore.addReadMoreTo(tv,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
```
### Example with RecyclerView
<img src="https://user-images.githubusercontent.com/26925002/152580755-c51a58b3-f488-49e6-9e43-72b0e240e9e1.gif" align="right" width="32%"/>

```kotlin
internal class SimpleAnotherAdapter internal constructor(private val context: Context) :
    RecyclerView.Adapter<SimpleAnotherAdapter.ViewHolder>() {

    private val readMoreOption: AnotherReadMore = AnotherReadMore.Builder(context)
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
        return 30
    }
}
```

## LICENSE
```xml
MIT License

Copyright (c) 2022 Geovani Amaral

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
