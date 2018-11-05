#-*- coding: UTF-8 -*- 
'''
Created on 2016年7月25日
 
@author: huawei
'''
from com.alonelaval.jpc.common.pool import PoolHolder

class Connection():
    def __init__(self):
        self.pool=PoolHolder.pool()
    def get_conn(self):
        return self.pool.connection()
     
    def getData(self,sql):
        self.debug( sql)
        conn = self.get_conn()
        cursor = conn.cursor()
        cursor.execute(sql)
        result = cursor.fetchall()
        for k in result:
            yield k
        cursor.close()
        conn.close()
     
    def debug(self,sql):
        if False:
            print sql
             
    def executeSql(self,sql):
        self.debug( sql)
        conn = self.get_conn()
        cursor = conn.cursor()
        count = cursor.execute(sql)
        cursor.close()
        conn.commit()
        conn.close()
        return count
     
    def getCount(self,sql):
        self.debug( sql)
        conn = self.get_conn()
        cursor = conn.cursor()
        cursor.execute(sql)
        result = cursor.fetchone()
        cursor.close()
        conn.close()
        return result[0]
     
    def getOneData(self,sql):
        self.debug(sql)
        conn = self.get_conn()
        cursor = conn.cursor()
        cursor.execute(sql)
        result = cursor.fetchone()
        cursor.close()
        conn.close()
        return result
    
    def showTables(self,sql="SHOW TABLES"):
        self.debug( sql)
        conn = self.get_conn()
        cursor = conn.cursor()
        cursor.execute(sql)
        result = cursor.fetchall()
        for k in result:
            yield k
        cursor.close()
        conn.close()
    
if __name__ == '__main__':
    conn = Connection();
    
    for data in conn.getData("select * from tb_invest_malicious"):
        print data
    
    for data in conn.showTables("show tables"):
        print data   
        
    for column_info in conn.getData("desc tb_test"):
        print column_info
        
        
        
        
        
        
        
        