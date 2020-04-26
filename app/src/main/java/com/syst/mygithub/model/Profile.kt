package com.syst.mygithub.model

open class Profile(
    var name: String,
    var login: String,
    var public_repos : Int,
    var public_gists : Int,
    var followers: Int,
    var following: Int,
    var created_at : String,
    var updated_at : String,
    var avatar_url: String,
    var html_url: String


) {
    override fun toString(): String {
        return "Profile(name='$name', public_repos=$public_repos, public_gists=$public_gists, followers=$followers, following=$following, avatar_url='$avatar_url', html_url='$html_url')"
    }
}