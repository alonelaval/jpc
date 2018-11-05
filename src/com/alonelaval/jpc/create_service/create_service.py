# -*- encoding: utf-8 -*-
'''
Created on 2018年7月11日

@author: huawei
'''
import os

from com.alonelaval.jpc.base_create import BaseCreate
                    
class CreateService(BaseCreate):
    def __init__(self):
        self.package="/service"
        self.service_inter_template = "./template/service.temp"
        self.service_impl_template="./template/serviceImpl.temp"
        
    def file_path(self,config):
        return config.service_path
    
    def process_file(self,file_path,table_names,package_name):
        for _,class_name in table_names:
            inter_file_path = file_path+"/"+"inter"
            impl_file_path = file_path+"/"+"impl"
            self.create_path(inter_file_path)
            self.create_path(impl_file_path)
            self.create_file(inter_file_path,class_name,package_name,self.service_inter_template,class_name+"Service.java")
            self.create_file(impl_file_path,class_name,package_name,self.service_impl_template,class_name+"ServiceImpl.java")
       
    
if __name__ == '__main__':
    pass
        
        
        
    


        
    

