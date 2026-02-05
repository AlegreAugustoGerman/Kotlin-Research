package clase4

fun main(){

    //Kotlin tiene inferencia de tipos de datos el sabe si es int o string

    val nombreUsuario ="Juan"  // define una variable inmutable; su valor no puede cambiar una vez asignado.
    println("nombreUsuario")

    var nombreUsuario2 ="Carlos"  // permite cambiar el valor de la variable después de su declaración, es decir, es mutable.
    var enamilNoLeidos=5

    nombreUsuario2="pablo"  //reasigno


    println("Usuario: $nombreUsuario2, Emails:$enamilNoLeidos")
    val totoaEmail:Int=150
    val totoaEmail2:Long=15000000

    val porcentaje: Float=75.5f
    val porcentaje2:Double=150.2

    val asunto: String ="Reunión"
    val esUrgente: Boolean=true

    //conversión entre tipos de datos
    val numero=42
    val comoTexto=numero.toString()
    val textoNumero="25".toInt()

    println(comoTexto)
    println(textoNumero)

    //calcular porcentajes
    val leidos=15
    val totales=20

    val procentajeEmail= leidos.toFloat()/totales
    println(procentajeEmail)

    val procentajeEmail2= leidos/totales
    println(procentajeEmail2)

    val nombre="maria"
    val recibidos=15
    val enviados=20

    val porcentajeEnviados = (enviados.toFloat() / (recibidos+enviados))*100
    println("$nombre - Enviados:${porcentajeEnviados}%")
}