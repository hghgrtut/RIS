import java.util.regex.Pattern

object Main {

    fun isMyPattern(string: String) = isStringHasRegex(string = string, regex = "abcdefghijklmnopqrstuv5320736")

    fun isValidUrl(string: String): Boolean =
        if (isStringHasRegex(string = string, regex = HTTP_S_REGEXP))
            isStringHasRegex(string = string, regex = "$HTTP_S_REGEXP$URL_END_REGEXP")
        else isStringHasRegex(string = string, regex = URL_END_REGEXP)

    private fun isStringHasRegex(string: String, regex: String) = string.contains(Pattern.compile(regex).toRegex())

    private const val HTTP_S_REGEXP = "^https?:[0-9]{0,4}//"
    private const val URL_END_REGEXP = "[a-z]{2,}.[a-z(?=)#/^:]{1,}"
}