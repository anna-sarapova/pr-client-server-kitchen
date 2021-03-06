package com.server.kitchen.models

data class Distribution (
    val order_id: Int, //
    val table_id: Int, //
    val waiter_id: Int, //
    val items: MutableList<Int>, //
    val priority: Int, //
    val max_wait: Int, //
    val pick_up_time: Long, //
) {
    var cooking_time: Long = 0
    val cooking_details: MutableList<CookingDetail> = arrayListOf()

    fun toJSON(): String {
        return """
            {
                "order_id" : $order_id,
                "table_id" : $table_id,
                "waiter_id" : $waiter_id,
                "items" : $items,
                "priority" : $priority,
                "max_wait" : $max_wait,
                "pick_up_time" : ${System.currentTimeMillis()},
                "cooking_time": ${System.currentTimeMillis()},
                "cooking_details": [${cookingDetailsToJSON()}]
            }
        """.trimIndent()
    }

    fun cookingDetailsToJSON(): String {
        val jsonList: StringBuilder = java.lang.StringBuilder()
        for(i in 0 until cooking_details.size) {
            jsonList.append("{ \"food_id\": ${cooking_details[i].food_id}, \"cook_id\": ${cooking_details[i].cook_id}}")
            if(i != cooking_details.size - 1) {
                jsonList.append(",")
            }
        }

        return jsonList.toString()
    }
}