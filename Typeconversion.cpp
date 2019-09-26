//https://blog.csdn.net/qq_31285709/article/details/101482040

//Typeconversion.cpp
#include <stdio.h>
#include <stdlib.h>
#include <string.h>						
#include <unistd.h>
#include<sstream>
#include <iostream>
using namespace std;

int main(int argc, char *argv[])	//用于传参的主函数
{
	cout<<argv[0]<<endl;
	//记录了参数port的值
	char* unsignedshorttemp = argv[1];	
	cout<<typeid(unsignedshorttemp).name()<<" -unsignedshorttemp- "<<unsignedshorttemp<<endl;	//显示当前port的类型和值
	
	//char *类型向unsigned short类型的转换
	//实现方式1，直接atoi之后赋值
	unsigned short port1 = atoi(unsignedshorttemp);
	cout<<typeid(port1).name()<<" -port1- "<<port1<<endl;	//显示当前port1的类型和值
	
	//实现方式2，char *转成string，string转char* ,char* 转 unsigned short
	//绕了一圈又到实现方式1，但是这个过程可以看到char *转成string，string转char*的实现。
	//char *类型转成string类型
	string str;
	stringstream stream;
	stream << unsignedshorttemp;
	str = stream.str();
	//string类型转char*类型，char* a = (char*)str.c_str();
	unsigned short port2 ;
	port2 = atoi((char*)str.c_str());	//char *类型转unsigned short类型
	cout<<typeid(port2).name()<<"-port2-"<<port2<<endl;	//显示当前port2的类型和值
	
	//记录了参数server_ip的类型
	char* constchartemp = argv[2];	
	cout<<typeid(constchartemp).name()<<" -constchartemp- "<<constchartemp<<endl;	//显示当前server_ip的类型和值
	
	//char *类型向const char*类型的转换
	//实现方法1，间接赋值
	const char* server_ip1;
	server_ip1=constchartemp;
	cout<<typeid(server_ip1).name()<<" -server_ip1- "<<server_ip1<<endl;	//显示当前server_ip1的类型和值
	//实现方法2，直接赋值
	const char* server_ip2=constchartemp;
	cout<<typeid(server_ip2).name()<<" -server_ip2- "<<server_ip2<<endl;	//显示当前server_ip2的类型和值
}
