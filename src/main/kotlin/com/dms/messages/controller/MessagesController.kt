package com.dms.messages.controller

import com.dms.messages.model.Message
import com.dms.messages.service.MessageService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/messages")
@RestController
class MessagesController(private val messageService: MessageService) {

    @GetMapping
    fun listMessages(): List<Message> = messageService.getMessages()

    @PostMapping
    fun post(@RequestBody message: Message): ResponseEntity<Message> {
        return ResponseEntity.status(HttpStatus.CREATED).body(messageService.saveMessage(message))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Message> {
        val existengMessage = messageService.findByMessage(id)
        return if (existengMessage.isPresent) {
            messageService.deleteMessage(id)
            ResponseEntity(HttpStatus.NO_CONTENT)
        } else {
            ResponseEntity.notFound().build()
        }
    }
}