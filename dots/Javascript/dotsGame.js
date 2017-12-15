class dotsGame {
  constructor(size, p1, p2) {
    this.size = size;
    this.p1 = p1;
    this.p2 = p2
    this.orangeP = true;
  }


}

function humanMove(played_bar)
{
  if(dg.orangeP) {
    ctx.fillStyle = 'orange';
    dg.orangeP = false;
  }
  else {
    ctx.fillStyle = 'blue';
    dg.orangeP= true;
  }
  if(played_bar.dir == 0){
    ctx.fillRect(played_bar.bx + dsize,played_bar.by - dsize,(cwidth/dg.size) - (2*dsize),10);
  }
  else if(played_bar.dir == 1) {
    ctx.fillRect(played_bar.bx - dsize,played_bar.by + dsize,10,(cheight/dg.size) - (2*dsize));
  }
  played_bar.available = false;
  checkBoard();
}

function checkBoard() {
  squareArray.forEach(function(square) {
    checkSquare(square);
  });
}

function checkSquare(square) {
  
  if(surrounded) {
    drawSquare(square);
  }
}
