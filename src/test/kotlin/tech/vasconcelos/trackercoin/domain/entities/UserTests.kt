package tech.vasconcelos.trackercoin.domain.entities

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDateTime

class UserTests {


    @Test
    fun `create_WithValidInput_ShouldCreateUserSuccessfully`() {
        // Arrange
        val name = "John Doe"
        val email = "john.doe@example.com"

        // Act
        val user = User.create(name, email)

        // Assert
        assertNotNull(user)
        assertNotNull(user.id)
        assertEquals(name, user.name)
        assertEquals(email, user.email)
    }

    @Test
    fun `create_ShouldSetCreatedDateToCurrentDateTime`() {
        // Arrange
        val before = LocalDateTime.now()

        // Act
        val user = User.create("John Doe", "john.doe@example.com")

        // Assert
        assertTrue(user.createdDate.isAfter(before) || user.createdDate.isEqual(before))
        assertTrue(user.createdDate.isBefore(LocalDateTime.now()) || user.createdDate.isEqual(LocalDateTime.now()))
    }

    @Test
    fun `create_WithInvalidEmail_ShouldThrowIllegalArgumentException`() {
        // Arrange
        val name = "John Doe"
        val invalidEmail = "invalid-email"

        // Act & Assert
        val exception = assertThrows<IllegalArgumentException> {
            User.create(name, invalidEmail)
        }
        assertTrue(exception.message?.contains("Invalid email") == true)
    }
}