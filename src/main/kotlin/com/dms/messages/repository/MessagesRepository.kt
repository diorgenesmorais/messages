package com.dms.messages.repository

import com.dms.messages.model.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MessagesRepository : JpaRepository<Message, Int> {
    override fun findAll(): List<Message>
}