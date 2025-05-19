package com.launchpad.idea_backend.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.*
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.exchange
import javax.print.attribute.standard.Media

@Service
class MLService (private val restTemplate : RestTemplate) {
    @Value("\${ml.api.base-url}") private lateinit var mlBaseUrl: String

    fun predictSuccess(input: Map<String, Any>) : Map<String, Any>?  {
        val url = "$mlBaseUrl/predict-success"

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON

        val request = HttpEntity(input, headers)

        val response = restTemplate.exchange(url, HttpMethod.POST ,request, object: ParameterizedTypeReference<Map<String,Any>>() {})

        return if(response.statusCode == HttpStatus.OK){
            response.body as Map<String, Any>
        } else null;
    }

    fun ideaFeedback(input : Map<String, Any>) : String? {
        val url = "$mlBaseUrl/idea-feedback"

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON

        val request = HttpEntity(input, headers)

        val response = restTemplate.exchange(url, HttpMethod.POST, request, String::class.java)

        return if (response.statusCode == HttpStatus.OK){
            response.body
        }
        else {
            null
        }
    }


}