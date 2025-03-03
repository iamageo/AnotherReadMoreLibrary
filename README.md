![banner_lib](https://user-images.githubusercontent.com/26925002/152582154-45f53428-5048-4b04-9297-e769a49ea4ec.png)

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=19"><img alt="API" src="https://img.shields.io/badge/API-19%2B-brightgreen.svg?style=flat"/></a>
  <img alt="repo size" src="https://img.shields.io/github/repo-size/iamageo/AnotherReadMoreLibrary"/>
  <br/>


  <br/>
    <img alt="forks" src="https://img.shields.io/github/forks/iamageo/AnotherReadMoreLibrary?style=social"/>
    <img alt="stars" src="https://img.shields.io/github/stars/iamageo/AnotherReadMoreLibrary?style=social"/>
</p>

[![Android CI](https://github.com/iamageo/AnotherReadMoreLibrary/actions/workflows/android_ci.yml/badge.svg)](https://github.com/iamageo/AnotherReadMoreLibrary/actions/workflows/android_ci.yml)


## 🏁 Including in your project 
[![](https://jitpack.io/v/iamageo/AnotherReadMoreLibrary.svg)](https://jitpack.io/#iamageo/AnotherReadMoreLibrary)

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	  implementation 'com.github.iamageo:another-read-more-lib:1.0.3'
	}

## 🛠 Library Attributes 
Attributes | Type | Default | Description
--- | --- | --- | ---
textLength | Int | 0 | Minimal text to show labels. 
textLengthType | Int TYPE_LINE(1) or TYPE_CHARACTER(2) | 0 | Indicates whether text trimming should be done by number of characters or by number of lines. 
moreLabel | String | none | text of more label. 
lessLabel | String | none | text of less label.
moreLabelColor | Int | Color.BLACK | Color from moreLabel.
lessLabelColor | Int | Color.BLACK | Color from lessLabel.
underlineVisible | Boolean | true | Show/hide underline in more and less labels.

### ✨ Basic example for Kotlin 

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

    private val anotherReadMore: AnotherReadMore = AnotherReadMore.Builder(context)
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
            anotherReadMore.addReadMoreTo(
                holder.mTextView,
                Html.fromHtml(context.getString(R.string.big_text))
            )
        } else {
            anotherReadMore.addReadMoreTo(
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

## License
```


    Copyright 2022 Geovani Amaral

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

```
