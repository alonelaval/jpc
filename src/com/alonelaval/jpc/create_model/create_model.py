# -*- encoding: utf-8 -*-
'''
Created on 2018年7月11日

@author: huawei
'''
import os
from com.alonelaval.jpc.base_create import BaseCreate


                
class CreateModel(BaseCreate):
    
    def __init__(self):
        self.package="/model"
        self.template = "./template/model.temp"
        
    def class_name(self,class_name):
        return class_name+"Model.java"
        
    def file_path(self,config):
        return config.model_path
    
               
if __name__ == '__main__':
    pass
        
    

