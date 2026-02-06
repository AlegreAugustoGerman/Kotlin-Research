package clase17

enum class EmailFolders{
    INBOX,
    SENT,
    DRAFT,
    ARCHIVE,
    SPAM
}

enum class EmailPriority(val level: Int, val color:String){
    LOW(1,"gris"),
    NORMAL(2,"azul"),
    HIGH(3,"naranja"),
    URGENT(4,"rojo")
}

fun prioridadIntAEmailPriority(entero:Int): EmailPriority?{
    return if (entero in 0 until EmailPriority.entries.size)
        EmailPriority.entries.get(entero)
    else
        null
}

fun main(){

    println("========")
    println("Selecciona carpeta")
    println("1. Bandeja de entrada")
    println("2. Borradores")
    println("3. Archivados")
    println("4. Spam")
    val valorCarpeta  = readLine()?.trim()?.toInt()?:0

    var carpetaActual = EmailFolders.entries.get(valorCarpeta)

    when(carpetaActual){
        EmailFolders.INBOX -> {
            println("Bienvenido a Bandeja de entrada")
        }
        EmailFolders.SENT -> {
            println("Bienvenido a Enviados")
        }
        EmailFolders.DRAFT -> {
            println("Bienvenido a Borradores")
        }
        EmailFolders.ARCHIVE -> {
            println("Bienvenido a Archivados")
        }
        EmailFolders.SPAM -> {
            println("Bienvenido a Spam")
        }
    }
    val prioridadEmail=prioridadIntAEmailPriority(0)
    println("La prioridad de ${prioridadEmail?.name} es ${prioridadEmail?.level} con color ${prioridadEmail?.color}")

    println("\n=== EJERCICIO ===")
    println("Crea enum 'EstadoEmail' con: NUEVO, LEIDO, RESPONDIDO")
    println("1. Agrega propiedad 'icono' a cada estado")
    println("2. Crea función para convertir int a EstadoEmail")
    println("3. Muestra todos con índice e icono")

    EstadoEmail.entries.forEachIndexed { index, estado ->
        println("[$index] $estado ${estado.icono}")
    }
}
fun intToEstado(index: Int): EstadoEmail? {
    return if (index in 0 until EstadoEmail.entries.size) {
        EstadoEmail.entries[index]
    } else null
}
enum class EstadoEmail(val icono: String) {
    NUEVO("icono_mensaje"),
    LEIDO("icono_leido"),
    RESPONDIDO("↩icono_respondido")
}