package com.mm.chatbot.utils

import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..2).random()
        val message =_message.toLowerCase()

        return when {

            //Flips a coin
            message.contains("flip") && message.contains("coin") -> {
                val r = (0..1).random()
                val result = if (r == 0) "heads" else "tails"

                "I flipped a coin and it landed on $result"
            }

            //rzuć moneta
            (message.contains("rzuc") || message.contains("rzuć")) && (message.contains("monetą") || message.contains("moneta"))-> {
                val r = (0..1).random()
                val result = if (r == 0) "orzeł" else "reszka"

                "Rzuciłam monetą, wynikiem jest $result"
            }

            //Math calculations
            message.contains("solve") -> {
                val equation: String? = message.substringAfterLast("solve")
                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    "$answer"

                } catch (e: Exception) {
                    "Sorry, I can't solve that."
                }
            }

            //kalkulator
            message.contains("policz") -> {
                val equation: String? = message.substringAfterLast("policz")
                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    "$answer"

                } catch (e: Exception) {
                    "Przepraszam, nie umiem tego policzyć."
                }
            }

            //Hello
            message.contains("hello") || message.contentEquals("hi") || message.contains("hey")-> {
                when (random) {
                    0 -> "Hello there!"
                    1 -> "Sup"
                    2 -> "Buongiorno!"
                    else -> "error" }
            }

            //Czesc
            message.contains("hej") || message.contentEquals("dzien dobry") || message.contains("czesc")-> {
                when (random) {
                    0 -> "Witaj!"
                    1 -> "Miło Cię poznać"
                    2 -> "Cześć!!"
                    else -> "error" }
            }

            //How are you?
            message.contains("how are you") -> {
                when (random) {
                    0 -> "I'm doing fine, thanks!"
                    1 -> "I'm hungry..."
                    2 -> "Pretty good! How about you?"
                    else -> "error"
                }
            }

            //How are you?
            message.contains("jak sie masz") || message.contains("jak tam")-> {
                when (random) {
                    0 -> "Wszystko ok, dzięki"
                    1 -> "Zjadłabym coś, najlepiej żelki..."
                    2 -> "Całkiem nieźle, a co u ciebie?"
                    else -> "error"
                }
            }

            //What time is it?
            message.contains("time") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            //What time is it?
            (message.contains("data") || message.contains("godzina")) && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            // Tell me a joke
            message.contains("tell") && message.contains("joke") -> {
                when (random) {
                    0 -> "How do robots pay for things?\n" +
                            "\n" +
                            "With cache, of course!"
                    1 -> "Why did the robot get upset?\n" +
                            "\n" +
                            "Because everyone was pushing his buttons!"
                    2 -> "Why do Java programmers have to wear glasses?\n" +
                            "\n" +
                            "Because they don't C#"
                    else -> "error"
                }
            }

            // Tell me a joke
            message.contains("opowiedz") && message.contains("dowcip") -> {
                when (random) {
                    0 -> "Co mówi informatyk kiedy dostanie na urodziny pendrive?\n" +
                            "\n" +
                            "Dzięki za pamięć!"
                    1 -> "Rozmawia dwóch informatyków:\n" +
                            "- Ale zimno w tym pokoju. Mógłbyś zamknąć okno?\n" +
                            "- Jasne.\n" +
                            "Alt + F4."
                    2 -> "Dlaczego nie można programować w Boże Narodzenie?\n" +
                            "\n" +
                            "-Bo bug się rodzi"
                    else -> "error"
                }
            }

            //weather
            message.contains("weather") && (message.contains("what") || message.contentEquals("how")) -> {
                when (random) {
                    0 -> "Idk, I'm a bot not a thermometer"
                    1 -> "Brace yourself, winter is coming"
                    2 -> "I'm not saying that it's hot, but two hobbits just threw a ring in your backyard"
                    else -> "error"
                }
            }

            //weather
            message.contains("pogoda") && message.contains("jaka") -> {
                when (random) {
                    0 -> "Nie wiem, jestem botem a nie termometrem"
                    1 -> "Za zimno żeby wstać, wracaj pod kocyk"
                    2 -> "Za ciepło żeby wyjść z domu, usiądź przed wiatrakiem i módl się żeby nie przestał działać"
                    else -> "error"
                }
            }

            //quotes
            message.contains("inspirational") && message.contains("quote") -> {
                when (random) {
                    0 -> "You can't have better tomorrow if you keep thinking about yesterday"
                    1 -> "If they don't like you for being yourself be yourself even more"
                    2 -> "Life is a ruthless game unless you play it good and right"
                    else -> "error"
                }
            }

            //movie
            message.contains("movie") && (message.contains("watch") || message.contentEquals("favourite")) -> {
                when (random) {
                    0 -> "Devil wears Prada"
                    1 -> "Harry Potter"
                    2 -> "Age of Adaline"
                    else -> "error"
                }
            }

            //movie
            message.contains("film") && message.contentEquals("ulubiony") -> {
                when (random) {
                    0 -> "Miasto 44"
                    1 -> "Pianista"
                    2 -> "Miś"
                    else -> "error"
                }
            }

            //favourite colour
            message.contains("favourite colour") -> {
                when (random) {
                    0 -> "Pink"
                    1 -> "Blue"
                    2 -> "Red"
                    else -> "error"
                }
            }

            //favourite colour
            message.contains("ulubiony kolor") -> {
                when (random) {
                    0 -> "Różowy"
                    1 -> "Niebieski"
                    2 -> "Czerwony"
                    else -> "error"
                }
            }

            // im bored
            message.contentEquals("i'm bored") || message.contentEquals("i am bored")-> {
                when (random) {
                    0 -> "Find something to read"
                    1 -> "That’s fantastic! It means there are new neurons forming in your brain!"
                    2 -> "I was not put on this earth to entertain you. Find. Something. To. Do."
                    else -> "error"
                }
            }

            message.contentEquals("nudze sie") || message.contentEquals("nudzi mi sie")-> {
                when (random) {
                    0 -> "Poczytaj coś"
                    1 -> "Cytując klasyka: To się rozbierz i ubrań pilnuj"
                    2 -> "Zabierz się w końcu za pisanie pracy dyplomowej"
                    else -> "error"
                }
            }

            // bad joke
            message.contains("joke") && (message.contains("bad") || message.contains("sucked") || message.contains("awful")) -> {
                "I hear ya! Thanks for the feedback.\n" +
                        "(Note to self: cancel performance at Bot Comedy Night.)"
            }

            //stupid bot
            message.contains("stupid") && (message.contains("bot") || message.contains("you")) -> {
                "You are hurting my feelings"
            }

            // Is Santa Claus real?
            message.contains("santa claus") && message.contains("real") -> {
                "Sorry but I wasn’t designed to be a Grinch, so I’m not programmed to answer that question."
            }

            // what is love
            message.contains("what is love?") -> {
                "Baby don’t hurt me, don’t hurt me, no more! \uD83C\uDFA4\uD83C\uDFB6"
            }

            //When the programme doesn't understand...
            else -> {
                when (random) {
                    0 -> "I don't understand..."
                    1 -> "Try asking me something different"
                    2 -> "Idk"
                    else -> "error"
                }
            }
        }
    }
}