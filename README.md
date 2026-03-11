# 🚩 Flag Guessing Game (Android) 📱

**Test your geography knowledge with this interactive flag-guessing game!**

## ✨ **Features**
- **Dynamic Flag Display**: Randomly pulls flags from an internal database (e.g., Andorra, UAE, Afghanistan).
- **Instant Feedback**: Real-time validation with visual indicators for correct/incorrect guesses.
- **Three Attempts per Flag**: Learn through trial and error—correct answers are revealed after 3 wrong guesses.
- **Modern UI**: Built with **Kotlin & Jetpack Compose** for a smooth, reactive experience.

## 🎮 **How to Play**
1. **Guess the Flag**: Type the country name for each flag shown.
2. **Submit**: Tap **Submit** to check your answers.
3. **Feedback**:
   - ✅ **Correct** → `CORRECT!` (Green)
   - ❌ **Wrong** → `WRONG!` (Red) *(3 attempts per flag)*
   - 🔵 **Revealed** → Answer shown in blue after 3 failed attempts.
4. **Next Round**: Tap **Next** to refresh the flags.

## 🛠 **Technical Details**
- **Language**: Kotlin
- **Framework**: Jetpack Compose (Declarative UI)
- **State Management**: `mutableStateOf` for real-time UI updates.
- **Flag Data**: Stored as pairs of `imageResourceID` + `countryName`.

### **Setup**
1. Open in **Android Studio (Flamingo+)**.
2. Ensure **Jetpack Compose** is configured.
3. Flag assets stored in `res/drawable`.
