counter = 100  #赋值整型变量
miles = 1000.0 # 浮点型
name = "John" #字符串

print (counter)
print (miles)
print (name + "\n")
print("\n=======================================================================\n")
# 多个变量赋值
a, b ,c =1,2,"Wallace"
print(a)
print(b)
print(c + "\n")
print("\n=======================================================================\n")
#加号（+）是字符串连接运算符，星号（*）是重复操作
str = 'Hello World!'
print (str)
print(str[0])
print(str[2:5])
print(str[2:])
print(str * 2)
print(str + "TEST")
print("\n=======================================================================\n")
#列表
list = ['abcd', 786, 2.23, 'Wallace', 70.2]
tinylist = [123,'John']
print (list)
print(list[0])
print(list[1:3])
print(list[2:])
print(list * 2) #输出列表两次
print(list + tinylist)
print("\n=======================================================================\n")
#元组
tuple = ('abcd',786,2.23,'John',70.2)
tinytuple = (123,'Wallace')
print (tuple) # 输出完整元组
print (tuple[0]) # 输出元组的第一个元素
print (tuple[1:3]) # 输出第二个至第三个的元素
print (tuple[2:]) # 输出从第三个开始至列表末尾的所有元素
print (tinytuple * 2) # 输出元组两次
print (tuple + tinytuple) # 打印组合的元组
print("\n=======================================================================\n")
#元字典
dict = {}
dict['one'] = "This is One."
dict[2] = "This is Two."
tinydict = {'name':'John','code':6734,'dept':'sales'}
print (dict['one'])
print (dict[2])
print (tinydict)
print (tinydict.keys())
print (tinydict.values())
print("\n=======================================================================\n")
#算术运算符
a = 2
b = 4
c  = a**b
print(c)
a = 10
b = 3
c = a // b
print(c)
print("\n=======================================================================\n")
#成员运算符
a = 10
b = 20
list = [1,2,3,4,5];
if (a in list):
     print ("Line 1 - a is available in the given list")
else:
     print ("Line 1 - a is not available in the given list")

if (b not in list):
     print ("Line 2 - b is not available in the given list")
else:
     print ("Line 2 - b is available in the given list")

a = 2
if ( a in list ):
     print ("Line 3 - a is available in the given list")
else:
     print ("Line 3 - a is not available in the given list")
print("\n=======================================================================\n")

