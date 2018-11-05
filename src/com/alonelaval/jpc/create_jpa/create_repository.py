# -*- encoding: utf-8 -*-
'''
Created on 2018年7月11日

@author: huawei
'''
import os
from com.alonelaval.jpc.base_create import BaseCreate

                        
class CreateRepository(BaseCreate):
    
    def __init__(self):
        self.package="/repository"
        self.template = "./template/repository.temp"
        
    def class_name(self,class_name):
        return class_name+"Repository.java"
    


if __name__ == '__main__':
    pass
        
    

