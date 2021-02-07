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
   public static final int singlePart=1;
   public static final int doublePart=3;
   public void getHeight();
   public void getWidth();
   public void getLength();
   public void getArea();
   public void getCostOfBox(); 
   public void getFlute();
}
class Join
{
    private  HashMap<String,Integer> m=new HashMap();
    private String boxName;
    
    public Join(String boxName)
    {
         this.boxName = boxName;
         m.put("Universal",20);
         m.put("AllFlapMeeting",30);
         m.put("HoneyComb",40);
         m.put("ReverseTuckin",40);
         m.put("TopOpeningSnapLock",50);
    }
    public double pins()
    {
        return 10.0; 
    }
   public double pasting()
   {
       return m.get(boxName);
   } 
}
class Flute
{
    public char type;
    public double gsm;
    private double extraGsm;
    private double totalGsm;
    
    public HashMap<Character,Integer> m = new HashMap();
    
    public Flute(char type,double gsm)
    {
        this.type = type;
        this.gsm  = gsm;
        this.totalGsm = 0.0;
        m.put('A',10);
        m.put('B',30);
        m.put('C',20);
        m.put('E',40);
        m.put('F',50);
        m.put('G',20);
    }
    
    public double getTotalGsm()
    {
        totalGsm = m.get(type) + this.gsm*100.0;
        return totalGsm;
    }
    
    public int getExtraGsm()
    {
        return m.get(type);
    }
}

class Universal implements Box
{
    private double length, height, width, area,stitchingCost;
    private String part;
    private Flute flute;
    private double manufacturingCost;
    public Universal(double length,double height,double width, Flute flute,double stitchingCost,String part)
    {
        this.length=length;
        this.height=height;
        this.width=width;
        this.flute=flute;
        this.stitchingCost=stitchingCost;
        this.part=part;
    }
   public void getHeight()
   {
      System.out.println("Height of Universal Box= "+height);
   }
   public void getWidth()
   {
       System.out.println("Width of Universal Box= "+width);
   }
   public void getLength()
   {
        System.out.println("Length of Universal Box = "+length);
   }
   public void getArea()
   {   
       area=length*width*height;
       System.out.println("Area of Universal Box = "+area);
   }
   public void getFlute()
   {
    System.out.println("Type = "+flute.type+", Gsm = "+flute.gsm+", ExtraGsm = "+flute.m.get(flute.type));      
   }
   public void getCostOfBox()
   { 
    manufacturingCost = (part=="singlePart") ? area*flute.getTotalGsm()*flute.getExtraGsm()*stitchingCost*Box.singlePart : area*flute.getTotalGsm()*flute.getExtraGsm()*stitchingCost*Box.doublePart; 
    System.out.println("Manufacturing Cost of Universal Box = "+manufacturingCost);
   }
}

class AllFlapMeeting implements Box
{
    private double length, height, width, area,stitchingCost;
    private String part;
    private Flute flute;
    private double manufacturingCost;
    public AllFlapMeeting(double length,double height,double width, Flute flute,double stitchingCost,String part)
    {
        this.length=length;
        this.height=height;
        this.width=width;
        this.flute=flute;
        this.stitchingCost=stitchingCost;
        this.part=part;
    }
   public void getHeight()
   {
      System.out.println("Height of AllFlapMeeting Box= "+height);
   }
   public void getWidth()
   {
       System.out.println("Width of AllFlapMeeting Box= "+width);
   }
   public void getLength()
   {
        System.out.println("Length of AllFlapMeeting Box = "+length);
   }
   public void getArea()
   {   
       area=length*width*height;
       System.out.println("Area of AllFlapMeeting Box = "+area);
   }
   public void getFlute()
   {
    System.out.println("Type = "+flute.type+", Gsm = "+flute.gsm+", ExtraGsm = "+flute.m.get(flute.type));      
   }
   public void getCostOfBox()
   { 
    manufacturingCost = (part=="singlePart") ? area*flute.getTotalGsm()*flute.getExtraGsm()*stitchingCost*Box.singlePart : area*flute.getTotalGsm()*flute.getExtraGsm()*stitchingCost*Box.doublePart; 
    System.out.println("Manufacturing Cost of AllFlapMeeting Box = "+manufacturingCost);
   }    
}
class HoneyComb implements Box
{
   private double length, height, width, area,stitchingCost;
    private String part;
    private Flute flute;
    private double manufacturingCost;
    public HoneyComb(double length,double height,double width, Flute flute,double stitchingCost,String part)
    {
        this.length=length;
        this.height=height;
        this.width=width;
        this.flute=flute;
        this.stitchingCost=stitchingCost;
        this.part=part;
    }
   public void getHeight()
   {
      System.out.println("Height of HoneyComb Box= "+height);
   }
   public void getWidth()
   {
       System.out.println("Width of HoneyComb Box= "+width);
   }
   public void getLength()
   {
        System.out.println("Length of HoneyComb Box = "+length);
   }
   public void getArea()
   {   
       area=length*width*height;
       System.out.println("Area of HoneyComb Box = "+area);
   }
   public void getFlute()
   {
    System.out.println("Type = "+flute.type+", Gsm = "+flute.gsm+", ExtraGsm = "+flute.m.get(flute.type));      
   }
   public void getCostOfBox()
   { 
    manufacturingCost = (part=="singlePart") ? area*flute.getTotalGsm()*flute.getExtraGsm()*stitchingCost*Box.singlePart : area*flute.getTotalGsm()*flute.getExtraGsm()*stitchingCost*Box.doublePart; 
    System.out.println("Manufacturing Cost of HoneyComb Box = "+manufacturingCost);
   } 
}
class ReverseTuckIn implements Box
{
    private double length, height, width, area,stitchingCost;
    private String part;
    private Flute flute;
    private double manufacturingCost;
    public ReverseTuckIn(double length,double height,double width, Flute flute,double stitchingCost,String part)
    {
        this.length=length;
        this.height=height;
        this.width=width;
        this.flute=flute;
        this.stitchingCost=stitchingCost;
        this.part=part;
    }
   public void getHeight()
   {
      System.out.println("Height of ReverseTuckIn Box= "+height);
   }
   public void getWidth()
   {
       System.out.println("Width of ReverseTuckIn Box= "+width);
   }
   public void getLength()
   {
        System.out.println("Length of ReverseTuckIn Box = "+length);
   }
   public void getArea()
   {   
       area=length*width*height;
       System.out.println("Area of ReverseTuckIn Box = "+area);
   }
   public void getFlute()
   {
    System.out.println("Type = "+flute.type+", Gsm = "+flute.gsm+", ExtraGsm = "+flute.m.get(flute.type));      
   }
   public void getCostOfBox()
   { 
    manufacturingCost = (part=="singlePart") ? area*flute.getTotalGsm()*flute.getExtraGsm()*stitchingCost*Box.singlePart : area*flute.getTotalGsm()*flute.getExtraGsm()*stitchingCost*Box.doublePart; 
    System.out.println("Manufacturing Cost of ReverseTuckIn Box = "+manufacturingCost);
   }
}
class TopOpeningSnapLock implements Box
{
    private double length, height, width, area,stitchingCost;
    private String part;
    private Flute flute;
    private double manufacturingCost;
    public TopOpeningSnapLock(double length,double height,double width, Flute flute,double stitchingCost,String part)
    {
        this.length=length;
        this.height=height;
        this.width=width;
        this.flute=flute;
        this.stitchingCost=stitchingCost;
        this.part=part;
    }
   public void getHeight()
   {
      System.out.println("Height of TopOpeningSnapLock Box= "+height);
   }
   public void getWidth()
   {
       System.out.println("Width of TopOpeningSnapLock Box= "+width);
   }
   public void getLength()
   {
        System.out.println("Length of TopOpeningSnapLock Box = "+length);
   }
   public void getArea()
   {   
       area=length*width*height;
       System.out.println("Area of TopOpeningSnapLock Box = "+area);
   }
   public void getFlute()
   {
    System.out.println("Type = "+flute.type+", Gsm = "+flute.gsm+", ExtraGsm = "+flute.m.get(flute.type));      
   }
   public void getCostOfBox()
   { 
    manufacturingCost = (part=="singlePart") ? area*flute.getTotalGsm()*flute.getExtraGsm()*stitchingCost*Box.singlePart : area*flute.getTotalGsm()*flute.getExtraGsm()*stitchingCost*Box.doublePart; 
    System.out.println("Manufacturing Cost of TopOpeningSnapLock Box = "+manufacturingCost);
   }
}

public class Main
{
	public static void main(String[] args) 
	{
	Flute flute=new Flute('A',11);
	Join join =new Join("Universal");
    double stitchingCost=join.pasting();
    Box B1 = new Universal(11.2,12.2,13.3,flute,stitchingCost,"doublePart");
    B1.getLength();
    B1.getWidth();
    B1.getHeight();
    B1.getArea();
    B1.getFlute();
    B1.getCostOfBox();
    
    
    Flute flute1=new Flute('G',12);
	Join join1 =new Join("TopOpeningSnapLock");
    double stitchingCost1=join.pasting();
    Box B2 = new TopOpeningSnapLock(10.2,11.2,12.3,flute1,stitchingCost1,"singlePart");
    B2.getLength();
    B2.getWidth();
    B2.getHeight();
    B2.getArea();
    B2.getFlute();
    B2.getCostOfBox();
    
	}
}

