//@Composable
//fun TestUI(){
//    Box (modifier = Modifier
//        .background(Color.Gray)
//    ) {
//        Row(modifier = Modifier
//            .size(400.dp, 200.dp)
//            .padding(5.dp)
//            .offset(10.dp, 20.dp)
//            .background(Color.LightGray)
//            .offset(10.dp, 20.dp)
//            .padding(10.dp)
//
//        ) {
//            Column (modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 0.dp)) {
//                Text(text = "Привет", modifier = Modifier.background(Color.Red))
//                Text(text = "Привет")
//                Text(text = "Привет")
//            }
//            Column(modifier = Modifier.background(Color.Green)) {
//                Text(text = "Android")
//                Text(text = "Android", modifier = Modifier
//                    .background(Color.Blue)
//                )
//                Text(text = "Android")
//            }
//            Column (modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)) {
//                Text(text = "Kotlin")
//                Text(text = "Kotlin")
//                Text(text = "Jetpack Compose", modifier = Modifier.background(Color.Yellow))
//            }
//            TestImage()
//        }
//    }
//}

//@Composable
//fun TestImage(){
//    Image(
//        painter = painterResource(id = R.drawable.pinguin),
//        contentDescription = "Пингвин",
//        modifier = Modifier.size(50.dp)
//    )
//}
//
//@Composable
//fun UserCard(){
//    Row (
//        modifier = Modifier
////            .offset(0.dp, 30.dp)
//            .size(400.dp, 100.dp)
//            .background(Color.Blue)
//            .offset (0.dp, 0.dp ),
//        verticalAlignment = Alignment.CenterVertically
//    ){
//        TestImage()
//        Text(text = "Главная", fontSize = 27.sp)
//    }
//}
//@Composable
//fun TestSize(padd: PaddingValues){
//    Text(text = "Идейные соображения высшего порядка, а также реализация намеченных " +
//            "плановых заданий влечет за собой процесс внедрения и модернизации форм " +
//            "развития. С другой стороны постоянное информационно-пропагандистское " +
//            "обеспечение нашей деятельности играет важную роль в формировании позиций, " +
//            "занимаемых участниками в отношении поставленных задач. Равным образом " +
//            "новая модель организационной деятельности представляет собой интересный " +
//            "эксперимент проверки существенных финансовых и административных условий.",
//        fontSize = 45.sp, modifier = Modifier
//            .padding(padd)
//            .background(Color.Yellow)
////        .height(30.dp)
////        .width(200.dp)
//        .fillMaxHeight(0.5f)
////        .fillMaxWidth()
////        .fillMaxSize(0.6f)
////        .widthIn(50.dp, 150.dp)
////        .heightIn(50.dp, 150.dp)
////        .sizeIn(50.dp, 50.dp, 150.dp, 150.dp)
//        .verticalScroll(rememberScrollState())
//
//    )
//}

//@Composable
//fun TestRow() {
//    Row(modifier = Modifier
//        .background(Color.LightGray)
//        .fillMaxHeight(0.1f)
//        .fillMaxWidth(1f),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceAround
//    ) {
//        Text("Сообщения", Modifier
//            .background(Color.Gray, RoundedCornerShape(10.dp))
//            .fillMaxHeight(0.5f)
//            .width(110.dp)
//            .wrapContentHeight(),
//            textAlign = TextAlign.Center
//
//        )
//        Text("Уведомления", Modifier
//            .background(Color.Gray, RoundedCornerShape(10.dp))
//            .fillMaxHeight(0.5f)
//            .width(110.dp)
//            .wrapContentHeight(),
//            textAlign = TextAlign.Center
//        )
//        Text("Спам", Modifier
//            .background(Color.Gray, RoundedCornerShape(10.dp))
//            .fillMaxHeight(0.5f)
//            .width(110.dp)
//            .wrapContentHeight(),
//            textAlign = TextAlign.Center
//        )
//    }
//}

@Composable
fun ButtonText(text: String, textBut: MutableState<String>){
    val count = remember{ mutableStateOf(0) }
    val defCol = remember { mutableStateOf(Color(0xFF3F51B5)) }
        Text(text = "$text: ${count.value}", Modifier
            .background(defCol.value, RoundedCornerShape(10.dp))
            .fillMaxHeight(0.5f)
            .width(110.dp)
            .wrapContentHeight()
            .clickable(onClick = {
                count.value++
                textBut.value = "Вы нажали на кнопку $text!"
                if (defCol.value == Color(0xFF3F51B5)) {
                    defCol.value = Color(0xFF010F59)
                }
                else{
                    defCol.value = Color(0xFF3F51B5)
                }
            }),
            textAlign = TextAlign.Center,
            color = Color(0xFFFFFFFF),
            fontFamily = FontFamily.SansSerif
        )
}

@Composable
fun TestRow(pad: PaddingValues){
    val textButton = remember { mutableStateOf("Пока ничего не нажато!") }
    Column {
        Row(modifier = Modifier
            .padding(pad)
            .background(Color.LightGray)
            .fillMaxHeight(0.1f)
            .fillMaxWidth(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ){
            ButtonText("Сообщения", textButton)
            ButtonText("Уведомления", textButton)
            ButtonText("Спам", textButton)
        }
        Text(text = textButton.value)
    }
}

// МОДИФИКАТОРЫ
// .background() - изменяет задний фон элемента. Принимает 2 аргумента:
// color - цвет заднего фона
// shape - форма закрашенного заднего фона
// .padding() - устанавливает отступы от объекта. Можно указать значение для любой из 4-х сторон
// .offset - сдвиг элемента.
//
// Размеры
// .size - указывает размер элемента в .dp
// .height() - указывает высоту элемента в .dp
// .width()  - указывает ширину элемента в .dp
// .fillMaxHeight() - Растянуть объект по всей высоте контейнера
// .fillMaxWidth() - Растянуть объект по всей ширине контейнера
// .fillMaxSize()  - Растянуть объект на весь контейнер
// .widthIn(50.dp, 150.dp) - ограничение размера элемента по ширине
// .heightIn(50.dp, 150.dp) - ограничение размера элемента по высоте
// .sizeIn(50.dp, 50.dp, 150.dp, 150.dp) - ограничение размера элемента по ширине и высоте
//
// Прокрутка
// .verticalScroll(rememberScrollState()) - создание вертикальной прокрутки содержимого элемента
// .horizontalScroll(rememberScrollState()) - создание горизонтальной прокрутки прокрутки содержимого элемента
