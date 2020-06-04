package cs_utec.cs2901;

public class Celda {
    boolean revelada = false;
    boolean bomba = false;
    boolean flagged = false;
    int adjacent = 0;
    public void setAdjacent(int new_adj){
        adjacent = new_adj;
    };
    public boolean setBomba(){
        if (bomba = false){
          bomba = true;
          return false;
        }else {return true;}
    }
    public boolean click(){
        if (bomba){
            return true;
        }else {return false;}
    }
    public void flag(){
        flagged = true;
    };

}
