package recursion;
public class TilePlacement{

    public static void placeTiles(String alignment, int n, int m){
        if(alignment.length()==n){
            System.out.println(alignment);
            return;
        }

        if(alignment.length()==n-1){
            placeTiles(alignment+'H',n,m);
            return;
        }

        placeTiles(alignment+'H', n, m);
        placeTiles(alignment+ "VV", n, m);
    }

    public static int countTilePlacements(String alignment, int n, int m){
        if(alignment.length()==n){
            return 1;
        }
        if(alignment.length()==n-1){
            return countTilePlacements(alignment+'H',n,m);
        }
        return countTilePlacements(alignment+'H', n, m)+countTilePlacements(alignment+ "VV", n, m);
    }

    public static void main(String args[]){
        int n=5;
        int m =2;
        //  tile size of 1*m so means total of n tiles will be used
        // there are 2 cases 
        // either put horizontally or place 2 tile in vertical position
        // count the possible ways
        placeTiles("",n,m);
        System.out.println(countTilePlacements("",n,m));
    }
}