package ru.netology.nmedia.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import ru.netology.nmedia.entity.PostEntity

interface PostRepository : JpaRepository<PostEntity, Long> {
    @Modifying
    @Query("UPDATE PostEntity p SET p.likes = p.likes + 1 WHERE p.id = :id")
    fun likeById(@Param("id") id: Long)

    @Modifying
    @Query("UPDATE PostEntity p SET p.likes = p.likes - 1 WHERE p.id = :id")
    fun unlikeById(@Param("id") id: Long)
}