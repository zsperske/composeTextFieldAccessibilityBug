# composeTextFieldAccessibilityBug

Jetpack Compose version: 1.4.2
Material Version: 1.4.2
Jetpack Compose component used: TextField
Android Studio Build: Android Studio Electric Eel | 2022.1.1 Patch 1
Kotlin version: 1.8.20

Steps to Reproduce or Code Sample to Reproduce:
1. Enable Talkback Screenreader
2. Open App
3. Try to select the first TextField, either by tapping on it or by swiping left/right to move focus around.
4. Notice that you cannot select the TextField.

I also noted some other issues:

1. When you enable "isError", a generic error message is read aloud and there is no way to change it.
2. If you use the FocusRequest to move focus to the TextField by tapping on the "Toggle Error" button, it only works the first time and does not work again after that.
