#include<iostream>
#include<ctime>
#include<iomanip>
using namespace std;

void Insertsart(int r[],int n);//直接插入排序   时间O(n^2)    空间O(1)
void ShellInsert(int r[],int n);//希尔排序   时间O(nlogn)~O(n^2)    空间O(1)
void Bubblesort(int r[],int n);//冒泡排序   时间O(n^2)    空间O(1)
void Bubblesortpos(int r[],int n);//冒泡排序（改进）  时间O(n^2)    空间O(1)
int Partion(int r[],int first,int end);//快速排序   
void Qsort(int r[],int i,int j);//快速排序    时间O(nlogn)    空间O(logn)~O(n)
void Selectsort(int r[],int n);//简单选择排序  时间O(n^2)   空间O(1)
void Sift(int r[],int k,int m);//堆排序
void Heapsort(int r[],int n);//堆排序  时间O(nlogn)    空间O(1)
void Merge(int r[],int r1[],int s,int m,int t);//归并排序
void MergeSort(int r[],int r1[],int n);//归并排序    时间O(nlogn)   空间O(n)
void visit(int r[],int n);//遍历排序后序列
int compare[7];
int move[7];

//直接插入排序
void Insertsart(int r[],int n)//升序
{
	for(int i=1;i<=n;i++)//i从2-n循环，共n-1趟排序
	{
		compare[0]++;
		if(r[i]<r[i-1])
		{
			int temp=r[i];//将待插入记录赋值给哨兵r[0]
			r[i]=r[i-1];//元素后移
			for(int j=i-1;temp<r[j];j--)//从后往前顺序查找
			{
				r[j+1]=r[j];//元素后移
				move[0]++;
			}
			r[j+1]=temp;//插入记录
			move[0]+=2;
        }
	}
}

//希尔排序
void ShellInsert(int r[],int n)
{
	int i,j,d,temp;
	for(d=n/2;d>=1;d/=2)//以d为增量
	{
		for(i=d;i<=n;i+=d)//一趟希尔排序
		{
			compare[1]++;
			for(j=i;j>=0&&(r[j]<r[j-d]);j-=d)
			{
				temp=r[j];
				r[j]=r[j-d];
				r[j-d]=temp;
				move[1]+=3;
			}
		}
	}
}

//冒泡排序
void Bubblesort(int r[],int n)
{
	int temp;
	//外循环：总共需要遍历的趟数
	for(int i=1;i<n;i++) //n-1趟
    {  //内循环：每一趟需要比较的次数
		for(int j=0;j<=n-i;j++)
		{  
			compare[2]++;
			if(r[j]>r[j+1]) //相邻元素比较
			{
				temp=r[j];//元素交换位置
				r[j]=r[j+1];
				r[j+1]=temp;
				move[2]+=3;
            }
		}
	}
}

//冒泡排序（改进）
void Bubblesortpos(int r[],int n)
{
    int pos=n; //初始化时无序元素的范围
    while(pos>0)
    {
		int temp;
		int bound=pos;//本趟排序无序元素的范围
		pos=0;
		for(int i=1;i<=bound;i++)
		{
			compare[3]++;
			if(r[i-1]>r[i])//相邻元素比较
			{
				temp=r[i-1];//交换
				r[i-1]=r[i];
				r[i]=temp;
				pos=i;
				move[3]+=3;
			}
		}
	}
}

//快速排序
int Partion(int r[],int first,int end)
{
	int i=first;//分区的左界
	int j=end;//分区的右界
	int pivot=r[i];//保存第一个元素，作为基准元素
	while(i<j)
	{
		while((i<j)&&(r[j]>=pivot))//右侧扫描，寻找<pivot的元素前移
			j--;
		compare[4]++;
		r[i]=r[j];
		move[4]++;
		while((i<j)&&(r[i]<=pivot))//左侧扫描，寻找>pivot的元素后移
			i++;
		compare[4]++;
		r[j]=r[i];
		move[4]++;
    }
    r[i]=pivot;//将轴值移动至i=j的位置
    return i;//返回分区的分界值i
}
void Qsort(int r[],int i,int j)
{
	if(i<j)
    {
        int pivotloc=Partion(r,i,j);
        Qsort(r,i,pivotloc-1);//左分区快速排序
        Qsort(r,pivotloc+1,j) ;//右分区快速排序
	}
}

//简单选择排序
void Selectsort(int r[],int n)
{
	int temp;
	for(int i=0;i<n;i++)//n-1趟排序
	{
		int index=i;//查找最小记录的位置
		for(int j=i+1;j<=n;j++)
		{
				compare[5]++;
			if(r[j]<r[index])
				index=j;
		}
			if(i!=index)//若第一个就是最小元素，则不用交换
			{
				temp=r[i];
				r[i]=r[index];
				r[index]=temp;//利用temp作为临时空间交换记录
				move[5]+=3;
			}
    }
}

//堆排序
void Sift(int r[],int k,int m)//k是被筛选结点的编号，m是最后一个结点的编号
{
	int temp;
	int i=k,j=2*i;//i是要筛选的结点，j是i的左孩子
	while(j<=m)//j存在
	{
		if(j<m&&r[j]<r[j+1])
		{
			j++;//j是左右孩子中较大者
			compare[6]++;
		}
		if(r[i]>=r[j])
		{
			compare[6]++;
	    	break;//符合大根堆的条件，结束
		}
		else//根结点与孩子结点交换
		{
			temp=r[i];
			r[i]=r[j];
			r[j]=temp;
			move[6]+=3;
			i=j;
			j=2*i;//待比较结点下移
		}
    }
}
void Heapsort(int r[],int n)
{
	int temp;
	int i;
	for(i=n/2;i>=0;i--)//建堆
		Sift(r,i,n);
	for(i=n;i>0;i--)//堆排序
    {
		temp=r[0];
		r[0]=r[i];
		r[i]=temp;//输出堆顶元素
		move[6]+=3;
		Sift(r,0,i-1);//重新建堆
    }
}
//归并排序
void Merge(int r[],int r1[],int s,int m,int t)
{
  int i=s;//i指向r[s~m]
  int j=m+1;//j指向r[m+1~t]
  int k=s;//k指向r1
  while(i<=m&&j<=t)
  {
	  compare[7]++;
     if(r[i]<=r[j])
	 {
		 r1[k++]=r[i++];//取r[i]和r[j]中较小者放入r1[k]，并且自加一
	    move[7]++;
	 }
     else
	 {
		 r1[k++]=r[j++];
		 move[7]++;
	 }
   }
   while(i<=m)  r1[k++]=r[i++];//若r[s~m]没处理完
    move[7]++;
   while(j<=t)  r1[k++]=r[j++];//若r[m+1~t]没处理完
    move[7]++;
}
void MergePass(int r[],int r1[],int n,int h)
{
   int i=0;
   while(i<=n-2*h+1)//长度为h的序列两两归并
   {
      Merge(r,r1,i,i+h-1,i+2*h-1);
      i+=2*h;
    }
    if(i<n-h+1)
      Merge(r,r1,i,i+h-1,n);//两个序列，其中一个小于h
    else
      for( ;i<=n;i++)//只有一个小于等于h的序列
         r1[i]=r[i];
	   move[7]++;
}
void MergeSort(int r[],int r1[],int n)
{
    int h=1;
    while(h<n)
    {
       MergePass(r,r1,n,h);//将r归并到r1
       h=2*h;
       MergePass(r1,r,n,h);//将r1归并到r
       h=2*h;
     }
}
//遍历排序后序列
void visit(int r[],int n)
{
	cout<<"  排序后的序列为："<<endl;
	for(int i=0;i<n;i++)
	{
		cout<<setw(4)<<r[i]<<" ";
	}
	cout<<endl;
}

void main()
{
	cout<<"\t欢迎使用排序程序\n";
    cout<<"\t1.随机生成数组\n";
    cout<<"\t2.手动生成数组\n";
reinput1:
		const int N=10;
		int R[N];
     	int no=-1;
	    cin>>no;
		switch(no)
		{
		case 1:

			
			srand((unsigned int) time(NULL));
			int i;
			cout<<"  随机生成的序列为："<<endl;
			for(i=0;i<N;i++)
			{
				R[i]=rand()%100;
				cout<<setw(4)<<R[i]<<" ";
			}
			cout<<endl;
			break;
		case 2:
			cout<<"  手动输入序列："<<endl;
			for(i=0;i<N;i++)
			{
				cin>>R[i];
			}
			cout<<"  手动输入的序列为："<<endl;
			for(i=0;i<N;i++)
			{
				cout<<setw(4)<<R[i]<<" ";
			}
			cout<<endl;
			break;
		case 0:
			cout<<"谢谢使用！\n";
			exit(0);
		default:
            cout<<"重新输入！\n";
			goto reinput1;
		}

	cout<<"\t1.直接插入排序\n";
    cout<<"\t2.希尔排序\n";
	cout<<"\t3.冒泡排序\n";
	cout<<"\t4.冒泡排序（改进）\n";
	cout<<"\t5.快速排序\n";
	cout<<"\t6.简单选择排序\n";
	cout<<"\t7.堆排序\n";
    cout<<"\t8.归并排序\n";
	cout<<"\t0.退出程序\n";
	for(;;)
	{
		//把随机生成的数组R赋值给r，避免排序后R被修改
		const int N=10;
        int r[N],r1[N];
		for(int i=0;i<N;i++)
		{
			r[i]=R[i];
		}
		//选择条件
reinput2:
		int sign=-1;
		cin>>sign;
		switch(sign)
		{
		case 1:
			cout<<"直接插入排序\n";
			Insertsart(r,N-1);
			visit(r,N);
			/*		for(i=0;i<N;i++)
			{
			cout<<setw(4)<<R[i]<<" ";
			}
			cout<<endl;*///验证R没有被修改
			break;
		case 2:
			cout<<"希尔排序\n";
			/*			for(i=0;i<N;i++)
			{
			cout<<setw(4)<<r[i]<<" ";
			}
			cout<<endl;*///验证r已经初始化
			ShellInsert(r,N-1);
			visit(r,N);
			break;
		case 3:
			cout<<"冒泡排序\n";
			Bubblesort(r,N-1);
			visit(r,N);
			break;
		case 4:
			cout<<"冒泡排序（改进）\n";
			Bubblesortpos(r,N-1);
			visit(r,N);
			break;
		case 5:
			cout<<"快速排序\n";
			Qsort(r,0,N-1);
			visit(r,N);
			break;
		case 6:
			cout<<"简单选择排序\n";
			Selectsort(r,N-1);
			visit(r,N);
			break;
		case 7:
			cout<<"堆排序\n";
			Heapsort(r,N-1);
			visit(r,N);
			break;
			case 8:
			cout<<"归并排序\n";
			MergeSort(r,r1,N-1);
			visit(r,N);
			break;
		case 0:
			cout<<"谢谢使用！\n";
			exit(0);
		default:
            cout<<"重新输入！\n";
			goto reinput2;
		}
			cout<<"比较次数:"<<compare[sign-1]<<"\t移动次数:"<<move[sign-1]<<endl;
            compare[sign-1]=0;
			move[sign-1]=0;

	}
}
