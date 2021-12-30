package com.tatvasoftpractical

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Users{
    private var page: Int? = null
    private var per_page: Int? = null
    private var total: Int? = null
    private var total_pages: Int? = null
    private var data: ArrayList<Data>? = null
    private var support: Support? = null

    fun getPage(): Int? {
        return page
    }

    fun setPage(page: Int?) {
        this.page = page
    }

    fun getPerPage(): Int? {
        return per_page
    }

    fun setPerPage(perPage: Int?) {
        this.per_page = perPage
    }

    fun getTotal(): Int? {
        return total
    }

    fun setTotal(total: Int?) {
        this.total = total
    }

    fun getTotalPages(): Int? {
        return total_pages
    }

    fun setTotalPages(totalPages: Int?) {
        this.total_pages = totalPages
    }

    fun getData(): ArrayList<Data>? {
        return data
    }

    fun setData(data: ArrayList<Data>?) {
        this.data = data
    }

    fun getSupport(): Support? {
        return support
    }

    fun setSupport(support: Support?) {
        this.support = support
    }

    data class Data( var id: Int? = null,
                     var email: String? = null,
                     var first_name: String? = null,
                     var last_name: String? = null,
                     var avatar: String? = null)

    class Support {
        var url: String? = null
        var text: String? = null
    }
}