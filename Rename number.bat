@echo off&setlocal EnableDelayedExpansion

set a=1

for /f "delims=" %%i in ('dir /b *.csv') do (

	if not "%%~ni"=="%~n0" (if !a! LSS 10 (ren "%%i" "fog0!a!.csv") else ren "%%i" "fog!a!.csv"

	set/a a+=1

	)
	
)

::这段程序把当前目录下的.csv文件进行重命名为“fog编号”，当小于10的时候用01，02……来表示。
:: 文件后缀不同可以把.csv替换成自定义后缀，前缀不同可以把fog替换成自定义前缀，小于10的数不想加0，可以把“fog0”的“0”删掉
:: 双击改.bat文件运行批量化脚本
