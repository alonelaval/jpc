# -*- encoding: utf-8 -*-
'''
Created on 2018年7月31日

@author: huawei
'''

def create_column_info(column_name,field_name,java_data_type,is_pri=False,comment=""):
    anno=''
    comm ="    /** %s */\n" % comment
    if is_pri:
        anno = "    @Id \n    @GeneratedValue(strategy = GenerationType.IDENTITY) \n"
    anno += "    @ApiModelProperty(\"%s\")\n"%comment
    anno += "    @Column(name = \"%s\")\n"%column_name
    field = "    private %s %s;"
    if java_data_type.find(".") >0:
        dType = java_data_type.split(".")[2]
        field = field % (dType,field_name)
        return (comm+anno+field,java_data_type)
    else:
        field = field % (java_data_type,field_name)
        return (comm+anno+field,None)
        
        
if __name__ == "__main__":
    print create_column_info('org_name',"orgName","Byte")[0]
    print create_column_info("org_count","orgCount","java.math.BigDecimal",True)[0]
    print create_column_info("org_count","orgCount","java.math.BigDecimal",True)[1]