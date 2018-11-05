#-*-encoding:utf-8-*-
'''
Createdon2018年7月31日

@author:huawei
'''
def camel_to_underline(camel_format):  
    ''''' 
        驼峰命名格式转下划线命名格式 
    '''  
    underline_format=''  
    if isinstance(camel_format, str):  
        for _s_ in camel_format:  
            underline_format += _s_ if _s_.islower() else '_'+_s_.lower()  
    return underline_format  
      
def underline_to_camel(underline_format,first_up=False):  
    ''''' 
        下划线命名格式驼峰命名格式 
    '''  
    camel_format = ''
    if isinstance(underline_format, str):
          
        if underline_format.find('_') <0:
            if first_up:
                return underline_format.capitalize()  
            return underline_format
        s = underline_format.split('_')
        for i,_s_ in enumerate(s):
            if first_up == False and i == 0:
                camel_format += _s_
                continue  
            camel_format += _s_.capitalize()  
    return camel_format  