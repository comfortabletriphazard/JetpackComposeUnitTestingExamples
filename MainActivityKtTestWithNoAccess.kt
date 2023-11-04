package com.threetrees.unittesting

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.*
import org.junit.Rule
import org.junit.Test

internal class MainActivityKtTestWithNoAccess {

    class RandomNameChangerTest {
        @get:Rule
        val composeTestRule = createComposeRule()

        @Test
        fun randomNameChangerComposableTest() {
            // Set up the Composable directly within the test - the code goes below rather than called from another class you can typically access
            composeTestRule.setContent {
                // Composable content goes here
                val names = listOf("John Doe", "Jane Smith", "Alice Johnson")
                var currentName by remember { mutableStateOf(names.first()) }

                // Replace this with your RandomNameChanger Composable content
                // Example content:
                Column {
                    Text(text = currentName)
                    Button(
                        onClick = {
                            currentName = names.random()
                        }
                    ) {
                        Text("Change Name")
                    }
                }
            }

            // Verify that the initial name ("John Doe") is displayed
            composeTestRule
                .onNode(hasText("John Doe"))
                .assertIsDisplayed()

            // Simulate a button click
            composeTestRule.onNode(hasText("Change Name")).performClick()

//            Thread.sleep(4000)
            // Verify that the name has changed (not equal to "John Doe")
            composeTestRule
                .onNode(hasText("John Doe"))
                .assertDoesNotExist()
        }
    }
}
