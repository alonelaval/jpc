# -*- encoding: utf-8 -*-
'''
Created on 2018年7月11日

@author: huawei
'''
import os
from string import Template

def read_dao(entity_dic_path,ignores=None):
    for root, dirs, files in os.walk(entity_dic_path):
#             print(root) #当前目录路径  
#             print(dirs) #当前路径下所有子目录  
            print(files) #当前路径下所有非目录子文件
            for line in files:
                line = line.split(".")[0]
                if line not in ignores:
                    yield line
                

repository_template = open("../template/serviceImpl.temp","r").read()
def create_repository_file(entity_name):
    template = Template(repository_template)
    func = lambda s: s[:1].lower() + s[1:] if s else ''
    pkg ="org" if entity_name.startswith("Org") else "user" if entity_name.startswith("User") else "platform"
    repository_content = template.substitute(name=entity_name,name_low=func(entity_name),pkg=pkg)
    repository = open("/Users/hua/workspace/python/create_jpa/test/"+entity_name+"ServiceImpl.java","w")
    repository.write(repository_content)
    repository.close()
    
    
if __name__ == '__main__':
    for line in read_dao("/Users/hua/workspace/ycz/cornerstone/entity/src/main/java/com/okycz/cornerstone/entity/biz",["User"]):
        create_repository_file(line)
        
        
        
    


        
    

