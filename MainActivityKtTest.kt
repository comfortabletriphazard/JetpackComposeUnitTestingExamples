package com.threetrees.unittesting

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.*
import org.junit.Rule
import org.junit.Test

internal class MainActivityKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun randomNameChangerComposableTest() {
        // Set up the Composable with a remembered name
        composeTestRule.setContent {
            RandomNameChanger()
        }

        // Verify that the initial name ("John Doe") is displayed
        composeTestRule
            .onNode(hasText("John Doe"))
            .assertIsDisplayed()

        // Simulate a button click
        composeTestRule.onNode(hasText("Change Name")).performClick()

        // Wait for the Composable to recompose
        composeTestRule.waitForIdle()

        // Verify that the name has changed (not equal to "John Doe")
        composeTestRule
            .onNode(hasText("John Doe"))
            .assertDoesNotExist()
    }
}