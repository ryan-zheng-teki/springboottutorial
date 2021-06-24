package com.qiusuo.schema

class DatabaseSchemaGeneratorFactory(val dialect: String) {
    fun getDatabaseSchemaGenerator(): DatabaseSchemaGenerator? {
        return null;
    }
}