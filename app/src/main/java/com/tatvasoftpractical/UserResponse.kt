package com.tatvasoftpractical

data class UserResponse(
        private var page: Int? = null,
        private var per_page: Int? = null,
        private var total: Int? = null,
        var total_pages: Int? = null,
        var data: ArrayList<Data>? = null,
//        private var support: Users.Support? = null
)

data class Data( var id: Int? = 0,
                 var email: String? = null,
                 var first_name: String? = null,
                 var last_name: String? = null,
                 var avatar: String? = null)