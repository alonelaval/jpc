# -*- encoding: utf-8 -*-
'''
Created on 2018年7月11日

@author: huawei
'''
import os
from jinja2 import Environment, PackageLoader, select_autoescape
repository_template = open("../template/constantsController.temp","r").read()
env = Environment(
    loader=PackageLoader('com.alonelaval.jpc', 'template'),
    autoescape=select_autoescape(['html', 'temp']),
    trim_blocks=True
)

def read_constants(entity_dic_path,ignores=None):
    for root, dirs, files in os.walk(entity_dic_path):
#             print(root) #当前目录路径  
#             print(dirs) #当前路径下所有子目录  
            print(files) #当前路径下所有非目录子文件
            for line in files:
                line = line.split(".")[0]
                if line not in ignores:
                    yield line
                


def create_constants_file(paths,ignores=None):
    java_types = []
    
    for  line in read_constants(paths,ignores):
        java_types.append(line)
    java_types.sort()
    print java_types
    func = lambda s: s[:1].lower() + s[1:] if s else ''
    types = []
    for line in java_types:
        types.append((line,func(line)))
    
    print types
     
    template = env.get_template("constantsController.temp")
    repository_content = template.render({"java_types":java_types,"types":types})
    repository = open("/Users/hua/workspace/python/jpc/test/ConstantsController.java","w")
    repository.write(repository_content)
    repository.close()
    
    
if __name__ == '__main__':
#     for line in read_constants("/Users/hua/workspace/ycz/cornerstone/entity/src/main/java/com/okycz/cornerstone/entity/constants",[]):
#         print line
    create_constants_file("/Users/hua/workspace/ycz/cornerstone/entity/src/main/java/com/okycz/cornerstone/entity/constants",["IEnum"])
        
        
    

