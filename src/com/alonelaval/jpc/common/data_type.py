# -*- encoding: utf-8 -*-
'''
Created on 2018年7月31日

@author: huawei
'''

mysql_java_types={
             "date":"java.time.LocalDate",
             "datetime":"java.time.LocalDateTime",
             "timestamp":"java.sql.Timestamp",
             "int":"Integer",
             "char":"String",
             "bit":"Byte",
             "tinyint":"Byte",
             "mediumint":"Integer",
             "text":"String",
             "bigint":"java.math.BigInteger",
             "float":"Float",
             "double":"Double",
             "decimal":"java.math.BigDecimal",
             "id":"Long",
             "year":"java.time.LocalDate",
             "enum":"java.io.Serializable",
             "varchar":"String",
             "binary":"Byte []",
             "blob":"Byte []",
             "integer":"Integer",
             "smallint":"Short",
             "longtext":"String",
             "time":"java.time.LocalTime"
             }


def data_type_match(data_type):
    return mysql_java_types[str(data_type)]

