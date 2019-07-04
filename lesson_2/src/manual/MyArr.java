package manual;
class MyArr {
    int [] arr;
    private int size;
    public MyArr ( int size ){
        this . size = 0;
        this . arr = new int [ size ];
    }
    public void display (){
        for ( int i = 0 ; i < this . size ; i ++) {
            System . out . println ( this . arr [ i ]);
        }
    }
    public void delete ( int value ){
        int i = 0;
        for ( i = 0 ; i < this . size ; i ++) {
            if ( this . arr [ i ] == value ) break;
        }
        for ( int j = i ; j < this . size - 1 ; j ++) {
            this . arr [ j ] = this . arr [ j + 1 ];
        }
        this . size --;
    }
    public void insert ( int value ){
        this.arr [ this . size ] = value;
        this . size ++;
    }
}
