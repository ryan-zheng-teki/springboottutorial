package com.qiusuo.data

/**
 * Define a table. The table contains the column names and values
 * of the columns
 */
class Table(var name: String) {
    private var columnNames = ArrayList<String>()
    private var columnValues = ArrayList<String>()
    fun addColumn(columnName: String, columnValue: String) {
        columnNames.add(columnName)
        columnValues.add(columnValue)
    }

    fun getColumn(columnName: String): String {
        val columnIndex = columnNames.indexOf(columnName)
        return columnValues.get(columnIndex)
    }
}