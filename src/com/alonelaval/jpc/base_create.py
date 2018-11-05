# -*- encoding: utf-8 -*-
'''
Created on 2018年9月4日

@author: huawei
'''
import os
from string import Template

class BaseCreate():
    def __init__(self):
        self.template =None
        self.package=None
    
    def file_path(self,config):
        return config.controller_path
    
    def create(self,config,table_names):
        file_path=self.file_path(config)
        if file_path: 
            self.create_path(file_path)
            self.process(file_path, table_names, config.package_name)
        else:
            if config.project_path:
                file_path= config.project_path + self.package
                self.create_path(file_path)
            self.process_file(file_path,table_names,config.package_name)
            
    def process_file(self,file_path,table_names,package_name):
        for table_name,class_name in table_names:
            self.create_file(file_path,class_name,package_name,self.template,self.class_name(class_name),table_name=table_name)
            
    def create_file(self,file_path,class_name,package_name,template_name,class_file_name,table_name=None):
        template = Template(open(template_name,"r").read())
        func = lambda s: s[:1].lower() + s[1:] if s else ''
        repository_content = template.substitute(name=class_name,name_low=func(class_name),pkg=package_name)
        with open(file_path+"/"+class_file_name,"w") as writer:
            writer.write(repository_content)

            
    def create_path(self,file_path):    
        if not os.path.isdir(file_path):
            os.makedirs(file_path)
    
    def class_name(self,class_name):
        return class_name+"Controller.java"
        