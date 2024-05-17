package com.dms.messages.service

import com.dms.messages.model.Message
import com.dms.messages.repository.MessagesRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class MessageService(val repository: MessagesRepository) {
    fun getMessages() = repository.findAll()

    @Transactional
    fun saveMessage(message: Message) = repository.save(message)

    fun findByMessage(messageId: Int) = repository.findById(messageId)

    fun deleteMessage(messageId: Int) = repository.deleteById(messageId)
}