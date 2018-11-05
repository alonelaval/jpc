# -*- encoding: utf-8 -*-
'''
Created on 2018年9月3日

@author: huawei
'''
from yaml import load
import os
# from com.alonelaval.jpc.common.util import singleton

# @singleton
class Config:
#     def instance(cls):
#         return Config()
    
    def __init__(self):
        config_path = os.path.join(os.path.dirname(__file__), 'config.yaml')
        self.cfg = None
        with open(config_path,"r") as stream:
            self.cfg = load(stream)
        self.tables =self.cfg.get("tables")
        self.project_path=self.cfg.get("projectPath")
        self.db_host=self.cfg.get("db").get("host")
        self.db_name=self.cfg.get("db").get("db_name")
        self.db_user=self.cfg.get("db").get("user")
        self.db_password=self.cfg.get("db").get("password")
        self.db_port=self.cfg.get("db").get("port")
        self.db_type=self.cfg.get("db").get("db_type")
        self.repository_path=self.cfg.get("repositoryPath")
        self.model_path=self.cfg.get("modelPath")
        self.entity_path=self.cfg.get("entityPath")
        self.filters=self.cfg.get("filters")
        self.service_path=self.cfg.get("servicePath")
        self.project_name=self.cfg.get("projectName")
        self.package_name=self.cfg.get("packageName")
        self.dao_path=self.cfg.get("daoPath")
        self.controller_path=self.cfg.get("controllerPath")
    
config_instance = Config()

if __name__ == "__main__":
    
    print Config.instance()
    config = Config()
    print config.db_name