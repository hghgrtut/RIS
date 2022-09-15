import org.junit.jupiter.api.Assertions.*
internal class MainTest {

    @org.junit.jupiter.api.Test
    fun isMyPatternCorrect() = assertTrue(Main.isMyPattern("abcdefghijklmnopqrstuv5320736."))

    @org.junit.jupiter.api.Test
    fun isMyPatternInvalid() = assertFalse(Main.isMyPattern("abcdefghijklmnoasdfasdpqrstuv5320736"))

    @org.junit.jupiter.api.Test
    fun isUrlCorrect() {
        assertTrue(Main.isValidUrl("http://www.example.com"))
        assertTrue(Main.isValidUrl("http://example.com"))
    }

    @org.junit.jupiter.api.Test
    fun isUrlInvalid() {
        assertFalse(Main.isValidUrl("Just Text"))
        assertFalse(Main.isValidUrl("http://a.com"))
    }
}

