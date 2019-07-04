package manual;

public class Sorts {
    void bubble(int[]arr) {
        boolean b = false;
        while (!b) {
            b=true;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i]>arr[i+1]){
                    b=false;
                    int tmp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=tmp;
                }
            }
        }
    }
    void select(int[]arr){
        for (int i = 0; i <arr.length ; i++) {
            int mark=i;
            for (int j = i+1; j <arr.length ; j++) {
               if(arr[j]<arr[mark])mark=j;
            }
            int tmp=arr[mark];
            arr[mark]=arr[i];
            arr[i]=tmp;
        }
    }
    void insert(int[]arr){
        for (int i = 1; i <arr.length ; i++) {
            int tmp=arr[i];
            int j=i;
            while(j>0&&arr[j-1]>=tmp){
                arr[j]=arr[j-1];
                --j;
            }
            arr[j]=tmp;
        }
    }
}
