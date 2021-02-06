/* # Problem 2
We need to find manufacturing cost of a box.
There are 5 type of Box.
1. Universal
2. AllFlapMeeting
3. HoneyComb
4. ReverseTuckIn
5. TopOpening SnapLock
Each Box has some basic properties : length,height,width,area, flute;
A box can either use pins or pasting() to join.
A box can either single part or double part.
there are 7 types of flute : A,B,C,E,F,G and B(B is mostly used).
a flute has gsm and extra gsm;
you need to calcuate cost of a box : area  totalGSM  ExtraGSM * stitching cost (if double part cost is multiplied by 3)
where as Area : length  width  hight
and total GSM : extraGSM + GSM * 100;
and Extra GSM For Flute :
A = 10,B = 30,C = 20,E = 40,F =50,G = 20
and stitching cost :
1.if box has a pin then : 10rs per pin
2.if box has a pasting then cost is :
1. Universal : 20
2. AllFlapMeeting : 30
3. HoneyComb : 40
4. ReverseTuckIn : 40
5. TopOpening SnapLock = 50
*/


import java.util.*;
interface Box
{
     private double length, height, width, area;
     private double GSM, Extra_GSM;
     private int flute [6]={10,,30,20,40,50,20};  //Price
     public void pin();
     public void pasting();
     public void single_part();
     public void double_part();
     
}
class calcuate_cost_of_box
{   Box B;                         // reference variable
private double Area;                length  width  hight
private double total_GSM;           extraGSM + GSM * 100;
private double Extra_GSM;            For Flute :
    calcuate_cost_of_box(Box B)
    {
        this.B=B;
    }
    
    
}
class Universal implements Box
{
    
}
class AllFlapMeeting implements Box
{
    
}
class HoneyComb implements Box
{
    
}
class ReverseTuckIn implements Box
{
    
}
class TopOpening SnapLock implements Box
{
    
}

public class Main
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World");
	}
}

