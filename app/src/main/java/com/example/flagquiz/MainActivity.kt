package com.example.flagquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import java.util.Locale

//https://youtu.be/2o_25eMKVts <-- video


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlagGuessingGameApp()
        }
    }
}

data class Flag(val drawableId: Int, val countryName: String)


// Function to choose a random flag
fun chooseRandomFlag(): Flag {
    val flagOptions = listOf(
        Flag(R.drawable.ad, "Andorra"),
        Flag(R.drawable.ae, "United Arab Emirates"),
        Flag(R.drawable.af, "Afghanistan"),
        Flag(R.drawable.ag, "Antigua and Barbuda"),
        Flag(R.drawable.ai, "Anguilla"),
        Flag(R.drawable.al, "Albania"),
        Flag(R.drawable.am, "Armenia"),
        Flag(R.drawable.ao, "Angola"),
        Flag(R.drawable.ass, "American Samoa"),
        Flag(R.drawable.at, "Austria"),
        Flag(R.drawable.aw, "Aruba"),
        Flag(R.drawable.ax, "\u00c5land Islands"),
        Flag(R.drawable.az, "Azerbaijan"),
        Flag(R.drawable.ba, "Bosnia and Herzegovina"),
        Flag(R.drawable.bb, "Barbados"),
        Flag(R.drawable.bd, "Bangladesh"),
        Flag(R.drawable.be, "Belgium"),
        Flag(R.drawable.bf, "Burkina Faso"),
        Flag(R.drawable.bg, "Bulgaria"),
        Flag(R.drawable.bh, "Bahrain"),
        Flag(R.drawable.bi, "Burundi"),
        Flag(R.drawable.bj, "Benin"),
        Flag(R.drawable.bl, "Saint Barthélemy"),
        Flag(R.drawable.bm, "Bermuda"),
        Flag(R.drawable.bn, "Brunei Darussalam"),
        Flag(R.drawable.bo, "Bolivia, Plurinational State of"),
        Flag(R.drawable.bq, "Caribbean Netherlands"),
        Flag(R.drawable.br, "Brazil"),
        Flag(R.drawable.bs, "Bahamas"),
        Flag(R.drawable.bt, "Bhutan"),
        Flag(R.drawable.bv, "Bouvet Island"),
        Flag(R.drawable.bw, "Botswana"),
        Flag(R.drawable.by, "Belarus"),
        Flag(R.drawable.bz, "Belize"),
        Flag(R.drawable.ca, "Canada"),
        Flag(R.drawable.cc, "Cocos (Keeling) Islands"),
        Flag(R.drawable.cd, "Congo, the Democratic Republic of the"),
        Flag(R.drawable.cf, "Central African Republic"),
        Flag(R.drawable.cg, "Republic of the Congo"),
        Flag(R.drawable.ch, "Switzerland"),
        Flag(R.drawable.ci, "C\u00f4te d'Ivoire"),
        Flag(R.drawable.ck, "Cook Islands"),
        Flag(R.drawable.cl, "Chile"),
        Flag(R.drawable.cm, "Cameroon"),
        Flag(R.drawable.cn, "China (People's Republic of China)"),
        Flag(R.drawable.co, "Colombia"),
        Flag(R.drawable.cr, "Costa Rica"),
        Flag(R.drawable.cu, "Cuba"),
        Flag(R.drawable.cv, "Cape Verde"),
        Flag(R.drawable.cw, "Cura\u00e7ao"),
        Flag(R.drawable.cx, "Christmas Island"),
        Flag(R.drawable.cy, "Cyprus"),
        Flag(R.drawable.cz, "Czech Republic"),
        Flag(R.drawable.de, "Germany"),
        Flag(R.drawable.dj, "Djibouti"),
        Flag(R.drawable.dk, "Denmark"),
        Flag(R.drawable.dm, "Dominica"),
        Flag(R.drawable.dr, "Dominican Republic"),
        Flag(R.drawable.dz, "Algeria"),
        Flag(R.drawable.ec, "Ecuador"),
        Flag(R.drawable.ee, "Estonia"),
        Flag(R.drawable.eg, "Egypt"),
        Flag(R.drawable.eh, "Western Sahara"),
        Flag(R.drawable.er, "Eritrea"),
        Flag(R.drawable.es, "Spain"),
        Flag(R.drawable.et, "Ethiopia"),
        Flag(R.drawable.eu, "Europe"),
        Flag(R.drawable.fi, "Finland"),
        Flag(R.drawable.fj, "Fiji"),

    )
    return flagOptions.random()
}



// Function to choose random countries for options
fun chooseRandomCountries(correctCountry: String): List<String> {
    val countries = listOf(
        "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda",
        "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas",
        "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize",
        "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil",
        "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Cambodia",
        "Cameroon", "Canada", "Central African Republic", "Chad", "Chile", "China",
        "Colombia", "Comoros", "Congo", "Costa Rica", "Croatia", "Cuba", "Cyprus",
        "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic",

    )

    val randomCountries = countries.shuffled().take(4).toMutableList()
    if (!randomCountries.contains(correctCountry)) {
        randomCountries[0] = correctCountry
    }
    return randomCountries.toList()
}

@Composable
fun FlagGuessingGameApp() {
    var showGuessHint by remember { mutableStateOf(false) }
    var showGuessTheCountry by remember { mutableStateOf(false) }
    var showGuessTheFlag by remember { mutableStateOf(false) }
    var showAdvancedLevel by remember { mutableStateOf(false) }

    if (!showGuessHint && !showGuessTheCountry && !showGuessTheFlag && !showAdvancedLevel) {
        // Main screen with options
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { showGuessTheCountry = true }) {
                Text("Guess the Country Game")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { showGuessHint = true }) {
                Text("Guess Hint Game")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { showGuessTheFlag = true }) {
                Text("Guess the Flag Game")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { showAdvancedLevel = true }) {
                Text("Advanced Level")
            }
        }
    } else if (showGuessTheCountry) {
        // Show the guess the country game screen
        GuessTheCountryScreen {
            // Reset the game state or navigate away after the game is done
            showGuessTheCountry = false
        }
    } else if (showGuessHint) {
        // Show the guess hint game screen
        GuessHintScreen {
            // Reset the game state or navigate away after the game is done
            showGuessHint = false
        }
    } else if (showGuessTheFlag) {
        // Show the guess the flag game screen
        GuessTheFlagGame {
            // Reset the game state or navigate away after the game is done
            showGuessTheFlag = false
        }
    } else if (showAdvancedLevel) {
        // Show the advanced level game screen
        AdvancedLevelGame {
            // Reset the game state or navigate away after the game is done
            showAdvancedLevel = false
        }
    }
}




@Composable
fun GuessTheCountryScreen(onStartGame: () -> Unit) {
    var flag by remember { mutableStateOf(Flag(0, "")) }
    var selectedCountry by remember { mutableStateOf<String?>(null) }
    var isCorrect by remember { mutableStateOf(false) }
    var showNextButton by remember { mutableStateOf(false) }
    var wrongAnswerGiven by remember { mutableStateOf(false) }

    // Function to generate a new flag and reset state variables
    fun generateNewFlag() {
        flag = chooseRandomFlag()
        selectedCountry = null
        isCorrect = false
        showNextButton = false
        wrongAnswerGiven = false
    }

    // Generate the flag only once when the composable is first composed
    LaunchedEffect(Unit) {
        generateNewFlag()
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display the flag image
        flag.drawableId.takeIf { it != 0 }?.let { drawableId ->
            Image(
                painter = painterResource(id = drawableId),
                contentDescription = "Random Flag",
                modifier = Modifier.size(250.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display list of country names
        Column {
            val countryOptions = chooseRandomCountries(flag.countryName).shuffled() // Shuffle the options
            countryOptions.forEach { country ->
                Button(
                    onClick = {
                        if (!showNextButton) { // Ensure selection only before showing the next button
                            selectedCountry = country
                        }
                    },
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Text(country)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Submit or Next button
        if (!showNextButton) {
            Button(
                onClick = {
                    if (selectedCountry != null) {
                        // Handle submission
                        isCorrect = selectedCountry.equals(flag.countryName, ignoreCase = true)
                        showNextButton = true // Show the next button
                        wrongAnswerGiven = !isCorrect // Set wrong answer flag if the answer is wrong
                    }
                }
            ) {
                Text("Submit")
            }
        }

        // Display correctness message
        if (wrongAnswerGiven) {
            Text(
                "WRONG!",
                color = Color.Red,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                "The correct country is ${flag.countryName}",
                color = Color.Blue,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }

        if (isCorrect) {
            Text(
                "CORRECT!",
                color = Color.Green,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }

        if (showNextButton) {
            // Next button
            Button(
                onClick = {
                    generateNewFlag() // Generate a new flag
                    showNextButton = false // Hide the next button
                }
            ) {
                Text("Next")
            }
        }
    }
}


@Composable
fun GuessHintScreen(onNextClicked: () -> Unit) {
    var flag by remember { mutableStateOf(Flag(0, "")) }
    var guessedChars by remember { mutableStateOf<List<Char?>?>(null) }
    var userInput by remember { mutableStateOf("") }
    var isCorrectGuess by remember { mutableStateOf(false) }
    var incorrectGuesses by remember { mutableStateOf(0) }
    var showNextButton by remember { mutableStateOf(false) }

    // Function to generate a new flag and reset state variables
    fun generateNewFlag() {
        flag = chooseRandomFlag()
        guessedChars = List(flag.countryName.length) { null }
        userInput = ""
        isCorrectGuess = false
        incorrectGuesses = 0
        showNextButton = false
    }

    // Generate initial flag when the screen is first shown
    LaunchedEffect(Unit) {
        generateNewFlag()
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display the flag image
        flag.drawableId.takeIf { it != 0 }?.let { drawableId ->
            Image(
                painter = painterResource(id = drawableId),
                contentDescription = "Random Flag",
                modifier = Modifier.size(250.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display the dashes representing the country name
        Text(
            text = guessedChars?.joinToString(separator = "") { it?.toString() ?: "-" } ?: "",
            style = TextStyle(fontSize = 24.sp),
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Text field for user input
        OutlinedTextField(
            value = userInput,
            onValueChange = { userInput = it },
            label = { Text("Enter a single character") },
            singleLine = true,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Button for submitting guess or going to next
        if (!showNextButton) {
            // Submit button
            Button(
                onClick = {
                    if (userInput.length == 1) {
                        val char = userInput.first().toLowerCase()
                        if (flag.countryName.toLowerCase().contains(char)) {
                            // Replace dashes with the correct character
                            guessedChars = guessedChars?.mapIndexed { index, c ->
                                if (flag.countryName[index].toLowerCase() == char) {
                                    char
                                } else {
                                    c
                                }
                            }
                            isCorrectGuess = guessedChars?.all { it != null } ?: false
                        } else {
                            isCorrectGuess = false
                            incorrectGuesses++
                        }
                        userInput = "" // Clear the input field

                        // Check if the game should proceed to the next round
                        if (isCorrectGuess || incorrectGuesses >= 3) {
                            showNextButton = true
                        }
                    }
                }
            ) {
                Text("Submit")
            }
        } else {
            // Next button
            Button(
                onClick = {
                    generateNewFlag()
                }
            ) {
                Text("Next")
            }
        }

        // Display correctness message
        if (isCorrectGuess) {
            Text(
                text = "CORRECT!",
                color = Color.Green,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        // Display message for reaching maximum incorrect attempts
        if (incorrectGuesses >= 3) {
            Text(
                text = "Incorrect!",
                color = Color.Red,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = "The correct country is ${flag.countryName}",
                color = Color.Blue,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}


@Composable
fun GuessTheFlagGame(onBackToMenu: () -> Unit) {
    var flags by remember { mutableStateOf<List<Flag>>(emptyList()) }
    var correctCountryName by remember { mutableStateOf("") }
    var showNextButton by remember { mutableStateOf(false) }
    var isCorrect by remember { mutableStateOf(false) }
    var selectedFlagIndex by remember { mutableStateOf(-1) }

    // Function to generate new flags and reset state variables
    fun generateNewFlags() {
        flags = (1..3).map { chooseRandomFlag() }
        correctCountryName = flags.random().countryName
        showNextButton = false
        isCorrect = false
        selectedFlagIndex = -1
    }

    // Generate initial flags when the screen is first shown
    LaunchedEffect(Unit) {
        generateNewFlags()
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        flags.forEachIndexed { index, flag ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Display the flag image
                Image(
                    painter = painterResource(id = flag.drawableId),
                    contentDescription = "Flag $index",
                    modifier = Modifier.size(200.dp).clickable {
                        if (!showNextButton) {
                            selectedFlagIndex = index
                            isCorrect = flag.countryName == correctCountryName
                            showNextButton = true // Show the next button
                        }
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        // Display the correct country name below one of the flag options
        Text(
            text = "Guess the country: $correctCountryName",
            style = TextStyle(fontSize = 18.sp),
            modifier = Modifier.padding(top = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Display correctness message
        if (showNextButton) {
            if (isCorrect) {
                Text(
                    "CORRECT!",
                    color = Color.Green,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            } else {
                Text(
                    "WRONG!",
                    color = Color.Red,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }

        // Next button
        if (showNextButton) {
            Button(
                onClick = {
                    generateNewFlags() // Generate new flags
                }
            ) {
                Text("Next")
            }
        }

        // Optional: Add a button to go back to the main menu
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onBackToMenu) {
            Text("Back to Menu")
        }
    }
}

@Composable
fun AdvancedLevelGame(onBackToMenu: () -> Unit) {
    var flags by remember { mutableStateOf<List<Flag>>(emptyList()) }
    var answers by remember { mutableStateOf(List(3) { "" }) }
    var showSubmitButton by remember { mutableStateOf(true) }
    var showCorrectMessage by remember { mutableStateOf(false) }
    var showWrongMessage by remember { mutableStateOf(List(3) { false }) }
    var showNextButton by remember { mutableStateOf(false) }
    var incorrectAttempts by remember { mutableStateOf(0) } // Track the number of incorrect attempts
    var correctAnswersState by remember { mutableStateOf(List(3) { false }) } // Track correct answers
    var score by remember { mutableStateOf(0) } // User's score

    // Function to generate new flags and reset state variables
    fun generateNewFlags() {
        flags = (1..3).map { chooseRandomFlag() }
        answers = List(3) { "" }
        showSubmitButton = true
        showCorrectMessage = false
        showWrongMessage = List(3) { false }
        showNextButton = false
        incorrectAttempts = 0 // Reset incorrect attempts counter
        correctAnswersState = List(3) { false } // Reset correct answers state
    }

    // Generate initial flags when the screen is first shown
    LaunchedEffect(Unit) {
        generateNewFlags()
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // User's score displayed on top right of the screen
        Text(
            text = "Score: $score",
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 16.dp)
        )

        flags.forEachIndexed { index, flag ->
            // Display the flag image
            Image(
                painter = painterResource(id = flag.drawableId),
                contentDescription = "Flag $index",
                modifier = Modifier.size(120.dp)
            )
            // Text field for user input
            OutlinedTextField(
                value = answers[index],
                onValueChange = { newAnswer ->
                    // Allow answer update only if it hasn't been marked as correct
                    if (!correctAnswersState[index]) {
                        answers = answers.toMutableList().apply { set(index, newAnswer) }
                    }
                },
                label = { Text("Enter the country name") },
                textStyle = TextStyle(
                    color = if (correctAnswersState[index]) Color.Green else Color.Black
                ),
                singleLine = true,
                readOnly = correctAnswersState[index],
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .background(
                        color = when {
                            correctAnswersState[index] -> Color.LightGray
                            showWrongMessage[index] -> Color.Red
                            else -> Color.White
                        }
                    )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Submit button
        if (showSubmitButton) {
            Button(
                onClick = {
                    // Check answers
                    var correctCount = 0
                    for (i in answers.indices) {
                        val isCorrect = answers[i].equals(flags[i].countryName, ignoreCase = true)
                        showWrongMessage = showWrongMessage.toMutableList().apply {
                            set(i, !isCorrect && answers[i].isNotBlank())
                        }
                        if (isCorrect && !correctAnswersState[i]) {
                            correctCount++
                            score++ // Increment score for each correct answer
                        }
                    }
                    if (correctCount == flags.size) {
                        showCorrectMessage = true
                        showSubmitButton = false
                        showNextButton = true
                    } else {
                        incorrectAttempts++
                        if (incorrectAttempts >= 3) {
                            // This ensures the "Next" button is shown after 3 incorrect attempts,
                            // independent of any correct answer
                            showSubmitButton = false
                            showNextButton = true
                        }
                    }

                    // Update correct answers state
                    for (i in answers.indices) {
                        correctAnswersState = correctAnswersState.toMutableList().apply {
                            set(i, answers[i].equals(flags[i].countryName, ignoreCase = true))
                        }
                    }
                },
                enabled = answers.none { it.isBlank() } && !showNextButton
            ) {
                if (incorrectAttempts >= 3) {
                    Text("Next")
                } else {
                    Text("Submit")
                }
            }
        }

        // Next button
        if (showNextButton) {
            Button(
                onClick = { generateNewFlags() },
            ) {
                Text("Next")
            }
        }

        // Display correctness message
        if (showCorrectMessage) {
            Text(
                text = "CORRECT!",
                color = Color.Green,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        } else if (incorrectAttempts >= 3) {
            Text(
                text = "WRONG!",
                color = Color.Red,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            // Display correct countries' names in blue
            flags.forEachIndexed { index, flag ->
                if (!answers[index].equals(flags[index].countryName, ignoreCase = true) && !correctAnswersState[index]) {
                    Text(
                        text = "Correct answer: ${flags[index].countryName}",
                        color = Color.Blue,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }
    }
}
































































































































































































