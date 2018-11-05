# -*- encoding: utf-8 -*-
'''
Created on 2018年7月31日

@author: huawei
'''
from com.alonelaval.jpc.common.connection import Connection
from com.alonelaval.jpc.create_entity.create_column import create_column_info
from com.alonelaval.jpc.common.data_type import data_type_match
from com.alonelaval.jpc.common.name_util import underline_to_camel
from jinja2 import Environment, PackageLoader, select_autoescape
import os.path
from com.alonelaval.jpc.base_create import BaseCreate

env = Environment(
    loader=PackageLoader('com.alonelaval.jpc', 'template'),
    autoescape=select_autoescape(['html', 'temp']),
    trim_blocks=True
)

class CreateEntity(BaseCreate):
    def __init__(self):
        self.package="/entity"
        self.template = "entity.temp"
    
    def file_path(self,config):
        return config.entity_path
       
    def create_file(self,file_path,class_name,package_name,template_name,class_file_name,table_name=None):
        fields,java_types = self.cretea_entity_data(str(table_name))
        template = env.get_template(template_name)
        content =  template.render({"package_name":package_name,
                         "table_name":table_name,
                         "fields":fields,
                         "clazz_name":class_name,
                         "java_types":java_types})
        with open(file_path+"/"+class_name+".java","w") as f:
            f.write(content)
            
    def get_column_info(self,table_name):
        conn = Connection();
        for column_info in conn.getData("desc %s"% table_name):
            column_name = column_info[0]
            column_type = column_info[1].split("(")[0]
            is_pri = True if str(column_info[3]) =='PRI' else False 
            yield column_name, column_type, is_pri
                     
    def cretea_entity_data(self,table_name):
        fields =[]
        java_types=set()
        for column_info in self.get_column_info(table_name):
            column_name,column_type,is_pri = column_info
            field_name = underline_to_camel(str(column_name),first_up=False)
            java_date_type = data_type_match(column_type)
            field_detail,import_type = create_column_info(column_name,field_name,java_date_type,is_pri)
            fields.append(field_detail)
            if import_type is not None:
                java_types.add(import_type)
                
        return (fields,java_types)   
            


    


if __name__ == "__main__":
    pass

    