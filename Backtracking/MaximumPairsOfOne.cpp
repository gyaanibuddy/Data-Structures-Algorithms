#include<iostream>
using namespace std;
class Maxpair
{
	private:
		 int arr[5][5];
		 bool cntarr[5][5];
		 int rmax = 5;
		 int colmax = 5;
		 int maxsize = 0;
	public:
		void create2Darray()
		{
			cout<<"Enter Elements in array"<<endl;
			for(int i = 0;i<5;i++)
			{
				for(int j = 0;j<5;j++)
				{
					cin>>arr[i][j];
				}
			}
		}
		int getVal(int i, int j)
		{
			if(i<0||i>=rmax||j<0||j>colmax)
				return 0;
			return arr[i][j];
		}
		void findMaxBlock(int r,int c,int size)
		{
			if(r>=5 || c>=5)
				return;
			
			cntarr[r][c] = true;
			size++;
			if(size>maxsize)
				maxsize = size;
			
			int dir[8][2]={{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
			for(int i = 0;i<8;i++)
			{
				int newi = r + dir[i][0];
				int newj = c+ dir[i][1];
				int val = getVal(newi,newj); 
				if(val>0&&(cntarr[newi][newj]==false))
				{
					findMaxBlock(newi,newj,size);
				}
			}	
			cntarr[r][c] = false;
		}
		int getMaximumOnes()
		{
			for(int i = 0;i<5;i++)
			{
				for(int j = 0;j<5;j++)
				{
					if(arr[i][j] == 1)
					{
						findMaxBlock(i,j,0);
					}
				}
			}			
			return maxsize;
		}
		void print()
		{
			cout<<"Elements of array are"<<endl;
			for(int i = 0;i<5;i++)
			{
				for(int j = 0;j<5;j++)
				{
					cout<<arr[i][j]<<" ";
				}
				cout<<endl;
			}			
		}
};
int main()
{
	Maxpair obj;
	obj.create2Darray(); 
	obj.print();
	cout<<"Maximum number of adjecent 1's pair = "<<obj.getMaximumOnes()<<endl;
	return 0;
}
