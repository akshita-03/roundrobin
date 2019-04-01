import java.text.DecimalFormat;
import java.util.*;

class roundrobin {
    static int time=2500000;
    public static void main(String []ak) {
        Scanner input=new Scanner(System.in);
        int Arrival[]=new int[30];
        int Brust[]=new int[30];
        int Remain[]=new int[30];
        int Complete[]=new int[30];
        int Waiting[] = new int[30],trunaround[]=new int[30];
        int timequant1=6,timequant2=10,total,Ak,max=0,num=0,data_no;
        float Total_waiting=0,Total_trounaround=0,Average_wait,Average_trunaround;
        DecimalFormat d2=new DecimalFormat(".##");
        System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$----Arrival time should be in Ascending Order-------$$$$$$$$");
        System.out.print("Enter The No of Process=");
        data_no=input.nextInt();
        for (int i=0;i<data_no;++i){
            int name=i+1;
            System.out.print("\n Enter the Arrival time process P"+name+"=");
            Arrival[i]=input.nextInt();
            System.out.print("Enter The Brust Time of Process P"+name+"=");
            Brust[i]=input.nextInt();

        }
       time=Arrival[0];
        for (Ak=0;Ak<3;++Ak){
            if (Ak==0){
                for (int i = 0; i <data_no ; i++) {
                    if (time<Arrival[i] && Remain[i]!=0)
                    {
                        time=Arrival[i];
//                        System.out.println(time);
                    }
                    System.out.println(time);
                    if (Brust[i]>timequant1)
                    {
                        Remain[i]=Brust[i]-timequant1;
                        time=time+timequant1;
                    }
                    else if(Brust[i]<=timequant1){
                        time=time+Brust[i];
                        System.out.println(time);
                        Remain[i]=0;
                        Complete[i]=time;

                    }

                }


            }

            if (Ak==1){
                for (int i = 0; i < data_no; i++) {
                    if (Remain[i]>timequant2)
                    {

                        Remain[i]=Remain[i]-timequant2;
                        time=time+timequant2;

                    }
                    else if(Remain[i]<=timequant2 && Remain[i]!=0){

                        time=time+Remain[i];
                        Complete[i]=time;
                        System.out.println(Complete[i]);
                        Remain[i]=0;


                    }

                }
            }
            if (Ak==2){
                for (int i = 0; i <data_no; i++) {
                    if(Remain[i]>0) {
                        if (max < Remain[i]) {
                        max=Remain[i];
                        }
                    }
                }
            }
            for (int i = 0; i <data_no ; i++) {
                if (Remain[i]==max && Remain[i]!=0)
                {
                    time=time+Remain[i];
                    Remain[i]=0;
                    Complete[i]=time;
                }

            }




        }
        for (int i = 0; i < data_no; i++) {
            if (Remain[i]==0){
                trunaround[i]=Complete[i]-Arrival[i];
                Waiting[i]=trunaround[i]-Brust[i];
                if (Waiting[i]<0)
                {
                    Waiting[i]=0;
                }
            }

        }
      System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$#####Calculation$$$$$$$$$$$$\n");
       System.out.println("Process      Arrival    Brust    Complete_T   Trunaround      Waiting\n");
        for (int i = 0; i <data_no ; i++) {
            if (Remain[i]==0){
                int name=i+1;
                System.out.println("P"+name+"             "+Arrival[i]+"           "+Brust[i]+"       " +Complete[i]+"             "+trunaround[i]+"              "+Waiting[i]);
            }

        }
        for (int i = 0; i < data_no ; i++) {
            if(Remain[i]==0){
                num += 1;
                Total_trounaround=Total_trounaround+trunaround[i];
                Total_waiting=Total_waiting+Waiting[i];

            }
        }

        Average_trunaround=Total_trounaround/num;
        Average_wait=Total_waiting/num;
        System.out.println("\nAverage trunAround Time="+d2.format(Average_trunaround));
        System.out.println("Average Waiting Time="+d2.format(Average_wait));
        for (int i = 0; i < data_no; i++) {
            if (Remain[i]!=0){
                int name=i+1;
                System.out.println("\nProcess which is terminated p"+name);
            }

        }
    }

} 