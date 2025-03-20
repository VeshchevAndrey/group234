@Composable
fun Base(){
    val color = remember { mutableStateOf(Color(0xFF6650a4)) }
    val shape = remember { mutableStateOf(RoundedCornerShape(20.dp)) }
    val border = remember { mutableStateOf(BorderStroke(0.dp, Color.Black)) }
    Column {
        Button(onClick = { 
            if (color.value == Color(0xFF6650a4)){
                color.value = Color(0xFF3D5AFE)
            }
            else {
                color.value = Color(0xFF6650a4)
            }
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = color.value
            ),
            shape = shape.value,
            border = border.value
        ) { Text(text = "Нажми - цвет поменяется!") }
        Button(onClick = {shape.value = RoundedCornerShape(0.dp) },
            colors = ButtonDefaults.buttonColors(
                containerColor = color.value
            ),
            shape = shape.value,
            border = border.value
        ) { Text(text = "Нажми - форма поменяется!") }
        Button(onClick = {border.value = BorderStroke(2.dp, Color.Black)},
            colors = ButtonDefaults.buttonColors(
                containerColor = color.value
            ),
            shape = shape.value,
            border = border.value
        ) { Text(text = "Нажми - рамка появится!") }
    }
}

@Preview(showBackground = true)
@Composable
fun TestUIPreview(){
    Base()
}
