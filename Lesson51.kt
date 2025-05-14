package com.example.group234

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val state = remember { mutableStateOf(true)}
            val (selectedOption, onOptionSelected) = remember { mutableStateOf("r1") }
            val variants = remember { mutableListOf(
                "Клавиатура",
                "Мышь",
                "Системный блок",
                "Монитор"
            ) }
            val (selectedVariant, onVariantSelected) = remember { mutableStateOf(variants[0]) }
            val variants2 = remember { mutableListOf(
                "Minecraft",
                "Grand Thief Auto",
                "Final Fantasy",
                "Call of Duty"
            ) }
            val (selectedVariant2, onVariantSelected2) = remember { mutableStateOf(variants2[0]) }
            val quizVariants = listOf(
                Quiz("Красный", 0),
                Quiz("Жёлтый", 0),
                Quiz("Зеленый", 1)
            )
            val (selectedQuizVariants, onQuizVariantsSelected) = remember {
                mutableStateOf(quizVariants[0])
            }
            val score = remember { mutableStateOf(0) }
            Column (modifier = Modifier
                .verticalScroll(ScrollState(0))) {
                Text(text = "Выбор из 2-х пунктов с использованием true/false")
                Column (modifier = Modifier
                    .selectableGroup()
                ) {
                    Row (verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = state.value,
                            onClick = {state.value = state.value.not()}
                        )
                        Text(text = "Вариант 1")
                    }
                    Row (verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = !state.value,
                            onClick = {state.value = state.value.not()}
                        )
                        Text(text = "Вариант 2")
                    }
                }
                Text(text = "Выбор из 3-х пунктов с изменяемого значения (строка)")
                Column (modifier = Modifier
                    .selectableGroup()
                ) {
                    Row (verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = (selectedOption == "r1"),
                            onClick = { onOptionSelected("r1") }
                        )
                        Text(text = "Опция 1")
                    }
                    Row (verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = (selectedOption == "r2"),
                            onClick = { onOptionSelected("r2") }
                        )
                        Text(text = "Опция 2")
                    }
                    Row (verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = (selectedOption == "r3"),
                            onClick = { onOptionSelected("r3") }
                        )
                        Text(text = "Опция 3")
                    }
                }
                Text(text = "Выбор из 4-х пунктов с использованием списка и .forEach")
                Column (modifier = Modifier
                    .selectableGroup()
                ) {
                    variants.forEach{variant ->
                        Row (verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = (variant == selectedVariant),
                                onClick = { onVariantSelected(variant) }
                            )
                            Text(text = variant)
                        }
                    }
                }
                Text(text = "Выбор варианта при нажатии всей строки")
                Column (modifier = Modifier
                    .selectableGroup()
                ) {
                    variants2.forEach{ variant ->
                        Row (verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .selectable(
                                    selected = (variant == selectedVariant2),
                                    onClick = { onVariantSelected2(variant) }
                                )
                                .fillMaxWidth(1f)
                        ) {
                            RadioButton(
                                selected = (variant == selectedVariant2),
                                onClick = { onVariantSelected2(variant) }
                            )
                            Text(text = variant)
                        }
                    }

                }
                Text(text = "Выбор варианта с data-классом")
                Column (modifier = Modifier
                    .selectableGroup()
                ) {
                    quizVariants.forEach { quizVariant ->
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .selectable(
                                    selected = (quizVariant.name == selectedQuizVariants.name),
                                    onClick = { onQuizVariantsSelected(quizVariant) }
                                )
                        ) {
                            RadioButton(
                                selected = (quizVariant.name == selectedQuizVariants.name),
                                onClick = { onQuizVariantsSelected(quizVariant) }
                            )
                            Text(text = quizVariant.name)
                        }
                    }
                    Button(onClick = {score.value += selectedQuizVariants.score}) { Text(text = "Следующий вопрос ${score.value}") }
                }
            }
        }
    }
}

data class Quiz(val name: String, val score: Int)
