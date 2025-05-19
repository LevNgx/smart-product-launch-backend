package com.launchpad.idea_backend.controller

import com.launchpad.idea_backend.service.MLService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/ml")
class MLController (private val mlService: MLService) {

    @PostMapping("/predict")
    fun predict(@RequestBody input : Map<String, Any>) : ResponseEntity<Any> {
        println("hit hthis")
        try{
            val result = mlService.predictSuccess(input)
            println("Result ${result}")
            return if (result != null) {
                ResponseEntity.ok(result)
            }
            else ResponseEntity.status(500).body("Internal server.")
        }
        catch (e : Exception){
            println(e)
            return ResponseEntity.status(500).body("The following Exception occurred ${e}")
        }


    }

    @PostMapping("/idea-feedback")
    fun ideaFeedback(@RequestBody input: Map<String,Any>) : ResponseEntity<Any> {
        try{
            val result = mlService.ideaFeedback(input)
            println("Result ${result}")
            return if (result != null) {
                ResponseEntity.ok(result)
            }
            else ResponseEntity.status(500).body("Internal server.")
        }
        catch (e : Exception){
            println(e)
            return ResponseEntity.status(500).body("The following Exception occurred ${e}")
        }
    }
}