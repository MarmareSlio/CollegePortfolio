// calculates cumulative grade for all students
#include <stdlib.h>
#include <stdio.h>
#include "lab4.h"

void cum_all(Node* start, char** cat){
	printf("Student Name: %s",start->student.name);
	int avg = 0;
	double cum = 0;
	// outputting the score for first category
	if(start->student.cat1.score1>0){
		avg++;
		cum+=start->student.cat1.score1;
	}
	if(start->student.cat1.score2>0){
		avg++;
		cum+=start->student.cat1.score2;
	}
	if(start->student.cat1.score3>0){
		avg++;
		cum+=start->student.cat1.score3;
		}
	if(avg!=0){
		start->student.cat1.cum = cum/avg;
		printf("\t%s Cumlative: %.2f",cat[0],start->student.cat1.cum);
	}else{
		printf( "\t%s Cumlative: n/a", cat[0]);
		start->student.cat1.cum = 0;
	}
	// outputting the score for second category
	avg = 0;
	cum = 0;
	if(start->student.cat2.score1>0){
		avg++;
		cum+=start->student.cat2.score1;
		}
	if(start->student.cat2.score2>0){
		avg++;
		cum+=start->student.cat2.score2;
		}
	if(start->student.cat2.score3>0){
		avg++;
		cum+=start->student.cat2.score3;
		}
	if(avg!=0){
		start->student.cat2.cum = cum/avg;
		printf("\t%s Cumlative: %.2f", cat[1], start->student.cat2.cum);
	}else{
		printf( "\t%s Cumlative: n/a", cat[1]);
		start->student.cat2.cum = 0;
	}
	// outputting the score for third category
	avg = 0;
	cum = 0;
	if(start->student.cat3.score1>0){
		avg++;
		cum+=start->student.cat3.score1;
		}
	if(start->student.cat3.score2>0){
		avg++;
		cum+=start->student.cat3.score2;
		}
	if(start->student.cat3.score3>0){
		avg++;
		cum+=start->student.cat3.score3;
		}
	if(avg!=0){
		start->student.cat3.cum = cum/avg;
		printf("\t%s Cumlative: %.2f", cat[2],start->student.cat3.cum);
	}else{
		printf( "\t%s Cumlative: n/a", cat[2]);
		start->student.cat3.cum = 0;
	}
	// outputting the score for fourth category
	avg = 0;
	cum = 0;
	if(start->student.cat4.score1>0){
		avg++;
		cum+=start->student.cat4.score1;
		}
	if(start->student.cat4.score2>0){
		avg++;
		cum+=start->student.cat4.score2;
		}
	if(start->student.cat4.score3>0){
		avg++;
		cum+=start->student.cat4.score3;
		}
	if(avg!=0){
		start->student.cat4.cum = cum/avg;
		printf("\t%s Cumlative: %.2f", cat[3],start->student.cat4.cum);
	}else{
		printf( "\t%s Cumlative: n/a", cat[3]);
		start->student.cat4.cum = 0;
	}
	// calculating the current grade
	start->student.Current_Grade = (.15*start->student.cat1.cum)+(.3*start->student.cat2.cum)+(.2*start->student.cat3.cum)+(.35*start->student.cat4.cum);
	printf(" Current Grade is:  %.2f",start->student.Current_Grade);
}
