#_*_ coding: utf-8 _*_

import xlrd

#打开Excel文件读取数据
data=xlrd.open_workbook("users.xlsx")


#获取一个工作表
table=data.sheets()[0] #通过索引顺序获取

#获取整行和整列的值（数组）

row=table.row_values(1)

col=table.col_values(1)

#print row
#print col

#获取行数和列数
nrows=table.nrows
ncols=table.ncols

#print nrows,ncols


#循环行列表数据
#for i in range(nrows):
 #   print table.row_values(i)

#单元格
cell_A1=table.cell(0,0).value

cell_D3=table.cell(2,3).value

print 'A1='+cell_A1

print 'D3='+cell_D3



