import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
suspend fun main(): Unit = coroutineScope{
    println("Программа покупки продуктов")
    delay(1000L)
    print("Купить товар:\n1.Да\n2.Нет\n")
    val buy = readln()
    when(buy){
        "1" -> buyProduct().join()
        "2" -> cancelProduct().join()
        else -> throw Exception("Ошибка: такой опции нет!")
    }
    bie().join()
    println("\nНачало программы")
    val numbers = launch {
        var i = 0
        while (i < 4) {
            delay(1000L)
            println (++i)
        }
    }
    val lazyCor = launch(start = CoroutineStart.LAZY) {
        delay(2300L)
        println("Произошел ленивый запуск")
    }
    val finishCor = launch(start = CoroutineStart.LAZY) {
        delay(4300L)
        println("Произошел ленивый запуск")
    }
    lazyCor.start()
    finishCor.start()
    numbers.join()
}

suspend fun buyProduct() = coroutineScope{
    launch{
        println("Оплата продукта началась")
        delay(2000L)
        println("Сканирование и обработка...")
        delay(2000L)
        println("Покупка оплачена.")
    }
}
suspend fun cancelProduct() = coroutineScope{
    launch{
        println("Отмена покупки...")
        delay(2000L)
        println("Покупка отменена.")
    }
}
suspend fun bie() = coroutineScope{
    launch{
        delay(500L)
        println("До свидания")
    }
}