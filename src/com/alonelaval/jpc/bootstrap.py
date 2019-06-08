# -*- encoding: utf-8 -*-
'''
Created on 2018年9月3日

@author: huawei
'''
import yaml

import os

import sys
from com.alonelaval.jpc.config import config_instance
from com.alonelaval.jpc.common.connection import Connection
from com.alonelaval.jpc.common.pool import PoolHolder
from com.alonelaval.jpc.create_entity.create_entity import CreateEntity
from com.alonelaval.jpc.create_dao.create_dao import CreateDao
from com.alonelaval.jpc.create_jpa.create_repository import CreateRepository
from com.alonelaval.jpc.create_model.create_model import CreateModel
from com.alonelaval.jpc.create_contorller.create_controller import CreateController
from com.alonelaval.jpc.create_service.create_service import CreateService
from com.alonelaval.jpc.common.name_util import underline_to_camel

reload(sys)
# sys.setdefaultencoding('utf8')

creates=[ CreateEntity(),
        CreateRepository(),
        CreateDao(),
        CreateModel(),
        CreateController(),
        CreateService()
         ]
def prefix_filter(table_name):
    return table_name.replace("tb_","")

def get_table_names(table_name_filter=prefix_filter):
    conn = Connection()
    for table in conn.showTables():
        table_name = str(table[0])
        class_name = underline_to_camel(table_name if table_name_filter is None else table_name_filter(table_name),first_up=True)
        yield str(table_name),str(class_name)
        
def get_primary_key(table_name):
    conn = Connection()
    for column_name, column_type, is_pri in conn.get_column_info(table_name):
        if is_pri:
            return column_name
#         print column_name, column_type, is_pri
    
        
def bootstrap():
    config = config_instance
    if not config.project_path:
        config.project_path = os.path.join(os.path.dirname(__file__)).split("jpc")[0]+"jpc/test/"+config.project_name
    
    if not os.path.isdir(config.project_path):
            os.makedirs(config.project_path)
    need_create_tables = config.tables
    #初始化数据库链接
    PoolHolder.instance(config)
    table_name_iterator = get_table_names()
    table_names = []
    for table_name,class_name in table_name_iterator:
        
        
#         if not table_name.startswith("view"):
        
#             primary_key = get_primary_key(table_name)
#             primary_key = primary_key if primary_key is not None else "ID"
#             print "alter table %s modify column %s int(11)  AUTO_INCREMENT; " % (table_name,primary_key) 
#             print "alter table %s AUTO_INCREMENT=10000;" % table_name
        if need_create_tables :
            if table_name in need_create_tables:
                table_names.append((table_name,class_name))
        else:
            table_names.append((table_name,class_name))
    print table_names
    
    for create in creates:
        create.create(config,table_names)
#     
    
if __name__ == "__main__":
    bootstrap()
    