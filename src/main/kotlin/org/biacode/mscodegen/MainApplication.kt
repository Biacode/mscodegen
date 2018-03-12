package org.biacode.mscodegen

import org.apache.commons.text.StrSubstitutor
import org.biacode.mscodegen.util.FileLoadUtils
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * Created by Arthur Asatryan.
 * Date: 3/12/18
 * Time: 12:20 PM
 */

fun main(args: Array<String>) {
    // TODO: All of this will be replaced with dynamic bindings from properties or environment variables
    val fileContent = FileLoadUtils.loadFileSource(FileLoadUtils.getResourcePath("domain.ms"))
    val substitutionMap = mapOf(
            "project.base.package" to "org.biacode.mscodegen",
            "class.package.name" to "user",
            "class.name" to "User",
            "user.first_name" to "Arthur",
            "user.last_name" to "Asatryan",
            "class.created.date" to LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM uuuu", Locale.US)),
            "class.created.time" to LocalDateTime.now().format(DateTimeFormatter.ofPattern("H:M:ss", Locale.US))
    )
    val generationResult = StrSubstitutor(substitutionMap).replace(fileContent)
    println("*************** TEMPLATE ***************")
    println(fileContent)
    println("*************** OUTPUT ***************")
    println(generationResult)
}