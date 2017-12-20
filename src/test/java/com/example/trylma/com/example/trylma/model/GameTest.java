package com.example.trylma.com.example.trylma.model;

import com.example.trylma.model.Game;
import com.example.trylma.model.Peg;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class GameTest {
    Game game;
    Peg peg;
    List<Peg> neighbours;
    int i;
    int j;

    @Before
    public void initialize() throws Exception {
        game = new Game();
        game.initalizeBoard();
        i=7;
        j=10;
        peg = new Peg(i,j,1);
        assertNotNull(game);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetPeg() {
        game.getPeg(-1, -1);
    }

    @Test
    public void testFindNeightbours() {
        neighbours = game.findNeighbours(peg);
        int suma=0;
        for(int k=0; k<neighbours.size();k++){
            Peg pegTemp = neighbours.get(k);
            int ii = pegTemp.geti();
            int jj = pegTemp.getj();
            if(ii==i && jj==j-1 || ii==i && jj==j+1 || ii==i+1 && jj==j || ii==i-1 && jj==j){
                suma++;
            }
            if(i%2==0 && jj==j+1 && ii==i-1 || i%2==0 && jj==j+1 && ii==i+1){
                suma++;
            }
            if(i%2!=0 && jj==j-1 && (ii==i-1 || ii==i+1 )){
                suma++;
            }
        }
        assertEquals(6,suma);
        assertEquals(6,neighbours.size());
    }
}
