package com.example.myapp

data class Likes(
    val can_see_profile: Boolean,
    val likes_received_count: Int,
    val profiles: List<Profile>
)