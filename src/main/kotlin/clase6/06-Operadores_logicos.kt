package clase6

fun main(){
    val emailRecibidos=15
    val emailsEnviados=10
    val limiteEmails=29

//>) y menor que (<

    val tieneEmails= emailRecibidos > 16  // tieneEmails=false
    val excedeEnviados= emailsEnviados >= limiteEmails

    println("Tiene emails?${tieneEmails}")
    println("Alcanzamos el limite de emails enviados ? ${excedeEnviados}")

    val sonIguales =emailRecibidos == emailsEnviados
    println("son iguales:$sonIguales ")

    val sonDiferentes = emailRecibidos !=emailsEnviados
    println("Son diferentes?:$sonDiferentes")

    // contains es increible ahorra mucho
    val email="user@example.com"
    val password="1234"
    val tieneArroba= email.contains(other="@")
    val tienePunto=email.contains(other=".")
    val esEmailValido=tieneArroba && tienePunto

    println("Contiene los carateres solicitados $esEmailValido")

    //  idea de busqueda y pedir que cambie el password
    val passwordCorto= password.length < 8
    val passwordLargo= password.length > 12

    val passwordProblematico= passwordCorto || passwordLargo
    println("contraseña problematica? $passwordProblematico")


    val emailInvalido =!esEmailValido // !TRUE = FALSE      FALSE=TRUE
    print ("Es un email invalido $emailInvalido")
}