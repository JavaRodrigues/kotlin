package Myapp

fun buildAquarium() {
    val myAquarium = Aquarium()
}

fun main() {
    buildAquarium()
}

fun printSize() {
    println("Width: $width cm " +
            "Length: $length cm " +
            "Height: $height cm ")
}
fun buildAquarium() {
    val myAquarium = Aquarium()
    myAquarium.printSize()
}

