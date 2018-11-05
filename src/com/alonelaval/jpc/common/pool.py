#-*- coding: UTF-8 -*- 
'''
Created on 2016年4月21日
 
@author: huawei
'''
from DBUtils.PooledDB import PooledDB
from pymongo.mongo_client import MongoClient
import MySQLdb
import string
import traceback
import com.alonelaval.jpc.config
     
class MyPool():
    @classmethod
    def CreateConnectionpool(cls,user,password,db_name,host,
                             dbtype,port=3306,maxconn=10,source=None):
        try:
            if dbtype=='oracle':
                import cx_Oracle
                pool = PooledDB(cx_Oracle,user = user, password =password, dsn = db_name,threaded=True,
                                mincached=maxconn,maxcached=maxconn,maxshared=maxconn,maxconnections=maxconn)
                return pool
            elif dbtype=='mysql':
            
                pool = PooledDB(MySQLdb, user=user,passwd=password,host=host,port=port,db=db_name,mincached=maxconn,maxcached=maxconn,maxshared=maxconn,maxconnections=maxconn,charset = "utf8", use_unicode = True)
                return pool
            elif dbtype=='mongo':
#                 db_conn = connstr.split("|");
                maxPoolSize=maxconn if maxconn else 100
                client = MongoClient(host, port,maxPoolSize=maxPoolSize)
                clientDB=client[db_name]
                if source is None or source =='': #不指定认证数据库，默认为使用的数据库
                    source = db_name
                  
                clientDB.authenticate(user,password,source=source)
                return clientDB
        except Exception, e:
            traceback.print_exc( )
            raise Exception,'conn datasource Excepts,!!!(%s).'%(str(e))
            return None
             
class PoolHolder():
    _pool=None
    @classmethod
    def instance(cls,config):
        if cls._pool is None:
            cls._pool=MyPool.CreateConnectionpool(config.db_user,config.db_password,config.db_name,
                                              config.db_host,config.db_type,config.db_port)
    @classmethod
    def pool(cls):
        return cls._pool
