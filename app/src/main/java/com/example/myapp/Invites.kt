package com.example.myapp

data class Invites(
    val pending_invitations_count: Int,
    val profiles: List<ProfileX>,
    val totalPages: Int
)