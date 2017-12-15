var canvas = document.getElementById('gameCanvas'),
elemLeft = canvas.offsetLeft,
elemTop = canvas.offsetTop,
ctx = canvas.getContext("2d"),
cwidth = 600,
cheight = 600,
dsize = 5,
dotArray = [],
barArray = [],
squareArray = [];

class dot {
  constructor(x,y) {
    this.dx = x;
    this.dy = y;
  }

};

class bar {
  constructor(x,y,vert) {
    this.bx = x;
    this.by = y;
    this.dir = vert;
    this.available = true;
    if(vert == 0) {
      this.width = (cwidth/dg.size) - (2*dsize);
      this.height = 10;
    }
    else if(vert == 1) {
      this.height = (cheight/dg.size) - (2*dsize);
      this.width = 10;
    }
  }

};

class square {
  constructor(x,y) {
    this.sx = x;
    this.sy = y;
  }
}

canvas.addEventListener('click', function(event) {
    // var x = event.pageX - elemLeft,
    //     y = event.pageY - elemTop;
    var x = event.pageX,
        y = event.pageY;
    barArray.forEach(function(bar) {
        if (y > bar.by && y < bar.by + bar.height && x > bar.bx && x < bar.bx + bar.width) {
            humanMove(bar);
        }
    });

}, false);

function pageLoaded() {
    dg = new dotsGame(4, true, true);
    dotArray = initDots(dg);
    barArray = initBars(dg);
    squareArray = initSquares(dg);
    drawBoard();
}

function drawBoard() {
  dotArray.forEach(function(dot) {
    drawDot(dot);
  });
  barArray.forEach(function(bar) {
    drawBar(bar);
  });
}

function drawDot(dot) {
  ctx.beginPath();
  ctx.arc(dot.dx, dot.dy, dsize, 0, 2 * Math.PI, false);
  ctx.fillStyle = 'grey';
  ctx.fill();
  ctx.lineWidth = 1;
  ctx.strokeStyle = 'black';
  ctx.stroke();
}

function drawSquare(square) {
  ctx.fillStyle = 'grey';
  ctx.fillRect(square.sx + dsize,square.sy + dsize,(cheight/dg.size) - (2*dsize),(cheight/dg.size) - (2*dsize));
}

function drawBar(bar) {
  if(bar.dir == 0){
    ctx.fillStyle = 'grey';
    ctx.rect(bar.bx + dsize,bar.by - dsize,(cwidth/dg.size) - (2*dsize),10);
    ctx.lineWidth = 1;
    ctx.strokeStyle = 'black';
    ctx.stroke();
  }
  else if(bar.dir == 1) {
    ctx.fillStyle = 'grey';
    ctx.rect(bar.bx - dsize,bar.by + dsize,10,(cheight/dg.size) - (2*dsize));
    ctx.lineWidth = 1;
    ctx.strokeStyle = 'black';
    ctx.stroke();
  }
}

function initDots(game){
  da = []
  for(i = 0; i < dg.size; i ++) {
    for(j = 0; j < dg.size; j ++) {
      dt = new dot(10 + (cwidth/dg.size)*(i),10 + (cheight/dg.size)*(j));
      da.push(dt);
    }
  }
  return da;
}

function initSquares(game){
  sa = []
  for(i = 0; i < dg.size - 1; i++) {
      for(j = 0; j < dg.size - 1; j ++) {
        sq = new square(10 + (cwidth/(dg.size))*(i),10 + (cheight/(dg.size))*(j))
        sa.push(sq);
    }
  }
  return sa;
}

function initBars(game){
  ba = []
  for(i = 0; i < dg.size; i ++) {
    for(j = 0; j < dg.size; j ++) {
      if(i != dg.size-1) {
          brho = new bar(10 + (cwidth/dg.size)*(i),10 + (cheight/dg.size)*(j),0);
          ba.push(brho);
      }
      if(j != dg.size-1) {
        brvert = new bar(10 + (cwidth/dg.size)*(i),10 + (cheight/dg.size)*(j),1);
              ba.push(brvert);
      }
    }
  }
  return ba;
}
