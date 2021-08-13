package com.example.framework

import com.example.adapter.ConsoleInterface

fun main() {
    val consoleInterface = ConsoleInterface()

    println("Please input your name: ")
    val name = readLine()!!

    println("Please input your date of birth (YYYY-MM-DD): ")
    val dob = readLine()!!

    println("Please input your loan amount: ")
    val loanAmount = readLine()!!

    println("\n=== Applying Loan ===")
    Thread.sleep(3_000)
    val result = consoleInterface.submit(name, dob, loanAmount)

    println("\n\nResult: $result")
}
