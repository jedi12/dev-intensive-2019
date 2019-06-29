package ru.skillbranch.devintensive.utils

val symbolMap = mapOf(
    "а" to "a",
    "б" to "b",
    "в" to "v",
    "г" to "g",
    "д" to "d",
    "е" to "e",
    "ё" to "e",
    "ж" to "zh",
    "з" to "z",
    "и" to "i",
    "й" to "i",
    "к" to "k",
    "л" to "l",
    "м" to "m",
    "н" to "n",
    "о" to "o",
    "п" to "p",
    "р" to "r",
    "с" to "s",
    "т" to "t",
    "у" to "u",
    "ф" to "f",
    "х" to "h",
    "ц" to "c",
    "ч" to "ch",
    "ш" to "sh",
    "щ" to "sh",
    "ъ" to "",
    "ы" to "i",
    "ь" to "",
    "э" to "e",
    "ю" to "yu",
    "я" to "ya")

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.trim()?.split(" ")

        return when (parts?.size) {
            1 -> if (parts[0].isNotEmpty()) parts.getOrNull(0) to null else null to null
            2 -> parts.getOrNull(0) to parts.getOrNull(1)
            else -> null to null
        }
    }

    fun transliteration(payload: String, divider: String = " "): String {
        return buildString {
            for (char in payload) {
                when {
                    char == ' ' -> append(divider)
                    char.isUpperCase() -> append(symbolMap[char.toLowerCase().toString()]?.toUpperCase() ?: char)
                    else -> append(symbolMap[char.toString()] ?: char)
                }
            }
        }
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val first: String = (firstName?.trim()?.firstOrNull() ?: "").toString()
        val last: String = (lastName?.trim()?.firstOrNull() ?: "").toString()

        if (first == "" && last == "") return null
        return "$first$last".toUpperCase()
    }
}