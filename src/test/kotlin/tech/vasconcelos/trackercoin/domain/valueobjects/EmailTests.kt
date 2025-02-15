import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import tech.vasconcelos.trackercoin.domain.exceptions.EmailInvalidException
import tech.vasconcelos.trackercoin.domain.valueobjects.Email

class EmailTests {

    @Test
    fun `create_WithValidEmail_ShouldCreateEmailSuccessfully`() {
        val validEmail = "user@example.com"
        val email = Email.create(validEmail)
        assertNotNull(email)
        assertEquals(validEmail, email.address)
    }

    @Test
    fun `create_WithInvalidEmail_ShouldThrowEmailInvalidException`() {
        val invalidEmail = "invalid-email"
        val exception = assertThrows<EmailInvalidException> {
            Email.create(invalidEmail)
        }
        assertEquals("The email 'invalid-email' is invalid", exception.message)
    }

    @Test
    fun `isValid_WithValidEmail_ShouldReturnTrue`() {
        val validEmail = "user@example.com"
        assertTrue(Email.isValid(validEmail))
    }

    @Test
    fun `isValid_WithInvalidEmail_ShouldReturnFalse`() {
        val invalidEmail = "invalid-email"
        assertFalse(Email.isValid(invalidEmail))
    }

    @Test
    fun `create_WithEmptyEmail_ShouldThrowEmailInvalidException`() {
        val emptyEmail = ""
        assertThrows<EmailInvalidException> {
            Email.create(emptyEmail)
        }
    }


}
