fun main(args: Array<String>) {
    println("Ввведите число философов:")
    try {
        val n = readln().toInt() // количество философов
        val forks = Array(n) { true } // создание вилок (true - вилка свободна)
        val philosophersOrder = (0 until n).toList().toIntArray()
        // случайный порядок философов
        philosophersOrder.shuffle()

        var j = 0 // счетчик философов

        while (j < n) {
            val i = philosophersOrder[j]

            // философ пытается взять вилки
            val leftFork = i
            val rightFork = (i + 1) % n
            var hasFork = false

            val randomFork = ((Math.random() * 2).toInt() + i) % n
            if (forks[randomFork]) {
                if (randomFork == leftFork) {
                    println("Философ $i взял левую вилку")
                } else if (randomFork == rightFork) {
                    println("Философ $i взял правую вилку")
                }
                forks[randomFork] = false
                hasFork = true
            } else {
                // вилка занята
                if (randomFork == leftFork) {
                    println("Философ $i не смог взять левую вилку")
                    if (forks[rightFork]) {
                        hasFork = true
                        forks[rightFork] = false // взятие правой вилки
                        println("Философ $i берет правую вилку")

                    }
                } else {
                    println("Философ $i не смог взять правую вилку")
                    if (forks[leftFork]) {
                        hasFork = true
                        forks[rightFork] = false // взятие левой вилки
                        println("Философ $i берет левую вилку")

                    }
                }
            }

            if (hasFork) {
                // философ ест
                println("Философ $i ест")
            } else {
                println("Философ $i размышляет")
            }
            j++
        }

        println("Обед окончен")
    }
    catch (e: NumberFormatException) {
        println("Ойй, неправильный формат..")
    }
}