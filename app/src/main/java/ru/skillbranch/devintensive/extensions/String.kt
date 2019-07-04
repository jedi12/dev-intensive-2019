package ru.skillbranch.devintensive.extensions

val htmlTagRegex = """<.*?>""".toRegex()
val moreTwoSpacesRegex = """\s{2,}""".toRegex()

fun String.truncate(len: Int = 16): String {
    val result = this.trim()
    return if (result.length <= len + 1) result else "${result.take(len + 1).trimEnd()}..."
}

fun String.stripHtml(): String {
    val result = htmlTagRegex.replace(this, "")
    return moreTwoSpacesRegex.replace(result, " ")
}