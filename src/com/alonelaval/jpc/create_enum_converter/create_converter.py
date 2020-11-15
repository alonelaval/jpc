# -*- encoding: utf-8 -*-
'''
Created on 2018年7月11日

@author: huawei
'''
import os
from string import Template

def read_entity(entity_dic_path,ignores=None):
    for root, dirs, files in os.walk(entity_dic_path):
#             print(root) #当前目录路径  
#             print(dirs) #当前路径下所有子目录  
            print(files) #当前路径下所有非目录子文件
            for line in files:
                line = line.split(".")[0]
                if line not in ignores:
                    yield line
                

repository_template = open("../template/converter.temp","r").read()
def create_repository_file(entity_name):
    template = Template(repository_template)
    repository_content = template.substitute(name=entity_name)
    repository = open("/Users/hua/workspace/python/jpc/test/"+entity_name+"Converter.java","w")
    repository.write(repository_content)
    repository.close()
    
    
if __name__ == '__main__':
    for line in read_entity("/Users/hua/workspace/ycz/panasonic/entity/src/main/java/com/okycz/panasonic/entity/constants",["IEnum"]):
        create_repository_file(line)
        
    

