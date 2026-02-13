package class22

open class Email( //open permite que una clase pueda ser extendida 
    val subject: String,
    private val password: String,
    protected var isEncripted: Boolean = false
){

    fun send(encrypt: Boolean): String{
        if(encrypt){
            encrypt()
        }
        return "Email enviado"
    }

    private fun encrypt(){
        isEncripted = true
        println("El correo esta encryptado")
    }

}
                 //se pasan parametros como siempre,:Email operación de extensión 
class SecureEmail(subject: String, password: String): Email(subject,password, true){ //invocamos al constructor Email

    private fun verifyIsEncrypted(){
        if(!isEncripted){
            throw SecurityException("Mail not encrypted")
        }
    }
    fun showHashingAlgorithm(): String {
        return "SHA1"
    }
}



fun main(){

    val email = Email("asunto", "1234")
    val secureEmail = SecureEmail("Asunto 2", "56789")

    secureEmail.showHashingAlgorithm()


    println("\n=== EJERCICIO ===")
    println("Crea clase 'BankAccount' con:")
    println("1. balance (private)")
    println("2. deposit() (public)")
    println("3. validateAmount() (private)")

    val account = BankAccount(100.0)
    println(account.deposit(50.0))
    println("Balance: ${account.getBalance()}")

}

interface Forma{
    val area: Float
    fun pintar()
}

class BankAccount(private var balance: Double) {

    fun deposit(amount: Double): String {
        return if (validateAmount(amount)) {
            balance += amount
            "Depósito exitoso. Balance: $balance"
        } else {
            "Cantidad inválida"
        }
    }

    private fun validateAmount(amount: Double): Boolean {
        return amount > 0
    }

    fun getBalance(): Double = balance
}

/*
open class Email(
    val subject: String,
    private val password: String // Nadie fuera de Email lo ve
) {
    protected var isEncrypted: Boolean = false // El hijo SI puede verlo y cambiarlo

    // Función pública: El punto de entrada
    fun send() {
        prepareEmail()
        println("Enviando '$subject'. Encriptado: $isEncrypted")
    }

    // protected: El hijo puede decidir CÓMO preparar el email
    protected open fun prepareEmail() {
        println("Preparación básica de email.")
    }

    // private: Solo Email sabe cómo se hace el cifrado base
    private fun applyBaseEncryption() {
        isEncrypted = true
    }
    
    // Método para que el hijo pueda ejecutar el cifrado privado indirectamente
    protected fun activateEncryption() {
        applyBaseEncryption()
    }
}

class SecureEmail(subject: String, password: String) : Email(subject, password) {

    // Sobrescribimos el comportamiento del padre
    override fun prepareEmail() {
        println("Aplicando protocolos de alta seguridad...")
        activateEncryption() // Usamos el método protegido del padre
    }

    fun showAlgorithm() = "AES-256"
}

*/