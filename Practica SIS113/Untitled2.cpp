#include <iostream>
#include <math.h>
using namespace std;
class Ejercicio1 {
	double x,y,r,ang; 					
	public:
	void init(){  
		cout<<"Ingrese dos valores"<<endl;
		cin>>x>>y;
	}
	void suma(){
		r=sqrt(x*x+y*y);
		ang=atan(y/x);
		ang=ang*180/M_PI;
	}
	void display(){
		printf("El radio es: %.2f",r);
		printf("\nEl angulo es: %.2f",ang);
	}
};
int main(){
		Ejercicio1 obj1; 
		obj1.init();
		obj1.suma();
		obj1.display();
}

