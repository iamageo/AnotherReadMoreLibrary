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

```kotlin
val tv = findViewById<TextView>(R.id.mTextView)
        
val anotherReadMore: AnotherReadMore = AnotherReadMore.Builder(this)
    .textLength(100, AnotherReadMore.TYPE_LINE)
    .moreLabel("mais")
    .lessLabel("menos")
    .build()

anotherReadMore.addReadMoreTo(tv,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
```
