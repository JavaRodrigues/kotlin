package PrimeiroProjeto

fun main() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    // eager, cria uma nova lista
    val eager = decorations.filter { it[0] == 'p' }
    println("eager: $eager")


    // lazy, vai esperar até ser solicitado a avaliar
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")

    val newList = filtered.toList()
    println("new list: $newList")

    val lazyMap = decorations.asSequence().map {
        println("aceess: $it")
        it
    }
    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")


    val lazyMap2 = decorations.asSequence().filter { it[0] == 'p' }.map {
        println("access: $it")
        it
    }
    println("_____")
    println("filtered: ${lazyMap2.toList()}")

    val dirtyLevel = 20
    val waterFilter = {dirty: Int -> dirty /2}
    println(waterFilter(dirtyLevel))


//O corpo do código chama a função que foi passada como o segundo argumento e passa o primeiro argumento para ela
    fun updateDirty(dirty: Int, operation: (Int) -> Int ): Int{
    return operation(dirty)
}
    println(updateDirty(30, waterFilter))

    fun increaseDirty( start: Int) = start + 1
    println(updateDirty(15, ::increaseDirty))

    var dirtyLevel = 19;
    dirtyLevel = updateDirty(dirtyLevel) { dirtyLevel -> dirtyLevel + 23}
    println(dirtyLevel)
}