/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 *
 * @author kaun_meet
 */

class flightPair{
    flight f1,f2;
    int thr,tmin;
    public flightPair(flight f1, flight f2,int thr,int tmin) {
        this.f1 = f1;
        this.f2 = f2;
    }
}
class passenger{
    String firstname,lastname,pan;
    passenger(String a,String b,String c){
        this.firstname=a;
        this.lastname=b;
        this.pan=c;
    }
}
class flight {

    String airline;
    int seate=0;
    int seatb=0;
    int id;
    String from;
    String to;
    String dur;
    String days;
    int timehour, timemin;
    int timerhour, timermin;
    int rows;
    int cols;
    int cost1,cost2;
    String[] seats = new String[rows];
//    int[][] seats = new int[rows][cols];
    ArrayList<pairsi> meal = new ArrayList<pairsi>();
    ArrayList<pairss> others = new ArrayList<pairss>();

    flight(String a, int b, String c, String d, String e, int f, int g, int h, int i, int j, int k, String[] l, ArrayList<pairsi> m, ArrayList<pairss> n,int xx,int yy) {
        this.airline = a;
        this.id = b;
        this.from = c;
        this.to = d;
        this.days = e;
        this.timehour = f;
        this.timemin = g;
        this.timerhour = h;
        this.timermin = i;
        this.rows = j;
        this.cols = k;
        this.seats = l;
        for(int ii=0;ii<this.rows;ii++){
            for(int ij=0;ij<this.cols;ij++){
                if(this.seats[ii].charAt(ij)=='1'){
                    seate++;
                }
                if(this.seats[ii].charAt(ij)=='2'){
                    seatb++;
                }
            }
        }
        this.meal = m;
        this.others = n;
        if(timermin>timemin){
            dur=Integer.toString(timerhour-timehour)+":"+Integer.toString(timermin-timemin);
        }
        else{
            dur=Integer.toString(timerhour-timehour-1)+":"+Integer.toString(60+timermin-timemin);
        }
        this.cost1=xx;
        this.cost2=yy;
        
    }
    int availCount(flight f){
        return 1;
    }
    
}
class booked{
    String airline;
    int id;
    int timehour,timemin;
    int timerhour,timermin;
    String seatno;
    String date;  
}
class user{
    String name;
    int userid;
    String password;
    String gender;
    String dob;
    String address;
    String pan;
    ArrayList<booked> history;
    public user(String name, int userid, String password, String gender, String dob, String address, String pan) {
        this.name = name;
        this.userid = userid;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.pan = pan;
        history=new ArrayList<>();
    }
    
    ArrayList<booked> bookinggs=new ArrayList<booked>();
    
    // booked    
}
class pairss {

    String first;
    String second;

    pairss(String first, String second) {
        this.first = first;
        this.second = second;

    }
}

class pairsi {

    String item;
    int value;
    pairsi(String item,int value){
        this.item=item;
        this.value=value;
    }
}


public class MiniProject {
static ArrayList<flight> allflight=new ArrayList<flight>();
static ArrayList<user> alluser=new ArrayList<user>();
 static int uniid;
 static int seatchoice = 0;
 static int flightselect=-1;
 static ArrayList<flight> resultsDirect=new ArrayList<>();
    static ArrayList<flightPair> resultIndirect=new ArrayList<>();
    static ArrayList<passenger> allpassenger=new ArrayList<>();
 static int cost=-1;
//    static flight tt = resultsDirect.get(flightselect);
//    static int n = tt.rows;
//    static int m = tt.cols;
//    static String[] matrix = new String[n];
//    static ArrayList<Point> book = new ArrayList<>();
//    static ArrayList<Point> selec = new ArrayList<>();
static flight tt;
    static int n;
    static int m ;
    static String[] matrix;
    static ArrayList<Point> book;
    static ArrayList<Point> selec;

    static boolean checkpan(String name){
        if(name.length()!=10){
            return true;
        }
        for(int i=0;i<10;i++){
                if(i>=5 && i<=8){
                    continue;
                }
                if((name.charAt(i)>='a' && name.charAt(i)<='z') ||(name.charAt(i)>='A' && name.charAt(i)<='Z')){
                    ;
                }
                else{
                    return true;
                }
        }
        for(int i=5;i<9;i++){
            if(name.charAt(i)>='0' && name.charAt(i)<='9'){
                ;
            }
            else{
                return true;
            }
        }
        return false;
    }
    static boolean checkdate(int day,int month,int year){
        return false;
    }
    static boolean match(char[] pass,char[] confpass){
        try{
            if(pass.length!=confpass.length){
                return true;
            }
            if(pass.length<4){
                return true;
            }
            for(int i=0;i<pass.length;i++){
                if(pass[i]!=confpass[i]){
                    return true;
                }
            }
            return false;
            
        }
        catch(Exception e){
            return true;
        }
        
    }
    static String passString(char pass[]){
        return new String(pass);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        File fc = new File("data.txt");
        try {
            Scanner usrobj = new Scanner(fc);
//            System.out.println("sds");
            int number_of_flights = usrobj.nextInt();
//        System.out.println();
            int i;
            for (i = 0; i < number_of_flights; i++) {
//                flight temp = null;
                String gh1;
                gh1 = usrobj.next();
//                temp.airline = gh;

//                System.out.println(temp.airline);
                int gh2 = usrobj.nextInt();
//                System.out.println(temp.id);

                String gh3 = usrobj.next();
//                System.out.println(temp.from);

                String gh4 = usrobj.next();
//                System.out.println(temp.to);

                String gh5 = usrobj.next();

                int gh6 = usrobj.nextInt();
                int gh7 = usrobj.nextInt();
                int gh8 = usrobj.nextInt();
                int gh9 = usrobj.nextInt();
                int gh10 = usrobj.nextInt();
                int gh11 = usrobj.nextInt();

                String[] gh12 = new String[gh10];

                int j, k;

                for (j = 0; j < gh10; j++) {
//                    temp.seats[j] = usrobj.next();
                    gh12[j] = usrobj.next();
                    System.out.println(gh12[j]);
                }
                j = usrobj.nextInt();
                String[] gh13 = new String[j];
//               temp.meal=new ArrayList<>();
                ArrayList<pairsi> vv = new ArrayList<>();

                while (j > 0) {
                    String a = usrobj.next();
                    k = usrobj.nextInt();
                    vv.add(new pairsi(a, k));

//                    temp.meal.add(new pairsi(a, k));
                    j--;

                }
                ArrayList<pairss> vvv = new ArrayList<>();

                j = usrobj.nextInt();
                while (j > 0) {
                    String a = usrobj.next();
                    String kk = usrobj.next();
                    vvv.add(new pairss(a, kk));

//                    temp.others.add(new pairss(a, kk));
                    j--;

                }
                int hh=usrobj.nextInt();
                int hj=usrobj.nextInt();
                

                flight temp = new flight(gh1, gh2, gh3, gh4, gh5, gh6, gh7, gh8, gh9, gh10, gh11, gh12, vv, vvv,hh,hj);
                allflight.add(temp);
            }
//            fc.close();

        } catch (FileNotFoundException e) {
//            System.out.println("dw");
            System.out.println(e.getMessage());
        }
        int i;
//        for (i = 0; i < allflight.size(); i++) {
//            System.out.println(allflight.get(i).airline);
//            System.out.println(allflight.get(i).meal.get(0).item);
//            System.out.println(allflight.get(i).others.get(0).first);
//            System.out.println(allflight.get(i).seats[0]);
//            
//        }

        new home().setVisible(true);

// TODO code application logic here
    

// TODO code application logic here
    }

}
